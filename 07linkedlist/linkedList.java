import java.util.*;
import java.io.*;

public class linkedList{
    private LNode head;
    private LNode tail;
    private int size;

    public linkedList(){
	size = 0;
    }

    public linkedList(LNode x){
	head = x;
	size = 1;
	while(x.getNext() != null){
	    size++;
	    x = head.getNext();
	}
	tail = x;
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

    public void set(int index, int val){
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
	tail.setNext(point);
	tail = point;
	size++;
	return true;
    }

    private boolean add(LNode point){
	LNode temp = head;
	while(temp.getNext() != null){
	    temp = temp.getNext();
	}
	temp.setNext(point);
	size++;
	return true;
    }

    public boolean add(int index, int val){
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
	if(index == size() - 1) tail = add;
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
	String ans = "[";
	while(point.getNext() != null){
	    ans+=point;
	    point = point.getNext();
	    ans+=",";
	}
	ans+=point + "]";
	return ans;
    }
}
