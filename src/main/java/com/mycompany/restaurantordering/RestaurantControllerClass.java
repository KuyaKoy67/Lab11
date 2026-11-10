package com.mycompany.restaurantordering;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class RestaurantControllerClass {
    
    private final Order order = new Order();
    
    private String selectedEntree = "";
    private double entreePrice = 0.0;
    private String slectedDrink = "";
    private double drinkPrice = 0.0;
    private boolean waterRequested = false;
    private String specialRequestsText = "";
    
    @FXML
    public void initialize() {
        itemsListView.setItems(FXCollections.observableArrayList(Order.getEntreePrices().keySet()));
        itemsListView.getSelectionModel().selectedItemProperty().addListener((obs, o, n) -> updateOrder());
        specialRequestTextField.textProperty().addListener((obs, o, n) -> updateOrder());
    }
 
    @FXML
    void updateOrder() {
        order.setEntree(itemsListView.getSelectionModel().getSelectedItem());
 
        Toggle drink = toggleGroup.getSelectedToggle();
        order.setDrink(drink == null ? null : ((RadioButton) drink).getText());
 
        order.setWaterRequested(freeWaterCheckBox.isSelected());
        order.setSpecialRequests(specialRequestTextField.getText());
 
        currentOrderLabel.setText("Current Order: "
                + (order.getEntree() == null ? "-" : order.getEntree()) + ", "
                + (order.getDrink() == null ? "-" : order.getDrink()));
        totalLabel.setText(String.format("Total: $%.2f", order.getTotal()));
    }
    
    @FXML
    private Button clearOrderButton;
 
    @FXML
    private RadioButton coffeeRadioButton;
 
    @FXML
    private Label currentOrderLabel;
 
    @FXML
    private CheckBox freeWaterCheckBox;
 
    @FXML
    private ListView<String> itemsListView;
 
    @FXML
    private RadioButton juiceRadioButton;
 
    @FXML
    private Button placeOrderButton;
 
    @FXML
    private RadioButton sodaRadioButton;
 
    @FXML
    private TextField specialRequestTextField;
 
    @FXML
    private RadioButton teaRadioButton;
 
    @FXML
    private ToggleGroup toggleGroup;
 
    @FXML
    private Label totalLabel;
 
    @FXML
    private Pane pane;

    
    @FXML
    void exitMenu(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML
    void clearEntreeMenu(ActionEvent event) {
        itemsListView.getSelectionModel().clearSelection();
    }
    
    @FXML
    void clearSpecialRequestMenu(ActionEvent event) {
        specialRequestTextField.clear();
    }
    
    @FXML
    void aboutMenu(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Restaurant Ordering Application");
        alert.setContentText("Version: 1.0\nDeveloper: Your Name");
        alert.showAndWait();
    }
}
