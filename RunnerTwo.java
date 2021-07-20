import java.util.*;
import java.util.stream.*;

public class RunnerTwo {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){return 0;}
        HashSet<Pojo> memory = new HashSet<>();

        HashSet<String> avaliableWords = new HashSet<>(wordList);
        Queue<Pojo> queue= new LinkedList<>();
        queue.add(new Pojo(beginWord, avaliableWords));
        int result = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            result ++;
            for(int i = 0; i <levelSize; i ++ ){
                Pojo pojo = queue.poll();
                if(memory.contains(pojo)) continue;
                memory.add(pojo);
                String currentW = pojo.currentWord;
                HashSet<String> dict = pojo.avaliabeDict;
                Set<String> oneJumps = dict.stream().filter(w->isDiffByOne(w, currentW)).collect(Collectors.toSet()); 
                for(String word: oneJumps){
                    if(word.equals(endWord)) {
                        return levelSize;
                    }
                    HashSet<String> newDict = new HashSet<>(pojo.avaliabeDict);
                    newDict.remove(word);
                    queue.add(new Pojo(word, newDict));
                }
            }
        }

        return 0;

    }
    
    public boolean isDiffByOne(String w1, String w2){
        return false;
    }
    
    public static class Pojo {
        public String currentWord; 
        public HashSet <String> avaliabeDict;
        public Pojo(String word, HashSet <String> avaliabeDict){
            this.currentWord = word;
            this.avaliabeDict = avaliabeDict;
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentWord, avaliabeDict);
        }
    }
    public static void main(String[] args) {
        // System.out.println((new RunnerTwo()).numKLenSubstrNoRepeats("havefunonleetcode",  5));
    }

}
