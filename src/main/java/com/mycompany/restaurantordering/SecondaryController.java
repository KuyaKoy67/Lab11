package com.mycompany.restaurantordering;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
public class SecondaryController {
 
    @FXML
    private Label drinkLabel;
 
    @FXML
    private Label drinkPrice;
 
    @FXML
    private Label entreeLabel;
 
    @FXML
    private Label entreePrice;
 
    @FXML
    private Label totalPrice;
 
    @FXML
    private Label waterLabel;
 
    @FXML
    private Label requestsLabel;
 
    @FXML
    private Button closeButton;
 
    public void setOrder(Order order) {
        entreeLabel.setText(order.getEntree());
        entreePrice.setText(String.format("$%.2f", order.getEntreePrice()));
        drinkLabel.setText(order.getDrink());
        drinkPrice.setText(String.format("$%.2f", order.getDrinkPrice()));
        waterLabel.setText(order.isWaterRequested() ? "Yes" : "No");
 
        String requests = order.getSpecialRequests().trim();
        requestsLabel.setText(requests.isEmpty() ? "None" : requests);
 
        totalPrice.setText(String.format("$%.2f", order.getTotal()));
    }
 
    @FXML
    void closeButton(ActionEvent event) {
        ((Stage) closeButton.getScene().getWindow()).close();
    }
}
