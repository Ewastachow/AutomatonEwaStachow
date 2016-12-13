package automaton.gui;/**
 * Created by EwaStachów on 05/12/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by EwaStachów on 10/12/2016.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Parent root = FXMLLoader.load(getClass().getResource("automatonGUI.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 1200, 600));
//        primaryStage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("automatonGUI.fxml"));

        Pane pane = loader.load();

        AutomatonGUIController controller = loader.getController();

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();


//        Parent parent = FXMLLoader.load(getClass().getResource("automatonGUI.fxml"));
//
//        primaryStage.setTitle("Tu bd tytuł");
//        primaryStage.setScene(new Scene(parent));
//        primaryStage.show();


//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("automatonGUI.fxml"));
//        StackPane stackPane = loader.load();
//
////        StackPaneController controller = new StackPaneController();
////        loader.setController(controller);
//
//        AutomatonGUIController controller = loader.getController();
//
//        Scene scene = new Scene(stackPane);
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Automaty Komórkowe");
//        primaryStage.show();


//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(this.getClass().getResource("automatonGUI.fxml"));
//
//        AutomatonGUIController controller = loader.getController();
//
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(, 1200, 600));
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
