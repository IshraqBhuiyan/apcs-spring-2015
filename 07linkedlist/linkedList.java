import java.util.*;
import java.io.*;

public class linkedList{
    private LNode head;
    private int size;

    public linkedList(){
    }

    public linkedList(LNode x){
	setHead(x);
	LNode x = head;
	while(x.getValue() != null){
	    size++;
	    x = head.getNext();
	}
    }

    public LNode get(int index){
	LNode point = head;
	for(int i=0; i<index; i++){
	    point = point.getNext();
	}
	return point;
    }

    public int size(){
	return size;
    }

    public int indexOf(int val){
	LNode point = head;
	int i = 0;
	while(i<size() && point.getValue() != val){
	    point = point.getNext();
	    i++;
	}
	if(i>=size()) return -1;
	return i;
    }

    public void set(int val, int index){
	LNode point = head;
	int i = 0;
	while(i != index){
	    point= point.getNext();
	    i++;
	}
	point.setValue(val);
    }

    public boolean add(int val){
	LNode point = new LNode(val);
	return add(point);
    }

    private boolean add(LNode point){
	LNode point = head;
	while(point.getNext() != null){
	    point = point.getNext();
	}
	point.setNext(point);
	size++;
	return true;
    }

    public boolean add(int val, int index){
	LNode point = head;
	LNode add = new LNode(val);
	int i = 0;
	while(i< index - 1){
	    point = point.getNext();
	    i++;
	}
	LNode next = point.getNext();
	point.setNext(add);
	add.setNext(next);
	size++;
	return true;
    }

    public int remove(int index){
	LNode point = head;
	int i = 0;
	while(i < index - 1){
	    point = point.getNext();
	    i++;
	}
	if(i>=size()) throw new IndexOutOfBoundsException();
	LNode next = point.getNext().getNext();
	int val = point.getNext().getValue();
	point.setNext(next);
	size--;
	return val;
    }

    public String toString(){
	LNode point = head;
	String ans = "["+ point + ",";
	while(point.getNext() != null){
	    ans+=point;
	    point = point.getNext();
	    ans+=",";
	}
	ans+=point + "]";
	return ans;
    }
}
