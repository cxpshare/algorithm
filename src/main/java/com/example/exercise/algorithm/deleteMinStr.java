package com.example.exercise.algorithm;

import java.util.*;

/**
 * 删除字符串中出现次数最少的字符
 *
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 ≤ n ≤ 20，保证输入的字符串中仅出现小写字母
 *
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：aabcddd
 *
 * 输出：aaddd
 */
public class deleteMinStr {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            // 原始字符串
            String str = in.nextLine();
            if (str.equals("")) break;
            char[] chars = str.toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            // 统计字符串中已有字符个数
            for (char c : chars){
                if (map.get(c) == null){
                    map.put(c,1);
                }
                else {
                    map.put(c, map.get(c) + 1);
                }
            }
            // 获取map中所有的值，并找到最小值
            Collection<Integer> collection = map.values();
            int min = Collections.min(collection);
            for (Map.Entry entry: map.entrySet()){
                if ((int)entry.getValue() == min){
                    // 将对应最少字符替换为""
                    str = str.replaceAll(String.valueOf(entry.getKey()),"");
                }
            }
            System.out.println(str);
        }
    }
}
