module com.egcmusicapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    requires junit;
    
    opens com.egcmusicapp to javafx.fxml;
    exports com.egcmusicapp;

    opens com.model to javafx.fxml;
    exports com.model;
}
