import java.util.*;
import java.io.*;

public class partition{

    public static void main(String[]args){
	int[] test = {3, 4, 5, 2, 11, 178, 56, 23, 65, 73, 98, 77, 42};
	partition(test, 5, test.length-1);
    }

    public static void partition(int[] split, int si, int ei){
	int[] D = new int[split.length];
	int i =0;
	for(int i=0;i<si;i++){
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

    public static void quickselect(int[] arr, int k){ //kth smallest element
	
