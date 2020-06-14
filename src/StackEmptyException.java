/*
   FileName:	StackEmptyException
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

class StackEmptyException extends RuntimeException {
	public StackEmptyException() {
		super("Error: The linked stack is empty!");
	}
}