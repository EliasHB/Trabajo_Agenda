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
    private Button removeButton;
    @FXML
    private TextField removeTextbox;
    @FXML
    private Label removeint;
    @FXML
    private Label labelSearch;
    @FXML
    private TextField textSearch;
    @FXML
    private Button buttonSearch;
    @FXML
    private MenuItem menuSaveBinary;
    @FXML
    private MenuItem menuLoadBinary;

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setHide();
    }

    @FXML
    private void add(ActionEvent event) {
        setHide();
        setVisibleAddTrue();

    }

    @FXML
    private void remove(ActionEvent event) {
        setHide();
        setVisibleRemoveTrue();
    }

    @FXML
    private void search(ActionEvent event) {
        setHide();
        cleanText();
        setVisibleSearchTrue();
    }

    @FXML
    private void orderAndShow(ActionEvent event) {
        setHide();
        cleanText();
        setVisibleGroupTrue();
        grupo.orderListByName();
        textArea.setText(grupo.watch());

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
        grupo.add(textName.getText(), Integer.valueOf(intStrength.getText()),
                Integer.valueOf(intSpeed.getText()), Integer.valueOf(intResis.getText()));
        cleanText();
    }

    @FXML
    private void setRemove(ActionEvent event) {
        grupo.remove(Integer.valueOf(removeTextbox.getText()));
    }
    
    @FXML
    private void setSearch(ActionEvent event) {
        textArea.setText(grupo.search(textSearch.getText()));
       
    }


    private void setVisibleAddTrue() {
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        textName.setVisible(true);
        intStrength.setVisible(true);
        intSpeed.setVisible(true);
        intResis.setVisible(true);
        buttonAdd.setVisible(true);
    }
    private void cleanText(){
        textArea.setText("");
        textName.setText("");
        intStrength.setText("");
        intSpeed.setText("");
        intResis.setText("");
    }
    private void setVisibleRemoveTrue() {
        removeTextbox.setVisible(true);
        removeint.setVisible(true);
        removeButton.setVisible(true);
    }

    private void setVisibleGroupTrue() {
        textArea.setVisible(true);
    }
    private void setVisibleSearchTrue(){
        labelSearch.setVisible(true);
        textSearch.setVisible(true);
        buttonSearch.setVisible(true);
        textArea.setVisible(true);
    }

    private void setHide() {
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        textArea.setVisible(false);
        textName.setVisible(false);
        intStrength.setVisible(false);
        intSpeed.setVisible(false);
        intResis.setVisible(false);
        buttonAdd.setVisible(false);
        removeTextbox.setVisible(false);
        removeint.setVisible(false);
        removeButton.setVisible(false);
        labelSearch.setVisible(false);
        textSearch.setVisible(false);
        buttonSearch.setVisible(false);

    }

    @FXML
    private void saveBinary(ActionEvent event) {
    }

    @FXML
    private void loadBinary(ActionEvent event) {
    }

}
