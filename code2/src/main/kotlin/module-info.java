module triath.code2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    opens triath.code2 to javafx.fxml;
    exports triath.code2;
}