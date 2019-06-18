package task_flowers;

import java.util.ArrayList;

public class Basket implements Soldable {
    private String name;
    private ArrayList<Soldable> basket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Soldable> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Soldable> basket) {
        this.basket = basket;
    }

    public Basket(String name) {
        this.name = name;
        basket = new ArrayList<Soldable>();
    }

    public void addToBasket(Soldable product, int addAmount) {
        for (int i = 0; i < addAmount; i++) {
            basket.add(product);
        }
    }

    @Override
    public void printCheck() {
        double totalPrice = 0;
        System.out.println("Check for your basket " + this.name);
        for (int i = 0; i < basket.size(); i++) {
            basket.get(i).printCheck();
            totalPrice += basket.get(i).getPrice();
        }
        System.out.println("Total for basket " + this.name + " " + totalPrice + " $");
        System.out.println("Thank you for your purchase!");
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
