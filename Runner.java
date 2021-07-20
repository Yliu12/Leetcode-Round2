import java.util.*;

class Runner {

    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        Map<Integer, LinkedList<Integer>> elementIndexMap = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < nums2.length; i++) {
            var val = elementIndexMap.getOrDefault(nums2[i], new LinkedList<Integer>());
            val.add(i);
            elementIndexMap.put(nums2[i], val);
        }

        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            if (elementIndexMap.containsKey(curr)) {
                LinkedList<Integer> currentList = new LinkedList(elementIndexMap.get(curr));

                int next = i + 1;
                while (!currentList.isEmpty()) {
                    if (next == nums1.length) {
                        return result;
                    }
                    int nextVal = nums1[next];
                    int length = currentList.size();
                    for (int j = 0; j < length; j++) {
                        int indexOf2 = currentList.poll();
                        if (indexOf2 + 1 == nums2.length - 1) {
                            continue;
                        }
                        if (nextVal == nums2[indexOf2 + 1]) {
                            currentList.add(indexOf2 + 1);
                            result = Math.max(next - i +1, result);
                        }
                    }
                    next++;
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println((new Runner()).findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));
    }
}