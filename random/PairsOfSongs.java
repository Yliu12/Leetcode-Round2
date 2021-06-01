package random;

import java.util.*;

public class PairsOfSongs {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> timeCountMap = new HashMap<>();
        for(int i: time){
            var key = i%60;
            if(timeCountMap.containsKey(key)){
                timeCountMap.put(key, timeCountMap.get(key)+1);
            } else{
                timeCountMap.put(key, 1);
            }
        }
         System.out.print(timeCountMap);
        int result = 0;
        for(var key: timeCountMap.keySet()){
            var times = timeCountMap.get(key);
            if(key == 30 || key == 0){
                if(times == 1){
                    continue;
                }
                result += times*(times-1) *.5;
               
            }else if( timeCountMap.containsKey(60-key)){
                result += times * timeCountMap.get(60-key);
                timeCountMap.put(60-key, 0);
            }
        }
        return result;
    }
}
