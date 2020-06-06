package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent fxml = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Database Inspector");
        Scene scene = new Scene(fxml);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }
    public static void main(String[] args) {
        launch(args);
    }
}
