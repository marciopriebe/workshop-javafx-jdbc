package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartamentService;
import model.services.SellerService;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartament;
	
	@FXML
	private MenuItem about;
	
	@FXML 
	public void onMenuItemSellerAction() {
		loadView("/gui/SellerList.fxml", (SellerListController controller) -> {
			controller.setSellerService(new SellerService());
			controller.updateTableView();
			
		});
	}
	
	@FXML
	public void onMenuItemDepartamentAction() {
		loadView("/gui/DepartamentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartamentService());
			controller.updateTableView();
			
		});
	}
	
	@FXML
	public void onMenuItemAboutAction(){
		loadView("/gui/About.fxml", x -> {});
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {				
	}
	
	@SuppressWarnings("unused")
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();	
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBOx = (VBox)((ScrollPane)mainScene.getRoot()).getContent(); 
			
			Node mainMenu  = mainVBOx.getChildren().get(0);
			mainVBOx.getChildren().clear();
			mainVBOx.getChildren().add(mainMenu);
			mainVBOx.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
			
			
		} catch (IOException e) {
				Alerts.showAlert("IO Exception", "Error load view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	/*
	 * private synchronized void loadView2(String absoluteName) { try { FXMLLoader
	 * loader = new FXMLLoader(getClass().getResource(absoluteName)); VBox newVBox =
	 * loader.load();
	 * 
	 * Scene mainScene = Main.getMainScene(); VBox mainVBOx =
	 * (VBox)((ScrollPane)mainScene.getRoot()).getContent();
	 * 
	 * Node mainMenu = mainVBOx.getChildren().get(0);
	 * mainVBOx.getChildren().clear(); mainVBOx.getChildren().add(mainMenu);
	 * mainVBOx.getChildren().addAll(newVBox.getChildren());
	 * 
	 * DepartmentListController controller = loader.getController();
	 * controller.setDepartmentService(new DepartamentService());
	 * controller.updateTableView();
	 * 
	 * 
	 * } catch (IOException e) { Alerts.showAlert("IO Exception", "Error load view",
	 * e.getMessage(), AlertType.ERROR); } }
	 */
	
}
