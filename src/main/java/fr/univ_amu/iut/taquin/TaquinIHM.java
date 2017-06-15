package fr.univ_amu.iut.taquin;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Optional;

public class TaquinIHM extends BorderPane{

    private StatusBar statusBar;

    private TaquinBoard taquinBoard;

    private MenuBar menuBar;

    private int taille = 4;

    public TaquinIHM() {
        initialize();
        creerBindings();

        this.setTop(menuBar);
        this.setCenter(taquinBoard);
        this.setBottom(statusBar);
    }

    private void creerBindings() {

    }

    private void initialize() {
        statusBar = new StatusBar();
        taquinBoard = new TaquinBoard(taille);
        menuBar = creerBarreDeMenu();
    }

    private MenuBar creerBarreDeMenu() {
        return new MenuBar(creerMenuJeu());
    }

    private Menu creerMenuJeu() {
        Menu menuJeu = new Menu("Jeu");

        MenuItem menuItemNouvellePartie = new MenuItem("Nouvelle Partie");
        menuItemNouvellePartie.setOnAction(event -> actionMenuJeuNouveau());

        MenuItem menuItemQuitter = new MenuItem("Quitter");
        menuItemQuitter.setOnAction(event -> actionMenuJeuQuitter());

        menuJeu.getItems().addAll(menuItemNouvellePartie,menuItemQuitter);

        return menuJeu;
    }

    void setStageAndSetupListeners(Stage stage) {
        stage.setOnCloseRequest(event -> {
            this.actionMenuJeuQuitter();
            event.consume();
        });
    }

    private void afficheDialogFinDePartie() {
        String messageFinDePartie = "";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de partie");
        alert.setContentText(messageFinDePartie);
        alert.showAndWait();
    }


    private void actionMenuJeuQuitter() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Êtes vous certain de vouloir quitter l'application ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    private void actionMenuJeuNouveau() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Êtes vous certain de vouloir créer une nouvelle partie ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            nouvellePartie();
        }
    }

    void nouvellePartie(){
        taquinBoard.nouvellePartie();
        statusBar.nouvellePartie();
    }
}
