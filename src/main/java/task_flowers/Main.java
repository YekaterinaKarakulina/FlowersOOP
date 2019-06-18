package task_flowers;

import java.util.ArrayList;

public class Main {
    static ArrayList<Flowers> storageOfFlowers = new ArrayList<Flowers>();

    public static void addToStorage(Flowers flower, int amountToAdd) {
        for (int i = 0; i < amountToAdd; i++) {
            storageOfFlowers.add(flower);
        }
    }

    public static void removeFromStorage(Flowers flower, int amountToRemove) {
        for (int i = 0; i < amountToRemove; i++) {
            storageOfFlowers.remove(flower);
        }
    }

    public static void main(String[] args) throws Exception {

        ImportedFlowers peony = new ImportedFlowers("peony", 5, "pink", 45, "Canada");
        ImportedFlowers rose = new ImportedFlowers("rose", 4, "white", 55, "Holland");
        ImportedFlowers tulip = new ImportedFlowers("tulip", 3, "yellow", 35, "Holland");
        ImportedFlowers gerberaOrange = new ImportedFlowers("gerbera", 3.5, "orange", 45, "US");
        ImportedFlowers gerberaRed = new ImportedFlowers("gerbera", 3.5, "red", 45, "US");
        ImportedFlowers gerberaYellow = new ImportedFlowers("gerbera", 3.5, "yellow", 45, "US");
        ImportedFlowers gerberaPink = new ImportedFlowers("gerbera", 3.5, "pink", 45, "US");
        ImportedFlowers orchidWhite = new ImportedFlowers("orchid", 6, "while", 35, "Thailand");
        ImportedFlowers orchidPink = new ImportedFlowers("orhid", 6, "pink", 35, "Thailand");
        ImportedFlowers calla = new ImportedFlowers("calla", 5, "white", 30, "Holland");

        LocalFlowers chamomile = new LocalFlowers("chamomile", 2, "white", 50, 5);
        LocalFlowers lily = new LocalFlowers("lily", 2.5, "pink", 50, 3);
        LocalFlowers gladioleViolet = new LocalFlowers("gladiole", 3.5, "violet", 55, 4);
        LocalFlowers gladioleWhite = new LocalFlowers("gladiole", 3.5, "white", 55, 4);
        LocalFlowers dladioleRed = new LocalFlowers("gladiole", 3.5, "red", 55, 4);
        LocalFlowers lilacPurple = new LocalFlowers("lilac", 2, "purple", 30, 5);
        LocalFlowers lilacWhite = new LocalFlowers("lilac", 2, "white", 30, 5);
        LocalFlowers chrysanthemumBurgundy = new LocalFlowers("chrysanthemum", 2.5, "burgundy", 35, 5);
        LocalFlowers chrysantemumWhite = new LocalFlowers("chrysanthemum", 2.5, "white", 35, 5);
        LocalFlowers iris = new LocalFlowers("iris", 4, "yellow", 30, 4.5);

        PottedFlowers potOrchid = new PottedFlowers("orchid", 8, "white", 12, "glass", "moss");
        PottedFlowers potPatio = new PottedFlowers("patio", 7, "pink", 15, "plastic", "transportSubstrate");
        PottedFlowers potCactus = new PottedFlowers("cactus", 4, "green", 8, "plastic", "transportSubstrate");
        PottedFlowers potViolet = new PottedFlowers("violet", 5.5, "violet", 10, "plastic", "blackSoil");
        PottedFlowers potGeranium = new PottedFlowers("geranium", 3.5, "red", 12, "peatCup", "peat");

        addToStorage(new ImportedFlowers("rose", 4.5, "pink", 60, "US"), 1);
        addToStorage(tulip, 2);
        System.out.println(storageOfFlowers.toString());
        removeFromStorage(tulip, 1);
        System.out.println(storageOfFlowers.toString());
        addToStorage(lily, 2);
        System.out.println(storageOfFlowers.toString());

        Bouquet bouquet1 = new Bouquet("gerberasForMe");
        bouquet1.addFlower(gerberaOrange, 4);
        bouquet1.addFlower(gerberaPink, 4);
        bouquet1.addFlower(gerberaRed, 3);
        bouquet1.addFlower(gerberaYellow, 4);
        System.out.println("Bouquet price " + bouquet1.getName() + " " + bouquet1.calculateCost() + " $");
        bouquet1.removeFlower(gerberaYellow, 4);
        bouquet1.removeFlower(gerberaPink, 2);
        bouquet1.removeFlower(gerberaRed, 1);
        bouquet1.removeFlower(gerberaOrange, 1);
        System.out.println("Bouquet price " + bouquet1.getName() + " " + bouquet1.calculateCost() + " $");
        bouquet1.printCheck();

        Bouquet bouquet2 = new Bouquet("lilac");
        bouquet2.addFlower(lilacPurple, 5);
        bouquet2.addFlower(lilacWhite, 4);
        System.out.println("Bouquet price " + bouquet2.getName() + " " + bouquet2.calculateCost() + " $");
        bouquet2.printCheck();

        Basket basket1 = new Basket("My 1st basket");
        basket1.addToBasket(potCactus, 2);
        basket1.addToBasket(potOrchid, 1);
        basket1.addToBasket(bouquet2, 1);
        basket1.printCheck();
    }
}
