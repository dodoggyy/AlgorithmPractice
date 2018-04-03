package com.practice;

/**
 * Implement 7. Reverse Integer
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            String mInvert = "";
            boolean mIsNegative = false;
            while (x != 0) {
                if (x < 0 && !mIsNegative) {
                    mInvert += "-";
                    if (x == Integer.MIN_VALUE) {
                        return 0;
                    }
                    x = Math.abs(x);
                    mIsNegative = true;
                }
                mInvert += (x % 10);
                x /= 10;

            }
            if (mInvert.equals("") || Long.parseLong(mInvert) > Integer.MAX_VALUE
                    || Long.parseLong(mInvert) < Integer.MIN_VALUE) {
                return 0;
            } else {
                return Integer.parseInt(mInvert);
            }
        }

        public int reverse2(int x) {
            int mReverse = 0;

            while (x != 0) {
                int mTmpResult = x % 10;
                mReverse *= 10;
                mReverse += (x % 10);
                if (mReverse % 10 != mTmpResult) {
                    return 0;
                }
                x /= 10;
            }
            return mReverse;
        }
    }
}
