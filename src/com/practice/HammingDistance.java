package practice;

/**
 * Implement 461. Hamming Distance
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int mXOR = 0, mCount = 0;
            mXOR = x ^ y;
            while(mXOR > 0) {
                if(mXOR%2 != 0) {
                    mCount++;
                }
                mXOR /= 2;
            }
            return mCount;
        }
        
        public int hammingDistance2(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}
