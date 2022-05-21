import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static List<Products> productsList = new ArrayList<>();
    public static List<ShippingRate> shippingRate = new ArrayList<>();
    public static List<Cart> cart = new ArrayList<>();
    public static void main(String[] args) {
        ShippingRate s1 = new ShippingRate("RO", 1);
        ShippingRate s2 = new ShippingRate("UK", 2);
        ShippingRate s3 = new ShippingRate("US", 3);
        shippingRate.add(s1);
        shippingRate.add(s2);
        shippingRate.add(s3);
        Products p1 = new Products("Mouse", 10.99, "RO", 0.2);
        Products p2 = new Products("Keyboard", 40.99, "UK", 0.7);
        Products p3 = new Products("Monitor", 164.99, "US", 1.9);
        Products p4 = new Products("Webcam", 84.99, "RO", 0.2);
        Products p5 = new Products("Headphones", 59.99, "US", 0.6);
        Products p6 = new Products("Desk Lamp", 89.99, "UK", 1.3);
        productsList.add(p1);
        productsList.add(p2);
        productsList.add(p3);
        productsList.add(p4);
        productsList.add(p5);
        productsList.add(p6);
        for(int i = 0; i < productsList.size(); i++)
            System.out.println(productsList.get(i).getName() + " - $" + productsList.get(i).getPrice());

        int selected;
        do {
            selected = Menu();
            switch (selected) {
                case 1:
                    AddToCart();
                    break;
                case 2:
                    ShowProductsList();
                    break;
                case 3:
                    Invoice();
                    break;
                default:
                    break;
            }
        } while(selected != 3);
    }

    private static void ShowProductsList() {
        for(int i = 0; i < productsList.size(); i++)
            System.out.println(productsList.get(i).getName() + " - $" + productsList.get(i).getPrice());
    }
    private static void Invoice() {
        double subTotal = 0, shipping = 0, total = 0;

        System.out.println("********** Shopping cart contents **********");
        for(int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getName() + " x " + cart.get(i).getQuantity());
            subTotal += (cart.get(i).getPrice() * cart.get(i).getQuantity());
        }

        for(int i = 0; i < productsList.size(); i++) {
            for(int j = 0; j < cart.size(); j++) {
                if(productsList.get(i).getName().equals(cart.get(j).getName())) {
                    String shippedFrom = productsList.get(i).getShippedFrom();
                    for(int k = 0; k < shippingRate.size(); k++) {
                        if (shippedFrom.equals(shippingRate.get(k).getCountry())) {
                            shipping += ((shippingRate.get(k).getRate() * productsList.get(i).getWeight() ) / 0.1) * cart.get(j).getQuantity();
                        }
                    }
                }
            }
        }

        System.out.println("********** Invoice **********");
        System.out.println("Subtotal: $" + subTotal);
        System.out.println(("Shipping: $" + Math.round(shipping)));
        total = GetTotal(subTotal, shipping);
        System.out.println("Total: $" + total);
    }
    public static double GetTotal(double subTot, double shipping) {
        double tot = 0;
        tot += subTot + shipping;

        return tot;
    }
    private static void AddToCart() {
        System.out.print("Enter product name: ");
        Scanner sc = new Scanner(System.in);
        String selectedProduct = sc.nextLine();

        for(int i = 0; i < productsList.size(); i++) {
            if(productsList.get(i).getName().equals(selectedProduct)) {
                cart.add(new Cart(productsList.get(i).getName(), productsList.get(i).getPrice(), 1, productsList.get(i).getWeight()));
            }
        }

        int qt;
        for(int i = 0; i < cart.size() - 1; i++) {
            for(int j = i + 1; j < cart.size(); j++) {
                if(cart.get(i).getName().equals(cart.get(j).getName())) {
                    qt = cart.get(i).getQuantity();
                    cart.get(i).setQuantity(++qt);
                    cart.remove(j);
                }
            }
        }

        System.out.println("********** Your cart is **********");
        for(int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getName() + " x " + cart.get(i).getQuantity());
        }
    }

    private static int Menu() {
            int selection;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Select your option:");
            System.out.println("1 - Add to cart");
            System.out.println("2 - Show catalog of products");
            System.out.println("3 - Invoice");
            System.out.println("Your selected option is: ");
            selection = sc.nextInt();
            return selection;
        }
    }
