/**
 * 
 */
package com.algo;

import java.util.ArrayList;

/**
 * Display selection sort algorithm 
 * @author Chris.Lin
 * @version 1.0 12 Mar 2017
 */
public class SelectionSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int dataLength = 10;
        int[] unsortData = new int[dataLength];
        ArrayList<Integer> sortData = new ArrayList<Integer>();
        System.out.println(" Unsorted data:");
        genRandArray(unsortData);
        
        selectSortExtraSpace(unsortData, sortData);
        System.out.println("\n Selection sort with out-of-place:");
        for(int i=0; i < sortData.size(); i++){
            System.out.print(sortData.get(i) + " "); 
        }
        
        selectSort(unsortData);
        System.out.println("\n Selection sort with in-place:");
        for(int i=0; i < unsortData.length; i++){
            System.out.print(unsortData[i] + " "); 
        }
    }

    /** Selection sort algorithm with in-place implementation*/
    public static void selectSort(int[] inputData){
        for(int i=0; i < inputData.length; i++){
            int minIndex = i;
            //find index of minimum value in unsorted list
            for(int j=i+1; j < inputData.length; j++){
                if(inputData[j] < inputData[minIndex]){
                    minIndex = j;
                }
            }
            //swap minimum value to unsorted list's head
            if(i != minIndex){
                int tmp =  inputData[i];
                inputData[i] = inputData[minIndex];
                inputData[minIndex] = tmp;
            }
        }
    }
    
    /** Selection sort algorithm with out-of-place implementation*/
    public static void selectSortExtraSpace(int[] inputData, ArrayList<Integer> outputData){
        if(outputData.isEmpty() == false){
            return;
        }
        
        ArrayList<Integer> unsortedData = new ArrayList<Integer>();
        for(int i=0; i < inputData.length; i++){
            unsortedData.add(inputData[i]);
        }

        while(unsortedData.isEmpty() == false){
            int i=0;
            int minIndex = i;
            for(int j=i+1; j < unsortedData.size(); j++){
                if(unsortedData.get(j) < unsortedData.get(minIndex)){
                    minIndex = j;
                }
            }
            outputData.add(unsortedData.get(minIndex)); //insert minimum value from unsorted to sorted list
            unsortedData.remove(minIndex); //remove minimum value in unsorted list
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
