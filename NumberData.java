/**
 * class NumberData keeps a list of 11 numbers in a 1-D array
 * 
 * @author (Mr. Heath) 
 * @version (May 2014)
 */
public class NumberData
{
    // array of data
      private int limit;
      private final int MULTIPLE = 2;
      private int[] list = {10, 30, 10, 60, 100, 90, 50, 20, 80, 80, 40};

    /**
     * Constructor for objects of class NumberData
     */
    public NumberData()
    {
      //  Initialize the size of the array 
      limit = list.length;
    }

    /**
     * outputs the size limit of the data structure*/
    public int getLimit()
    {
      return limit;
    }
    
    /**
     * outputs the number at position index
     */
    public int getThisNum(int index)
    {
      return list[index];
    }

    /**
     * outputs a string concatenation of the numbers in the array
     */
    public String toString()
    {
      String nums = "";
      for (int index = 0; index < limit; index++)
         nums += (list[index] + "  ");
      return nums;
    }
}