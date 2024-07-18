package YashM;
import java.util.*;


public class Student_Grade_Calculator {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Total Number of Subjects: ");
		int tsub = sc.nextInt();
		
		int [] subMarks = new int[tsub];
		for(int i=0;i<tsub;i++) {
			System.out.println("Enter the marks obtained in Subject"+(i+1)+"(out of 100): ");
			subMarks[i] = sc.nextInt();
		}
		int total_marks = 0;
		 
		for(int i=0;i<tsub;i++) {
			total_marks=subMarks[i] + total_marks;
		}
		float average = total_marks/tsub;
		
		char grade = 'F';
		
		if(average>=90) {
			grade = 'A';
		}
		else if(average>=80) {
			grade = 'B';
		}
		else if(average>=70) {
			grade = 'C';
		}
		else if(average>=60) {
			grade = 'D';
		}
		else if(average>=50) {
			grade = 'E';
		}
		
		System.out.println("The Total marks obtained in all subjects : "+total_marks);
		System.out.println("Average percentage obtained : "+average);
		System.out.println("Grade : "+grade);
	}

}
