package practice;

import java.util.Arrays;

/**
 * Implement 414. Third Maximum Number
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class ThirdMaximumNumber {
    class Solution {
        public int thirdMax(int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            Arrays.sort(nums);
            if (nums.length == 2)
                return nums[1];
            int mCount = 1, mIndex = nums.length - 1;
            while (mCount < 3 && mIndex > 0) {
                if (nums[mIndex] != nums[mIndex - 1])
                    mCount++;
                mIndex--;
            }
            if (mCount < 3)
                return nums[nums.length - 1];
            return nums[mIndex];
        }

//        public int thirdMax2(int[] nums) {
//            if (nums.length == 0)
//                return 0;
//            if (nums.length == 1)
//                return nums[0];
//            if (nums.length == 2)
//                return (nums[0] > nums[1]) ? nums[0] : nums[1];
//            int mFirst = 0, mSecond = 0, mThird = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if(nums[i] == mFirst || nums[i] == mSecond)
//                    continue;
//                if (mFirst < nums[i]) {
//                    mThird = Math.max(mSecond, mThird);
//                    mSecond = Math.max(mFirst, mSecond);
//                    mFirst = nums[i];
//                } else if (mSecond < nums[i]) {
//                    mThird = Math.max(mSecond, mThird);
//                    mSecond = nums[i];
//                } else if (mThird < nums[i]) {
//                    mThird = nums[i];
//                }
//            }
//            if (mThird == 0)
//                return mFirst;
//            return mThird;
//        }
    }
}
