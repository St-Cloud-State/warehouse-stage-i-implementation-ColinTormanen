import java.util.*;

public class WishlistTester {
    public static void main(String[] args) {
        Wishlist list = new Wishlist();

        Product p1 = new Product("Laptop", 1, 1, 150.0);
        Product p2 = new Product("Apple", 2, 1, 5.0);
        Product p3 = new Product("Fridge", 3, 1, 2000.0);

        System.out.println("Testing the insert and display methods:");
        list.insertProduct(p1);
        list.insertProduct(p2);
        list.insertProduct(p3);

        Iterator products = list.getProducts();

        System.out.println("All items currently in the list:");
        while(products.hasNext()) {
            System.out.println(products.next());
        }


    }
}