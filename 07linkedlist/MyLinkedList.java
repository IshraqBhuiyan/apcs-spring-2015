import java.util.*;
import java.io.*;

public class MyLinkedList<T extends Comparable<T>>{
    private LNode<T> head;
    private LNode<T> tail;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    public MyLinkedList(LNode<T> x){
	head = x;
	size = 1;
	while(x.getNext() != null){
	    size++;
	    x = head.getNext();
	}
	tail = x;
    }

    public String name(){
	return "bhuiyan.ishraq";
    }

    public LNode<T> get(int index){
	LNode<T> point = head;
	for(int i=0; i<index; i++){
	    point = point.getNext();
	}
	return point;
    }

    public int size(){
	return size;
    }

    public int indexOf(T val){
	LNode<T> point = head;
	int i = 0;
	while(i<size() && point.getData().compareTo(val) != 0){
	    point = point.getNext();
	    i++;
	}
	if(i>=size()) return -1;
	return i;
    }

    public void set(int index, T val){
	LNode<T> point = head;
	int i = 0;
	while(i != index){
	    point= point.getNext();
	    i++;
	}
	point.setData(val);
    }

    public boolean add(T val){
	LNode<T> point = new LNode<T>(val);
	tail.setNext(point);
	tail = point;
	size++;
	return true;
    }

    private boolean add(LNode<T> point){
	LNode<T> temp = head;
	while(temp.getNext() != null){
	    temp = temp.getNext();
	}
	temp.setNext(point);
	size++;
	return true;
    }

    public boolean add(int index, T val){
	LNode<T> point = head;
	LNode<T> add = new LNode<T>(val);
	int i = 0;
	while(i< index - 1){
	    point = point.getNext();
	    i++;
	}
	LNode<T> next = point.getNext();
	point.setNext(add);
	add.setNext(next);
	size++;
	if(index == size() - 1) tail = add;
	return true;
    }

    public T remove(int index){
	LNode<T> point = head;
	int i = 0;
	while(i < index - 1){
	    point = point.getNext();
	    i++;
	}
	if(i>=size()) throw new IndexOutOfBoundsException();
	LNode<T> next = point.getNext().getNext();
	T val = point.getNext().getData();
	point.setNext(next);
	size--;
	return val;
    }

    public String toString(){
	LNode<T> point = head;
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
