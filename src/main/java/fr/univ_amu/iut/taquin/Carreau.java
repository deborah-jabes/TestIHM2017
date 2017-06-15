package fr.univ_amu.iut.taquin;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Carreau extends Button {
    private Integer value;
    private Location location;
    private Location locationAttendue;


    public Carreau(Integer value, Location location) {
        final int squareSize = TaquinBoard.CELL_SIZE - 13;
        this.value = value;
        this.location = location;
        this.locationAttendue = location;

        setMinSize(squareSize, squareSize);
        setMaxSize(squareSize, squareSize);
        setPrefSize(squareSize, squareSize);

        setAlignment(Pos.CENTER);

        setText(value.toString());
        setFont(Font.font("Monospace", FontWeight.BOLD, 20));
    }

    public Integer getValue() {
        return value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean estBienPlace() {
        return locationAttendue.equals(location);
    }

    @Override
    public String toString() {
        return "Carreau{" + "value=" + value + ", location=" + location + '}';
    }
}
