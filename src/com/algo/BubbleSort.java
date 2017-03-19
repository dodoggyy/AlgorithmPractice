package com.algo;

import java.util.Arrays;

/**
 * Display bubble sort algorithm 
 * @author Chris.Lin
 * @version 1.0 12 Mar 2017
 */
public class BubbleSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] unsortData1 = new int[dataLength];
        int[] unsortData2 = new int[dataLength];
        System.out.println(" Unsorted data:");
        genRandArray(unsortData1);
        unsortData2 = Arrays.copyOf(unsortData1, unsortData1.length);

        bubbleSort(unsortData1);
        System.out.println("\n Bubble sort with check flag :");
        for(int i=0; i < unsortData1.length; i++){
            System.out.print(unsortData1[i] + " "); 
        }
        
        bubbleSortNonFlag(unsortData2);
        System.out.println("\n Bubble sort with non-checked flg:");
        for(int i=0; i < unsortData2.length; i++){
            System.out.print(unsortData2[i] + " "); 
        }

    }

    /** Selection sort algorithm with flag check*/
    public static void bubbleSort(int[] inputData){
        for(int i=0; i < inputData.length; i++){
            boolean bSwap = false;
            for(int j=0; j < (inputData.length - i - 1); j++){
                if(inputData[j+1] < inputData[j]){
                    int tmp = inputData[j+1];
                    inputData[j+1] = inputData[j];
                    inputData[j] = tmp;
                    bSwap = true;
                }
            }
            if(bSwap == false){//check array has swapped or not this time
                break;
            }
        }
    }
    
    /** Selection sort algorithm with non-flag check*/
    public static void bubbleSortNonFlag(int[] inputData){
        for(int i=0; i < inputData.length; i++){
            for(int j=0; j < (inputData.length - i - 1); j++){
                if(inputData[j+1] < inputData[j]){
                    int tmp = inputData[j+1];
                    inputData[j+1] = inputData[j];
                    inputData[j] = tmp;
                }
            }
        }
    }

    /** Generate random data*/
    public static void genRandArray(int[] randArray){
        for (int i=0; i < randArray.length; i++){
            int n = (int)(Math.random()*(randArray.length - 1) + 1);
            randArray[i] = n;
            System.out.print(randArray[i] + " ");
        }
    }

}
