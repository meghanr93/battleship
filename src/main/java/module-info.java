module ryan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens ryan.battleship to javafx.fxml;
    exports ryan.battleship;
}