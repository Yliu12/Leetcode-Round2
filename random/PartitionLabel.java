package random;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> charIndexMap = new HashMap<>();
        List<Character> uniqueChars = new ArrayList<>();
        for(int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if(charIndexMap.containsKey(c)){
                charIndexMap.get(c).add(i);
            } else {
                var list =  new ArrayList<Integer>();
                list.add(i);
                charIndexMap.put(c,list);
                uniqueChars.add(c);
            }
        }
        char start = s.charAt(0);
        List<Integer> startList = charIndexMap.get(start);
        List<int[]> partitions = new ArrayList<int[]>();
        
        var lastPartition = new int[]{ startList.get(0), startList.get(startList.size()-1)};
        partitions.add(lastPartition);
    
        for(char c: uniqueChars){
            var indexes = charIndexMap.get(c);
            var first = indexes.get(0); 
            var last = indexes.get(indexes.size()-1);
            if(first > lastPartition[1]){
                lastPartition = new int[]{ first, last};
                partitions.add(lastPartition);
            } else if(last> lastPartition[1]){
                lastPartition[1] = last;
            }
        }
         
        return  partitions.stream().map(indexes->indexes[1]-indexes[0]+1).collect(Collectors.toList());
        }
}
