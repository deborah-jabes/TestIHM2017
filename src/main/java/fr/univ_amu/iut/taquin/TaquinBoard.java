package fr.univ_amu.iut.taquin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaquinBoard extends GridPane {

    public static final int CELL_SIZE = 100;
    private List<Carreau> carreaux;
    private int taille;

    private Carreau carreauVide;

    private BooleanProperty estPartieTerminee;

    private IntegerProperty nombreDeMouvement;

    private final EventHandler<ActionEvent> ecouteurDeCarreau = event -> {
        Carreau carreau = (Carreau) event.getSource();
        System.out.println("Déplacement de "+ carreau);
        deplacer(carreau);
        verifierFinDePartie();
    };

    public TaquinBoard(int taille) {
        this.taille = taille;
        estPartieTerminee = new SimpleBooleanProperty(false);
        nombreDeMouvement = new SimpleIntegerProperty(0);
        carreaux = new ArrayList<>(taille*taille);
        initCarreaux();
    }

    public BooleanProperty estPartieTermineeProperty() {
        return estPartieTerminee;
    }

    private void initCarreaux() {
        int numeroCarreau = 0;
        for (int row = 0; row < taille; row++) {
            for (int col = 0; col < taille; col++) {
                Carreau carreau = new Carreau(++numeroCarreau, new Position(col,row));
                this.add(carreau, col, row);
                carreau.setOnAction(ecouteurDeCarreau);
                carreaux.add(carreau);
            }
        }

        initCarreauVide();
    }

    private void initCarreauVide() {
        carreauVide = carreaux.get(taille*taille-1);
        carreauVide.setText("");
        carreauVide.setDisable(true);
    }

    void nouvellePartie() {
        melanger();
        estPartieTerminee.set(false);
        nombreDeMouvement.set(0);
    }

    private void deplacer(Carreau carreau){
        Position locationCarreau = carreau.getPosition();
        Position locationVide = carreauVide.getPosition();

        for(Direction direction : Direction.values()){
            Position locationAdjacente = locationCarreau.offset(direction);

            if(estDeplacementPossible(locationAdjacente, locationVide)){
                permuter(carreau, carreauVide);
            }
        }
    }

    private boolean estDeplacementPossible(Position locationAdjacente, Position locationVide) {
        return locationAdjacente.estValidePour(taille) && locationAdjacente.equals(locationVide);
    }

    private void permuter(Carreau carreau1, Carreau carreau2) {
        Position location1 = carreau1.getPosition();
        Position location2 = carreau2.getPosition();

        deplacer(carreau1, location2);
        deplacer(carreau2, location1);

        nombreDeMouvement.set(nombreDeMouvement.get() + 1);
    }

    private void verifierFinDePartie() {
        boolean estDansLOrdre = true;
        for (Carreau carreau : carreaux) {
            if (!carreau.estBienPlace())
                estDansLOrdre = false;
        }

        estPartieTerminee.set(estDansLOrdre);
    }

    private void deplacer(Carreau carreau, Position location) {
        System.out.println(carreau + " se déplace en "+location);
        carreau.setPosition(location);
        placer(carreau);
    }

    private void placer(Carreau carreau){
        GridPane.setConstraints(carreau, carreau.getPosition().getX(), carreau.getPosition().getY());
    }

    private void melanger() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < taille * taille * 100; i++) {
            int indiceAleatoire = random.nextInt(taille * taille);
            deplacer(carreaux.get(indiceAleatoire));
        }
    }

    public int getNombreDeMouvement() {
        return nombreDeMouvement.get();
    }

    public IntegerProperty nombreDeMouvementProperty() {
        return nombreDeMouvement;
    }
}
