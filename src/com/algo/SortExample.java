package com.algo;

public class SortExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] unsortData = new int[dataLength];

        System.out.println(" Unsorted data:");
        genRandArray(unsortData);
        
        Sort(unsortData, 0, (unsortData.length-1));
        System.out.println("\n sort with :");
        for(int i=0; i < unsortData.length; i++){
            System.out.print(unsortData[i] + " "); 
        }

    }

    /**  sort algorithm with version*/
    public static void Sort(int[] inputData,int indexStart, int indexEnd){
        
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
