module com.mycompany.restaurantordering {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.restaurantordering to javafx.fxml;
    exports com.mycompany.restaurantordering;
}
