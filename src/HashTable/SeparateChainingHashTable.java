package HashTable;

import LinkedList.DoublyLinkedList;

import java.util.Arrays;
import java.util.Iterator;

public class SeparateChainingHashTable<K, V> implements HashTableADT<K, V>{
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.5;

    private final double loadFactor;
    private int size, capacity, threshold;

    private DoublyLinkedList<Node<K, V>>[] table;

    public SeparateChainingHashTable() {
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public SeparateChainingHashTable(int capacity) {
        this(DEFAULT_LOAD_FACTOR, capacity);
    }

    public SeparateChainingHashTable(double loadFactor, int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("capacity is fail");
        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor)) {
            throw new IllegalArgumentException("Load Factor is fail");
        }
        this.loadFactor = loadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.threshold = (int) (this.capacity * loadFactor);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int hashCodeToIndex(int hashKey) {
        return (int) ((hashKey & 0xFFFFFFFL) % capacity);
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public boolean has(K key) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        if (linkedList == null || linkedList.isEmpty()) return false;
        Iterator<Node<K, V>> itr = linkedList.iterator();
        while (itr.hasNext()) {
            Node<K, V> node = itr.next();
            if (node.getKey().equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean insert(K key, V value) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        if (linkedList == null) table[index] = linkedList = new DoublyLinkedList<>();

        Node<K, V> existedNode = null;
        Iterator<Node<K, V>> itr = linkedList.iterator();

        while (itr.hasNext()) {
            Node<K, V> node = itr.next();
            if (node.getKey().equals(key)) existedNode = node;
        }

        return false;
    }

    @Override
    public V get(K key) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        if (linkedList == null || linkedList.isEmpty()) return null;
        Iterator<Node<K, V>> itr = linkedList.iterator();
        while (itr.hasNext()) {
            Node<K, V> node = itr.next();
            if (node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
