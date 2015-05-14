import java.util.*;
import java.io.*;

public class RunningMedian{
    private MyHeap max;
    private MyHeap min;
    private int[] median;

    public RunningMedian(){
	max = new MyHeap(true);
	min = new MyHeap(false);
	median = new int[0];
    }

    public RunningMedian(int val){
	max = new MyHeap(true);
	min = new MyHeap(false);
	median = new int[0];
	add(val);
    }

    public void BADadd(int val){
	if(max.size() == min.size() && median.length < 2){
	    if(median.length == 0){
		median = new int[1];
		median[0] = val;
	    }else if(median.length == 1){
		int temp = median[0];
		median = new int[2];
		if(val < temp){
		    median[0] = val;
		    median[1] = temp;
		}else{
		    median[0] = temp;
		    median[1] = val;
		}
	    }
	}else if(max.size() == min.size()){
	}
    }

    public void add(int val){
	if(val =< min.peek()){
	    min.add(val);
	}
	if(val >= max.peek()){
	    max.add(val);
	}
    }
}
