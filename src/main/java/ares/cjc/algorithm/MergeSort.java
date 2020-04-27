package ares.cjc.algorithm;

import java.util.Arrays;

public class MergeSort {
    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     */
    public static void sort(int[] arr, int start, int end){
        if(start < end){
            //拆半成两个小集合，分别进行递归
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        //开辟额外大集合，设置指针
        int[] tempArray = new int[end-start+1];
        int p1 = start, p2 = mid + 1, p=0;
        //比较两个小集合的元素，一次放入大集合
        while(p1 <= mid && p2 <= end){
            if(arr[p1] <= arr[p2]){
                tempArray[p++] = arr[p1++];
            }else{
                tempArray[p++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            tempArray[p++] = arr[p1++];
        }
        while (p2 <= end) {
            tempArray[p++] = arr[p2++];
        }
        for(int i=0; i<tempArray.length; i++){
            arr[i+start] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,1,50,33,24,5,-4,7};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
