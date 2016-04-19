package tackettLawasProgram6;

import java.util.ArrayList;

public class QuickSort 
{
    private int array[];
    private int length;
 
    public void sort(int[] list) 
    {
        if (list == null || list.length == 0) 
        {
            return;
        }
        
        this.array = list;
        length = list.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int loIndex, int hiIndex) {
         
        int i = loIndex;
        int j = hiIndex;
        
        // Calculates midpoint
        int pivot = array[loIndex + (hiIndex - loIndex)/2];
        
        // Exchange pairs that are on the wrong sides
        while (i <= j) 
        {
            while (setPositionTo(i) < pivot) 
            {
                i++;
            }
            
            while (setPositionTo(j) > pivot) 
            {
                j--;
            }
            
            if (i <= j) 
            {
            	// Can I use a function from ExtendedIterator like this????
                swap(i, j, false);
                i++;
                j--;
            }
        }
        
        // Recurse
        if (loIndex < j)
        {
            quickSort(loIndex, j);
        }
        
        if (i < hiIndex)
        {
            quickSort(i, hiIndex);
        }
    }
}