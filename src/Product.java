
public class Product {

    public double price;
    public double promoPrice;
    public int stability;
    public int length;
    public double newPrice;

    public Product(double price, double promoPrice, int stability, int length) {
        this.price = price;
        this.promoPrice = promoPrice;
        this.stability = stability;
        this.length = length;
        this.newPrice = promoPrice;
    }

    public void increasePrice(double amount) {
        newPrice += amount;
    }

    public void reducePrice(double amount) {
        promoPrice -= amount;
        newPrice = promoPrice;
    }
}
