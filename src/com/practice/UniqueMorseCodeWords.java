package practice;

/**
 * Implement 804. Unique Morse Code Words
 * 
 * @author Chris.Lin
 * @version 1.0
 */
import java.util.HashMap;

public class UniqueMorseCodeWords {

    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] mMorseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                    ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                    "--.." };
            int mInitialPosition = Integer.valueOf('a');
            int mCount = 0;
            String mTmp = "";
            HashMap mMorseConvert = new HashMap();
            for (int i = 0; i < words.length; i++) {
                mTmp = "";
                for (int j = 0; j < words[i].length(); j++) {
                    mTmp += mMorseCode[Integer.valueOf(words[i].charAt(j)) - mInitialPosition];
                }
                if (mMorseConvert.containsValue(mTmp) == false) {
                    mMorseConvert.put(words[i], mTmp);
                    mCount++;
                }
            }

            return mCount;

        }

        public int uniqueMorseRepresentations2(String[] words) {
            String[] mMorseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                    ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                    "--.." };
            HashMap mMorseConvert = new HashMap();
            for (int i = 0; i < words.length; i++) {
                StringBuffer mTmp = new StringBuffer("");
                for (int j = 0; j < words[i].length(); j++) {
                    mTmp.append(mMorseCode[Integer.valueOf(words[i].charAt(j)) - 'a']);
                }
                if (mMorseConvert.containsValue(mTmp.toString()) == false) {
                    mMorseConvert.put(words[i], mTmp.toString());
                }
            }

            return mMorseConvert.size();
        }
    }
}
