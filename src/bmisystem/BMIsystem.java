/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmisystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BMIsystem extends Application {
    private TextField name,weight,height;
    private Button countbtn,exitbtn;      
    private Label enterlength,enterwidth;
    private RadioButton male,female;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-Background-color:lightblue");
        //Step 1 :tittle
        GridPane top = new GridPane();
         name = new TextField();
         weight = new TextField();
         height = new TextField();
         
        Label n = new Label("Name : ");
        Label w = new Label("Weight(KG) : ");
        Label h = new Label("Height(M) : ");
        Label g = new Label("Gender : ");
        RadioButton maleRB = new RadioButton("Male");
        RadioButton femaleRB = new RadioButton("Female");
        ToggleGroup genderTG = new ToggleGroup();
        maleRB.setToggleGroup(genderTG);
        femaleRB.setToggleGroup(genderTG);
        countbtn = new Button("Calculate");
        exitbtn = new Button("Exit");
        
        n.setPadding(new Insets(10));
        w.setPadding(new Insets(10));
        h.setPadding(new Insets(10));
        g.setPadding(new Insets(10));
        top.add(n,0,0);
        top.add(w,0,1);
        top.add(h,0,2);
        top.add(g,0,3);
        top.add(name,1,0);
        top.add(weight,1,1);
        top.add(height,1,2); 
        top.add(maleRB,1,3);
        top.add(femaleRB,2,3);
        top.add(countbtn,1,4);
        top.add(exitbtn,2,4);
        name.setPadding(new Insets(0,0,2,0));
        weight.setPadding(new Insets(0,0,2,0));
        height.setPadding(new Insets(0,0,2,0));      
        pane.setTop(top);
        top.setAlignment(Pos.TOP_LEFT);
       
        GridPane botton = new GridPane();
        Label r = new Label("Result------------------------------------------------- ");
        Label a = new Label("");
        Rectangle r1 = new Rectangle(250,280);
        r1.setFill(null);
        r1.setStroke(Color.LIGHTBLUE);
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup sex = new ToggleGroup();
        male.setToggleGroup(sex);
        female.setToggleGroup(sex);
        Label BMIknowledge = new Label();
        botton.add(male,1,0);
        botton.add(female,2,0);
        botton.add(BMIknowledge,1,1);
        botton.add(r,0,0);
        botton.add(a,0,1);
        botton.add(r1,0,1);
        pane.setBottom(botton);
        botton.setAlignment(Pos.TOP_LEFT);
         
    
        
        
        Scene scene = new Scene(pane, 400, 500);
        
        primaryStage.setTitle("BMI System");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(BMIsystem.class.getResourceAsStream("image/bmi.png")));
        primaryStage.show();
        
        countbtn.setOnAction(e->{
            
            String gender = "";
            String status= "";
            try{
               String Name = name.getText();    
               String kg = weight.getText();
               String m = height.getText();
               double w1 = Double.parseDouble(kg);
               double h1 = Double.parseDouble(m);    
               double bmi=w1/(h1*h1);
                if(maleRB.isSelected()){
                    gender = "Male";
                    if(bmi < 20){
                        status = "Underweight";
                    }else if(bmi >= 20 && bmi <= 24.9){
                        status = "Normal";
                    }else if(bmi >=25 && bmi <= 31.9){
                        status = "Overweight";
                    }else if(bmi >=32){
                        status = "Obese";
                    }
                }
                if(femaleRB.isSelected()){
                    gender = "Female";
                    if(bmi < 18.5){
                        status = "Underweight";
                    }else if(bmi >= 18.5 && bmi <= 21.9){
                        status = "Normal";
                    }else if(bmi >=22 && bmi <= 27.9){
                        status = "Overweight";
                    }else if(bmi >=28){
                        status = "Obese";
                    }
                }
                
                a.setText(String.valueOf("Name: "+Name+
                        "\nWeight: "+w1+" kg"+
                        "\nHeight: "+h1+" m"+
                        "\nGender: "+gender+
                        "\nBMI: "+bmi+
                        "\n"+status));
            
            }catch(ArithmeticException b){
                a.setText("Height cannot be zero");
            }catch(NumberFormatException lol){ 
                 a.setText("Text Field Is Not Valid");
            }
      
        
            
            
        
        });
        
        
        exitbtn.setOnAction(e->{
            ImageIcon icon = new ImageIcon("image/bmi.png"); 
             int bye=JOptionPane.showConfirmDialog(null, "Conform Exit?","QAQ",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,icon);
             if(bye==0){
                 System.exit(0);
             }
        });
        
         male.setOnAction(e->{
            ImageIcon icon = new ImageIcon("image/bmi.png"); 
            if(male.isSelected()){
              JOptionPane.showMessageDialog(null,"BMI                       Weight Status\nBelow 20             Underweight\n20-24.9                Normal\n25-31.9                Overweight\n32 and Above     Obese","Male",JOptionPane.INFORMATION_MESSAGE,icon);    
            }  
        });
        
     
         female.setOnAction(e->{
            ImageIcon icon = new ImageIcon("image/bmi.png"); 
            if(female.isSelected()){
              JOptionPane.showMessageDialog(null,"BMI                          Weight Status\nBelow 18.5             Underweight\n18.5-21.9                Normal\n22-27.9                   Overweight\n28 and Above        Obese","Female",JOptionPane.INFORMATION_MESSAGE,icon);   
            }  
        });
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
