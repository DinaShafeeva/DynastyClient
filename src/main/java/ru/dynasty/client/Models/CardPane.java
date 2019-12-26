package ru.dynasty.client.Models;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CardPane extends Pane {
    private Card card;

    public CardPane(Card card) {

        Image img = new Image("src/main/resources/Images/health0.png");
        ImageView imageView = new ImageView();
        imageView.setImage(img);
        Label label1 = new Label("1");
        Label label2 = new Label("1");
        Label label3 = new Label("1");
        getChildren().addAll(imageView,label1,label2,label3);
    }
}
