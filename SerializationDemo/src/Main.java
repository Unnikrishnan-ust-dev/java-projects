import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        System.out.println("Hello world!");

        PurchaseOrder order = new PurchaseOrder("1234","Dell",5,20000);
        System.out.println(order);
        FileOutputStream fos = new FileOutputStream("order.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(order);

        FileInputStream fis = new FileInputStream("order.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        PurchaseOrder order1 = null;
        try {
             order1 = (PurchaseOrder) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found: " + e.getMessage());
        }

        if(order1!=null){
            System.out.println(order1);
        }else{
            System.out.println("No Order Found");
        }
    }
}