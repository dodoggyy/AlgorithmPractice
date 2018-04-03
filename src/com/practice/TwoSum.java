package com.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement 1. Two Sum
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) { // O(n^2)
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (target == nums[i] + nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }
    }

    class Solution2 { // O(2n) = O(n)
        public int[] twoSum(int[] nums, int target) {
            int[] mResult = new int[2];
            Map<Integer, Integer> mMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                mMap.put(target - nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (mMap.containsKey(nums[i]) && (mMap.get(nums[i]) != i)) {
                    mResult[1] = mMap.get(nums[i]);
                    mResult[0] = i;
                    return mResult;
                }
            }
            return null;
        }
    }
}
