package com.algo;

import java.util.ArrayList;

/**
 * Display insertion sort algorithm 
 * @author Chris.Lin
 * @version 1.0 12 Mar 2017
 */
public class InsertionSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] randData = new int[dataLength];
        ArrayList<Integer> sortData = new ArrayList<Integer>();

        System.out.println(" Unsorted data:");
        genRandArray(randData);
        insertSortExtraSpace(randData,sortData);
        System.out.println("\n Insertion sort with out-of-place:");
        for(int i=0; i < sortData.size(); i++){
            System.out.print(sortData.get(i) + " "); 
        }
        
        insertSort(randData);
        System.out.println("\n Insertion sort with in-place:");
        for(int i=0; i < randData.length; i++){
            System.out.print(randData[i] + " "); 
        }

    }

    /** Insertion sort algorithm with in-place implementation*/
    public static void insertSort(int[] insertData){
        for(int i=1; i < insertData.length; i++){
            int addVal = insertData[i];
            int j = i;

            while(j > 0 && addVal < insertData[j-1]){
                insertData[j] = insertData[j-1]; //shift origin data to next position
                j--;
            }
            insertData[j] = addVal; //place value to correct position
        } 
    }

    /** Insertion sort algorithm with out-of-place implementation*/
    public static void insertSortExtraSpace(int[] insertData,ArrayList<Integer> outputData){
        for(int i=0; i < insertData.length; i++){
            int addVal = insertData[i];
            int j = i;

            while(j > 0 && addVal < outputData.get(j-1)){
                j--;
            }
            outputData.add(j, addVal); //place value to correct position
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
