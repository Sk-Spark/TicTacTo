/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacto;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author spark
 */
public class Tile extends Label
{
    private int state;
    private static String[] text = {" ","X","O"};
    private static Color color[] = {Color.BLUE, Color.BLUE, Color.RED};
    private static Font font = new Font("Verdana", 60);
    private static final int size = 120;
    private static final Color bgColor = Color.rgb(150,150,150);
    
    Tile()
    {
        this.state = 0;
        this.setMinWidth(size);
        this.setMinHeight(size);
        init();
    }
    
    public int getState() {return this.state;}
    
    public void reset()
    {
        this.state = 0;
        this.setText(text[state]);
    }
    
    private void init()
    {
        this.setAlignment(Pos.CENTER);
        this.setFont(font);
        this.setBackground(new Background( new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY) ));
        setState(0);
    }
    
    protected boolean setState(int s)
    {
        if(this.state != 0)
                return false;
        
        this.state = s;
        this.setText(text[state]);        
        return true;
    }
    
    public char getChar()
    {
        return text[this.state].charAt(0);
    }
    

    
}
