/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajo_agenda_fxmaven;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author W10
 */
public class Scene3Controller implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            String link = "jdbc:mysql://localhost:3306/DataBase?serverTimezone=UTC&user=root&password=admin";
            Connection con = DriverManager.getConnection(link);
            Statement st = con.createStatement();
            String y = "";
            ResultSet x = st.executeQuery("SELECT * FROM Personaje");
            while (x.next()) {
                y = y + x.getString("Nombre") + " " + x.getString("Fuerza") + " "
                        + x.getString("Velocidad") + " " + x.getString("Resistencia")
                        + System.lineSeparator();

            }
            textArea.setText(y);
            st.close();
            con.close();
        } catch (SQLException ex) {
            textArea.setText("No se ha podido conectar con la" + System.lineSeparator() 
                    + " base de datos o esta vacia");
        }

    }

    @FXML
    private void closeWindow(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
