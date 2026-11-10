/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantordering;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author carln
 */
public class Order {
 
    private static final Map<String, Double> ENTREE_PRICES = new LinkedHashMap<>();
    private static final Map<String, Double> DRINK_PRICES = new LinkedHashMap<>();
 
    static {
        ENTREE_PRICES.put("Chicken Salad", 6.50);
        ENTREE_PRICES.put("Turkey Sandwich", 6.75);
        ENTREE_PRICES.put("Vegetable Wrap", 6.00);
        ENTREE_PRICES.put("Grilled Cheese", 5.00);
 
        DRINK_PRICES.put("Coffee", 1.50);
        DRINK_PRICES.put("Tea", 1.50);
        DRINK_PRICES.put("Soda", 2.00);
        DRINK_PRICES.put("Juice", 1.75);
    }
 
    private String entree;
    private String drink;
    private String specialRequests = "";
    private boolean waterRequested;
}

