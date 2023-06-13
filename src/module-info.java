module workshop_javafx_jdbc {
	requires javafx.controls;
    requires java.net.http;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;   
    requires java.logging;
    requires java.desktop;
	requires java.sql;
	requires mysql.connector.j;
    
	
	
	 
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	
	opens model.entities to javafx.fxml, javafx.base;
	opens model.services to javafx.fxml, javafx.base;
	opens gui to javafx.fxml;	

	
	exports gui to javafx.fxml;
	exports model.entities to javafx.fxml;
	exports model.services to javafx.fxml;
}

