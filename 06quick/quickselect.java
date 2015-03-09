import java.util.*;
import java.io.*;

public class quickselect{

    public static void main(String[]args){
	int[] test = {3, 4, 5, 2, 11, 178, 56, 23, 65, 73, 98, 77, 42};
	partition(test, 5, test.length-1);
    }

    public static void partition(int[] split, int si, int ei){
	int[] D = new int[split.length];
	int i =0;
	for(i=0;i<si;i++){
	    if(i<si || i>ei) D[i] = split[i];
	}
	int pivot = split[(Math.random() * (ei - si + 1)) + si];
	int end = ei;
	i = si;
	for(;i<end+1;i++){
	    if(split[si] < pivot){
		D[si] = split[si];
		si++;
	    }else if(split[si] > pivot){
		D[end] = split[si];
		end--;
	    }
	}
	D[si] = split[si];
    }

    public static int part(int[] arry, int si, int ei){ //revision of the partition function
	int[] copy = int[arry.length];
	int i;
	for(i=0;i<copy.length;i++){
	    if(i<si || i>ei) copy[i] = arry[i];
	}
	int pivot = arry[(Math.random * (ei - si + 1)) +si]; //randomly determine the pivot in the range of ei to si
	int end = ei;
	for(i=si;i<end+1;i++){
	    if(arry[i] > pivot){
		copy[ei] = arry[i];
		ei--;
	    }
	    if(arry[i] < pivot){
		copy[si] = arry[i];
		si++;
	    }
	}
	copy[si] = pivot;
	for(i=0;i<copy.length;i++){
	    arry[i] = copy[i];
	}
	return si;
    }
    public static int quickselect(int[] arr, int n){ //nth smallest element
	if(n > arr.length || n < 0) return -1;
	int start = 0;
	int end = arr.length;
	while(part(arr, start, end) != n){};
	return arr[n];
    }
