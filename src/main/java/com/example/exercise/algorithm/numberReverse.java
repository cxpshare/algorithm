package com.example.exercise.algorithm;

import java.util.Scanner;

/**
 * 数字颠倒
 *
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 数据范围：0 ≤ n ≤ 2^30 −1
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入：1516000
 *
 * 输出：0006151
 */
public class numberReverse {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("");
        for (int i = str.length -1 ; i >= 0; i--){
            System.out.print(str[i]);
        }
    }
}
