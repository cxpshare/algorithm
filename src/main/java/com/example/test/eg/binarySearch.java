package com.example.test.eg;


import java.util.Scanner;

/**
 * 二分查找
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,4,5,6};
        System.out.println("请输入需要查询的数字：");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // 二分查找
        int left = 0;
        int right = arr.length -1;
        while (left < right){
            int m = (left + right) / 2;
            if(n < arr[m]){
                right = m - 1;
            }
            else if (n > arr[m]){
                left = m + 1;
            }
            else if(arr[m] == n){
                System.out.printf("在数组中的位置为：%d ", m);
                break;
            }
        }
        if(left >= right){
            System.out.printf("在数组中不存在：%d ", n);
        }

    }
}
