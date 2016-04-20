package tackettLawasProgram6;

import java.io.IOException;
import java.util.ArrayList;

/*

HW6 - Java Iterators
Schlipf
04/21/16
Ryan Tackett and Eli Lawas

*/


public class Main
{
    public static void main(String[] args)
    {
        Main.introMessage();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        try
        {
            int currentByte;
            String userPassedInArray = "";
            
            // read in user passed array as bytes
            while ((currentByte = System.in.read()) != '\n')
            {
                char currentByteAsChar = (char)currentByte;
                userPassedInArray += Character.toString(currentByteAsChar);
            }

            String[] stringArray = userPassedInArray.split(" "); // seperate userPassedInArray to an array of strings , e.g., "1 2 3" becomes {"1", "2", "3"};
            
            for (String item : stringArray) 
            {
                int itemAsInt = Integer.parseInt(item);
                list.add(itemAsInt);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error! Array was not passed in correctly");
        }

        printList(list, "Unsorted list below");
                    
        ArrayList<Integer> sortedList = QuickSort.sort(list);
        
        printList(sortedList, "Sorted list below");
    }
    
    public static void introMessage()
    {
        System.out.println("Please enter an array to sort.");
        System.out.println("Seperate each element in the array by a space, then type enter to complete");
        System.out.println("e.g., 3 4 5 6 \n");        
    }
    
    public static void printList(ArrayList<Integer> list, String message)
    {
        System.out.println("\n" + message);
        
        for (int item : list) 
        {
            System.out.print(item + " ");
        }
                    
        System.out.println("\n");
    }
    
}