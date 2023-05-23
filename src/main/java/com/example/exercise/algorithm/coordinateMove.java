package com.example.exercise.algorithm;

import java.util.Scanner;

/**
 * 坐标移动
 *
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 */
public class coordinateMove {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(";");
        int x = 0, y = 0;
        for (String value : str) {
            String[] s = value.split("");
            if (s.length > 1 && s.length < 4) {
                // 判断是否向左移动
                if ("A".equals(s[0])) {
                    // 判断后面数字是否正确
                    if (s.length == 3) {
                        String z = s[1] + s[2];
                        if (Character.isDigit(z.charAt(0)) && Character.isDigit(z.charAt(1))) {
                            x = x - Integer.parseInt(z);
                        }
                    } else {
                        String z = s[1];
                        if (Character.isDigit(z.charAt(0))) {
                            x = x - Integer.parseInt(z);
                        }
                    }

                }
                // 判断是否向右移动
                else if ("D".equals(s[0])) {
                    // 判断后面数字是否正确
                    if (s.length == 3) {
                        String z = s[1] + s[2];
                        if (Character.isDigit(z.charAt(0)) && Character.isDigit(z.charAt(1))) {
                            x = x + Integer.parseInt(z);
                        }
                    } else {
                        String z = s[1];
                        if (Character.isDigit(z.charAt(0))) {
                            x = x + Integer.parseInt(z);
                        }
                    }
                }
                // 判断是否向上移动
                else if ("W".equals(s[0])) {
                    // 判断后面数字是否正确
                    if (s.length == 3) {
                        String z = s[1] + s[2];
                        if (Character.isDigit(z.charAt(0)) && Character.isDigit(z.charAt(1))) {
                            y = y + Integer.parseInt(z);
                        }
                    } else {
                        String z = s[1];
                        if (Character.isDigit(z.charAt(0))) {
                            y = y + Integer.parseInt(z);
                        }
                    }
                }
                // 判断是否向下移动
                else if ("S".equals(s[0])) {
                    // 判断后面数字是否正确
                    if (s.length == 3) {
                        String z = s[1] + s[2];
                        if (Character.isDigit(z.charAt(0)) && Character.isDigit(z.charAt(1))) {
                            y = y - Integer.parseInt(z);
                        }
                    } else {
                        String z = s[1];
                        if (Character.isDigit(z.charAt(0))) {
                            y = y - Integer.parseInt(z);
                        }
                    }
                }
            }
        }
        System.out.println(x + "," + y);
    }
}
