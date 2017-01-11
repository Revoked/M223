package com.ubs.util;

public class Nguyen<T> {
	
	private Khanh<T> root;
	
	public void add(T value) {
		Khanh<T> toAdd = new Khanh<T>(value);
		if(root == null) {
			root = toAdd;
		}
		else {
			Khanh<T> adding = root;
			while(adding.hasNext()) {
				adding = adding.next();
			}
			adding.setNext(toAdd);
			toAdd.setPrevious(adding);
		}
	}
	
	public T get(int index) {
		Khanh<T> pointer = root;
		for(int i = 0; i<index; i++) {
			if(pointer.hasNext()) {
				pointer = pointer.next();
			}
			else {
				return null;
			}
		}
		if(pointer != null) {
			return pointer.getValue();
		}
		else {
			return null;
		}
	}
	
	private boolean remove(Khanh<T> toRemove) {
		Khanh<T> prev = toRemove.previous();
		Khanh<T> next = toRemove.next();
		if(prev != null) {
			prev.setNext(next);
		}
		if(next != null) {
			next.setPrevious(prev);
		}
		if(root == toRemove) {
			root = next;
		}
		return true;
	}
	
	public boolean remove(int index) {
		Khanh<T> pointer = root;
		for(int i = 0; i<index; i++) {
			if(pointer.hasNext()) {
				pointer = pointer.next();
			}
			else {
				return false;
			}
		}
		if(pointer != null) {
			return remove(pointer);
		}
		else {
			return false;
		}
	}
	
	public boolean remove(T value) {
		Khanh<T> pointer = root;
		while(pointer != null) {
			if(!pointer.getValue().equals(value)) {
				pointer = pointer.next();
			}
			else {
				break;
			}
		}
		if(pointer != null) {
			return remove(pointer);
		}
		else {
			return false;
		}
	}
	
	public int size() {
		Khanh<T> pointer = root;
		int count = 0;
		while(pointer != null) {
			count++;
			pointer = pointer.next();
		}
		return count;
	}
	
	@Override
	public String toString() {
		if(root == null) {
			return "<>";
		}
		else {
			String toReturn = size() + ": [";
			Khanh<T> adding = root;
			while(true) {
				toReturn = toReturn + "<" + adding.getValue() + ">";
				if(adding.hasNext()) {
					adding = adding.next();
				}
				else {
					break;
				}
			}
			toReturn += "]";
			return toReturn;
		}
	}
	
	public void print() {
		System.out.println(this);
	}

}
