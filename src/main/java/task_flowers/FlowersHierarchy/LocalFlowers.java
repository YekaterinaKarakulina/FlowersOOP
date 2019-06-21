package task_flowers.FlowersHierarchy;

import task_flowers.FlowersHierarchy.CutFlowers;

public class LocalFlowers extends CutFlowers {
    private double discountPercent;

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalFlowers(String title, double price, String color, int flowerLength, double discountPercent) {
        super(title, price, color, flowerLength);
        this.discountPercent = discountPercent;
    }
}
