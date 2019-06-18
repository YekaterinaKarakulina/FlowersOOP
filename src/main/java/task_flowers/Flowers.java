package task_flowers;

public class Flowers extends SellingItem {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Flowers(String title, double price, String color) {
        super(title, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "title='" + super.getTitle() + '\'' +
                ", price=" + super.getPrice() +
                ", color='" + color + '\'' +
                '}';
    }


}
