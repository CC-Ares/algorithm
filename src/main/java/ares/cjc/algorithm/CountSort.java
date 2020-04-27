package ares.cjc.algorithm;

import java.util.Arrays;

/**
 * 计数排序
 *
 * 时间复杂度 : O(M + N)
 * 时间复杂度 : O(M)
 */
public class CountSort {

    public static int[] sort(int[] arr) {
        //1. 找到数组最大值和最小值
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        //2. 找到最大值与最小值的差
        int d = max - min;

        //3. 初始化数组
        int[] countArray = new int[d + 1];

        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        //4. 统计数组做变形，后边的元素等于前面的元素之和
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }

        //5. 倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[countArray[arr[i] - min] - 1] = arr[i];
            countArray[arr[i] - min]--;
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{95,94,91,98,99,90,99,93,91,92};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
