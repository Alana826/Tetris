
/**
 * Write a description of class AIPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;

public class AIPlayer
{
    private int level;
    private int speed;
    private int[] pieces;
    
    public AIPlayer()
    {
        level = 1;
        speed = 1;
    }
    
    //mutator methods
    public void upLevel()
    {
        level += 1;
        speed *= 1.5;
    }
    
    //getter methods
    public int getLevel()
    {
        return level;
    }
    
    //Make Tetriminos or make Tetrimino type??
    //Where will the case switch statement to assign the type num to the subclass be?
    public int[] choose(int numPieces)
    {
        pieces = new int[numPieces];
        Random rand = new Random();
            
        switch(level)
        {
            case 1:
                for (int i = 0; i < numPieces; i++)
                {
                    pieces[i] = rand.nextInt(7); //number will change depending on how many types of tetriminos there are
                } 
                break;
            case 2:
                for (int i = 0; i < numPieces; i++)
                {
                    if (i % 3 == 0) //add in extra of a certain type
                        pieces[i] = 4;
                    else
                        pieces[i] = rand.nextInt(7);
                }
                break;
            case 3:
                for (int i = 0; i < numPieces; i++)
                {
                    if (i % 3 == 0) //add in extra of a certain type
                        pieces[i] = 4;
                    else if (i % 3 == 1)
                        pieces[i] = 5;
                    else
                        pieces[i] = rand.nextInt(7);
                }
                break;
        }
        
        return pieces;
    }
}
