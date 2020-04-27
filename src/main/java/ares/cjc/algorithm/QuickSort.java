package ares.cjc.algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }

        int pivotIndex = partition(arr, startIndex, endIndex);

        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);

    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        int index = startIndex;

        while(left != right){

            while(left < right && arr[right] > pivot){
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if(left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;

        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,1,50,33,24,5,-4,7};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
