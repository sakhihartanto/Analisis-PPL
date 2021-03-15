/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchSortInteger;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class IntegerList {

    int[] list; //values in the list
//-------------------------------------------------------
//create a list of the given size
//-------------------------------------------------------

    public IntegerList(int size) {
        list = new int[size];
    }
//-------------------------------------------------------
//fill array with integers between 1 and 100, inclusive
//-------------------------------------------------------

    public void randomize() {
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 100) + 1;
        }
    }
//-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + ":\t" + list[i]);
        }
    }
//-------------------------------------------------------
//return the index of the first occurrence of target in the list.
//return -1 if target does not appear in the list
//-------------------------------------------------------

    public int search(int target) {
        int location = -1;
        for (int i = 0; i < list.length && location == -1; i++) {
            if (list[i] == target) {
                location = i;
            }
        }
        return location;
    }
//-------------------------------------------------------
//sort the list into ascending order using the selection sort algorithm
//-------------------------------------------------------

    public void selectionSort() {
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
//find smallest element in list starting at location i
            minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] > list[minIndex]) {
                    minIndex = j;
                }
            }
//swap list[i] with smallest element
            int temp = list[i];

            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    public void replaceFirst(int oldVal, int newVal) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == oldVal) {
                list[i] = newVal;
                i = list.length;
            }
        }
    }

    public void replaceAll(int oldVal, int newVal) {
        for (int i = 0; i < list.length; i++) {
            replaceFirst(oldVal, newVal);
        }
    }
    
    public void sortDecreasing(){
        int maxIndex;
        for (int i = 0; i < list.length - 1; i++) {
//find smallest element in list starting at location i
            maxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] > list[maxIndex]) {
                    maxIndex = j;
                }
            }
//swap list[i] with smallest element
            int temp = list[i];

            list[i] = list[maxIndex];
            list[maxIndex] = temp;
        }
    }
    
    public int binarySearchID(int target){
        int beginningOfList = 0;
        int endOfList = list.length-1;
        int middleOfList;
        
        while(beginningOfList <= endOfList){
            middleOfList = ((beginningOfList + endOfList)/2);
            if(list[middleOfList] == target){
                return middleOfList;
        }
            else
                if(list[middleOfList]> target){
                    beginningOfList= middleOfList + 1;
                }
                else{
                    endOfList = middleOfList - 1;
                }
        }
        return -1;
    }
}
