package com.test;

import java.util.Scanner;

public class SimpleConcertHandle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /** PART1 */
        int[] S = new int[20]; // seat number
        int[] P = new int[20]; // seat preference

        /** PART2 */
        Scanner mScanner = new Scanner(System.in);
        System.out.print("Number of seats n in [5,20] = ?");
        int mSeat = mScanner.nextInt();
        int mEvenShift = (mSeat % 2 == 0) ? 1 : 0; // 偶數座位初始位置需要做位移,因為迴圈從0開始
                                                   // 除以2再向左移1

        while (mSeat > 20 || mSeat < 5) { //超過範圍例外處理,直到輸入範圍內的數字
            System.out.print("!!WRONG!! Please input an integer in [5,20] = ?");
            mSeat = Integer.parseInt(mScanner.next());
        }

        for (int i = 0; i < mSeat; i++) {
            if (i < mSeat / 2) { //前半數列處理
                S[i] = mSeat - 2 * i - mEvenShift;
                P[i] = i + 1;
            } else if (i > mSeat / 2 - mEvenShift) { //後半數列處理
                S[i] = mSeat - 2 * (mSeat - i - 1) - 1 + mEvenShift;
                P[i] = mSeat - i;
            } else { //中間數處理
                S[i] = 1;
                P[i] = i + 1;
            }
        }

        System.out.print("Seat number:");
        for (int i = 0; i < mSeat; i++) { // 印出所有座位號碼表
            System.out.print(S[i] + " ");
        }
        System.out.print("\nSeat preference:");
        for (int i = 0; i < mSeat; i++) { // 印出所有座位喜好度表
            System.out.print(P[i] + " ");
        }

        System.out.print("\nOccupied seat no.: ?");
        mScanner = new Scanner(System.in);
        String mOccupied = mScanner.nextLine();
        String[] mOccupiedArray = mOccupied.split(" ");
        int[] mOccupiedList = new int[mOccupiedArray.length];
        // for (int i = 0; i < mOccupiedList.length; i++) {
        // mOccupiedList[i] = Integer.parseInt(mOccupiedArray[i]);
        // }

        for (int i = 0; i < mOccupiedList.length; i++) {
            System.out.print(mOccupiedList[i] + " ");
        }

        int[] mAvailiableList = new int[mSeat];

        for (int i = 0; i < mSeat; i++) {
            boolean bOccupied = false;
            for (int j = 0; j < mOccupiedList.length; j++) {
                if (S[i] == mOccupiedList[j]) {
                    bOccupied = true;
                    break;
                }
            }
            if (bOccupied) {
                mAvailiableList[i] = -1;
            }
        }

        /** PART3 */
        System.out.print("\nSeat number:");
        for (int i = 0; i < mSeat; i++) { // 印出所有座位號碼表狀態 X:已被佔據
            if (mAvailiableList[i] != -1) {
                System.out.print(S[i] + " ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.print("\nSeat preference:");
        for (int i = 0; i < mSeat; i++) { // 印出所有座位喜好度表狀態 X:已被佔據
            if (mAvailiableList[i] != -1) {
                System.out.print(P[i] + " ");
            } else {
                System.out.print("X ");
            }
        }

        /** PART4 */
        System.out.print("\nHow many adjacent seats to seek?");
        mScanner = new Scanner(System.in);
        int mSeek = mScanner.nextInt();

        if (mSeek > mSeat || mSeek < 1) {
            System.out.printf("Sorry! No %d adjacent seats!\n", mSeek);
        } else {
            int[] mAdjacentSeatList = new int[mSeek];
            int mTotalPreference = 0;
            for (int i = 0; i < (mSeat - mSeek); i++) { // 找出n相鄰有空閒的座位
                int mTmpPreference = 0;
                if (mAvailiableList[i] != -1) { // 如果有空閒的座位 則看接下鄰近座位是否也為空閒
                    for (int j = 0; j < mSeek; j++) {
                        if (mAvailiableList[j + i] != -1) {
                            mTmpPreference += P[j + i];
                        } else {
                            mTmpPreference = 0;
                            break;
                        }
                    }
                }

                if (mTotalPreference < mTmpPreference) { // 如果找到當前喜好度比之前的高,取代它並記錄座位
                    mTotalPreference = mTmpPreference;
                    for (int j = 0; j < mSeek; j++) {
                        mAdjacentSeatList[j] = S[j + i];
                    }
                }
            }

            if (mTotalPreference != 0) { // 印出總喜好度最高的K個相鄰座位號碼與總喜好度
                System.out.printf("Best %d adjacent seats: no. ", mSeek);
                for (int i = 0; i < mSeek; i++) {
                    System.out.printf("%d, ", mAdjacentSeatList[i]);
                }
                System.out.printf("with total preference %d", mTotalPreference);
            } else {
                System.out.printf("Sorry! No %d adjacent seats!\n", mSeek);
            }
        }

    }

}