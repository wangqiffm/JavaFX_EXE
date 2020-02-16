package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

        ObservableList<Screen> screens = Screen.getScreens();//Get list of Screens
        Button btn = new Button();
        btn.setText("Full Screen - Screen 1");
        btn.setOnAction((ActionEvent event) -> {
            Rectangle2D bounds = screens.get(0).getVisualBounds();
            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setFullScreen(true);
            //primaryStage.setWidth(bounds.getWidth());
            //primaryStage.setHeight(bounds.getHeight());
        });

        Button btn2 = new Button();
        btn2.setText("Full Screen - Screen 2");
        btn2.setOnAction((ActionEvent event) -> {
            if (screens.size() > 0) {
                Rectangle2D bounds = screens.get(1).getVisualBounds();
                primaryStage.setX(bounds.getMinX());
                primaryStage.setY(bounds.getMinY());
                primaryStage.setFullScreen(true);
                //primaryStage.setWidth(bounds.getWidth());
                //primaryStage.setHeight(bounds.getHeight());
            }
        });

//        StackPane root = new StackPane();
        root.addRow(1,new HBox(btn, btn2));

//        Scene scene = new Scene(root, 300, 250);
//
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
