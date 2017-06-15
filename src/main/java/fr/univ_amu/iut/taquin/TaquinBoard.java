package fr.univ_amu.iut.taquin;

import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class TaquinBoard extends GridPane {
    public static final int CELL_SIZE = 100;
    private List<Carreau> carreaux;
    private int taille;
    private Carreau carreauVide;

    private BooleanProperty estPartieTerminee;

    private final EventHandler<ActionEvent> ecouteurDeCarreau = event -> {
        Carreau carreau = (Carreau) event.getSource();
        System.out.println("Déplacement de "+ carreau);
        deplacer(carreau);
    };

    public TaquinBoard(int taille) {
        this.taille = taille;
        carreaux = new ArrayList<>(taille*taille);
        initCarreaux();
        creerBindings();
    }

    private void creerBindings() {

    }

    private void initCarreaux() {
        int numeroCarreau = 0;
        for (int row = 0; row < taille; row++) {
            for (int col = 0; col < taille; col++) {
                Carreau carreau = new Carreau(++numeroCarreau, new Location(col,row));
                this.add(carreau, col, row);
                carreau.setOnAction(ecouteurDeCarreau);
                carreaux.add(carreau);
            }
        }

        carreauVide = carreaux.get(taille*taille-1);
        carreauVide.setText("");
    }

    void nouvellePartie() {
        initCarreaux();
        melanger();
    }

    private void deplacer(Carreau carreau){
        Location locationCarreau = carreau.getLocation();
        Location locationVide = carreauVide.getLocation();

        for(Direction direction : Direction.values()){
            Location locationAdjacente = locationCarreau.offset(direction);

            if(estDeplacementPossible(locationAdjacente, locationVide)){
                permuter(carreau, carreauVide);
            }
        }
    }

    private boolean estDeplacementPossible(Location locationAdjacente, Location locationVide) {
        return locationAdjacente.isValidFor(taille) && locationAdjacente.equals(locationVide);
    }

    private void permuter(Carreau carreau1, Carreau carreau2) {
        Location location1 = carreau1.getLocation();
        Location location2 = carreau2.getLocation();

        deplacer(carreau1, location2);
        deplacer(carreau2, location1);
    }

    private void deplacer(Carreau carreau, Location location) {
        System.out.println(carreau + " se déplace en "+location);
        carreau.setLocation(location);
        placer(carreau);
    }

    private void placer(Carreau carreau){
        GridPane.setConstraints(carreau, carreau.getLocation().getX(), carreau.getLocation().getY());
    }

    private void melanger() {
    }
}
