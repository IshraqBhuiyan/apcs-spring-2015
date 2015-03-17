import java.util.*;
import java.io.*;

public class quickselect{

    public static void main(String[]args){
	int[] test = {3, 4, 5, 2, 11, 178, 56, 23, 65, 73, 98, 77, 42};
	System.out.println(Arrays.toString(test));
	//System.out.println(""+quickselect(test, 4));
	quickSort(test);
	System.out.println(Arrays.toString(test));
    }

    public static void partition(int[] split, int si, int ei){
	int[] D = new int[split.length];
	int i =0;
	for(i=0;i<si;i++){
	    if(i<si || i>ei) D[i] = split[i];
	}
	int pivot = split[(int)(Math.random() * (ei - si + 1)) + si];
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
	int[] copy = new int[arry.length];
	int i;
	for(i=0;i<copy.length;i++){
	    if(i<si || i>ei) copy[i] = arry[i];
	}
	int pivot = arry[(int)(Math.random() * (ei - si+1)) +si]; //randomly determine the pivot in the range of ei to si
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

    public static int quickselectr(int[] arr, int n){ //nth smallest element
	if(n > arr.length || n < 0) return -1;
	int start = 0;
	int end = arr.length;
	int check = part(arr, start, end);
	while(check != n){
	    if(check > n) end = check;
	    if(check < n){
		start = check;
	    }
	    check = part(arr, start, end);
	}
	return arr[n];
    }

    public static int quickselect(int[]arr, int n){
	return quickselect(arr,n, 0, arr.length-1);
    }

    public static int quickselect(int[]arr, int n, int si, int ei){
	int check = part(arr, si, ei);
	if(check == n) return arr[check];
	if(check > n) return quickselect(arr, n, si, check);
	return quickselect(arr, n - check, check, ei);
    }

    public static void quickSort(int[]arr){
	quicksort(arr, 0, arr.length - 1);
    }

    public static void quicksort(int[]arr, int s, int e){
	if(s >=e) return;
	int pivot = part(arr, s, e);
	quicksort(arr, s, pivot - 1);
	quicksort(arr, s, pivot + 1);
    }
}
