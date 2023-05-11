package com.example.exercise.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，
 * 然后再把这些数从小到大排序，按照排好的顺序输出。
 * 数据范围：1≤n≤1000  ，输入的数字大小满足：1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 */
public class randomNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n >= 0){
            List<Integer> inputList= new ArrayList<>(n);
            for (int i = 0 ; i < n ; i ++){
                inputList.add(in.nextInt());
            }
            inputList = inputList.stream().distinct().sorted().collect(Collectors.toList());
            for (Integer i: inputList){
                System.out.println(i);
            }

        }else{
            System.out.println("个数需要大于0");
        }
    }
}
