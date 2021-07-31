package Map;

public interface Map<K,V> {
    void add(K key,V value);
    boolean contains(K key);
    boolean isEmpty();
    void set(K key,V value);
    V remove(K key);
    int getSize();
    V get(K key);
}
