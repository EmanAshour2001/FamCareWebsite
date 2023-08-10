/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carinsurancecontract;

public class CarsInsuranceContract {
    private int horsepower;
    private int carAge;
    private boolean isSportCar;
    private boolean isParkedInGarage;
    private double basicPremium;
    private double discount;
    private double additionalCost;
    private double totalPremium;

    // Constructor
    public CarsInsuranceContract(int horsepower, int carAge, boolean isSportCar, boolean isParkedInGarage) {
        this.horsepower = horsepower;
        this.carAge = carAge;
        this.isSportCar = isSportCar;
        this.isParkedInGarage = isParkedInGarage;
        this.calculatePremiumParts();
        this.calculateTotalPremium();
    }

    // Method to calculate the premium parts
    private void calculatePremiumParts() {
        if (horsepower < 0 || horsepower > 9500) {
        System.out.println("Error: Invalid horsepower value. Horsepower must be between 0 and 9500.");
        basicPremium = 0;
        return;
        }
        if (horsepower >= 1 && horsepower <= 49) {
            basicPremium = 400.0;
        } else if (horsepower >= 50 && horsepower <= 100) {
            basicPremium = 600.0;
        } else {
            basicPremium = 600.0 + 3.80 * (horsepower - 100);
        }
   

        // Additional premium based on car's age for sport cars
        if (isSportCar) {
            if (carAge >= 0 && carAge <= 4) {
                additionalCost = basicPremium * 0.08; // 8% increase for new sport cars
            } else {
                additionalCost = basicPremium * 0.04; // 4% increase for older sport cars
            }
        }

        // Additional premium or discount based on parking location
        if (isParkedInGarage) {
            discount = basicPremium * 0.02; // 2% discount if parked in a garage
        } else {
            additionalCost += basicPremium * 0.08; // 8% increase if parked on the street overnight
        }
    }

    // Method to calculate the total insurance premium
    private void calculateTotalPremium() {
        totalPremium = basicPremium + additionalCost - discount;
    }

    // Method to get the basic premium
    public double getBasicPremium() {
        return basicPremium;
    }

    // Method to get the discount amount
    public double getDiscount() {
        return discount;
    }

    // Method to get the additional cost amount
    public double getAdditionalCost() {
        return additionalCost;
    }

    // Method to get the total insurance premium
    public double getTotalPremium() {
        return totalPremium;
    }

    // Main method to test the CarInsuranceContract class
    public static void main(String[] args) {
        int carHorsepower = 100000;
        int carAge = 10; // Car age in years
        boolean isSportCar = false;
        boolean isParkedInGarage = true;

        CarsInsuranceContract insuranceContract = new CarsInsuranceContract(carHorsepower, carAge, isSportCar, isParkedInGarage);

        System.out.println("Car Horsepower: " + carHorsepower);
        System.out.println("Car Age: " + carAge + " years");
        System.out.println("Is it a Sport Car: " + isSportCar);
        System.out.println("Is it parked in a garage: " + isParkedInGarage);
        System.out.println("Basic Premium: $" + insuranceContract.getBasicPremium());
        System.out.println("Discount: $" + insuranceContract.getDiscount());
        System.out.println("Additional Cost: $" + insuranceContract.getAdditionalCost());
        System.out.println("Total Premium: $" + insuranceContract.getTotalPremium());
    }
}
