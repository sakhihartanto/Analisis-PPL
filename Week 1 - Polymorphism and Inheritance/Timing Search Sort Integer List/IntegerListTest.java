/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingSearchSort;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class IntegerListTest {

    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);
//------------------------------------------------------
// main -- creates an initial list, then repeatedly prints
// the menu and does what the user asks until they quit
//------------------------------------------------------

    public static void main(String[] args) {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0) {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }
//------------------------------------------------------
// dispatch -- takes a choice and does what needs doing
//------------------------------------------------------

    public static void dispatch(int choice) {
        int loc;
        int val;
        long time1, time2;
        switch (choice) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println(list);
                break;
            case 2:
                System.out.println("How big should the list be?");
                list = new IntegerList(scan.nextInt());
                System.out.println("List is created.");
                break;
            case 3:
                list.randomize();
                System.out.println("List is filled with random elements.");
                break;
            case 4:
                list.fillSorted();
                System.out.println("List is filled with sorted elements.");
                break;
            case 5:
                System.out.print("Enter the value to look for: ");
                val = scan.nextInt();
                time1 = System.currentTimeMillis();
                loc = list.linearSearch(val);
                time2 = System.currentTimeMillis();
                printTime(time1, time2, "linearSearch() [Linear Search]: ");
                if (loc != -1) {
                    System.out.println("Found at location " + loc);
                } else {
                    System.out.println("Not in list");
                }
                break;
            case 6:
                System.out.print("Enter the value to look for: ");
                val = scan.nextInt();
                time1 = System.currentTimeMillis();
                loc = list.binarySearch(val);
                time2 = System.currentTimeMillis();
                printTime(time1, time2, "binarySearch() [Binary Search]: ");
                if (loc != -1) {
                    System.out.println("Found at location " + loc);
                } else {
                    System.out.println("Not in list");
                }
                break;
            case 7:
                time1 = System.currentTimeMillis();
                list.sortIncreasing();
                time2 = System.currentTimeMillis();
                printTime(time1, time2, "sortIncreasing() [Selection Sort]: ");

                System.out.println("List has been sorted.");
                break;
            case 8:
                time1 = System.currentTimeMillis();
                list.sortDecreasing();
                time2 = System.currentTimeMillis();
                printTime(time1, time2, "sortDecreasing() [Insertion Sort]: ");
                System.out.println("List has been sorted.");
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
//------------------------------------------------------
// printMenu -- prints the user's choices
//------------------------------------------------------

    public static void printMenu() {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Print the list");
        System.out.println("2: Create a new list of a given size");
        System.out.println("3: Fill the list with random ints in range 1-length");
        System.out.println("4: Fill the list with already sorted elements");
        System.out.println("5: Use linear search to find an element");
        System.out.println("6: Use binary search to find an element "
                + "(list must be sorted in increasing order)");
        System.out.println("7: Use selection sort to sort the list into "
                + " increasing order");
        System.out.println("8: Use insertion sort to sort the list into "
                + " decreasing order");
        System.out.print("\nEnter your choice: ");
    }

    public static void printTime(long time1Milli, long time2Milli, String strMsg) {
        System.out.println(strMsg + " took [" + (time2Milli - time1Milli) + "] milliseconds");
    }
}
