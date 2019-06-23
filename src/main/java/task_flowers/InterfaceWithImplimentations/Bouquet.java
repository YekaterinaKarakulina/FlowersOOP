package task_flowers.InterfaceWithImplimentations;

import task_flowers.Exceptions.EmptyBouquetException;
import task_flowers.Exceptions.NotEnoughFlowersInAStorage;
import task_flowers.FlowersHierarchy.Flowers;
import task_flowers.FlowersHierarchy.LocalFlowers;

import java.util.ArrayList;

import static task_flowers.Main.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Bouquet implements Soldable {

    Logger loggerForBouquet = LogManager.getLogger(Bouquet.class);

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
        if (total > 0) {
            loggerForBouquet.debug("Debug message: total of bouquet calculated");
        }
        return total;
    }

    public void addFlower(Flowers flower, int addAmount) throws NotEnoughFlowersInAStorage {
        setAmountOfFlowersForABouquet(0);
        for (int i = 0; i < addAmount; i++) {
            list.add(flower);
            if (storageOfFlowers.contains(flower)) {
                setAmountOfFlowersForABouquet(getAmountOfFlowersForABouquet() + 1);
                storageOfFlowers.remove(flower);
            } else {
                loggerForBouquet.error("NotEnoughFlowersInAStorage");
                throw new NotEnoughFlowersInAStorage();
            }
        }
    }

    public void removeFlower(Flowers flower, int removeAmount) {
        for (int i = 0; i < removeAmount; i++) {
            list.remove(flower);
            storageOfFlowers.add(flower);
        }
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public void printCheck() throws EmptyBouquetException {
        if (list.isEmpty()) {
            loggerForBouquet.error("EmptyBouquetException");
            throw new EmptyBouquetException();
        }
        System.out.println("Check for bouquet " + this.name);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Flower " + list.get(i).getTitle() + " " + list.get(i).getColor() + " " + list.get(i).getPrice() + " $");
        }
        loggerForBouquet.info("Bouquet successfully assembled");
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

