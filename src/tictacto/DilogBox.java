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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author spark
 */
public class DilogBox
{
    private static int ans = 0;
    
    public static int display(String title, String msg)
    {
        Stage window = new Stage();
        
        window.setTitle(title);
        
        Label lblMsg = new Label(msg);
        
        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");
        
        btnYes.setOnAction(e -> {
            ans = 1;
            window.close();
        });
                
        btnNo.setOnAction(e -> {
            ans = 0;
            window.close();
        });
        
        HBox hb = new HBox();

        hb.setSpacing(5);
        hb.setPadding(new Insets(10));
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(btnYes, btnNo);
                       
        VBox root = new VBox();
        
        root.setSpacing(10);
        root.getChildren().addAll(lblMsg,hb);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(5));
        
        Scene scene = new Scene(root, 300, 100);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();

        return ans;
        
    }

    
}
