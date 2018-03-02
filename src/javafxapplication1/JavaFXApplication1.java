/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {

Scene scene1, scene2, scene0;
Label label2= new Label();
int i=0;
ModalWindow mw=new ModalWindow();

private String[][] data=new String[100][2];

@Override
public void start(Stage stage) {
      
    stage.setTitle("Lab_3");

    //Start registration scene
    Label label_reg = new Label("LOGIN");
    TextField text_reg = new TextField();
    text_reg.setMaxWidth(150);
    
    Label label_reg_pas = new Label("PASSWORD");
    PasswordField text_reg_pas = new PasswordField();
    text_reg_pas.setMaxWidth(150);
    
    Label label_reg_Rpas = new Label("Retype Password");
    PasswordField text_reg_Rpas = new PasswordField();
    text_reg_Rpas.setMaxWidth(150);
    
    Button button_reg= new Button("OK");
    Button button_back= new Button("SIGN IN");
    
    button_reg.setOnAction(e -> {
        if(text_reg_pas.getText().equals(text_reg_Rpas.getText())){
            data[i][0]=text_reg.getText().trim();
            data[i][1]=text_reg_pas.getText().trim();
            if(!(data[i][0].equals("") || data[i][1].equals(""))){
                stage.setScene(scene1);
            }
            //System.out.println(data[i][0]);
            //System.out.println(data[i][1]);
            i++;
        }else if(!(text_reg_pas.getText().equals(text_reg_Rpas.getText()))){
            mw.window("Пароли не совместимы");
            text_reg.setText("");
            text_reg_pas.setText("");
            text_reg_Rpas.setText("");
        }        
    });
    
    button_reg.setOnKeyPressed(e->{
        if(e.getCode()==KeyCode.ENTER){
            if(text_reg_pas.getText().equals(text_reg_Rpas.getText())){
            data[i][0]=text_reg.getText().trim();
            data[i][1]=text_reg_pas.getText().trim();
            if(!(data[i][0].equals("") || data[i][1].equals(""))){
                stage.setScene(scene1);
            }
            //System.out.println(data[i][0]);
            //System.out.println(data[i][1]);
            i++;
        }else if(!(text_reg_pas.getText().equals(text_reg_Rpas.getText()))){
            mw.window("Пароли не совместимы!");
            text_reg.setText("");
            text_reg_pas.setText("");
            text_reg_Rpas.setText("");
        }
        }
    });
    
    button_back.setOnAction(e->{
        stage.setScene(scene1);
        text_reg.setText("");
        text_reg_pas.setText("");
        text_reg_Rpas.setText("");
    });
    button_back.setOnKeyPressed(e->{
        if(e.getCode()==KeyCode.ENTER){
            stage.setScene(scene1);
            text_reg.setText("");
            text_reg_pas.setText("");
            text_reg_Rpas.setText("");
        }
    });
    
    VBox layout0 = new VBox(20);
    HBox layoutH2=new HBox(10);
    layoutH2.setAlignment(Pos.CENTER);
    layoutH2.getChildren().addAll( button_reg,button_back);
    layout0.setAlignment(Pos.CENTER);
    layout0.getChildren().addAll(label_reg,text_reg,label_reg_pas,text_reg_pas,label_reg_Rpas,text_reg_Rpas,layoutH2);
    scene0= new Scene(layout0, 400, 350);
    scene0.getStylesheets().add("style/style.css");
    
    //End registration scene
    
    
    
    //Start Sign in Scene
    Label label_log = new Label("LOGIN");
    TextField text_log = new TextField();
    text_log.setMaxWidth(150);
    
    Label label_pass = new Label("PASSWORD");
    PasswordField text_pass = new PasswordField();
    text_pass.setMaxWidth(150);
    
    Button button1= new Button("SIGN IN");
    Button button2= new Button("SIGN UP");
    
    button1.setOnAction(e -> {
        for(int i=0;i<data.length;i++){
            if(text_log.getText().equals(data[i][0])){                
                if(text_pass.getText().equals(data[i][1])){
                    stage.setScene(scene2);
                    label2.setText("Hello "+data[i][0]);
                }else if(!(text_pass.getText().equals(data[i][1]))){
                    mw.window("Пароль не верен!");
                }
            }
        }
    } );
    button2.setOnAction(e -> {
        stage.setScene(scene0);
        text_log.setText("");
        text_pass.setText("");
    });
    
    button1.setOnKeyPressed(e->{
        if(e.getCode()==KeyCode.ENTER){
            for(int i=0;i<data.length;i++){
                if(text_log.getText().equals(data[i][0])){                
                    if(text_pass.getText().equals(data[i][1])){
                        stage.setScene(scene2);
                        label2.setText("Hello "+data[i][0]);
                    }else if(!(text_pass.getText().equals(data[i][1]))){
                        mw.window("Пароль не верен!");
                    }
                }
            }
        }
    });
    button2.setOnKeyPressed(e->{
        if(e.getCode()==KeyCode.ENTER){
            stage.setScene(scene0);
            text_log.setText("");
            text_pass.setText("");
        }
    });
    
    HBox layoutH = new HBox(10);
    layoutH.setAlignment(Pos.CENTER);
    layoutH.getChildren().addAll(button1,button2);
    VBox layout1 = new VBox(20);     
    layout1.setAlignment(Pos.CENTER);
    layout1.getChildren().addAll(label_log,text_log,label_pass,text_pass, layoutH);
    scene1= new Scene(layout1, 400, 270);
    scene1.getStylesheets().add("style/style.css");
    
    //End Sign in Scene
    
    
    //Start Scene 3
    
    Button button3= new Button("LOG OUT");
    
    button3.setOnAction(e -> {
        stage.setScene(scene1);
        text_log.setText("");
        text_pass.setText("");
    });
    button3.setOnKeyPressed(e->{
        if(e.getCode()==KeyCode.ENTER){
        stage.setScene(scene1);
        text_log.setText("");
        text_pass.setText("");
        }
    });
    
    VBox layout2= new VBox(20);
    layout2.setAlignment(Pos.CENTER);
    layout2.getChildren().addAll(label2,button3);
    scene2= new Scene(layout2,300,250);
    scene2.getStylesheets().add("style/style.css");
    
    //End Scene 3
    
    //stage
    
    stage.setScene(scene1);
    stage.setResizable(false);
    stage.show();
}
    public static void main(String[] args) {    
        launch(args);
    }
}