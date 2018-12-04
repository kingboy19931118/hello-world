package com.arbor.note.collection.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author qiaomu.wang
 * @date 2018-11-20
 */
public class Sort {

    /**
     * 冒泡排序 （）
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        int count = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                count2++;
                if (a[j] > a[j + 1]) {
                    flag = true;
                    count++;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(String.format("count=%d", count));
        System.out.println(String.format("count2=%d", count2));
    }

    /**
     * 插入排序 （选中瞬移位置）
     *
     * @param a
     * @param n
     */
    public static void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        int count = 0;
        int count2 = 0;

        for (int i = 1; i < n; i++) {

            int value = a[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j] = value;
        }
        System.out.println(String.format("count=%d", count));
        System.out.println(String.format("count2=%d", count2));
    }

    /**
     * 选择排序 （找最小/最大）
     *
     * @param a
     * @param n
     */
    public static void selectSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        int count = 0;
        int count2 = 0;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                count2++;
                if (a[i] > a[j]) {
                    count++;
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
            System.out.println(JSON.toJSONString(a));
        }
        System.out.println(String.format("count=%d", count));
        System.out.println(String.format("count2=%d", count2));
    }

    /**
     * 归并排序
     *
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        mergeSortChild(a, 0, n - 1);
    }

    private static void mergeSortChild(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int middle = begin + (end - begin >> 1);
        mergeSortChild(a, begin, middle);
        mergeSortChild(a, middle + 1, end);

        merge(a, begin, middle, end);
    }

    private static void merge(int[] a, int begin, int middle, int end) {
        int i = begin;
        int j = middle + 1;
        int k = 0;
        int[] tmp = new int[end - begin + 1];
        while (i <= middle && j <= end) {
            if (a[i] > a[j]) {
                tmp[k++] = a[j++];
            } else {
                tmp[k++] = a[i++];
            }
        }

        int start = i;
        int over = middle;

        if (j < end) {
            start = j;
            over = end;
        }

        while (start <= over) {
            tmp[k++] = a[start++];
        }

        for (int i1 = 0; i1 < k; i1++) {
            a[begin + i1] = tmp[i1];
        }

        System.out.println(JSON.toJSONString(a));
    }

    public static void quickSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        quickSortChild(a, 0, n - 1);
    }

    private static void quickSortChild(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }

//        int middle = begin + (end - begin >> 2);
        int p = partition(a, begin, end);
        quickSortChild(a, 0, p - 1);
        quickSortChild(a, p + 1, end);
    }

    private static int partition(int[] a, int begin, int end) {
        // TODO: 2018/11/21
        return 0;
    }

    public static void main(String[] args) {
//        Collections.sort();
        int[] a = new int[]{3, 6, 2, 1, 4, 5};
        int[] b = new int[]{6, 5, 4, 3, 2, 1};
        int[] c = new int[]{1, 2, 3, 4, 5, 6};
        bubbleSort(a, 6);
        bubbleSort(b, 6);
        bubbleSort(c, 6);

        a = new int[]{3, 6, 2, 1, 4, 5};
        b = new int[]{6, 5, 4, 3, 2, 1};
        c = new int[]{1, 2, 3, 4, 5, 6};
        selectSort(a, 6);
        selectSort(b, 6);
        selectSort(c, 6);

        a = new int[]{3, 6, 2, 1, 4, 5};
        b = new int[]{6, 5, 4, 3, 2, 1};
        c = new int[]{1, 2, 3, 4, 5, 6};
        mergeSort(a, 6);
        mergeSort(b, 6);
        mergeSort(c, 6);
    }
}
