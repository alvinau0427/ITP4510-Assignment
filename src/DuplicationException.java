/*
   FileName:	DuplicationException
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console.
*/

class DuplicationException extends ArithmeticException {
	public DuplicationException(){
		super("Error: Please enter the non-repetitive number!");
	}
}