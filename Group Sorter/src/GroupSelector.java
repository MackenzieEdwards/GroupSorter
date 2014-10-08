import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
		
public class GroupSelector
	{
	static ArrayList<Student> school = new ArrayList<Student>();
	static ArrayList<Student> list = new ArrayList<Student>();
	
	static int numberOfGroups;
	
	public static void main(String[] args) throws IOException
		{
		Scanner classRoster = new Scanner( new File("classroster.txt"));
		String firstName = null;
		String lastName = null;
		double score = 0.0;
		int groupNumber = 0;
		int group = 0;
		
		
		int classSize = classRoster.nextInt();
		
		for (int i = 0; i < classSize; i++)
			{
			firstName = classRoster.next();
			lastName = classRoster.next();
			score = classRoster.nextDouble();
			groupNumber = 0;
			school.add(new Student(firstName, lastName, score, groupNumber));
			}
		
		Collections.sort(school, new ScoreSorter());
				
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("How many groups do you want?");
		numberOfGroups = userInput1.nextInt();
		
		int j = 0;
		
		do 
		{
			Collections.sort(school, new ScoreSorter());
		
			System.out.println("Group " + (j+1));
			System.out.println("-------");
		
			for (int i=j; i < classSize; i=i+numberOfGroups)
			{
				list.add(new Student(school.get(i).getFirstName(), 
									 school.get(i).getLastName(),
									 school.get(i).getScore(),
									 school.get(i).getGroupNumber()));
			}
			
			Collections.sort(list, new NameSorter());
			
			for (Student s : list) {
			    System.out.println(s.getLastName()+ ", " + s.getFirstName());
			}
			
			list.clear();
			
			System.out.println();
			j++;
		}while (j < numberOfGroups);
		
	}

	}
