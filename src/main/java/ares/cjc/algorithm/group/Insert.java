package ares.cjc.algorithm.group;

import ares.cjc.algorithm.Sort;

/**
 * 插入排序
 *  特点：如果数组已经排好序，只需要n次对比就完成，不需要交换
 *       但是如果数组是倒序排序的，那性能将会和选择排序一样，需要头尾比到头
 *  时间复杂度： O(n²)
 */
public class Insert extends Sort{

    public static void sort(int[] arr){
        if(!isArray(arr)) return;

        int size = arr.length;
//        for(int i = 0;i<size-1;i++){
//            for(int j = i+1;j>0;j--){
//                if(arr[j]<arr[j-1]){
//                    exchange(arr,j,j-1);
//                }else{
//                    break;
//                }
//            }
//        }
        for(int i= 1;i<size;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    exchange(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
}
