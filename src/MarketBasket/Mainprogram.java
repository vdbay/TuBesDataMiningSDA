/*
 * Project Name :
 * Author :
 * Date :
 */
package MarketBasket;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Acer
 */
public class Mainprogram extends Combination{
    public static void makeRandomTransactionCSV(int jumlahtransaksi,int jumlahproduk) throws IOException{
        // Our example data
        
        Random rand = new Random();
        int rand_int;

        FileWriter csvWriter = new FileWriter("DataTransaction.csv");
        csvWriter.append("Pelanggan");
        csvWriter.append(",");
        csvWriter.append("Orderan");
        csvWriter.append("\n");

        for (int i=1;i<=jumlahtransaksi;i++) {
            csvWriter.append(Integer.toString(i));
            csvWriter.append(", ");
            for(int j=1;j<=jumlahproduk;j++){
                rand_int=(rand.nextInt(jumlahtransaksi)%jumlahproduk)+1;
                csvWriter.append(Integer.toString(rand_int));
                csvWriter.append("; ");
            }
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        makeRandomTransactionCSV(100,100);
//        String arr[] = {"buku","sendal", "pulpen"}; 
//	int r; 
//	int n = arr.length; 
//        for(r=1;r<=n;r++)
//	printCombination(arr, n, r);
    }
    
}
