/*
   FileName:	Stack
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

public interface Stack {
	public abstract int size();
	public abstract boolean isEmpty();
	public abstract void push(Object item);
	public abstract Object pop() throws StackEmptyException;
	public abstract Object top() throws StackEmptyException;
}