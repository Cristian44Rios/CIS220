// Cristian Rios
// Chpt3 PA

import java.util.Random;

public class BubbleSort {

    // Main method to run the program
    public static void main(String[] args) {
        int[] array = new int[25];
        Random rand = new Random();

        // Generate 25 random integers between 1 and 1000
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000) + 1;
        }

        System.out.println("Unsorted Array:");
        printArray(array);

        bubbleSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);
    }

    // Method to implement Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) { // -i to optimize since the last elements are already sorted
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
