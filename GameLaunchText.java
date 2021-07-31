//********************************************************************
//  GameLaunchText.java       Author: Lewis/Loftus
//
//  Displays numbers from the data structure multiplied by differnt #'s
//********************************************************************

import java.util.Scanner;

public class GameLaunchText
{
   //-----------------------------------------------------------------
   //  Instantiates a NumberData object and prints its contents 
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      NumberData myNums = new NumberData ();
      int multiplier = 1;
      Scanner scan = new Scanner (System.in);
      int limit = 10;
      int turnCount = 1;
      int turn = 1;
      
      do
      {
          // display the contents of the data structure
          // multiplied by the multiplier
          for (int count = 1; count <= limit; count++) 
         {int num = myNums.getThisNum(count);
            System.out.print (num * multiplier + "\t");
         }
         System.out.println();
         // get input from user
         System.out.print ("Enter the multiplier (1 to 10) or 0 to quit " );
         multiplier = scan.nextInt();
         turn = (turnCount % 2)+1;
         System.out.println("now it is player "+ turn + "'s turn");
         turnCount++;
        } while (!(multiplier == 0));
        
      System.out.println ("Thanks for playing " );
   }
}