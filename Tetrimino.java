/**
 * Write a description of class Tetrimino here.
 *
 * @Alana Taylor
 * @version (a version number or a date)
 */
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Tetrimino extends Pane
{
    private int xPos;
    private int yPos;
    private double speed;
    private int rotation;
    private Rectangle square;
    
    public Tetrimino(int myXPos, int myYPos, double mySpeed, int myRotation)
    {
        xPos = myXPos;
        yPos = myYPos;
        speed = mySpeed;
        rotation = myRotation;
    }
    
    public void paint()
    {
        square = new Rectangle(xPos, yPos, 60, 60);
        square.setFill(Color.MEDIUMVIOLETRED);
        getChildren().add(square);
    }
    
    public void queue()
    {}
    
    public void drop()
    {}
    
    public void left()
    {
        xPos -= 30;
    }
    
    public void right()
    {
        xPos += 30;
    }
    
    public void setXPos(int myXPos)
    {
        xPos = myXPos;
    }
    
    public int getXPos()
    {
        return xPos;
    }
    
    public void rotate()
    {
        if (rotation < 3)
            rotation += 1;
        else
            rotation = 0;
        
        switch (rotation) 
        {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    
    public void place()
    {}
    
    public void hold()
    {}
    
    public void speedUp(double mySpeed)
    {
        speed *= mySpeed;
    }
}
