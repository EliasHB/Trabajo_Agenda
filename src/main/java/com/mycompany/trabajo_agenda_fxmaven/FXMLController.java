package com.mycompany.trabajo_agenda_fxmaven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    Grupo grupo = new Grupo();
    private Label label;
    @FXML
    private MenuItem menuAdd;
    @FXML
    private MenuItem menuRemove;
    @FXML
    private MenuItem menuSearch;
    @FXML
    private MenuItem orderShow;
    @FXML
    private MenuItem menuSave;
    @FXML
    private MenuItem menuLoad;
    @FXML
    private Menu exitApp;
    @FXML
    private TextField textName;
    @FXML
    private TextField intStrength;
    @FXML
    private TextField intSpeed;
    @FXML
    private TextField intResis;
    @FXML
    private Button buttonAdd;
    @FXML
    private TextArea textArea;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private TextField removeText;
    @FXML
    private Label removeName;
   
    private void handleButtonAction(ActionEvent event) {
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void add(ActionEvent event){
        setVisibleAddTrue();
    }

    @FXML
    private void remove(ActionEvent event) {
        setVisibleRemoveTrue();
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void orderAndShow(ActionEvent event) {
    }

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void load(ActionEvent event) {
    }

    @FXML
    private void exitApp(ActionEvent event) {
    }

    @FXML
    private void setAdd(ActionEvent event) {
    }
    
    private void setVisibleAddTrue(){
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        textArea.setVisible(true);
        textName.setVisible(true);
        intStrength.setVisible(true);
        intSpeed.setVisible(true);
        intResis.setVisible(true);
        buttonAdd.setVisible(true);
    }
    private void setVisibleRemoveTrue(){
        removeText.setVisible(true);
        removeName.setVisible(true);
    }
    private void setHide(){
        
    }
    
}
