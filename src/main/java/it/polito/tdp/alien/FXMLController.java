package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.naming.NameNotFoundException;

import it.polito.tdp.dizionario.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FXMLController {

	private Dictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtWords;

    @FXML
    void doClear(ActionEvent event) {
    	this.txtResult.clear();
    	this.txtWords.clear();
    	this.model.pulisciDizionario();
    }

    @FXML
    void doTranslate(ActionEvent event) throws NameNotFoundException {
    	 this.txtResult.setText(model.traduci(this.txtWords.getText()));    	
    }

    @FXML
    void initialize() {
    	assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWords != null : "fx:id=\"txtWords\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dictionary model) {
		this.model = model;
	}
    
    

}
