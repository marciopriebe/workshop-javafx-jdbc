package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartament;
	
	@FXML
	private MenuItem about;
	
	@FXML 
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartamentAction() {
		loadView("/gui/DepartamentList.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction(){
		loadView("/gui/About.fxml");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {				
	}
	
	@SuppressWarnings("unused")
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();	
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBOx = (VBox)((ScrollPane)mainScene.getRoot()).getContent(); 
			
			Node mainMenu  = mainVBOx.getChildren().get(0);
			mainVBOx.getChildren().clear();
			mainVBOx.getChildren().add(mainMenu);
			mainVBOx.getChildren().addAll(newVBox.getChildren());
			
			
		} catch (IOException e) {
				Alerts.showAlert("IO Exception", "Error load view", e.getMessage(), AlertType.ERROR);
		}
	}
}
