import java.util.*;
import java.io.*;

public class StackAttack<E> extends something implements otherSomething{
    LNode<E> pancake;

    public StackAttack(){
    }

    public E push(E item){
	LNode<E> syrup = new LNode<E>(item);
	syrup.setNext(pancake);
	pancake = syrup;
	return E;
    }

    public E pop(){
	LNode<E> syrup
