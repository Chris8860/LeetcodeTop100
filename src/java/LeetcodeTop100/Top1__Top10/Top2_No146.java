package LeetcodeTop100.Top1__Top10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 * LRUCache cache = new LRUCache( 2 /缓存容量/ )
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 * 思路：使用一个HashMap来存储对应的key以及链表的节点;
 *       使用双端链表LinkedList来模拟内存，当对某个内存出现操作或者新添加一块内存，则将该内存移动到最前面;
 *       如果经过某次操作，出现内存数量不够，则将链表最末尾的移除。
 *       Tips:可以使用head以及tail来标识链表的首尾，从而节省很多边界判断。
 *            先写好moveToHead() ：将节点移动到首部，其实就是先removeNode，然后addNewNode。
 *                  addNewNode()：添加新的节点到链表
 *                  removeNode()：移除节点
 *                  popTail()：移除最后一个节点
 *           等方法，方便后续直接调用。
 *
 * */


public class Top2_No146 {

    public static void main(String[] args) {
        LRUCache l = new LRUCache(3);
        l.put(2,3);
        l.put(20,4);
        l.put(30,5);
        l.put(5,7);
        System.out.println(l.get(2));
        System.out.println(l.get(20));
    }

    static class LRUCache {

        private  Map<Integer, DoubleLinkedNode> map = new HashMap<>();
        private DoubleLinkedNode head, last;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;

            head = new DoubleLinkedNode();
            head.prev = null;

            last = new DoubleLinkedNode();
            last.next = null;

            head.next = last;
            last.prev = head;
        }

        public int get(int key) {
            DoubleLinkedNode node = map.get(key);
            if(node == null)
                return -1;
            else{
                this.moveToHead(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            DoubleLinkedNode node = map.get(key);
            if(node == null){     //新添加的内容不在内存中，首先要判断内存是否已满
                DoubleLinkedNode tmp = new DoubleLinkedNode();
                tmp.key = key;
                tmp.value = value;
                addNewNode(tmp);
                map.put(key,tmp);
                if(map.size() > capacity){  //内存溢出，需要移除最后一个内存单元
                    DoubleLinkedNode tail = popLast();
                    map.remove(tail.key);
                }
            }
            else{
                node.value = value;
                map.put(key, node);
                moveToHead(node);
            }
        }

        public void addNewNode(DoubleLinkedNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(DoubleLinkedNode node){
            DoubleLinkedNode pre = node.prev;
            DoubleLinkedNode next = node.next;
            pre.next = next;
            next.prev = pre;
        }

        public void moveToHead(DoubleLinkedNode node){  //讲一个节点移到链表头部，先将其删除，在添加到首部。
            removeNode(node);
            addNewNode(node);
        }

        public DoubleLinkedNode popLast(){
            DoubleLinkedNode res = last.prev;
            removeNode(res);
            return res;
        }
    }
    static private class DoubleLinkedNode {
        private int key;
        private int value;
        private DoubleLinkedNode prev;
        private DoubleLinkedNode next;
    }

}
