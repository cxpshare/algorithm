package com.example.exercise.algorithm;

import java.util.Scanner;

/**
 *  进制转换
 *
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 数据范围：保证结果在 1 ≤ n ≤ 2^31 − 1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：0xAA
 * 输出：170
 */
public class decimalConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next().substring(2);
            int result = Integer.parseInt(str, 16);
            System.out.println(result);
        }
        in.close();
    }
}
