package com.algo;

/**
 * Display merge sort algorithm 
 * @author Chris.Lin
 * @version 1.0 16 Apr 2017
 */
public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] unsortData = new int[dataLength];

        System.out.println(" Unsorted data:");
        genRandArray(unsortData);
        
        mergeSortRecursive(unsortData, 0, (unsortData.length-1));
        System.out.println("\n Merge sort with :");
        for(int i=0; i < unsortData.length; i++){
            System.out.print(unsortData[i] + " "); 
        }
    }

    /** Merge sort algorithm with recursive version*/
    public static void mergeSortRecursive(int[] inputData,int indexStart, int indexEnd){
        if(indexStart >= indexEnd){
            return;
        }
        else{
            int mid = (indexStart + indexEnd)/2;
            mergeSortRecursive(inputData,indexStart, mid);
            mergeSortRecursive(inputData, (mid + 1), indexEnd);
            listMerge(inputData, indexStart, (mid + 1), indexEnd);
        }

    }
    
    /** Sort data with comparison two of array*/
    public static void listMerge(int[] inputData,int indexStart, int indexMid, int indexEnd){
        int i = indexStart, j = indexMid, indexTmp = indexStart;
        int indexLeftEnd = (indexMid - 1);
        int length = (indexEnd - indexStart + 1);
        int [] tmp = new int[inputData.length];

        while(i <= indexLeftEnd && j <= indexEnd){
            tmp[indexTmp++] = (inputData[i] < inputData[j])? inputData[i++]: inputData[j++];
        }

        while(i <= indexLeftEnd){
            tmp[indexTmp++] =  inputData[i++];
        }

        while(j <= indexEnd){
            tmp[indexTmp++] = inputData[j++];
        }
        
        for (i = 0; i < length; i++)
        {
            inputData[indexEnd] = tmp[indexEnd];
            indexEnd--;
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
