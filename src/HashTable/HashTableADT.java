package HashTable;

public interface HashTableADT<K, V> extends Iterable<K> {
    //size, isEmpty, hashCodeToIndex, clear, has, insert, get, remove
    int size();
    boolean isEmpty();
    int hashCodeToIndex(int hashKey);
    void clear();
    boolean has(K key);
    boolean insert(K key, V value);
    V get(K key);
    V remove(K key);


}
