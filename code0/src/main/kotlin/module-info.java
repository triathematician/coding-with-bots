module triath.code2 {
    requires javafx.controls;
    requires kotlin.stdlib;
    requires tornadofx;

    opens triath.code0 to javafx.fxml;
    exports triath.code0;
}