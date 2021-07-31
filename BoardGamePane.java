import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color; 
import javafx.scene.input.KeyEvent;

//************************************************************************
//  BoardGamePane.java       Author: Lewis/Loftus
//
//  Represents the pane in which the Koch Snowflake fractal is presented.
//************************************************************************

public class BoardGamePane extends Pane
{
    private NumberData myBoard;
    private int current;  //current height Multiplier
    public final static double SQ = Math.sqrt(3) / 6;
    private Tetrimino test;
    
    //--------------------------------------------------------------------
    //  Makes an initial fractal of order 1 (a triangle) when the pane
    //  is first created.
    //--------------------------------------------------------------------
    public BoardGamePane()
    {
        myBoard = new NumberData();
        showData(1);
    }
    
    //--------------------------------------------------------------------
    //  Draws the fractal by clearing the pane and then adding three
    //  lines of the specified order between three predetermined points.
    //--------------------------------------------------------------------
    public void showData(int order)
    {
        getChildren().clear();
        int size = myBoard.getLimit();
        // draw horizontal line for the bottom of the display
        //getChildren().add(new Line(0, 375, 220, 375));
        
        Rectangle playingArea = new Rectangle(100, 50, 300, 600);
        playingArea.setFill(Color.LIGHTBLUE);
        
        getChildren().add(playingArea);
        int horizMult = 20; // multiplier to separate (x,y) positions
        
        // draw vertical lines for the column chart of the data
        for (int i = 100; i < 400; i+=30)
        {
            Line rows = new Line(i, 50, i, 650);
            rows.setStroke(Color.STEELBLUE);
            getChildren().add(rows);
            
            //int num = myBoard.getThisNum(i);
            //int y2 = (375 - (current*num));
            //getChildren().add(new Line(horizMult*i, 375, horizMult*i, y2));
            //addLine(order, 200, 20, 60, 300);
            //addLine(order, 60, 300, 340, 300);
            //addLine(order, 340, 300, 200, 20);
        }
        for (int j = 50; j < 650; j += 30)
        {
            Line cols = new Line(100, j, 400, j);
            cols.setStroke(Color.STEELBLUE);
            getChildren().add(cols);
        }
        
        // test = new Tetrimino(220, 200, 1.0, 0);
        // test.paint();
        // getChildren().add(test);
    }
    
    public void setOrder (int order)
    {
         current = order;
    }
    
    public int getOrder ()
    {
         return current;
    }
        
    //--------------------------------------------------------------------
    //  Recursively adds a line of the specified order to the fractal.
    //  The base case is a straight line between the given points.
    //  Otherwise, three intermediate points are computed and four line
    //  segments are added as a fractal of decremented order.
    //--------------------------------------------------------------------
    public void addLine(int order, double x1, double y1, double x5,
        double y5)
    {
        double deltaX, deltaY, x2, y2, x3, y3, x4, y4;
        
        if (order == 1)
        {
            getChildren().add(new Line(x1, y1, x5, y5));
        }
        else
        {
            deltaX = x5 - x1;  // distance between the end points
            deltaY = y5 - y1;
            
            x2 = x1 + deltaX / 3;  // one third
            y2 = y1 + deltaY / 3;
            
            x3 = (x1 + x5) / 2 + SQ * (y1 - y5);  // projection
            y3 = (y1 + y5) / 2 + SQ * (x5 - x1);
            
            x4 = x1 + deltaX * 2 / 3;  // two thirds
            y4 = y1 + deltaY * 2 / 3;
            
            addLine(order - 1, x1, y1, x2, y2);
            addLine(order - 1, x2, y2, x3, y3);
            addLine(order - 1, x3, y3, x4, y4);
            addLine(order - 1, x4, y4, x5, y5);
        }
    }
}
