public class Products {
    private String name;
    private double price;
    private String shippedFrom;
    private double weight;

    public Products(String name, double price, String shippedFrom, double weight) {
        this.name = name;
        this.price = price;
        this.shippedFrom = shippedFrom;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShippedFrom() {
        return shippedFrom;
    }

    public void setShippedFrom(String shippedFrom) {
        this.shippedFrom = shippedFrom;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
