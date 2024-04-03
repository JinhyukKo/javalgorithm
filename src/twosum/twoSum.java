package twosum;

import java.util.HashMap;

public class twoSum {

  public static void main(String[] args) throws Exception {
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      hashMap.put(nums[i], i);
    }
    int[] result = new int[2];

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
        result[0] = i;
        result[1] = hashMap.get(complement);
      }
    }
    System.out.println(result[0] + " " + result[1]);
  }
}
