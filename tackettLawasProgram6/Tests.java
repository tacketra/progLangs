package tackettLawasProgram6;

import java.util.ArrayList;

public class Tests
{
    public static void RunTests()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
        {
            list.add(i*i);
        }
        
        for (int i = 0; i < 10; i++)
        {
            System.out.println(list.get(i));
        }
                
        ExtendedIterator<Integer> iterator = new ExtendedIterator<Integer>(list);
        
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(iterator.elementAt(i));
        }
        
        for (int i = 0; i < 3; i++)
        {
            System.out.println(iterator.setPositionTo(i + 3));
        }
        
        for (int i = 0; i < 3; i++)
        {
            int first = ((i*2) + 3);
            int second = (i*2);
            iterator = iterator.swap(first, second);
            System.out.println("swapping index: " + first + ", index: " + second);
            System.out.println("element at " + second + " = " + iterator.elementAt(second) + " element at " + first + " = " + iterator.elementAt(first));
        }
    }
    
}
