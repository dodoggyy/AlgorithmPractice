package com.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Display Ordering Decision
 * 
 * @author Chris.Lin
 * @version 1.1 18 Mar 2018
 */
public class OrderingDecisionHandle {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        /** PART1 */
        int mDays = 32;
        String mPath = "E:\\data\\";
        String mFileName = "";
        boolean bIsFileExist;

        int T, // 規劃期間為T天
                H, // 單位持有成本
                B, // 單位缺貨成本
                A, // 單次訂購成本
                C, // 單位進貨成本
                s, // 再訂購點
                Q, // 經濟訂購批量
                V, // 初始進貨日
                R, // 訂購週期
                S; // 預期期初庫存量

        int[] D = new int[mDays], // 儲存第i(=1,…,31)天的預測需求量
                I = new int[mDays], // 儲存第i(=0,…,31)天的期末存貨量
                L = new int[mDays], // 儲存第i(=0,…,31)天的期末缺貨量
                Y = new int[mDays], // 儲存第i(=0,…,30)天的訂購決定
                O = new int[mDays]; // 儲存第i(=1,…,31)天的期初進貨量

        int mTotalDt = 0; // 總需求量
        int mAvgDt = 0; // 平均需求量
        int mSDDt = 0; // 標準差
        int mTmp = 0; // 暫存值
        int mTotalCost = 0; // 總成本

        int IC = 0; // 存貨成本
        int BC = 0; // 缺貨成本
        int OC = 0; // 訂購成本
        int PC = 0; // 進貨成本

        System.out.print("Enter filename:");
        Scanner mScanner = new Scanner(System.in);
        mFileName = mScanner.next();

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
        V = mScanner.nextInt();
        R = mScanner.nextInt();
        I[0] = mScanner.nextInt();
        L[0] = mScanner.nextInt();

        System.out.printf("T=%d, D= ", T);
        for (int i = 1; i <= T; i++) {
            System.out.printf("%d ", D[i]);
            mTotalDt += D[i];
        }
        mAvgDt = mTotalDt / T; // 平均值
        for (int i = 1; i <= T; i++) {
            mTmp += Math.pow((D[i] - mAvgDt), 2);
        }
        mSDDt = (int) Math.sqrt(mTmp / (T - 1)); // 標準差
        s = mAvgDt + mSDDt;
        Q = (int) Math.floor(Math.sqrt(2 * A * mTotalDt / H));
        S = 7 * mAvgDt;

        System.out.printf("\nH=%d, B=%d, A=%d, C=%d, V=%d, R=%d, I[0]=%d, L[0]=%d ", H, B, A, C, V, R, I[0], L[0]);
        System.out.printf("\nD=%d, D_bar=%d, stdev=%d; ", mTotalDt, mAvgDt, mSDDt);
        System.out.printf("(s,Q)=(%d,%d); (R,S)=(%d,%d)", s, Q, R, S);

        /** PART2 */
        System.out.printf("\n\n\n");
        System.out.printf("(s=%d,Q=%d) model:\n", s, Q);
        System.out.printf("t\tD\tO\tI\tL\n");
        System.out.printf("-----------------------------\n");
        for (int i = 0; i <= T; i++) {
            if (i > 0) {
                I[i] = I[i - 1] - D[i] + O[i];
                if (I[i] < 0) {
                    L[i] = Math.abs(I[i]);
                    I[i] = 0;
                } else {
                    IC += H * I[i];
                }

                BC += B * L[i];
                PC += C * O[i];

                if (I[i] < s) { // 當存貨量少或等於此值時，隨即引發一次訂購
                    Y[i + 1] = 1;
                    O[i + 1] = Q;
                }
            }
            if (i >= 0 && i <= T) {
                OC += A * Y[i];
            }

            System.out.printf("%d\t%d\t%d\t%d\t%d\n", i, D[i], O[i], I[i], L[i]);
        }
        mTotalCost = IC + BC + OC + PC;
        System.out.printf("===============================\n");
        System.out.printf("Total cost: %d = %d(IC) + %d(BC) + %d(OC) + %d(PC)\n", mTotalCost, IC, BC, OC, PC);

        /** PART3 */
        for (int i = 0; i <= T; i++) { // 重置陣列值
            Y[i] = O[i] = L[i] = 0;
        }
        mTotalCost = IC = BC = OC = PC = 0; // 重置
        System.out.printf("\n\n\n");
        System.out.printf("(R=%d,S=%d) model:\n", R, S);
        System.out.printf("t\tD\tO\tI\tL\n");
        System.out.printf("-----------------------------\n");
        int mDivision = 0;
        for (int i = 0; i <= T; i++) {
            if (i > 0) {
                I[i] = I[i - 1] - D[i] + O[i];
                if (I[i] < 0) {
                    L[i] = Math.abs(I[i]);
                    I[i] = 0;
                } else {
                    IC += H * I[i];
                }

                BC += B * L[i];
                PC += C * O[i];

                if ((i + 1) == (V + R * mDivision) && I[i] < S) { // 每隔R日即進貨一次
                    Y[i + 1] = 1;
                    O[i + 1] = S - I[i];
                    mDivision++;
                }
            }
            if (i >= 0 && i <= T) {
                OC += A * Y[i];
            }

            System.out.printf("%d\t%d\t%d\t%d\t%d\n", i, D[i], O[i], I[i], L[i]);
        }
        mTotalCost = IC + BC + OC + PC;
        System.out.printf("===============================\n");
        System.out.printf("Total cost: %d = %d(IC) + %d(BC) + %d(OC) + %d(PC)\n", mTotalCost, IC, BC, OC, PC);
    }
}
