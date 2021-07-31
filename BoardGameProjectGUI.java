import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

//************************************************************************
//  BoardGameProjectGUI.java       Author: Lewis/Loftus, adapted by D. Heath
//
//  Demonstrates the use of recursion to draw a fractal.
//************************************************************************

public class BoardGameProjectGUI extends Application
{
    private final static int MIN_ORDER = 1;
    private final static int MAX_ORDER = 4;
    private Tetrimino test;
    private int order;
    private Button up, down;
    private int turnCount = 0;
    private int turn;
    private BoardGamePane gamePane;
    
    //--------------------------------------------------------------------
    //  Displays two buttons that control the order of the fractal
    //  shown in the pane below the buttons.
    //--------------------------------------------------------------------
    public void start(Stage primaryStage)
    {
        // Image upImage = new Image(getClass().getResource("up.png").toExternalForm());
        // up = new Button();
        // up.setGraphic(new ImageView(upImage));
        // up.setOnAction(this::processUpButtonPress);
        
        // Image downImage = new Image(getClass().getResource("down.png").toExternalForm());
        // down = new Button();
        // down.setGraphic(new ImageView(downImage));
        // down.setOnAction(this::processDownButtonPress);
        // down.setDisable(true);
        
        AIPlayer comp = new AIPlayer();
        
        Player player1 = new Player("Joe");
        player1.upCurrScore(2500);
        player1.upHighScore(100000);
        
        Text level = new Text("Level: " + comp.getLevel());
        Text tetris = new Text("TETRIS");
        Text score = new Text("Score: " + player1.getCurrScore());
        
        HBox toolbar = new HBox();
        toolbar.setStyle("-fx-background-color: steelblue");
        toolbar.setAlignment(Pos.CENTER);
        toolbar.setPrefHeight(50);
        toolbar.setSpacing(40);
        toolbar.getChildren().addAll(level, tetris, score);
        
        Text playerName = new Text("Player name: " + player1.getName());
        Text highScore = new Text("Highscore: " + player1.getHighScore());
        
        HBox playerInfo = new HBox();
        playerInfo.setStyle("-fx-background-color: steelblue");
        playerInfo.setAlignment(Pos.BOTTOM_CENTER);
        playerInfo.setPrefHeight(50);
        playerInfo.setSpacing(40);
        //toolbar.getChildren().addAll(up, orderText, turnText, down);
        playerInfo.getChildren().addAll(playerName, highScore);
        
        gamePane = new BoardGamePane();
        
        test = new Tetrimino(220, 200, 1.0, 0);
        test.paint();
        
        Group root = new Group();
        root.setStyle("-fx-background-color: white");
        //root.getChildren().addAll(toolbar, gamePane, playerInfo, test);
        root.getChildren().addAll(gamePane, test);

        Scene scene = new Scene(root, 500, 900);
        scene.setOnKeyPressed(this::processKeyPress);
        
        primaryStage.setTitle("Board Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    //--------------------------------------------------------------------
    //  Increments the fractal order when the up button is pressed.
    //  Disables the up button if the maximum order is reached.
    //--------------------------------------------------------------------
    // public void processUpButtonPress(ActionEvent event)
    // {
        // order++;
        // gamePane.setOrder(order);
        // orderText.setText("Order: " + order);
        // gamePane.showData(order);
        
        // down.setDisable(false);
        // if (order == MAX_ORDER)
            // up.setDisable(true);
        // //increment turnCount and set new player # to be up
        // {
            // turnCount++;
            // turn = (turnCount % 2)+1;
            // turnText.setText("Player #: " + turn);
        // }
    // }

    //--------------------------------------------------------------------
    //  Decrements the fractal order when the down button is pressed.
    //  Disables the down button if the minimum order is reached.
    //--------------------------------------------------------------------
    // public void processDownButtonPress(ActionEvent event)
    // {
        // order--;
        // gamePane.setOrder(order);
        // orderText.setText("Order: " + order);
        // gamePane.showData(order);
        
        // up.setDisable(false);
        // if (order == MIN_ORDER)
            // down.setDisable(true);
        // //increment turnCount and set new player # to be up
        // {
            // turnCount++;
            // turn = (turnCount % 2)+1;
            // turnText.setText("Player #: " + turn);
        // }
    // }
    public void processKeyPress(KeyEvent event)
    {
        switch (event.getCode())
        {
            case RIGHT:
                //test.right();
                test.setXPos(test.getXPos() + 30);
                break;
            case LEFT:
                test.left();
                break;
            default:
                break;  // do nothing if it's not an arrow key
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
