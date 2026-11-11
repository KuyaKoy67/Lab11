package com.mycompany.restaurantordering;

import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

public class RestaurantControllerClass {
    
    private final Order order = new Order();
    
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
    void drinkSelected(ActionEvent event) {
        updateOrder();
    }
    
    @FXML
    void waterToggled(ActionEvent event) {
        updateOrder();
    }
    
    @FXML
    void placeButton(ActionEvent event) throws IOException {
        if (!order.isComplete()) {
            new Alert(Alert.AlertType.WARNING, "Please select one entrée and one drink.").showAndWait();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Order Summary");
        stage.setScene(new Scene(loader.load()));
        ((SecondaryController) loader.getController()).setOrder(order);
        stage.show();
        }
    
    @FXML
    void exitMenu(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML
        void clearButton(ActionEvent event) {
        itemsListView.getSelectionModel().clearSelection();
        toggleGroup.selectToggle(null);
        specialRequestTextField.clear();
        freeWaterCheckBox.setSelected(false);
        updateOrder();
    }

    @FXML
        void clearDrinkMenu(ActionEvent event) {
        toggleGroup.selectToggle(null);
        updateOrder();
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
