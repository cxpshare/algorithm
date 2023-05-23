package com.example.exercise.algorithm;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 简单密码
 * 描述
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1 ≤ n ≤ 100
 *
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 *
 * 示例1
 * 输入：YUANzhi1987
 *
 * 输出：zvbo9441987
 */
public class simplePassword {
    // 转换小写字母转换规则
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("abc", "2");
        map.put("def", "3");
        map.put("ghi", "4");
        map.put("jkl", "5");
        map.put("mno", "6");
        map.put("pqrs", "7");
        map.put("tuv", "8");
        map.put("wxyz", "9");

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            if (str.equals("")){
                break;
            }
            char[] ch = str.toCharArray();
            // 存储转换后的密码
            StringBuilder buffer = new StringBuilder();
            for (char c: ch){
                // 数字无需转换
                if (c >= '0' && c <= '9') {
                    buffer.append(c);
                }
                // 判断是否都为大写字母A-Y
                if (c >= 'A' && c <= 'Y') {
                    // 变为小写往后移动一位
                    char cNew = (char) (c + 32 + 1);
                    buffer.append(cNew);
                }
                // 判断是否为Z
                if (c == 'Z'){
                    // Z需要转换为a
                    buffer.append('a');
                }
                // 小写字母转换
                Set<String> keys = map.keySet();
                for (String key : keys){
                    if (key.contains(String.valueOf(c))) {
                        buffer.append(map.get(key));
                    }
                }
            }
            System.out.println(buffer);
        }
    }
}
