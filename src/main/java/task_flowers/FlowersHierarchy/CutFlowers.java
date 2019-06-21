package task_flowers.FlowersHierarchy;

public class CutFlowers extends Flowers {
    private int flowerLength;

    public int getFlowerLength() {
        return flowerLength;
    }

    public void setFlowerLength(int flowerLength) {
        this.flowerLength = flowerLength;
    }

    public CutFlowers(String title, double price, String color, int flowerLength) {
        super(title, price, color);
        this.flowerLength = flowerLength;
    }
}
