package org.lx.algorithms.bag;

import java.util.Iterator;

/**
 * ALGORITHM 1.4 Bag
 * 
 * @author
 *
 * @param <Item>
 */
public class MyBag<Item> implements Iterable<Item>
	{
		private Node first; // first node in list
	
		private class Node {
			Item item;
			Node next;
		}
	
		public void add(Item item) { // same as push() in Stack
			Node oldfirst = first;
			first = new Node();
			first.item = item;
			first.next = oldfirst;
		}
	
		public Iterator<Item> iterator() {
			return new ListIterator();
		}
	
		private class ListIterator implements Iterator<Item> {
			private Node current = first;
	
			public boolean hasNext() {
				return current != null;
			}
	
			public void remove() {
			}
	
			public Item next() {
				Item item = current.item;
				current = current.next;
				return item;
			}
		}
	}
