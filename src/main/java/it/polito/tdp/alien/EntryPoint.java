package it.polito.tdp.alien;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.dizionario.model.Dictionary;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	FXMLLoader loader = new FXMLLoader(EntryPoint.class.getResource("/fxml/Scene.fxml"));
    	Parent root = loader.load();
    	
    	
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        /*scene.getStylesheets().add("/styles/Styles.css");
        scene.getRoot().setStyle("-fx-font-family: 'serif'");*/
        
        Dictionary model = new Dictionary();
        FXMLController controller = loader.getController();
        controller.setModel(model);

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}