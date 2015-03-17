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
		    merged(i1+i2) = a[i1];
		}
		return merged;
	    }
	    if(a[i1]<n[i2]){
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

    public static int[] mergeSort(int[]arr){
	if(arr.length <= 1) return arr;
	int[] split1 = Arrays.copyOfRange(arr, 0, arr.length/2);
	int[] split2 = Array.copyOfRange(arr, arr.length/2, arr.length);
	return merge(mergeSort(split1), mergeSort(split2));
    }

}
