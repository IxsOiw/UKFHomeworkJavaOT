module com.example.ukfhomeworkjavaot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ukfhomeworkjavaot to javafx.fxml;
    exports com.example.ukfhomeworkjavaot;
}