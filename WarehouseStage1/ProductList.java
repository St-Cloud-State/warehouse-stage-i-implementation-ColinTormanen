import java.util.*;
import java.io.*;

public class ProductList implements Serializable {

    // Linked list to hold the products
    private List products = new LinkedList();

    private static ProductList productList;

    private ProductList() {
    }

    // Create the warehouse instance of the list
    public static ProductList instance() {
        if (productList == null) {
            productList = new ProductList();
            return productList;
        }
        else {
            return productList;
        }
    }

    // Inserts a product to the list
    public boolean insertProduct(Product product) {
        products.add(product);
        return true;
    }

    // Returns an iterator to the list
    public Iterator getProducts() {
        return products.iterator();
    }

    // Returns the product list to string
    @Override
    public String toString(){
        return products.toString();
    }

    private void writeObject(java.io.ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeObject(productList);
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void readObject(java.io.ObjectInputStream in) {
        try {
            if(productList != null) {
                return;
            }
            else {
                in.defaultReadObject();
                if(productList == null) {
                    productList = (ProductList) in.readObject();
                }
                else {
                    in.readObject();
                }
            }
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    // Determines if the list contains a product
    public boolean contains(Product p) {
        return products.contains(p);
    }
}


