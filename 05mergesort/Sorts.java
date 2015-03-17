import java.util.*;
import java.io.*;

public class Sorts{

    public static int[] merge(int[]a, int[]b){
	int[] merged = new int[a.length + b.length];
	int i1 = 0;
	int i2 = 0;
	while(i1 <= a.length && i2 <=b.length){
	    if(i1 == a.length){
		for(;i2<b.length;i2++){
		    merged[i1 + i2] = b[i2];
		}
		return merged;
	    }
	    if(i2 == b.length){
		for(;i1<a.length;i1++){
		    merged[i1+i2] = a[i1];
		}
		return merged;
	    }
	    if(a[i1]<b[i2]){
		merged[i1+i2] = a[i1];
		i1++;
	    }
	    else if(b[i2] <= a[i1]){
		merged[i1+i2]=b[i2];
		i2++;
	    }
	}
	return merged;
    }

    public static int[] mergeSortA(int[]arr){
	if(arr.length <= 1) return arr;
	int[] split1 = Arrays.copyOfRange(arr, 0, arr.length/2);
	int[] split2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
	return merge(mergeSortA(split1), mergeSortA(split2));
    }

    public static void mergeSort(int[]arr){
	int[] sorted = mergeSortA(arr);
	for(int i=0;i<sorted.length;i++){
	    arr[i] = sorted[i];
	}
    }

    public static void main(String[]args){
	int[] unsorted = {544, 233, 567, 98921873, 12234, 1245634, 123236373, 123265732};
	System.out.println(Arrays.toString(unsorted));
	mergeSort(unsorted);
	System.out.println(Arrays.toString(unsorted));
    }

}
