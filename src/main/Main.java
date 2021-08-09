package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("vistas/main.fxml"));
        primaryStage.setTitle("Panel de Control del Planificador");
        primaryStage.setScene(new Scene(root));

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            CloseWindow();
        });

        primaryStage.show();
    }

    private void CloseWindow() {
        String sTit = "Confirme su respuesta";
        String sMsj = "Realmente desea salir?";
        boolean Resp = app.util.ConfirmBox.display(sTit,sMsj);
        if (Resp) {
            System.exit(0);
        }
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
