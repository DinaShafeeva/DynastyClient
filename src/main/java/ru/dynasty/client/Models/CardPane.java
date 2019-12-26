package ru.dynasty.client.Models;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CardPane extends Pane {
    private Card card;

    public CardPane(Card card) {
        Button button = new Button();
        button.setPrefWidth(108);
        button.setPrefHeight(176);
        button.setStyle("-fx-background-color :  000000");
        Image img = new Image("src/main/resources/Images/Cards.png");
        ImageView imageView = new ImageView();
        imageView.setImage(img);
        Label name = new Label("");
        Label power = new Label("Power ");
        Label dif = new Label("Dif ");
        getChildren().addAll(imageView,name, power, dif, button);
    }
}
