package com.practice;

/**
 * Implement 14. Longest Common Prefix
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if ((strs.length == 0) || (strs == null)) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String mLongestPrefix = strs[0];
            int mEndIndex = mLongestPrefix.length();
            for (int i = mLongestPrefix.length(); i > 0; i--) {
                if (strs[1].startsWith(mLongestPrefix) == false) {
                    mEndIndex--;
                } else {
                    mLongestPrefix = mLongestPrefix.substring(0, mEndIndex);
                    break;
                }
            }

            for (int i = 2; i < strs.length; i++) {
                if (strs[i].startsWith(mLongestPrefix) == false) {
                    mEndIndex--;
                } else {
                    mLongestPrefix = mLongestPrefix.substring(0, mEndIndex);
                }

            }
            return mLongestPrefix;
        }
    }

    public String longestCommonPrefix2(String[] strs) {
        if ((strs.length == 0) || (strs == null)) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String mLongestPrefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                for (int j = mLongestPrefix.length(); j > 0; j--) {
                    if (strs[i].startsWith(mLongestPrefix) == false) {
                        mLongestPrefix = mLongestPrefix.substring(0, mLongestPrefix.length() - 1);
                    } else {
                        break;
                    }
                }
                if (mLongestPrefix.length() == 0) {
                    break;
                }
            }
            return mLongestPrefix;
        }
    }
}
