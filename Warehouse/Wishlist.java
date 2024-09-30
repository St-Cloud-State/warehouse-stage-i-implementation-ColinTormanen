public class Wishlist {

    private List list = new LinkedList();

    public Wishlist() {
    }

    public boolean insertProduct(Product product) {
        list.add(product);
        return true;
    }

    public Iterator getProducts() {
        return list.iterator();
    }

    public String toString(){
        return list.toString();
    }

    private void writeObject(java.io.ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeObject(list);
        }
        catch(IOExeption ioe) {
            ioe.printStackTrace();
        }
    }

    private void readObject(java.io.ObjectInputStream in) {
        try {
            if(list != null) {
                return;
            }
            else {
                in.defaultReadObject();
                if(list == null) {
                    list = (list) in.readObject();
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