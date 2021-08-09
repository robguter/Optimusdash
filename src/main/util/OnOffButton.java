package main.util;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class OnOffButton extends StackPane {
    private final Rectangle back = new Rectangle(40, 20, Color.RED);
    private final Button button = new Button();
    private String buttonStylOff = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 0.2, 0.0, 0.0, 2); -fx-background-color:   WHITE; -fx-cursor: hand";
    private String buttonStyleOn = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 0.2, 0.0, 0.0, 2); -fx-cursor: hand";
    private String bckStyle = "-fx-cursor: hand";
    private boolean state;

    private void init() {
        getChildren().addAll(back, button);
        setMinSize(40, 20);
        setMaxSize(40, 20);

        back.maxWidth(40);
        back.prefWidth(40);
        back.minWidth(40);

        back.maxHeight(20);
        back.minHeight(20);

        back.setArcHeight(back.getHeight());
        back.setArcWidth(back.getHeight());
        back.setFill(Color.valueOf("rgba(127,127,127,.5)"));
        back.setStroke(Color.valueOf("#FeF5Fa"));
        back.setStrokeWidth(1);
        back.setStyle(bckStyle);
        setAlignment(back, Pos.CENTER_LEFT);

        Double r = 2.0;
        button.setShape(new Circle(r));
        setAlignment(button, Pos.CENTER_LEFT);
        button.setMaxSize(18, 18);
        button.setMinSize(18, 18);
        button.setStyle(buttonStylOff);
        int i = 0;
        button.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY.DEFAULT)));
    }

    public OnOffButton() {
        init();
        EventHandler<Event> click = new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (state) {
                    button.setStyle(buttonStylOff);
                    back.setFill(Color.valueOf("rgba(127,127,127,.5)"));
                    setAlignment(button, Pos.CENTER_LEFT);
                    state = false;
                } else {
                    button.setStyle(buttonStyleOn);
                    back.setFill(Color.valueOf("rgba(0,127,127,1)"));
                    setAlignment(button, Pos.CENTER_RIGHT);
                    state = true;
                }
            }
        };

        button.setFocusTraversable(false);
        setOnMouseClicked(click);
        button.setOnMouseClicked(click);
    }

}