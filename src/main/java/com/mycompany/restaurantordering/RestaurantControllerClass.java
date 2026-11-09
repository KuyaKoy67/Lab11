package com.mycompany.restaurantordering;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class RestaurantControllerClass {

    @FXML
    private Button clearOrderButton;

    @FXML
    private RadioButton coffeeRadioButton;

    @FXML
    private Label currentOrderLabel;

    @FXML
    private CheckBox freeWaterCheckBox;

    @FXML
    private ListView<?> itemsListView;

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
    void clearButton(ActionEvent event) {
        specialRequestTextField.clear();
        itemsListView.getItems().clear();
        toggleGroup.selectToggle(null);
        totalLabel.setText("Total: $0.00");
        freeWaterCheckBox.setSelected(false);
    }
    
    @FXML
    void placeButton(ActionEvent event) {
        System.out.println("Order has been placed!");
    }
}

