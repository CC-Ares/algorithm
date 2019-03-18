package ares.cjc.algorithm.group;

import ares.cjc.algorithm.Sort;

/**
 * 选择排序
 * 循环n次，每次将最小值赋给第n位
 * 特点：运行时间和输入无关，该特点也是缺点，因为即使传入的是已排序好的数组，依然会执行这么多次
 * 时间复杂度为O(n²)
 *
 */
public class Selection extends Sort {

    public static void sort(int[] arr){
        if(!isArray(arr)) return;

        int size = arr.length;
        int minIndex;
        for(int i = 0;i<size;i++){
            minIndex = i;
            for(int j = i+1;j<size;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex == i){
                continue;
            }
            exchange(arr,i,minIndex);
        }
    }

}
