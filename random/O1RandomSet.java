package random;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class O1RandomSet {

    /** Initialize your data structure here. */
    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> list;

    public O1RandomSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        hashMap.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }
        int lastVal = list.get(list.size() - 1);
        int index = hashMap.get(val);
        list.set(index, lastVal);
        hashMap.put(lastVal, index);
        list.remove(list.size() - 1);
        hashMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size() - 1));
    }
}
