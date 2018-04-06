package practice;

import java.util.HashMap;

/**
 * Implement 290. Word Pattern
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] mParts = str.split(" ");
            if (mParts.length != pattern.length())
                return false;
            HashMap mMapPattern = new HashMap();
            for (int i = 0; i < mParts.length; i++) {
                if (mMapPattern.containsKey(pattern.charAt(i))) {
                    if (!mMapPattern.get(pattern.charAt(i)).toString().equals(mParts[i])) {
                        return false;
                    }
                } else if (mMapPattern.containsValue(mParts[i])) {
                    if(mMapPattern.get(pattern.charAt(i)) == null )
                    return false;
                } else {
                    mMapPattern.put(pattern.charAt(i), mParts[i]);
                }
            }
            return true;
        }
    }
}
