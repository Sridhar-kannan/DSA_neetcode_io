package arrays_and_hashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElementsInList {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(
                    new int[] {
                            entry.getKey(),
                            entry.getValue()
                    });
        }
        result.sort((o1, o2) -> o2[1] - o1[1]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = result.get(i)[0];
        }

        return res;

    }

    public static void main(String[] args) {

        int[] nums = { 5, 2, 5, 3, 5, 3, 1, 1, 3 };
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}