module com.example.pt09prak2072028fileio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pt09prak2072028fileio to javafx.fxml;
    exports com.example.pt09prak2072028fileio;
}