package leetcode869;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Allx
 * @Date 2021/10/28 16:03
 */
public class Solution {
    public boolean reorderedPowerOf2(int n) {
        //首先获得该数字每位上的数字
        List<Integer> list = new ArrayList<>();
        int len = (n + "").length();
        for (int i = 0; i < len; i++) {
            list.add(n % 10);
            n = n / 10;
        }

        //再计算长度为n有哪些为2的幂的数字
        int num = 1;
        List<Integer> count = new ArrayList<>();
        while ((num + "").length() <= len) {
            if ((num + "").length() == len) {
                count.add(num);
            }
            num *= 2;
        }

        Collections.sort(list);
        to:
        for (Integer x : count) {
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                al.add(x % 10);
                x = x / 10;
            }

            Collections.sort(al);
            for (int i = 0; i < len; i++) {
                if (al.get(i) != list.get(i)) {
                    continue to;
                }
            }
            return true;
        }
        return false;
    }
}
