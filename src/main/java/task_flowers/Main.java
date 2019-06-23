package task_flowers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import task_flowers.Exceptions.EmptyBasketException;
import task_flowers.Exceptions.EmptyBouquetException;
import task_flowers.Exceptions.NotEnoughFlowersInAStorage;
import task_flowers.FlowersHierarchy.Flowers;
import task_flowers.FlowersHierarchy.ImportedFlowers;
import task_flowers.FlowersHierarchy.LocalFlowers;
import task_flowers.FlowersHierarchy.PottedFlowers;
import task_flowers.InterfaceWithImplimentations.Basket;
import task_flowers.InterfaceWithImplimentations.Bouquet;

import java.util.ArrayList;


public class Main {

    public static Logger logger = LogManager.getLogger(Main.class);

    public static ArrayList<Flowers> storageOfFlowers = new ArrayList<Flowers>();

    public static void addToStorage(Flowers flower, int amountToAdd) {
        for (int i = 0; i < amountToAdd; i++) {
            storageOfFlowers.add(flower);
        }
        logger.info("Items were successfully added to storage");
    }

    public static void removeFromStorage(Flowers flower, int amountToRemove) {
        for (int i = 0; i < amountToRemove; i++) {
            storageOfFlowers.remove(flower);
        }
        logger.info("Items were successfully removed from storage");
    }

    private static int amountOfFlowersForABouquet = 0;

    public static int getAmountOfFlowersForABouquet() {
        return amountOfFlowersForABouquet;
    }

    public static void setAmountOfFlowersForABouquet(int a) {
        Main.amountOfFlowersForABouquet = a;
    }

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile", "C:\\Users\\User\\IdeaProjects\\Flowers\\src\\main\\resources\\log4j2.xml");

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

        addToStorage(lilacPurple, 10);
        addToStorage(lilacWhite, 15);
        addToStorage(rose, 5);
        removeFromStorage(rose, 1);
        addToStorage(rose, 2);
        System.out.println("STORAGE:\n_____________________________");
        for (int i = 0; i < storageOfFlowers.size(); i++) {
            System.out.println(storageOfFlowers.get(i).getTitle() + " " + storageOfFlowers.get(i).getColor());
        }
        System.out.println("_____________________________");

        try {
            Bouquet bouquet1 = new Bouquet("lilac");
            bouquet1.addFlower(lilacPurple, 5);
            bouquet1.addFlower(lilacWhite, 4);
            System.out.println("Bouquet price " + bouquet1.getName() + " " + bouquet1.calculateCost() + " $");
            bouquet1.printCheck();

            Bouquet bouquet3 = new Bouquet("roses");
            bouquet3.addFlower(rose, 5);
            System.out.println("Bouquet price " + bouquet3.getName() + " " + bouquet3.calculateCost() + " $");
            bouquet3.printCheck();

            Basket basket1 = new Basket("My 1st basket");
            basket1.addToBasket(potCactus, 2);
            basket1.addToBasket(potOrchid, 1);
            basket1.addToBasket(bouquet3, 1);
            basket1.printCheck();

        } catch (EmptyBouquetException e) {
            System.out.println("EmptyBouquetException");
            System.out.println("Your bouquet is empty! \nPlease add some items to print check.");
        } catch (EmptyBasketException e) {
            System.out.println("EmptyBasketException");
            System.out.println("Your basket is empty! \nPlease add some items to print check.");
        } catch (NotEnoughFlowersInAStorage e) {
            System.out.println("Not enough flowers in a storage. \nWe have just " + amountOfFlowersForABouquet + " flowers");
            System.out.println("Please decrease the amount or choose another items.");
        }
    }
}

