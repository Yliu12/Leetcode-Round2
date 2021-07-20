import java.util.*;
import java.util.stream.*;

public class LRUCache {

    LinkedHashMap<Integer, Integer> lhm;
    int capacity;
    public LRUCache(int capacity) {
        this.lhm = new LinkedHashMap<Integer, Integer>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(lhm.containsKey(key)){
            int v = lhm.get(key);
            
        }
        return -1;
    }
    
    public void put(int key, int value) {
        lhm.put(key, value);
        if( lhm.size() > capacity){
            lhm.remove(lhm.keySet().iterator().next());
        }
    }
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

}
