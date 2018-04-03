package com.practice;

/**
 * Implement 9. Palindrome Number
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class Palindrome {

    static class Solution {
        public static boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int mReverse = 0;
            int mTmp = x;
            while (x != 0) {
                int mTmpResult = x % 10;
                mReverse *= 10;
                mReverse += (x % 10);
                if (mReverse % 10 != mTmpResult) {
                    return false;
                }
                x /= 10;
            }

            return (mReverse == mTmp);
        }

        public boolean isPalindrome2(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int mReverse = 0;
            while (x > mReverse) {
                int mTmpResult = x % 10;
                mReverse *= 10;
                mReverse += (x % 10);
                if (mReverse % 10 != mTmpResult) {
                    return false;
                }
                x /= 10;
            }

            return (mReverse == x || ((mReverse / 10) == x));
        }
    }
}
