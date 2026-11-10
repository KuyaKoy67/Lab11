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
    
    public static Map<String, Double> getEntreePrices() {
        return ENTREE_PRICES;
    }
 
    public static Map<String, Double> getDrinkPrices() {
        return DRINK_PRICES;
    }
 
    public String getEntree() {
        return entree;
    }
 
    public void setEntree(String entree) {
        this.entree = entree;
    }
 
    public String getDrink() {
        return drink;
    }
 
    public void setDrink(String drink) {
        this.drink = drink;
    }
 
    public String getSpecialRequests() {
        return specialRequests;
    }
 
    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = (specialRequests == null) ? "" : specialRequests;
    }
 
    public boolean isWaterRequested() {
        return waterRequested;
    }
 
    public void setWaterRequested(boolean waterRequested) {
        this.waterRequested = waterRequested;
    }
 
    public double getEntreePrice() {
        return entree == null ? 0.0 : ENTREE_PRICES.getOrDefault(entree, 0.0);
    }
 
    public double getDrinkPrice() {
        return drink == null ? 0.0 : DRINK_PRICES.getOrDefault(drink, 0.0);
    }
 
    public double getTotal() {
        return getEntreePrice() + getDrinkPrice();
    }
 
    public boolean isComplete() {
        return entree != null && drink != null;
    }
 
    public void clear() {
        entree = null;
        drink = null;
        specialRequests = "";
        waterRequested = false;
    }
}

