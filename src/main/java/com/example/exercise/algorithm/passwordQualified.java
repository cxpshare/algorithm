package com.example.exercise.algorithm;

import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * 密码验证合格程序
 *
 * 描述
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1 ≤ n ≤ 100
 * 输入描述：
 *      一组字符串。
 * 输出描述：
 *      如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 *      021Abc9000
 *      021Abc9Abc1
 *      021ABC9000
 *      021$bc9000

 * 输出：
 *      OK
 *      NG
 *      NG
 *      OK
 */
public class passwordQualified {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            //1.判断长度是否超过8
            if (str.equals("")){
                break;
            }
            if (str.length() <= 8){
                System.out.println("NG");
                continue;
            }
            //2.判断是否包含大小写字母，数字，其他符号，至少包含三种
            int count = 0;
            // 大写字母
            Pattern p1 = Pattern.compile("[A-Z]");
            if (p1.matcher(str).find()){
                count ++;
            }
            // 小写字母
            Pattern p2 = Pattern.compile("[a-z]");
            if (p2.matcher(str).find()){
                count ++;
            }
            // 数字
            Pattern p3 = Pattern.compile("[0-9]");
            if (p3.matcher(str).find()){
                count ++;
            }
            // 其他字符
            Pattern p4 = Pattern.compile("^[a-zA-Z0-9]");
            if (p4.matcher(str).find()){
                count ++;
            }
            if (count > 2){
                // 子串
                if (getStr(str,0,3)){
                    System.out.println("NG");
                }else {
                    System.out.println("OK");
                }
            }else {
                System.out.println("NG");
            }
        }
    }

    // 判断是否包含大于两个长度的字串
    private static boolean getStr(String str ,int left, int right ){
        if (str.length() <= right){
            return false;
        }
        if (str.substring(right).contains(str.substring(left,right))){
            return true;
        }else {
            return getStr(str, left + 1, right +1);
        }
    }


}
