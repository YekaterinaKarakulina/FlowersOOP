package task_flowers.FlowersHierarchy;

import task_flowers.InterfaceWithImplimentations.Soldable;

public class PottedFlowers extends Flowers implements Soldable {
    private int potDiameter;
    private String potMaterial;
    private String soilType;

    public int getPotDiameter() {
        return potDiameter;
    }

    public void setPotDiameter(int potDiameter) {
        this.potDiameter = potDiameter;
    }

    public String getPotMaterial() {
        return potMaterial;
    }

    public void setPotMaterial(String potMaterial) {
        this.potMaterial = potMaterial;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public PottedFlowers(String title, double price, String color, int potDiameter, String potMaterial, String soilType) {
        super(title, price, color);
        this.potDiameter = potDiameter;
        this.potMaterial = potMaterial;
        this.soilType = soilType;
    }

    public void printCheck() {
        System.out.println("Total for pot flower " + this.getTitle() + " " + this.getPrice() + " $");
    }
}
