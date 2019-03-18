package ares.cjc.algorithm;

public class Sort {

    public static boolean isArray(int[] array){
        if(array == null || array.length == 0){
            return false;
        }
        return true;
    }

    public static boolean isSort(int[] array){
        for(int i = 0;i<array.length;i++){
            if(i!=array.length-1 && array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void exchange(int[] array,int a,int b){
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }

}
