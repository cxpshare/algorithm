package com.example.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：abc
 * 输出：abc00000
 */
public class stringSeparate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<String> list = new ArrayList<>();
        String result = "";
        if (str.length() > 0){
            int x = str.length() % 8;
            if( x != 0){
                StringBuilder b = new StringBuilder();
                for (int i = 0;i < 8 - x + 1; i ++ ){
                    b.append("0");
                }
                result = str + b;
            }else {
                result = str + "0";
            }
            int left = 0, right = 8;
            while (left != result.length() - 1){
                list.add(result.substring(left, right));
                left = right;
                right = right + 8;
            }
            for (String s: list){
                System.out.println(s);
            }
        }
    }
}
