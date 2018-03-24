package com.vinodh.geeksforgeeks.arrays;


import java.util.Scanner;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * <p>
 * Input:
 * array Length: 7(n)
 * Rotation of array by 2(d) elements
 * array values: { 1,2,3,4,5,6,7 }
 * <p>
 * Output: 3,4,5,6,7,1,2
 */
public class ArrayRotation {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int arrLength = scanner.nextInt();
            int rotateBy = scanner.nextInt();
            String rotateDirection = scanner.next();

            int[] test1DArray = new int[arrLength];

            // Save the Input into Array
            for (int i = 0; i < arrLength; i++) {
                test1DArray[i] = scanner.nextInt();
            }


            int[] final1DArray = rotate(test1DArray, rotateBy, arrLength, rotateDirection);
            printFinalArray(final1DArray, arrLength);
        }
    }

    private static int[] rotate(int[] test1DArray, int rotateBy, int arrLength, String rotateDirection) {
        int[] testArr = new int[arrLength];

        if ("left".equalsIgnoreCase(rotateDirection)) {

            for (int i = rotateBy; i < arrLength; i++) {
                testArr[i - rotateBy] = test1DArray[i];
            }
            //  System.arraycopy(test1DArray, rotateBy, testArr, rotateBy - rotateBy, arrLength - rotateBy);

            for (int i = 0; i < rotateBy; i++) {
                testArr[arrLength - rotateBy + i] = test1DArray[i];
            }
            // System.arraycopy(test1DArray, 0, testArr, arrLength - rotateBy + 0, rotateBy);
        } else {

            for (int i = arrLength - rotateBy; i < arrLength; i++) {
                testArr[i - (arrLength - rotateBy)] = test1DArray[i];
            }
            // System.arraycopy(test1DArray, arrLength - rotateBy, testArr, arrLength - rotateBy - (arrLength - rotateBy), arrLength - (arrLength - rotateBy));

            for (int i = 0; i < arrLength - rotateBy; i++) {
                testArr[rotateBy + i] = test1DArray[i];

            }
            // System.arraycopy(test1DArray, 0, testArr, rotateBy + 0, arrLength - rotateBy);
        }

        return testArr;
    }

    private static void printFinalArray(int[] finalArray, int arrLength) {

        for (int i = 0; i < arrLength; i++) {
            System.out.print(finalArray[i]);
        }
    }
}
