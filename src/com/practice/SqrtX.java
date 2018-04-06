package practice;

/**
 * Implement 69. Sqrt(x)
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class SqrtX {
    class Solution {
        public int mySqrt(int x) {
            int mSqrt = 1;
            if (x == 0)
                return 0;
            for (int i = 1; i < x / 2; i++) {
                if (((i + 1) * (i + 1) > x) || ((i + 1) * (i + 1) < 0))
                    break;
                mSqrt++;
            }
            return mSqrt;
        }

        public int mySqrt2(int x) {
            if (x == 0)
                return 0;
            int mSqrt = 1, mStart = 1, mEnd = x / 2;
            while (mStart <= mEnd) {
                mSqrt = (mStart + mEnd) / 2;
                if (mSqrt < x/mSqrt) {
                    mStart = mSqrt + 1;
                } else if (mSqrt > x/mSqrt) {
                    mEnd = mSqrt - 1;
                    mSqrt--;
                } else {
                    return mSqrt;
                }
            }
            return mSqrt;
        }
    }
}
