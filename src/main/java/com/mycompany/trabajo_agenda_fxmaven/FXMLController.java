package com.mycompany.trabajo_agenda_fxmaven;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    Grupo grupo = new Grupo();

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
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane fondo;

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
    private void setAdd(ActionEvent event) {
        grupo.add(textName.getText(), Integer.valueOf(intStrength.getText()),
                Integer.valueOf(intSpeed.getText()), Integer.valueOf(intResis.getText()));
        cleanText();
    }

    @FXML
    private void setRemove(ActionEvent event) {
        grupo.remove(Integer.valueOf(removeTextbox.getText()));
        removeTextbox.setText("");
    }

    @FXML
    private void setSearch(ActionEvent event) {
        textArea.setText(grupo.search(textSearch.getText()));
    }

    @FXML
    private void save(ActionEvent event) {
        grupo.writeFile();
    }

    @FXML
    private void load(ActionEvent event) {
        grupo.fromFileToArray();
    }

    @FXML
    private void saveBinary(ActionEvent event) {
        grupo.binaryFileWrite();
    }

    @FXML
    private void loadBinary(ActionEvent event) {
        try {
            grupo.binaryFileRead();
        } catch (ClassNotFoundException | FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void finishApp(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("/fxml/Scene2.fxml"));
        Scene scene = new Scene(scene2);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Salir");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void saveInDB(ActionEvent event) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/DataBase?serverTimezone=UTC&user=root&password=admin";
        String createString = "CREATE TABLE IF NOT EXISTS Personaje (Nombre TEXT(25), "
                + "Fuerza int(1), Velocidad int(1), Resistencia int(1))";
        Connection con = DriverManager.getConnection(url);
        Statement st = con.createStatement();
        st.executeUpdate(createString);
        String deleteSQL = "DELETE FROM Personaje";
        st.executeUpdate(deleteSQL);
        try {
            int x = 0;
            while (true) {
                Personaje pj = grupo.getObjetposition(x);
                x++;
                String name = pj.getNombre();
                int stren = pj.getStrength();
                int spid = pj.getSpeed();
                int resis = pj.getResistance();
                String insert = "INSERT INTO Personaje VALUES('" + name + "', "
                        + stren + ", " + spid + ", " + resis + ")";
                st.executeUpdate(insert);
            }
        } catch (Exception e) {
        }

        st.close();
        con.close();
    }

    @FXML
    private void loadFromDB(ActionEvent event) throws SQLException {
        String link = "jdbc:mysql://localhost:3306/DataBase?serverTimezone=UTC&user=root&password=admin";
        Connection con = DriverManager.getConnection(link);
        Statement st = con.createStatement();
        ResultSet x = st.executeQuery("SELECT * FROM Personaje");

        while (x.next()) {
            String name = x.getString("Nombre");
            int strength = Integer.valueOf(x.getString("Fuerza"));
            int speed = Integer.valueOf(x.getString("Velocidad"));
            int resis = Integer.valueOf(x.getString("Resistencia"));
            grupo.add(name, strength, speed, resis);

        }
        st.close();
        con.close();
    }

    @FXML
    private void consult(ActionEvent event) throws IOException, SQLException {
        Parent scene3 = FXMLLoader.load(getClass().getResource("/fxml/Scene3.fxml"));
        Scene scene = new Scene(scene3);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Consulta");
        stage.setScene(scene);
        stage.show();

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

    private void cleanText() {
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

    private void setVisibleSearchTrue() {
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

}
