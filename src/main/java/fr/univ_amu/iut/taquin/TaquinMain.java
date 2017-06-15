package fr.univ_amu.iut.taquin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TaquinMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Taquin");

        try {
            TaquinIHM ihm = new TaquinIHM();
            ihm.setStageAndSetupListeners(primaryStage);
            primaryStage.setScene(new Scene(ihm));

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
