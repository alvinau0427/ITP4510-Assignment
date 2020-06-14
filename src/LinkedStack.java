/*
   FileName:	LinkedStack
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

public class LinkedStack implements Stack {
	private LinkedList sll;
	private ListNode head;
	private ListNode tail;

	public LinkedStack() {
		sll = new LinkedList();
	}

	public int size() {
		return sll.getCount();
	}

	public boolean isEmpty() {
		return sll.isEmpty();
	}

	public void push(Object item) {
		sll.addToHead(item);
	}

	public Object pop() throws StackEmptyException {
		try {
			Object item = sll.removeFromHead();
			return item;
		}
		catch(EmptyListException e) {
			throw new StackEmptyException();
		}
	}

	public Object top() throws StackEmptyException {
		try {
			Object item = sll.removeFromHead();
			sll.addToHead(item);
			return item;
		}
		catch(EmptyListException e) {
			throw new StackEmptyException();
		}
	}
}

