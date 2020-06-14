/*
   FileName:	LinkedList
   StudentName: Au Chi Chung
   StudentID:	150533022
   ClassName:	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

public class LinkedList {
	private ListNode head;
	private ListNode tail;
	private int count;
	
	public LinkedList() {
		head = tail = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean chkDuplicate(int node) {
		ListNode current = head;
		while (current != null){
			if((int)current.data == node) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public void addToHead(Object item) {
		count++;
		if(isEmpty()) {
			head = tail = new ListNode(item);
		}else {
			head = new ListNode(item, head);
		}
	}
	
	public void addToTail(Object item) {
		count++;
		if(isEmpty()) {
			head = tail = new ListNode(item);
		}else {
			tail.next = new ListNode(item);
			tail = tail.next;
		}
	}
	
	public Object removeFromHead() throws EmptyListException {
		if(isEmpty()) {
			throw new EmptyListException();
		}
		count--;
		Object item = head.data;
		if(head == tail) {
			head = tail = null;
		}else {
			head = head.next;
		}
		return item;
	}
	
	public Object removeFromTail() throws EmptyListException {
		if(isEmpty()) {
			throw new EmptyListException();
		}
		count--;
		Object item = tail.data;
		if(head == tail) {
			head = tail = null;
			return item;
		}
		ListNode current = head;
		while(current.next != tail) {
			current = current.next;
		}
		tail = current;
		tail.next = null;
		return item;
	}
	
	public Object getItemAt(int node) {
		if(node < 0 || node >= count) {
			throw new IndexOutOfBoundsException();
		}
		int currentPos = 0;
		ListNode current = head;
		while(currentPos < node) {
			current = current.next;
			currentPos++;
		}
		return current.data;
	}
	
	public Object removeItemAt(int node) {
		if(node < 0 || node >= count) {
			throw new IndexOutOfBoundsException();
		}
		if(node == 0) {
			return (removeFromHead());
		}
		
		int currentPos = 0;
		ListNode current = head;
		while(currentPos < (node - 1)) {
			current = current.next;
			currentPos++;
		}
		Object item = current.next.data;
		current.next = current.next.next;
		count--;
		return item;
	}
	
	public void addItemAt(Object item, int node) {
		if(isEmpty() || node == 0) {
			addToHead(item);
			return;
		}
		if(node > count) {
			addToTail(item);
			return;
		}
		
		int currentPos = 0;
		ListNode current = head;
		while(currentPos < (node - 1)) {
			current = current.next;
			currentPos++;
		}
		ListNode newNode = new ListNode(item);
		newNode.next = current.next;
		current.next = newNode;
		count++;	
	}
	
	public void insertInOrder(Object item) {
		if(isEmpty()) {
			head = tail = new ListNode (item);
		}else {
			if( (int)head.data >= (int)item ) {
				addToHead(item);
			}else if( (int)tail.data <= (int)item ) {
				addToTail(item);
			}else {
				ListNode current = head;
				while(current.next != null) {
					if( (int)current.next.data >= (int)item ) {
						ListNode newNode = new ListNode(item);
						newNode.next = current.next;
						current.next = newNode;
						return;
					}
					current = current.next;
				}
			}
		}
	}
	
	public String toString() {
		String s = "";
		ListNode current = head;
		while(current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s;
	}
}