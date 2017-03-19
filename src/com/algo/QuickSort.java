package com.algo;

/**
 * Display quick sort algorithm 
 * @author Chris.Lin
 * @version 1.0 19 Mar 2017
 */

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] unsortData = new int[dataLength];

        System.out.println(" Unsorted data:");
        genRandArray(unsortData);
        
        quickSort(unsortData, 0, (unsortData.length-1));
        System.out.println("\n Quick sort with in-place:");
        for(int i=0; i < unsortData.length; i++){
            System.out.print(unsortData[i] + " "); 
        }
        
        
    }
    
    /** Quick sort algorithm with Hoare partition version*/
    public static void quickSort(int[] inputData,int indexStart, int indexEnd){
        if(indexStart < indexEnd){
            int i = indexStart;
            int j = indexEnd ;
            int pivotKey = inputData[indexStart];
            
            while(i < j){
                //Find the index value greater than pivot in the left side
                while(inputData[i] <= pivotKey && i < indexEnd){
                    i++;
                }
            
                //Find the index value less than pivot in the right side
                while(inputData[j] > pivotKey && j > indexStart){
                    j--;
                }
            
                if(i < j){
                    swap(inputData, i, j);//swap greater value to right,less value to left
                }
            }
            
            swap(inputData, indexStart, j);  //place pivot key value into correct position
            quickSort(inputData, indexStart, (j-1));  //quick sort in left side
            quickSort(inputData, (j+1), indexEnd);  //quick sort in right side
        }
    }

    /** SWAP function*/
    public static void swap(int[] inputArray, int index1, int index2){
        int tmp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = tmp;
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
