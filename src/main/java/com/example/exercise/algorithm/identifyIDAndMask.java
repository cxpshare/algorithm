package com.example.exercise.algorithm;

import java.util.Scanner;

/**
 * 识别有效的IP地址和掩码并进行分类统计
 *
 * 描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址从1.0.0.0到126.255.255.255;
 * B类地址从128.0.0.0到191.255.255.255;
 * C类地址从192.0.0.0到223.255.255.255;
 * D类地址从224.0.0.0到239.255.255.255；
 * E类地址从240.0.0.0到255.255.255.255
 *
 * 私网IP范围是：
 * 从10.0.0.0到10.255.255.255
 * 从172.16.0.0到172.31.255.255
 * 从192.168.0.0到192.168.255.255
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * （注意二进制下全是1或者全是0均为非法子网掩码）
 *
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 *
 * 输入描述：
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述：
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 */
public class identifyIDAndMask {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countError = 0, countP = 0;
        while (in.hasNextLine()){
            String[] str = in.nextLine().split("~");
            if (str[0].equals("")){
                break;
            }
            String[] ipList = str[0].split("\\.");
            boolean sate = false;
            for (String value : ipList) {
                if (value.equals("")) {
                    countError++;
                    sate = true;
                    break;
                }
            }
            if (sate){
                continue;
            }
            int ip_0 = Integer.parseInt(ipList[0]);
            int ip_1 = Integer.parseInt(ipList[1]);
            int ip_2 = Integer.parseInt(ipList[2]);
            int ip_3 = Integer.parseInt(ipList[3]);

            // 判断IP是否符合要求
            if (ip_1 >= 0 && ip_1 <= 255 && ip_2 >= 0 && ip_2 <= 255 && ip_3 >= 0 && ip_3 <= 255) {
                // A类
                if (ip_0 >= 1 && ip_0 <= 126) {
                    // 判断是否为掩码
                    if (isValidSubnetMask(str[1])) {
                        countA++;
                        //判断是否为私有ip
                        if (ip_0 == 10) {
                            countP++;
                        }
                    }else {
                        countError ++;
                    }
                }
                // B类
                else if (ip_0 >= 128 && ip_0 <= 191 ) {
                    // 判断是否为掩码
                    if (isValidSubnetMask(str[1])) {
                        countB++;
                        //判断是否为私有ip
                        if (ip_0 == 172 && ip_1 >= 16 && ip_1 <= 31) {
                            countP++;
                        }
                    }else {
                        countError ++;
                    }
                }
                // C类
                else if (ip_0 >= 192 && ip_0 <= 223 ) {
                    // 判断是否为掩码
                    if (isValidSubnetMask(str[1])) {
                        countC++;
                        //判断是否为私有ip
                        if (ip_0 == 192 && ip_1 == 168) {
                            countP++;
                        }
                    }
                    else {
                        countError ++;
                    }
                }
                // D类
                else if (ip_0 >= 224 && ip_0 <= 239 ) {
                    // 判断是否为掩码
                    if (isValidSubnetMask(str[1])) {
                        countD++;
                    }else {
                        countError ++;
                    }
                }
                // E类
                else if (ip_0 >= 240 && ip_0 <= 255 ) {
                    // 判断是否为掩码
                    if (isValidSubnetMask(str[1])) {
                        countE++;
                    }else {
                        countError ++;
                    }
                }

            }
            else {
                countError++;
            }
        }
        System.out.println(countA + " " + countB + " " + countC + " " + countD + " " + countE + " " + countError + " " + countP);
    }

    // 判断掩码知否合法
    public static boolean isValidSubnetMask(String subnetMask) {
        String[] split = subnetMask.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if(s.trim().equals("")){
                return false;
            }
            int i = Integer.parseInt(s);
            //如果有数字大于255，则直接返回false
            if (i > 255) {
                return false;
            }
            //转为二进制
            String binary = Integer.toBinaryString(i);
            //如果长度小于8，则在前面补0
            while (binary.length() < 8) {
                binary = "0".concat(binary);
            }
            sb.append(binary);
        }
        //32位二进制数中需要同时存在0和1，且不存在01
        return sb.toString().contains("1") && sb.toString().contains("0") && !sb.toString().contains("01");
    }
}
