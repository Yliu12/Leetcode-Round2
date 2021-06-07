package random;

import java.util.*;
import java.util.stream.IntStream;

class AnalyzeUserWebsite {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<String>> userHistory = new HashMap<>();
        Map<String, Integer> notsortedHistory = new HashMap<>();

        IntStream.range(0, username.length).forEach(i -> {
            if (userHistory.containsKey(username[i])) {
                var list = userHistory.get(username[i]);
                list.add(website[i]);
                if (list.size() >= 3) {
                    var three = String.join("SPLIT", list.subList(list.size() - 3, list.size()));
                    if (notsortedHistory.containsKey(three)) {
                        notsortedHistory.put(three, notsortedHistory.get(three) + 1);
                    } else {
                        notsortedHistory.put(three, 1);
                    }
                }
            } else {
                var history = new ArrayList<String>();
                history.add(website[i]);
                userHistory.put(username[i], history);
            }
        });
        Queue<AnalyzeUserWebsitePojo> sortedHistory = new PriorityQueue<>((a, b) -> a.compareTo(b));
        for (var entry : notsortedHistory.entrySet()) {
            sortedHistory.add(new AnalyzeUserWebsitePojo(entry.getKey(), entry.getValue()));
        }
        return Arrays.asList(sortedHistory.poll().history.split("SPLIT"));
    }

    public class AnalyzeUserWebsitePojo {
        public AnalyzeUserWebsitePojo(String history, int count) {
            this.history = history;
            this.count = count;
        }

        String history;
        int count;
        String text;

        public int compareTo(AnalyzeUserWebsitePojo b) {
            return Integer.compare(this.count, b.count) == 0 ? this.history.compareTo(b.history)
                    : -1 * Integer.compare(this.count, b.count);

        }
    }
}