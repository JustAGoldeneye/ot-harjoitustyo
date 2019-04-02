
package testiprojekti;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Testiprojekti extends Application {

    public static void main(String[] args) {
        launch(Testiprojekti.class);
    }

    @Override
    public void start(Stage stage) {
        Label text = new Label("saddsja");
        StackPane posit = new StackPane();
        posit.setPrefSize(200, 200);
        posit.getChildren().add(text);
        posit.setAlignment(Pos.CENTER);
        stage.setTitle("hdksa");
        Scene scene = new Scene(posit);
        stage.setScene(scene);
        stage.show();
    }
    
}
