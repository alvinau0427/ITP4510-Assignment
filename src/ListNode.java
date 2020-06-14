/*
   FileName:	ListNode
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

public class ListNode {
	public Object data;
	public ListNode next;
	
	public ListNode(Object data) {
		this.data = data;
		this.next = null;
	}
	
	public ListNode(Object data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}