package ares.cjc.algorithm.group;

import ares.cjc.algorithm.Sort;

/**
 * 归并排序
 * 时间复杂度 O（nlog（n））
 * 空间复杂度 O（n）
 */
public class Merge extends Sort{

    private static int[] aux;

    public static void sort(int[] arr){
        aux = new int[arr.length];
        sort(arr,0, arr.length-1);
    }

    private static void sort(int[] arr,int lo,int hi){
        if(hi <= lo) return;
        int mid = lo+(hi - lo)/2;
        sort(arr,lo,mid);
        sort(arr,mid+1,hi);
        merge(arr,lo,mid,hi);
    }

    //将arr[lo..mid] 和 arr[mid+1..hi]归并
    private static void merge(int[] arr,int lo,int mid,int hi){
        int i = lo;
        int j = mid + 1;

        //将arr[lo..hi]复制到aux[lo..hi]
        for(int k = lo;k<=hi;k++){
            aux[k] = arr[k];
        }

        for(int k=lo;k<=hi;k++){
            if      (i>mid)         arr[k] = aux[j++];
            else if (j>hi)          arr[k] = aux[i++];
            else if (aux[j]<aux[i]) arr[k] = aux[j++];
            else                    arr[k] = arr[i++];
        }
    }
}
