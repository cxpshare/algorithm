package com.example.exercise.algorithm;

import java.util.*;

/**
 * 合唱队
 * 描述
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 * 设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T1,T2,...,Tk，
 * 若存在 i(1≤i≤K) 使得: T1 < T2 < ... < Ti-1 < Ti, 且 Ti > Ti+1 > ... > Tk，则称这K名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 *
 * 数据范围：1≤n≤3000
 *
 * 输入描述：
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入：8
 *      186 186 150 200 160 130 197 200
 *
 * 输出：
 *      4
 *
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class chorus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] arr1 = new int[n]; //存储每个数左边小于其的数的个数
            int[] arr2 = new int[n];//存储每个数右边小于其的数的个数
            arr1[0] = 1;            //最左边的数设为1
            arr2[n - 1] = 1;        //最右边的数设为1
            for (int i = 0; i < n; i++) {
                arr1[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {   //动态规划
                        arr1[i] = Math.max(arr1[j] + 1, arr1[i]);
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                arr2[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {   //动态规划
                        arr2[i] = Math.max(arr2[i], arr2[j] + 1);
                    }
                }
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = arr1[i] + arr2[i] - 1; //两个都包含本身
            }

            int max = 1;
            for (int i = 0; i < n; i++) {
                if (res[i] > max) {
                    max = res[i];
                }
            }
            System.out.println(n - max);
        }
    }
}
