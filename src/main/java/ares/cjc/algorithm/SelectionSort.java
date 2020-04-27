package ares.cjc.algorithm;

import java.util.Arrays;

public class SelectionSort {
    /**
     *  时间复杂度O（n^2）
     *  空间复杂度O（1）
     *  不稳定排序
     */
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,1,50,33,24,5,-4,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
