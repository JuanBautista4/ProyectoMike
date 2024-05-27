package fes.aragon.controller;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class InicioLevelController {

        @FXML
        private Button btnAbrirLevel;

        @FXML
        void accionAbrirLevelDev(ActionEvent event) {
                try {
                        FXMLLoader modificar= new FXMLLoader(getClass().getResource("/fes/aragon/xml/level.fxml"));
                        Parent parent=(Parent)modificar.load();
                        Scene scene=new Scene(parent);
                        Stage stage=new Stage();
                        stage.setScene(scene);
                        stage.initStyle(StageStyle.UTILITY);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        ((LevelController)modificar.getController()).setEscena(scene);
                        ((LevelController)modificar.getController()).iniciar();
                        stage.show();
                        stage.requestFocus();

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }
        }




