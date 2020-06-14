/*
   FileName:	Cargo
   StudentName: Au Chi Chung
   StudentID: 	150533022
   ClassName: 	IT114105 / HDSE-1A
   Description: Cargo program for order sequence in JAVA command console and it would handle the cargo movement from tracks.
				1.	User enter the integer value of the quantity for tracks, and it must larger than 0.
				2.	User enter the integer value of the cargo, and hale the input by enter value '0'.
				3.	System would step-by-step for display the cargo movement.
*/

import java.util.*;
public class Cargo {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		LinkedList ll = new LinkedList();	// user input
		LinkedList sll = new LinkedList();	// sorted result
		int trackNum, cargo, target, track, minIndex, minValue;
		
		// number of track
		while(true) {
			try {
				trackNum = 0;
				System.out.print("Enter track number (enter > 0) : ");
				trackNum = Integer.parseInt(kb.nextLine());
				if(trackNum <= 0) {
					throw new ArithmeticException();
				}else {
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Error: Please enter the integer number!");
			}
			catch(NumberFormatException e) {
				System.out.println("Error: Please enter with the correct format!");
			}
			catch(ArithmeticException e) {
				System.out.println("Error: Please enter the positive number!");
			}
		}
		
		// create new stack track from number of user input to store cargo
		Stack[] stack = new LinkedStack[trackNum];
		for(int i = 0; i < trackNum; i++) {
			stack[i] = new LinkedStack();
		}
		
		// number of cargo
		while(true) {
			try {
				System.out.print("Enter cargo number (enter <= 0 to exit) : ");
				cargo = Integer.parseInt(kb.nextLine());
				if(cargo > 0) {
					if(ll.chkDuplicate(cargo)) {
						throw new DuplicationException();
					}else {
						ll.addToTail(cargo);
						sll.insertInOrder(cargo);
					}
				}else {
					if(ll.isEmpty()) {
						System.out.println("Error: Please enter the value of the cargo");
					}else {
						break;
					}
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Error: Please enter the integer number!");
			}
			catch(NumberFormatException e) {
				System.out.println("Error: Please enter with the correct format!");
			}
			catch(DuplicationException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// display the result
		System.out.println();
		System.out.println("Number of Tracks = " + trackNum);
		System.out.println("Number of Cargos = " + ll.getCount());
		System.out.println("Input order of cars (from left to right) is " + ll);
		
		// step for sorting the cargo
		temp1:
		while(!sll.isEmpty()) {
			target = ((int)sll.removeFromHead());	// set the first target for output track
			for(int i = 0; i < trackNum; i++) {		// check the cargo in tracks which meets the target for output
				if(!stack[i].isEmpty()) {
					if((int)stack[i].top() == target) {
						System.out.println("Move car " + stack[i].pop() + " from holding track " + (i + 1) + " to output track");
						continue temp1;
					}
				}
			}
			temp2:
			while(!ll.isEmpty()) {
				cargo = ((int)ll.removeFromHead());
				if(cargo == target) {
					System.out.println("Move car " + cargo + " from input track to output track");
					continue temp1;
				}
				
				int[] arrayTemp = new int[trackNum];
				for(int i = 0; i < trackNum; i++) {
					if(!stack[i].isEmpty()) {
						arrayTemp[i] = (int)stack[i].top();
					}
				}
				
				// transfer the cargo into track
				minValue = 0;
				minIndex = -1;
				for(int i = 0; i < arrayTemp.length; i++) {
					if(arrayTemp[i] != 0 && minValue == 0 && cargo < arrayTemp[i]) {
				 		minValue = arrayTemp[i];
						minIndex = i;
						continue;
					} else if(arrayTemp[i] != 0) {
						if(arrayTemp[i] < minValue) {
							minValue = arrayTemp[i];
							minIndex = i;
						}
					}
				}
				
				if(minIndex != -1 && cargo < minValue) {
					System.out.println("Move car " + cargo + " from input track to holding track " + (minIndex + 1));
					stack[minIndex].push(cargo);
					continue temp2;
				}else {
					for(int i = 0; i < trackNum; i++) {
						if(arrayTemp[i] == 0) {
							System.out.println("Move car " + cargo + " from input track to holding track " + (i + 1));
							stack[i].push(cargo);
							continue temp2;
						}
					}
					System.out.println("Fail to rearrange the cars!");
					break temp1;
				}
			}
		}
		
		// end for the cargo program
		System.out.println("Press any key to continue...");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
}