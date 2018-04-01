package com.practice;

/**
 * Implement 28. Implement strStr()
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || haystack == null) {
            return -1;
        }
        if (needle.length() == 0 || needle == null) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int mIndex = -1;
        int mDiffTime = haystack.length() - needle.length() + 1;
        for (int i = 0; i < mDiffTime; i++) {
            if (haystack.startsWith(needle, i) == true) {
                mIndex = i;
                break;
            }
        }
        return mIndex;
    }
    public int strStr2(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int mIndex = -1;
        int mDiffTime = haystack.length() - needle.length() + 1;
        for (int i = 0; i < mDiffTime; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                mIndex = i;
                break;
            }
        }
        return mIndex;
    }
}
