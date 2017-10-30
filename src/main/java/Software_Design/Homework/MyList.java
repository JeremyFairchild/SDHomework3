package Software_Design.Homework;

//import java.util.Scanner;

import org.apache.commons.cli.*;

public class MyList 
{
	
	public static int binSearch(Comparable[] aList, Comparable key)
	{
		// isIntheList is return value stays -1 if error occurs
		int isInTheList = -1;
		//0 is the first index of the array
		int start = 0;
		//array.length-1 is the last index of the array
		int end = aList.length-1;
		//Creates the midPoint here but works on it within the while loop
		int midPoint;
		//Used the end my while loop 
		int endLoop = 0;
		//While loop for doing binary search
		while(endLoop == 0)
		{
			//Check if the end and start index can get any smaller
			if((end - start) <= 1)
			{//checks if start is the key
				//if(aList[start] == key)
				if(aList[start].compareTo(key) == 0)
				{
					//ends loop because key is found
					endLoop = 1;
					//isInTheList is set to 1 so it is in the list
					isInTheList = 1;
				}//checks if end is the key
				//else if(aList[end] == key)
				else if(aList[end].compareTo(key) == 0)
				{
					//end loop key is found
					endLoop = 1;
					isInTheList = 1;
				}//this is if the key is not found
				else
				{
					//Loops ends as the is no more index spots to check
					endLoop = 1;
					//Sets to 0 to say key is not in the list
					isInTheList = 0;
				}
			}
			
			//Takes the floor midpoint (defaults) ex: 3/2 = 1.5 = 1
			midPoint = (start + end)/2;
			//if(aList[midPoint] > key)
			if(aList[midPoint].compareTo(key) > 0) // Hello (H=8) . compareTo flag (f=6)
			{//Check if the value at index mid is > key and makes that the new end
				end = midPoint;
			}
			else
			{//if midPoint is <= key it becomes the new start index
				start = midPoint;
			}	
		}
		//Returns if the key is in the list or not
		return isInTheList;
	}
	
	
	
	
	
	//sorting the array
	
	/*
	 * public static double[] comparisonSort(double[] inputArray)
	{
		double tempI;
		double tempJ;
		int keepGoing = 0;
		while(keepGoing <= inputArray.length-2) //n-2 comparison loops to fully sort this array in worst case
		{
		for(int i=0;i<=inputArray.length-2;i++)
		{
			tempI = inputArray[i]; //Two values for reordering the array
			tempJ = inputArray[i+1];
			if(Double.compare(tempI,tempJ) > 0) // returns value > 0 means I > J
			{ // if lower index is > bigger index switches the two
				inputArray[i] = tempJ;
				inputArray[i+1] = tempI;
			}
			
		}
		keepGoing++; //how many times to loop has gone on
		}
		
		
		return inputArray;
	}
	 */
	
	
	

	public static void main(String[] args)
	{
		String list = null;
		String Key = null;
		String type = null;
		Comparable[] InputFinal;
		Comparable KeyFinal;
		//CommandLineParser parser = new BasicParser();
		Options options = new Options();
		Option option = new Option("c", "description");
		option.setArgs(Option.UNLIMITED_VALUES);
		option.setLongOpt("list");
		options.addOption(option);
		options.addOption("t","type", true, "type Parameter");
		options.addOption("k","key", true, "key Parameter");
		
	
		
		
		
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			type = cmd.getOptionValue("type");
			//System.out.println(cmd.getOptionValue("type"));
			Key = cmd.getOptionValue("key");
			//System.out.println(cmd.getOptionValue("key"));
			//System.out.println(cmd.getOptionValue("list"));
			list = cmd.getOptionValue("list");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(new String("i").equals(type))
		{
			String[] stringSplitArray = list.split(" ");
			//Creates the Array to hold the int values
			//System.out.println("The list is of type Integer");
			int[] InputArray = new int[stringSplitArray.length];
			if(stringSplitArray.length == 1)
			{
				System.out.println("Enclose the list using \"\"");
			}
			for(int i=0; i < InputArray.length; i++)
			{//This puts the string version of the array into the new Int Array
				InputArray[i] = Integer.parseInt(stringSplitArray[i]);
				//System.out.print(InputArray[i]+" ");
			}
			InputFinal = new Integer[InputArray.length];
			for(int i=0; i < InputArray.length; i++)
			{
				InputFinal[i] = InputArray[i];
			}
			//System.out.println("\nNow Getting key value");
			int keyINT = Integer.parseInt(Key);
			KeyFinal = keyINT;
			System.out.print("The list is of type Integer,the search key is "+KeyFinal+", and the list is ");
			for(int i=0; i < InputArray.length; i++)
			{
				System.out.print(InputArray[i]+" ");
			}
			System.out.println();//starts a new line
			int result = binSearch(InputFinal,KeyFinal);
			if(result == 0)
			{//Displays not found if binSearch returns 0
				System.out.println("The key was not found!");
			}
			else if(result == 1)
			{
				System.out.println("The key was found!");
			}
			else
			{
				System.out.println("ERROR");
			}
			
		}
		else if(new String("s").equals(type))
		{
			String[] stringSplitArray = list.split(" ");
			//Creates the Array to hold the int values
			String[] InputArray = new String[stringSplitArray.length];
			if(stringSplitArray.length == 1)
			{
				System.out.println("Enclose the list using \"\"");
			}
			for(int i=0; i < InputArray.length; i++)
			{//This puts the string version of the array into the new Int Array
				InputArray[i] = (stringSplitArray[i]);
			}
			InputFinal = new String[InputArray.length];
			for(int i=0; i < InputArray.length; i++)
			{
				InputFinal[i] = InputArray[i];
			}
			KeyFinal = Key;
			System.out.print("The list is of type String,the search key is "+KeyFinal+", and the list is ");
			for(int i=0; i < InputArray.length; i++)
			{//This puts the string version of the array into the new Int Array
				//InputArray[i] = (stringSplitArray[i]);
				System.out.print(InputArray[i]+" ");
			}
			System.out.println();//starts a new line
			int result = binSearch(InputFinal,KeyFinal);
			if(result == 0)
			{//Displays not found if binSearch returns 0
				System.out.println("The key was not found!");
			}
			else if(result == 1)
			{
				System.out.println("The key was found!");
			}
			else
			{
				System.out.println("ERROR");
			}
		}
		else
		{
			System.out.println("Error");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		//Comparable[] InputArray = new Comparable[args.length];
		//Creates the InputArray from command line
		//int[] InputArray = new int[args.length];
		//for(int i=0; i < InputArray.length; i++)
		//{//This puts the command line args into the new Int Array
			//InputArray[i] = Double.parseDouble(args[i]);
		//}
		//if(InputArray.length <= 0)
		//{//ErrorChecking displays this if no command line input
			//int result = -1;
			//System.out.println(result);
		//}
		//else
		//{//This is if there is command line input
			//System.out.println("Is this working? ");
			//Comparable[] InputArraySaved = new Comparable[InputArray.length];
			//int index = 0; //used for indexing InputArraySaved
			
			
			/*
			 * for(double u: InputArray)
			 * {//This little for loop copies Input Array into a new array for later
				InputArraySaved[index] = u;
				index++;
				}
			 * 
			 */
			
			//comparisonSort(InputArray); // Sorts InputArray
			
			
			//this is to allow input
			//Scanner keyboard = new Scanner(System.in);
			
			
			
			
			
			/*
			 * This chunk of code was converting a keyboard input of string of numbers
			 * into an array. I didn't delete it incase it come in handy in the future.
			 * 
			 */
			//String of the Array that the user inputs
			//String stringInputArray = keyboard.nextLine();
			//This gets rid of the spaces in between each array number
			//String[] stringSplitArray = stringInputArray.split(" ");
			//Creates the Array to hold the int values
			//int[] InputArray = new int[stringSplitArray.length];
			//for(int i=0; i < InputArray.length; i++)
			//{//This puts the string version of the array into the new Int Array
				//InputArray[i] = Integer.parseInt(stringSplitArray[i]);
			//}
			
			
			
			
			
			
			
			
			
			//Takes the user input for key
			//double key = keyboard.nextDouble();
			
			//results gets a 0,1,-1 for the list determining if it found the key or not.
			//int result = binSearch(InputFinal,KeyFinal);
			
			
			
		//	if(result == 0)
			//{//Displays not found if binSearch returns 0
				//System.out.println("The key was not found!");
		//	}
			//else //Key was found now finding index from unsorted
			//{
				
				/*
				 * 
				 * int valueTrue = 0; //Keeps the while loop going 0=false 1=true
				int isKey = 0; //this is index while searching for key
				//Here I need to search the array until the element is found.
				while(valueTrue == 0)
				{
					if(Double.compare(InputArraySaved[isKey],key) == 0) //If iskey and key same return index
					{//ends while loop once first key found (can be multiple)
						System.out.println(isKey);
						valueTrue =1;
					}
					isKey++;
				}
				 * 
				 * 
				 * 
				 */
				
			//}
			
			
			
			
			
			//closes the scanner object
			//keyboard.close();
		}
		
		
		
		
		
	
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	


