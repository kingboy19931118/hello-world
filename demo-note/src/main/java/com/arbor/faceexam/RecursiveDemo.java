package com.arbor.faceexam;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author qiaomu.wang
 * @date 2018-12-06
 */
public class RecursiveDemo {

    @Test
    public void demo1() {
        long begin = System.currentTimeMillis();
        System.out.println(getCount(5));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        long begin2 = System.currentTimeMillis();
        System.out.println(getCountOld(5));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - begin2);
    }

    private Map<Integer, Integer> hasSolvedList = Maps.newHashMap();

    private int getCountOld(int total) {
        if (total == 2) {
            return 2;
        }
        if (total == 1) {
            return 1;
        }

        int ret = getCount(total - 1) + getCount(total - 2);
        return ret;
    }

    private int getCount(int total) {
        if (total == 2) {
            return 2;
        }
        if (total == 1) {
            return 1;
        }

        if (hasSolvedList.containsKey(total)) {
            return hasSolvedList.get(total);
        }

        int ret = getCount(total - 1) + getCount(total - 2);
        hasSolvedList.put(total, ret);
        return ret;
    }
}
