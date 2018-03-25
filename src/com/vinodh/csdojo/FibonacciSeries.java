package com.vinodh.csdojo;

import java.time.LocalTime;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 35;
        LocalTime localTime1 = LocalTime.now();
        System.out.println(LocalTime.now());
        System.out.println(fibWithoutDP(n));
        System.out.println("Time Taken ::" + (LocalTime.now().getNano() - localTime1.getNano()));
        System.out.println(LocalTime.now());
        Integer[] memozationArr = new Integer[n + 1];
        LocalTime localTime2 = LocalTime.now();
        System.out.println(LocalTime.now());
        System.out.println(fibWithDP(n, memozationArr));
        System.out.println("Time Taken ::" + (LocalTime.now().getNano() - localTime2.getNano()));
        System.out.println(LocalTime.now());

        LocalTime localTime3 = LocalTime.now();
        System.out.println(LocalTime.now());
        System.out.println(fibBottomUpApproach(n));
        System.out.println("Time Taken ::" + (LocalTime.now().getNano() - localTime2.getNano()));
        System.out.println(LocalTime.now());


    }

    public static int fibWithoutDP(int n) {
        if (n == 1 || n == 2) {
            return 1; // Breaking Condition
        } else {
            return fibWithoutDP(n - 1) + fibWithoutDP(n - 2);
        }
    }

    public static int fibWithDP(int n, Integer[] memoArr) {

        if (memoArr[n] != null) {
            return memoArr[n];
        }

        if (n == 1 || n == 2) {
            return 1; // Breaking Condition
        } else {
            memoArr[n] = fibWithDP(n - 1, memoArr) + fibWithDP(n - 2, memoArr);
            return memoArr[n];
        }

    }


    public static int fibBottomUpApproach(int n){
        if (n == 1 || n == 2) {
            return 1; // Breaking Condition
        }
        int[] memAr = new int[n+1];
        memAr[1]=1;
        memAr[2]=1;

        for(int i = 3; i<=n; i++){
            memAr[i] =  memAr[i-1] +  memAr[i-2];
        }
//        for(int i = 1; i<=n; i++){
//            System.out.println(">>>" +  memAr[i]);
//        }
        return  memAr[n];
    }

}
