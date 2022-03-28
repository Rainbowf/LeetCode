package leetcode;

import java.util.*;

//offer2q030

class RandomizedSet {
    //哈希表
    HashMap<Integer, Integer> map;
    //动态数组
    List<Integer> array;

    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, array.size());
        array.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastNum = array.get(array.size() - 1);

        array.set(index, lastNum);
        array.remove(array.size() - 1);

        map.put(lastNum,index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(array.size());
        return array.get(index);
    }
}