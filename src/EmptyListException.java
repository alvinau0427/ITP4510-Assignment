/*
   FileName:	EmptyListException
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

public class EmptyListException extends RuntimeException {
	public EmptyListException() {
		super("Error: The linked list is empty!");
	}
}