package tackettLawasProgram6;

import java.util.ArrayList;
import java.util.Iterator;

// iterator extension, to add addtional functioanlity to arraylist iterator
public class ExtendedIterator<T> implements Iterator<T>
{
    private Iterator<T> iterator;
    private ArrayList<T> list;
    
    private int currentIndex;
    
    ExtendedIterator(ArrayList<T> list)
    {
        this.populate(list);
    }

    // update iterators arrayList and the iterator itself after modifying the array/iterator
    private void updateIterator()
    {
        
    }
    
    private void populate(ArrayList<T> list)
    {
        this.list = null;
        this.iterator = null;
        this.list = list;
        this.iterator = list.iterator();
        this.currentIndex = -1;
    }
    
    // swap index1 with index2. resets position of iterator
    public ExtendedIterator swap(int index1, int index2)
    {
        return this.swap(index1, index2, false);
    }
    
    // swap index1 with index2. resets position of iterator
    public ExtendedIterator swap(int index1, int index2, boolean keepCurrentPosition)
    {
        int currentIndex = this.currentIndex;
        ArrayList<T> list = new ArrayList<T>();
        if (index1 == index2)
        {
            return this;
        }
        
        int firstIndex = index1;
        int secondIndex = index2;
        if (index1 > index2)
        {
            firstIndex = index2;
            secondIndex = index1;
        }

        T secondElement = this.elementAt(secondIndex);
        T firstElement = null; // for efficiency reasons it makes more sense to set in the while loop
        
        while (this.hasNext())
        {
            T currentElement = this.next();
            if (this.currentIndex == firstIndex)
            {
                firstElement = currentElement;
                currentElement = secondElement;
            }
            else if (this.currentIndex == secondIndex)
            {
                currentElement = firstElement;
            }
            
            list.add(currentElement);
        }
        
        //System.out.println("firstelement: " + firstElement + ", secondElement: " + secondElement);
        
        this.populate(list);
        
        if (keepCurrentPosition)
        {
            this.setPositionTo(currentIndex); // keep iterator position
        }
        
        return this;
    }
    
    // set iterator's position to index, returns element at that index
    public T setPositionTo(int index)
    {
        this.populate(this.list);

        while (this.currentIndex < index - 1)
        {
            this.next();
        }
        
        return this.next();
    }
    
    // get element of array at given index, resets iterator to start of list
    public T elementAt(int index)
    {
        return this.elementAt(index, false);
    }
    
    // get element of array at given index, if keepCurrentPosition is true iterator position does not change
    // otherwise iterator position is set to start
    public T elementAt(int index, boolean keepCurrentPosition)
    {
        int currentIndex = this.currentIndex;
        T ret = this.setPositionTo(index);
        
        if (keepCurrentPosition)
        {
            this.setPositionTo(currentIndex); // keep iterator position
        }
        else
        {
            this.populate(this.list); // reset iterator after getting element
        }
        
        return ret;
    }
    
    // similar to substring, returns a new iterator 
    public ExtendedIterator<T> subIterator(int startIndex, int endIndex)
    {
        ArrayList<T> subList = new ArrayList<T>();
        subList.add(this.setPositionTo(startIndex)); // set iterator to start index, and add that element to the subList
        
        while (this.currentIndex() < endIndex)
        {
            subList.add(this.next());
        }
        
        return new ExtendedIterator<T>(subList);
    }
    
    public ArrayList<T> toArray()
    {           
        return this.list;
    }
    
    /*
    ArrayList<T> retList = new ArrayList<T>();
    retList.add(this.setPositionTo(0));

    while (this.hasNext())
    {
        retList.add(this.next());
    }
    */
    
    public int length()
    {
        return this.list.size();
    }
    
    public int currentIndex()
    {
        return this.currentIndex;
    }
    
    @Override
    public boolean hasNext() 
    {
        return this.iterator.hasNext();
    }

    @Override
    public T next() 
    {
        this.currentIndex += 1;
        
        return this.iterator.next();
    }

    @Override
    public void remove()
    {
        this.iterator.remove();
    }
}