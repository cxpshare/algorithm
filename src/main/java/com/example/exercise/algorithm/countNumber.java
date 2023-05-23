package com.example.exercise.algorithm;

import java.util.Scanner;

/**
 * 计算某字符出现次数
 *
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * 数据范围：1 ≤ n ≤ 1000
 *
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例
 * 输入：ABCabc
 *      A
 * 输出：
 *      2
 */
public class countNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str_1 = in.nextLine().toLowerCase();
        String str_2 = in.next().toLowerCase();

        String target = str_1.replace(str_2, "");
        int result = str_1.length() - target.length();
        System.out.println(result);
    }
}
