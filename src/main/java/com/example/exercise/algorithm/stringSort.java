package com.example.exercise.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * 数据范围：1 ≤ n ≤ 1000，字符串长度满足 1 ≤ len ≤ 100
 *
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class stringSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0 ; i < n ; i ++){
            str[i] = in.next();
        }
        Arrays.sort(str);
        for (int i = 0 ; i < n ; i ++){
            System.out.println(str[i]);
        }
    }
}
