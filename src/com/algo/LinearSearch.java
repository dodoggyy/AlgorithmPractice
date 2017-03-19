package com.algo;

/**
 * Display basic search algorithm 
 * @author Chris.Lin
 * @version 1.0 6 Mar 2017
 */

public class LinearSearch {
    static final int INDEX_LOW = 0;
    static final int COUNTER = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        
        int[] randData = new int[dataLength];
        int searchNumber = (int)(Math.random()*(dataLength - 1) + 1);
        for (int i=0; i < dataLength; i++){
            int n = (int)(Math.random()*(dataLength - 1) + 1);
            randData[i] = n;
            System.out.print(randData[i] + " ");
        }
        
        //Linear search
        System.out.println("\nsearch number:" + searchNumber);
        System.out.println("search index:" + linearSearch(randData,searchNumber));

    }
    
    /** Linear search algorithm */
    public static int linearSearch(int data[], int search){
        for(int i=0; i < data.length; i++){
            if(data[i] == search){
                System.out.println("search times:" + i);
                return i;
            }
        }
        System.out.println("search times:" + data.length);
        return -1;
    }
}
