import java.util.*;

public class ListTester {

    public static void main(String[] args) {
        ProductList pList = ProductList.instance();

        Product p1 = new Product("Laptop", 1, 1, 150.0);
        Product p2 = new Product("Apple", 2, 1, 5.0);
        Product p3 = new Product("Fridge", 3, 1, 2000.0);

        System.out.println("Testing the insert and display methods:");
        pList.insertProduct(p1);
        pList.insertProduct(p2);
        pList.insertProduct(p3);

        Iterator products = pList.getProducts();

        System.out.println("All items currently in the list:");
        while(products.hasNext()) {
            System.out.println(products.next());
        }
        System.out.println("");

        System.out.println("Testing the contains method:");
        if(pList.contains(p1)) {
            System.out.println(p1.toString() + " exists in the list");
        }
        else {
            System.out.println(p1.toString() + " does not exist in the list");
        }

        Product p4 = new Product("Can", 4, 1, 10.0);

        if(pList.contains(p2)) {
            System.out.println(p2.toString() + " exists in the list");
        }
        else {
            System.out.println(p2.toString() + " does not exist in the list");
        }
        
    }
}