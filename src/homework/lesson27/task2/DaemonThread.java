package homework.lesson27.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DaemonThread extends Thread{
    private List<Product> productList;

    DaemonThread(List<Product> productList){
        this.productList = productList;
    }
    public void run(){
        for (Product product : productList) {
            String s = product.getId() + "::" + product.getAmount();
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("newFile.txt", true));
                writer.write(s);
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
