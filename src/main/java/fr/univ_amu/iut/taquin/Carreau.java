package fr.univ_amu.iut.taquin;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class Carreau extends Button {
    private Integer numero;
    private Position position;
    private Position positionVoulue;


    public Carreau(Integer numero, Position location) {
        final int squareSize = TaquinBoard.CELL_SIZE - 13;
        this.numero = numero;
        this.position = location;
        this.positionVoulue = location;

        setMinSize(squareSize, squareSize);
        setMaxSize(squareSize, squareSize);
        setPrefSize(squareSize, squareSize);

        setAlignment(Pos.CENTER);

        setText(numero.toString());
    }

    public Integer getNumero() {
        return numero;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean estBienPlace() {
        return positionVoulue.equals(position);
    }

    @Override
    public String toString() {
        return "Carreau{" + "numero=" + numero + ", position=" + position + '}';
    }
}
