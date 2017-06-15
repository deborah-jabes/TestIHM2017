package fr.univ_amu.iut.taquin;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class Carreau extends Button {
    private Integer value;
    private Location location;


    public Carreau(Integer value, Location location) {
        final int squareSize = TaquinBoard.CELL_SIZE - 13;
        this.value = value;
        this.location = location;

        setMinSize(squareSize, squareSize);
        setMaxSize(squareSize, squareSize);
        setPrefSize(squareSize, squareSize);

        setAlignment(Pos.CENTER);

        setText(value.toString());
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

    @Override
    public String toString() {
        return "Tile{" + "value=" + value + ", location=" + location + '}';
    }
}