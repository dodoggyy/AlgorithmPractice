package practice;

import java.util.HashMap;

/**
 * Implement 771. Jewels and Stones
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int mCount = 0;
        HashMap mJewel = new HashMap();
        for (int i = 0; i < J.length(); i++) {
            if (mJewel.get(J.charAt(i)) == null) {
                mJewel.put(J.charAt(i), 1);
                // System.out.println(J.charAt(i));
            }
        }
        for (int i = 0; i < S.length(); i++) {
            if (mJewel.get(S.charAt(i)) != null) {
                mCount++;
            }
        }

        return mCount;
    }

    public int numJewelsInStones2(String J, String S) {
        int mCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) >= 0) {
                mCount++;
            }
        }

        return mCount;
    }
}
