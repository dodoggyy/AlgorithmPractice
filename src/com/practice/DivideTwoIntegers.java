package com.practice;

/**
 * Implement 29. Divide Two Integers
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else {
                dividend+= 1;
            }
        }

        if (dividend == Integer.MAX_VALUE) {
            if (divisor == 1) {
                return Integer.MAX_VALUE;
            } else if(divisor == -1) {
                return -(Integer.MAX_VALUE);
            }
        }
        
        boolean bNegative = false;
        int mQuotient = 0;
        int mAbsDividend = Math.abs(dividend);
        int mAbsDivisor = Math.abs(divisor);

        if (mAbsDividend != dividend) {
            bNegative = !bNegative;
        }
        if (mAbsDivisor != divisor) {
            bNegative = !bNegative;
        }

        if (mAbsDividend < mAbsDivisor) {
            return 0;
        }

        while (mAbsDividend >= mAbsDivisor) {
            mAbsDividend -= mAbsDivisor;
            mQuotient++;
        }

        // mQuotient = Integer.MAX_VALUE;
        if (bNegative) {
            return -mQuotient;
        } else {
            return mQuotient;
        }
    }
}
