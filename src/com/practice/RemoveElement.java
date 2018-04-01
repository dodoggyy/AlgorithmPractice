package com.practice;

/**
 * Implement 27. Remove Element
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class RemoveElement {

    // val=3 then [3,2,2,3] -> [2,2]
    class Solution {
        public int removeElement(int[] nums, int val) {
            int mLen = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[mLen++] = nums[i];
                }
            }
            return mLen;
        }
    }
}
