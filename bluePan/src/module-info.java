module bluePan {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;
	
	exports packageController;
	exports packageModel;
	exports packageControler;
	
	opens packageController to javafx.fxml;
	opens packageModel to javafx.fxml;
	opens packageControler to javafx.fxml;
	
	
	
	opens application to javafx.graphics, javafx.fxml;
}
