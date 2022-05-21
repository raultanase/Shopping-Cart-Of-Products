public class Cart {
    String name;
    double price;
    int quantity;
    double shipping;

    public Cart(String name, double price, int quantity, double shipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shipping = shipping;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
}
