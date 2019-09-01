
package tictacto;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScoreBord extends VBox 
{
    private String text;
    private Label label;
    private Button btn;
    private static int width = 360, height = 80;

    public ScoreBord(TicTacTo ticTacTo) 
    {
        this.label = new Label("Come On Guys Let's Play !!!");
        this.btn = new Button("Start Game");
        this.btn.setOnAction(e -> ticTacTo.scoreBoardHandler(e));
        
        this.text = "Play";
        init();
    }
    
    private void init()
    {
        this.setPadding(new Insets(15, 0,0,0));
        this.setAlignment(Pos.CENTER);
        this.setMinSize(width, height);
        this.setSpacing(15);
        
        
        this.getChildren().addAll(label,btn);
        
    }    
    
    protected void display(String msg)
    {
        this.label.setText(msg);
    }
    
    protected void setBtnTxt(String txt)
    {
        this.btn.setText(txt);
    }
    
    protected void setBtnDisable(boolean st)
    {
        this.btn.setDisable(st);
    }
    
    
}
