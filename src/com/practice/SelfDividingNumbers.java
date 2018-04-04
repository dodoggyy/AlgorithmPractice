package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement 728. Self Dividing Numbers
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class SelfDividingNumbers {
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> mList = new ArrayList<Integer>();
            for (int i = left; i < right; i++) {
                int mTmp = i, mSelfDigit = 0;
                boolean bIsSelfDivide = true;
                while (mTmp != 0) {
                    mSelfDigit = mTmp % 10;
                    if (mSelfDigit == 0) {
                        bIsSelfDivide = false;
                        break;
                    }
                    if ((i % mSelfDigit) != 0) {
                        bIsSelfDivide = false;
                        break;
                    }
                    mTmp /= 10;
                }
                if (bIsSelfDivide) {
                    mList.add(i);
                }
            }
            return mList;

        }
    }
}
