/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingSearchSort;

/**
 *
 * @author Sakhi
 */
import java.util.Scanner;

public class IntegerList {

    int[] list; //values in the list
//------------------------------------------------------------
// Constructor -- takes an integer and creates a list of that
// size. All elements default to value 0.
//------------------------------------------------------------

    public IntegerList(int size) {
        list = null;
        list = new int[size];
    }
//------------------------------------------------------------
// randomize -- fills the array with randomly generated integers
// between 1 and 100, inclusive
//------------------------------------------------------------

    public void randomize() {
        int max = list.length;
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * max) + 1;
        }
    }
//------------------------------------------------------------
// fillSorted -- fills the array with sorted values
//------------------------------------------------------------

    public void fillSorted() {
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 2;
        }
    }
//------------------------------------------------------------
// print -- prints array elements with indices, one per line
//------------------------------------------------------------

    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += i + ":\t" + list[i] + "\n";
        }
        return s;
    }
//------------------------------------------------------------
// linearSearch -- takes a target value and returns the index
// of the first occurrence of target in the list. Returns -1
// if target does not appear in the list
//------------------------------------------------------------

    public int linearSearch(int target) {
        int location = -1;
        for (int i = 0; i < list.length && location == -1; i++) {
            if (list[i] == target) {
                location = i;
            }
        }
        return location;
    }
//------------------------------------------------------------
// sortIncreasing -- uses selection sort
//------------------------------------------------------------

    public void sortIncreasing() {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = minIndex(list, i);
            swap(list, i, minIndex);
        }
    }

    // Sort Decreasing
    public void sortDecreasing() {
        for (int index = 1; index < list.length; index++) {
            int key = list[index];
            int position = index;
            // Shift smaller values to the right
            while (position > 0 && key > list[position - 1]) {
                list[position] = list[position - 1];
                position--;
            }
            list[position] = key;
        }
    }

    public int binarySearch(int key) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key > list[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int minIndex(int[] list, int iIndex) {
        int iMinIndex = iIndex;
        for (int i = iIndex + 1; i < list.length; i++) {
            if (list[i] < list[iMinIndex]) {
                iMinIndex = i;
            }
        }
        return iMinIndex;
    }

    private void swap(int[] list, int i, int minIndex) {
        int iTemp = list[i];
        list[i] = list[minIndex];
        list[minIndex] = iTemp;
    }
}
