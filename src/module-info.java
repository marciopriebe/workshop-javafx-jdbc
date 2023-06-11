module workshop_javafx_jdbc {
	requires javafx.controls;
    requires java.net.http;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;   
    requires java.logging;
    requires java.desktop;
    
	
	
	 
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;	
	exports gui to javafx.fxml;
}

