import java.io.*;
import java.util.*;

public class WarehouseTester {

    public static void main(String[] args) {

        // Creating the warehouse lists
        ClientList cList = ClientList.instance();
        ProductList pList = ProductList.instance();


        // Populating the client list
        System.out.println("Inserting clients in the the client list:");

        Client client1 = new Client("John Doe");
        Client client2 = new Client("Jane Smith");
        Client client3 = new Client("Jerry Johnson");

        cList.insertClient(client1);
        cList.insertClient(client2);
        cList.insertClient(client3);


        // Print all the clients in the system
        System.out.println("Printing all clients:");
        Iterator clients = cList.getClients();

        while(clients.hasNext()) {
            System.out.println(clients.next());
        }


        // Populating the product list
        System.out.println("\nInserting products in the product list:");

        Product p1 = new Product("Laptop", 1, 1, 150.0);
        Product p2 = new Product("Apple", 2, 1, 5.0);
        Product p3 = new Product("Fridge", 3, 1, 2000.0);

        pList.insertProduct(p1);
        pList.insertProduct(p2);
        pList.insertProduct(p3);

        Iterator products = pList.getProducts();


        // Prints all the products in the system
        System.out.println("Printing all products:");
        while(products.hasNext()) {
            System.out.println(products.next());
        }


        // Adding items into client wishlists

        // Add laptop to john doe
        System.out.println("\nInserting the laptop product into John Doe's wishlist:");
        Client c = cList.searchClient(client1.getClientId());
        if(c != null)
            c.addToWishlist(p1);

        Iterator it = c.getWishlist();


        // Print john doe's wishlist
        System.out.println("John's wishlist:");
        while(it.hasNext())
            System.out.println(it.next());


        // Add apple and fridge to Jane's wishlist
        System.out.println("\nInserting apple and fridge into Jane's wishlist:");
        Client c2 = cList.searchClient(client2.getClientId());
        if(c2 != null){
            c2.addToWishlist(p2);
            c2.addToWishlist(p3);
        }


        // Print jane's wishlist
        System.out.println("Jane's wishlist:");
        Iterator it2 = c2.getWishlist();
        while(it2.hasNext()) 
            System.out.println(it2.next());
        
    }

}