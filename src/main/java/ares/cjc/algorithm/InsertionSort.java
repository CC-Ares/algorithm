package ares.cjc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    /**
     *  时间复杂度O（n^2）
     *  空间复杂度O（1）
     *  稳定排序
     */
    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int insertValue = arr[i];
            int j = i - 1;
            for(; j >= 0 && insertValue < arr[j]; j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,1,50,33,24,5,-4,7};
        sort(array);
        System.out.println(Arrays.toString(array));



    }


}
