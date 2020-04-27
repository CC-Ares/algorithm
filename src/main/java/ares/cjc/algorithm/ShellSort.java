package ares.cjc.algorithm;

import java.util.Arrays;

public class ShellSort {
    public static void sort(int[] arr){
        //希尔排序的增量
        int d = arr.length;
        while(d > 1){
            //使用希尔增量的方式，每次对半
            d = d / 2;
            for(int x = 0; x < d; x++){
                for(int i = x + d; i < arr.length; i+=d){
                    int temp = arr[i];
                    int j = i - d;
                    for(; j >= 0 && arr[j] > temp; j-=d){
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
