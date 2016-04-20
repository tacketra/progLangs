package tackettLawasProgram6;

import java.util.ArrayList;

public class QuickSort
{
    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {
        if (list == null || list.size() == 0) 
        {
            return null;
        }
        
        ExtendedIterator<Integer> iterator = new ExtendedIterator<Integer>(list);
        quickSort(0, iterator.length() - 1, iterator);
        
        return iterator.toArray();
    }
 
    private static void quickSort(int loIndex, int hiIndex, ExtendedIterator<Integer> iterator) {
        
        int i = loIndex;
        int j = hiIndex;
        
        // Calculates midpoint
        int pivot = iterator.elementAt(loIndex + (hiIndex - loIndex)/2);
        // System.out.println("pivot = " + pivot);
        
        // Exchange pairs that are on the wrong sides
        while (i < j) 
        {
            while (iterator.elementAt(i) < pivot) 
            {
                i++;
            }
            
            while (iterator.elementAt(j) > pivot) 
            {
                j--;
            }
            
            if (i <= j) 
            {
                iterator.swap(i, j);
                
                /*
                for(Integer item : iterator.toArray()){
                    System.out.print(item + "  ");
                }
                System.out.println();
                */
                
                i++;
                j--;
            }
        }
        
        // Recurse
        if (loIndex < j)
        {
            quickSort(loIndex, j, iterator);
        }
        
        if (i < hiIndex)
        {
            quickSort(i, hiIndex, iterator);
        }
    }
}