package com.example.exercise.algorithm;

import java.util.*;

/**
 * 合并表记录
 *
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：4
 *      0 1
 *      0 2
 *      1 2
 *      3 4
 *
 * 输出：0 3
 *      1 2
 *      3 4
 */
public class listMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < Integer.parseInt(n); i++ ){
            String[] str = in.nextLine().split(" ");
            int key = Integer.parseInt(str[0]);
            int value = Integer.parseInt(str[1]);
            if (map.containsKey(key)) {
                map.put(key, value + map.get(key));
            }
            else {
                map.put(key, value);
            }
        }
        for (Map.Entry a: map.entrySet()){
            System.out.println(a.getKey() + " " + a.getValue());
        }
    }
}
