package com.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Display Ordering Decision2
 * 
 * @author Chris.Lin
 * @version 1.0 18 Mar 2018
 */
public class OrderingDecisionHandle2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        /** PART4 */
        int mDays = 32;
        String mPath = "E:\\data\\";
        String mFileName = "data2.txt";
        boolean bIsFileExist;

        int T, // 規劃期間為T天
                H, // 單位持有成本
                B, // 單位缺貨成本
                A, // 單次訂購成本
                C; // 單位進貨成本

        int[] D = new int[mDays], // 儲存第i(=1,…,31)天的預測需求量
                I = new int[mDays], // 儲存第i(=0,…,31)天的期末存貨量
                L = new int[mDays], // 儲存第i(=0,…,31)天的期末缺貨量
                Y = new int[mDays], // 儲存第i(=0,…,30)天的訂購決定
                O = new int[mDays]; // 儲存第i(=1,…,31)天的期初進貨量

        int[] s = new int[13], // 再訂購點
                Q = new int[11], // 經濟訂購批量
                V = { 2, 4, 6 }, // 初始進貨日
                R = new int[8], // 訂購週期
                S = new int[8]; // 預期期初庫存量

        int mTotalDt = 0; // 總需求量
        int mAvgDt = 0; // 平均需求量
        int mSDDt = 0; // 標準差
        int mTmp = 0; // 暫存值
        int mTotalCost = 0; // 總成本

        // 暫存值
        int mTmps = 0;
        int mTmpQ = 0;
        int mTmpTotalCost = 0;
        int mTmpIC = 0;
        int mTmpBC = 0;
        int mTmpOC = 0;
        int mTmpPC = 0;
        int mBests = 0;
        int mBestQ = 0;
        int mBestR = 0;
        int mBestS = 0;

        int IC = 0; // 存貨成本
        int BC = 0; // 缺貨成本
        int OC = 0; // 訂購成本
        int PC = 0; // 進貨成本

        Scanner mScanner = new Scanner(System.in);
        Path mFilePath = Paths.get(mPath + mFileName);
        mScanner = new Scanner(mFilePath);
        T = mScanner.nextInt();
        for (int i = 1; i <= T; i++) {
            D[i] = mScanner.nextInt();
        }
        H = mScanner.nextInt();
        B = mScanner.nextInt();
        A = mScanner.nextInt();
        C = mScanner.nextInt();
        mScanner.nextInt();// 忽略V
        mScanner.nextInt();// 忽略R
        I[0] = mScanner.nextInt();
        L[0] = mScanner.nextInt();

        System.out.printf("T=%d, D= ", T);
        for (int i = 1; i <= T; i++) {
            System.out.printf("%d ", D[i]);
            mTotalDt += D[i];
        }
        mAvgDt = mTotalDt / T;
        for (int i = 1; i <= T; i++) {
            mTmp += Math.pow((D[i] - mAvgDt), 2);
        }
        mSDDt = (int) Math.sqrt(mTmp / (T - 1)); // 標準差
        mTmps = mAvgDt + mSDDt;
        s[0] = mTmps - 2 * mSDDt;
        for (int i = 1; i < s.length; i++) { // 設定st可能的值 s-2mSDDt,
                                             // s-2mSDDt+2,...,s
            s[i] = s[0] + 2 * i;
        }

        mTmpQ = (int) Math.floor(Math.sqrt(2 * A * mTotalDt / H));
        Q[0] = mTmpQ - 50; // 設Q[0]為Q -50
        for (int i = 1; i < Q.length; i++) { // 設定Qt可能的值 Q-50, Q-40,...,Q+50
            Q[i] = Q[0] - 50 + 10 * i;
        }

        for (int i = 0; i < R.length; i++) { // 設定(R,S)值
                                             // (1,mAvgDt),(3,3mAvgDt),...(15,15mAvgDt)
            R[i] = 1 + 2 * i;
            S[i] = (1 + 2 * i) * mAvgDt;
        }

        System.out.printf("\nD=%d, D_bar=%d, stdev=%d; ", mTotalDt, mAvgDt, mSDDt);

        for (int j = 0; j < s.length; j++) {
            for (int k = 0; k < Q.length; k++) {

                mTmpTotalCost = mTmpIC = mTmpBC = mTmpOC = mTmpPC = 0; // 重置暫存值
                for (int m = 0; m <= T; m++) { // 重置陣列值
                    Y[m] = O[m] = L[m] = 0;
                }

                System.out.printf("\n\n\n");
                System.out.printf("(s=%d,Q=%d) model:\n", s[j], Q[k]);
                System.out.printf("t\tD\tO\tI\tL\n");
                System.out.printf("-----------------------------\n");
                for (int i = 0; i <= T; i++) {
                    if (i > 0) {
                        I[i] = I[i - 1] - D[i] + O[i];

                        if (I[i] < 0) {
                            L[i] = Math.abs(I[i]);
                            I[i] = 0;
                        } else {
                            mTmpIC += H * I[i];
                        }

                        mTmpBC += B * L[i];
                        mTmpPC += C * O[i];

                        if (I[i] < s[j] && i < T) { // 當存貨量少或等於此值時，隨即引發一次訂購
                            Y[i + 1] = 1;
                            O[i + 1] = Q[k];
                        }
                    }
                    if (i >= 0 && i < T) {
                        mTmpOC += A * Y[i];
                    }

                    System.out.printf("%d\t%d\t%d\t%d\t%d\n", i, D[i], O[i], I[i], L[i]);
                }
                mTmpTotalCost = mTmpIC + mTmpBC + mTmpOC + mTmpPC;
                System.out.printf("===============================\n");
                System.out.printf("Total cost: %d = %d(IC) + %d(BC) + %d(OC) + %d(PC)\n", mTmpTotalCost, mTmpIC, mTmpBC,
                        mTmpOC, mTmpPC);

                if (mTmpTotalCost < mTotalCost || mTotalCost == 0) { // 找出最小cost
                                                                     // 或是 第一次存
                    mTotalCost = mTmpTotalCost;
                    IC = mTmpIC;
                    BC = mTmpBC;
                    OC = mTmpOC;
                    PC = mTmpPC;
                    mBests = s[j];
                    mBestQ = Q[k];
                }
            }
        }

        System.out.printf(
                "\n\n\nBest choice:(s,Q) = (%d, %d)\n" + "Total cost: %d = %d(IC) + %d(BC) + %d(OC) + %d(PC)\n", mBests,
                mBestQ, mTotalCost, IC, BC, OC, PC);

        mTotalCost = IC = BC = OC = PC = 0; // 重置
        for (int j = 0; j < V.length; j++) {
            for (int k = 0; k < R.length; k++) {
                for (int i = 0; i <= T; i++) { // 重置陣列值
                    Y[i] = O[i] = L[i] = 0;
                }
                mTmpTotalCost = mTmpIC = mTmpBC = mTmpOC = mTmpPC = 0; // 重置暫存值
                System.out.printf("\n\n\n");
                System.out.printf("(R=%d,S=%d) model:\n", R[k], S[k]);
                System.out.printf("t\tD\tO\tI\tL\n");
                System.out.printf("-----------------------------\n");
                int mDivision = 0;
                for (int i = 0; i <= T; i++) {
                    if (i > 0) {
                        I[i] = I[i - 1] - D[i] + O[i];
                        if (I[i] < 0) {
                            L[i] = Math.abs(I[i]);
                            I[i] = 0;
                        }

                        if (I[i] > 0) {
                            mTmpIC += H * I[i];
                        }

                        mTmpBC += B * L[i];
                        mTmpPC += C * O[i];

                        if ((i < T) && ((i + 1) == (V[j] + R[k] * mDivision)) && I[i] < S[k]) { // 每隔R日即進貨一次
                            Y[i + 1] = 1;
                            O[i + 1] = S[k] - I[i];
                            mDivision++;
                        }
                    }
                    if (i >= 0 && i < T) {
                        mTmpOC += A * Y[i];
                    }

                    System.out.printf("%d\t%d\t%d\t%d\t%d\n", i, D[i], O[i], I[i], L[i]);
                }
                mTmpTotalCost = mTmpIC + mTmpBC + mTmpOC + mTmpPC;
                System.out.printf("===============================\n");
                System.out.printf("Total cost: %d = %d(IC) + %d(BC) + %d(OC) + %d(PC)\n", mTmpTotalCost, mTmpIC, mTmpBC,
                        mTmpOC, mTmpPC);

                if (mTmpTotalCost < mTotalCost || mTotalCost == 0) { // 找出最小cost
                                                                     // 或是 第一次存
                    mTotalCost = mTmpTotalCost;
                    IC = mTmpIC;
                    BC = mTmpBC;
                    OC = mTmpOC;
                    PC = mTmpPC;
                    mBestR = R[k];
                    mBestS = S[k];
                }
            }
        }
        
        System.out.printf(
                "\n\n\nBest choice:(R,S) = (%d, %d)\n" + "Total cost: %d = %d(IC) + %d(BC) + %d(OC) + %d(PC)\n", mBestR,
                mBestS, mTotalCost, IC, BC, OC, PC);

    }
}
