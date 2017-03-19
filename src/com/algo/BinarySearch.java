package com.algo;

import java.util.Arrays;

/**
 * Display binary search algorithm 
 * @author Chris.Lin
 * @version 1.0 19 Mar 2017
 */
public class BinarySearch {
    static final int INDEX_LOW = 0;
    static final int COUNTER = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] randData = new int[dataLength];
        int searchNumber = (int)(Math.random()*(dataLength - 1) + 1);

        System.out.println("Sorted data:");
        genRandArray(randData);
        
        //Sort array
        Arrays.sort(randData);
        for (int i=0; i < randData.length; i++){
            System.out.print(randData[i] + " ");
        }
        
        //Binary search
        System.out.println("\nsearch number:" + searchNumber);
        System.out.println("search index:" + binarySearch(randData,searchNumber));
        
        //Binary search with recursive version
        System.out.println("\nsearch number:" + searchNumber);
        System.out.println("search index:" + binarySearchRecursive(randData,INDEX_LOW, randData.length,searchNumber,COUNTER));
    }
    
    /** Binary search algorithm */
    public static int binarySearch(int data[], int search){
        int indexLow = 0;
        int indexHigh = data.length;
        int times = 0;
        
        while(indexLow <= indexHigh){
            int indexMid = (indexLow + indexHigh) / 2;
            times++;
            if (data[indexMid] == search){
                System.out.println("search times:" + times);
                return indexMid;
            }else if (data[indexMid] > search){
                indexHigh = indexMid - 1;
            }else if (data[indexMid] < search){
                indexLow = indexMid + 1;
            }
        }

        System.out.println("search times:" + times + " Not found");
        return -1;
    }
    
    /** Binary search algorithm with recursive implementation */
    public static int binarySearchRecursive(int data[],int indexLow, int indexHigh, int search,int times){
        if (indexLow <= indexHigh){
            int indexMid = (indexLow + indexHigh) / 2;
            times++;
            if (data[indexMid] == search){
                System.out.println("search times:" + times);
                return indexMid;
            }else if (data[indexMid] > search){
                return binarySearchRecursive(data,indexLow, (indexMid - 1), search, times);
            }else if (data[indexMid] < search){
                return binarySearchRecursive(data,(indexMid + 1), indexHigh, search, times);
            }
        }
        
        System.out.println("search times:" + times + " Not found");
        return -1;
    }
    
    /** Generate random data*/
    public static void genRandArray(int[] randArray){
        for (int i=0; i < randArray.length; i++){
            int n = (int)(Math.random()*(randArray.length - 1) + 1);
            randArray[i] = n;
        }
    }
}
