module com.desanimados.thesolardungeon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.desanimados.thesolardungeon to javafx.fxml;
    exports com.desanimados.thesolardungeon;
}