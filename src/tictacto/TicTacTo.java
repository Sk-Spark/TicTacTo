/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacto;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author spark
 */
public class TicTacTo extends Application 
{
    private ScoreBord scoreBord;
    private Tile tiles[][];
    private VBox root;
    private Stage window;
    private int player;
    private GridPane grid;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        scoreBord = new ScoreBord(this);
        tiles = new Tile[3][3];
        player = 1;
        
        //Main game area
        grid = new GridPane();

        for(int i=0;i <3; ++i)
        {
            for(int j=0; j<3; ++j)
            {
                tiles[i][j] = new Tile();
                tiles[i][j].setOnMouseClicked(e -> handler(e) );
                
                GridPane.setConstraints(tiles[i][j], i, j);
                grid.getChildren().add(tiles[i][j]);
            }
        }
        
        grid.setPadding(new Insets(10));
        grid.setHgap(5);        
        grid.setVgap(5); 
        
        grid.setDisable(true);
        
        root = new VBox();        
        root.getChildren().addAll(grid, scoreBord);
        root.setPadding(new Insets(5));
        
        Scene scene = new Scene(root, 400, 500);
                
        //window initialization
        window.setResizable(false);
        window.setScene(scene);
        window.setTitle("Tic Tac To");
        
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();            
        } );

        window.show();

    }

    public static void main(String[] args) 
    {
        launch(args);
    }

    private void closeProgram() 
    {
        int ans = DilogBox.display("Close", "Are You sure you want to exit ?");
        if(ans == 1)
            window.close();            
    }
    
    // event handler for tiles
    private void handler( Event e )
    {
        Tile t = (Tile)e.getSource();
        boolean ans = t.setState(player);
        
        if(ans == false)
            return;
        
        if(player == 1)
        {
            player = 2;
            scoreBord.display("Chance of Player 2 !!!");
        }
        else 
        {
            player = 1;
            scoreBord.display("Chance of Player 1 !!!");
        }
        
        // Checking if player 1 won
        if(isPlayerWon('X'))
        {
            grid.setDisable(true);
            scoreBord.display("Player 1 Won !!! ");
            scoreBord.setBtnTxt("Play Again !!!");
            scoreBord.setBtnDisable(false);
            player = 1;
        }
        
        // Checking if player 2 won
        if(isPlayerWon('O'))
        {
            grid.setDisable(true);
            scoreBord.display("Player 2 Won !!! ");
            scoreBord.setBtnTxt("Play Again !!!");
            scoreBord.setBtnDisable(false);
            player = 1;
        }
        
        if(isGridFull())
        {
            scoreBord.setBtnTxt("Play Again !!!");
            scoreBord.setBtnDisable(false);
        }

    }
    
    //event handler for ScoreBord
    protected  void scoreBoardHandler( Event e )
    {
        System.out.println("Play");
        Button btn =(Button)e.getSource() ;
        String s = btn.getText();
        
        if(s.equals("Start Game") || s.equals("Play Again !!!"))
        {
            resetGrid();
            grid.setDisable(false);
            btn.setText("Play");
            btn.setDisable(true);
            scoreBord.display("Chance of Player 1 !!!");
        }        
            
    }
    
    //returns true if the grid is full
    private boolean isGridFull()
    {
        boolean ans = true;
        
        for(int i=0; i<3; ++i)
        {
            for(int j=0; j<3; ++j)
            {
                if(tiles[i][j].getState() == 0)
                {
                    ans = false;
                    return ans;
                }
            }
        }
        
        return ans;
    }

    // To set the grid to initial stage
    private void resetGrid()
    {
        for(int i=0; i<3; ++i)
        {
            for(int j=0; j<3; ++j)
            {
                tiles[i][j].reset();
            }
        }
    }
    
    //To check if player1 Won
    private boolean isPlayerWon(char ch)
    {
        boolean ans = false;
        
        // Checking Row wise
        for(int i=0; i<3; ++i)
        {
            if( tiles[i][0].getChar() == ch && tiles[i][1].getChar() == ch && tiles[i][2].getChar()==ch )
            {    
                return true;
            }
            
        }
        
        // Checking Coloum wise
        for(int i=0; i<3; ++i)
        {
            if( tiles[0][i].getChar() == ch && tiles[1][i].getChar() == ch && tiles[2][i].getChar()==ch )
            {    
                return true;
            }            
        }
        
        // Checking left digonal
        if( tiles[0][0].getChar() == ch && tiles[1][1].getChar() == ch && tiles[2][2].getChar()==ch )
        {    
            return true;
        }            
        
        // Checking right digonal
        if( tiles[0][2].getChar() == ch && tiles[1][1].getChar() == ch && tiles[2][0].getChar()==ch )
        {    
            return true;
        }        
        return false;
    }
    
    
    
}
