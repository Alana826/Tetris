
/**
 * Write a description of class Player here.
 *
 * @Alana Taylor
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int currScore;
    private int highScore;
    
    public Player(String myName)
    {
        name = myName;
    }
    
    //mutator methods
    public void upCurrScore(int newCurrScore)
    {
        currScore = newCurrScore;
    }
    
    public void upHighScore(int newHighScore)
    {
        highScore = newHighScore;
    }
    
    //getter methods
    public String getName()
    {
        return name;
    }
    
    public int getCurrScore()
    {
        return currScore;
    }
    
    public int getHighScore()
    {
        return highScore;
    }
}
