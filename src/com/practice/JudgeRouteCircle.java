package practice;

import java.util.HashMap;

/**
 * Implement 657. Judge Route Circle
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class JudgeRouteCircle {
    class Solution {
        public boolean judgeCircle(String moves) {
            if ((moves.length() % 2) != 0) {
                return false;
            }
            int[] mCount = { 0, 0 };
            for (int i = 0; i < moves.length(); i++) {
                switch (moves.charAt(i)) {
                case 'L':
                    mCount[0]--;
                    break;
                case 'R':
                    mCount[0]++;
                    break;
                case 'U':
                    mCount[1]++;
                    break;
                case 'D':
                    mCount[1]--;
                    break;
                default:
                    return false;
                }
            }
            if (mCount[0] != 0 || mCount[1] != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean judgeCircle2(String moves) {
        int x = 0, y = 0;
        for(char c : moves.toCharArray()) {
            switch (c) {
            case 'L':
                x--;
                break;
            case 'R':
                x++;
                break;
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
            default:
                return false;
            }
        }
        return (x==0 && y==0);
    }
}
