package task_flowers;

import java.util.ArrayList;

public class Bouquet implements Soldable {
    private String name;
    private ArrayList<Flowers> list;
    private boolean discountTF;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Flowers> getList() {
        return list;
    }

    public void setList(ArrayList<Flowers> list) {
        this.list = list;
    }

    public boolean isDiscountTF() {
        return discountTF;
    }

    public void setDiscountTF(boolean discountTF) {
        this.discountTF = discountTF;
    }

    public Bouquet(String name) {
        this.name = name;
        list = new ArrayList<Flowers>();
    }

    public double calculateCost() {
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            double discount = 0;
            double discountSum = 0;
            if (list.get(i) instanceof LocalFlowers) {
                discount = (((LocalFlowers) list.get(i)).getDiscountPercent());
                discountSum = list.get(i).getPrice() * discount / 100;
            }
            total += list.get(i).getPrice() - discountSum;
            if (discountSum != 0) {
                discountTF = true;
            }
        }
        return total;
    }

    public void addFlower(Flowers flower, int addAmount) {
        for (int i = 0; i < addAmount; i++) {
            list.add(flower);
        }
    }

    public void removeFlower(Flowers flower, int removeAmount) {
        for (int i = 0; i < removeAmount; i++) {
            list.remove(flower);
        }
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    @Override
    public void printCheck() {
        System.out.println("Check for bouquet " + this.name);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Flower " + list.get(i).getTitle() + " " + list.get(i).getColor() + " " + list.get(i).getPrice() + " $");
        }
        System.out.println("________________________\n");
        if (discountTF == true) {
            System.out.println("Local flowers included discount");
        }
        System.out.println("Total for bouquet " + this.calculateCost() + " $");
    }

    public double getPrice() {
        double totalBasket = 0;
        for (int i = 0; i < list.size(); i++) {
            double discount = 0;
            double discountSum = 0;
            if (list.get(i) instanceof LocalFlowers) {
                discount = (((LocalFlowers) list.get(i)).getDiscountPercent());
                discountSum = list.get(i).getPrice() * discount / 100;
            }
            totalBasket += list.get(i).getPrice() - discountSum;
        }
        return totalBasket;
    }
}

