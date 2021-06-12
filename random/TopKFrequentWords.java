package random;

import java.util.*;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, KFrequentPojo> map = new HashMap<>();
        
        for(String word:words){
            if(map.containsKey(word)){
                map.get(word).count = map.get(word).count +1;
            }else{
                map.put(word, new KFrequentPojo(word));
            }
        }
        Queue<TopKFrequentWords.KFrequentPojo> pq = new PriorityQueue<>((a, b)->{
            if(a.count == b.count){
                return a.word.compareTo(b.word);
            }
            return -1 * Integer.compare(a.count, b.count);
        });
        
        for(KFrequentPojo pojo : map.values()){
            pq.add(pojo);
        }
        var result = new ArrayList<String>();
        for(int i=0; i < k; i ++){
            result.add(pq.poll().word);
        }
        return result;
        
    }
    public static class KFrequentPojo {
        String word;
        Integer count;
        public KFrequentPojo(String word){
            this.word = word;
            this.count = 1;
        }
    }
}