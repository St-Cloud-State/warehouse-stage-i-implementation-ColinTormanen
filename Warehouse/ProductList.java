import java.util.*;
import java.io.*;

public class ProductList {

    private List products = new LinkedList();

    private static ProductList productList;

    private ProductList() {
    }

    public static instance() {
        if (productList == null) {
            productList = new ProductList();
        }
        else {
            return productList;
        }
    }

    public boolean insertProduct(Product product) {
        products.add(product);
        return true;
    }

    public Iterator getProducts() {
        return products.iterator();
    }

    public String toString(){
        return products.toString();
    }

    private void writeObject(java.io.ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeObject(productList);
        }
        catch(IOExeption ioe) {
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
                    productList = (productList) in.readObject();
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
