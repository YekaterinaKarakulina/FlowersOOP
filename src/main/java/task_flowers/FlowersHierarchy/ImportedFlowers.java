package task_flowers.FlowersHierarchy;

import task_flowers.FlowersHierarchy.CutFlowers;

public class ImportedFlowers extends CutFlowers {
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ImportedFlowers(String title, double price, String color, int flowerLength, String country) {
        super(title, price, color, flowerLength);
        this.country = country;
    }
}
