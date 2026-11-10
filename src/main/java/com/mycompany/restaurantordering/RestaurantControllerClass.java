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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class RestaurantControllerClass {
    
    private String selectedEntree = "";
    private double entreePrice = 0.0;
    private String slectedDrink = "";
    private double drinkPrice = 0.0;
    private boolean waterRequested = false;
    private String specialRequestsText = "";
    
    @FXML
    public void initialize() {
        itemsListView.setItems(FXCollections.observableArrayList(
        "Chicken Salad ($6.50)",
        "Turkey Sandwich ($6.75)", 
        "Vegetable Wrap ($6.50)", 
        "Grilled Cheese ($5.00)"));
        
        itemsListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                if (newVal.contains("Chicken Salad")) {
                    selectedEntree = "Chicken Salad";
                    entreePrice = 6.50;
                } else if (newVal.contains("Turkey Sandwich")) {
                    selectedEntree = "Turkey Sandwich";
                    entreePrice = 6.75;
                } else if (newVal.contains("Vegetable Wrap")) {
                    selectedEntree = "Vegetable Wrap";
                    entreePrice = 6.50;
                } else if (newVal.contains("Grilled Cheese")) {
                    selectedEntree = "Grilled Cheese";
                    entreePrice = 5.00;
                }
            }
        });
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
