package fr.univ_amu.iut.taquin;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Carreau extends Button {
    private Integer numero;
    private Position position;
    private Position positionVoulue;


    public Carreau(Integer numero, Position position) {
        final int squareSize = TaquinBoard.CELL_SIZE;
        this.numero = numero;
        this.position = position;
        this.positionVoulue = position;

        setMinSize(squareSize, squareSize);
        setMaxSize(squareSize, squareSize);
        setPrefSize(squareSize, squareSize);

        setAlignment(Pos.CENTER);

        setText(numero.toString());
        setFont(Font.font("Monospace", FontWeight.BOLD, 20));
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
