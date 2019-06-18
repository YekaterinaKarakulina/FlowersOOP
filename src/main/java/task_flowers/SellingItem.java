package task_flowers;

public abstract class SellingItem {
    private String title;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SellingItem(String title, double price) {
        this.title = title;
        this.price = price;
    }
}
