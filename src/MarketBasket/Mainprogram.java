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
    public static void makeRandomTransactionCSV(int jumlah) throws IOException{
        // Our example data
        
        Random rand = new Random();
        int rand_int=rand.nextInt(jumlah);

        FileWriter csvWriter = new FileWriter("DataTransaction.csv");
        csvWriter.append("Pelanggan");
        csvWriter.append(",");
        csvWriter.append("Orderan");
        csvWriter.append("\n");

        for (int i=1;i<=jumlah;i++) {
            csvWriter.append(Integer.toString(i));
            rand_int=rand.nextInt(jumlah);
            csvWriter.append(", ");
            csvWriter.append(Integer.toString(rand_int));
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
        makeRandomTransactionCSV(100);
//        String arr[] = {"buku","sendal", "pulpen"}; 
//	int r; 
//	int n = arr.length; 
//        for(r=1;r<=n;r++)
//	printCombination(arr, n, r);
    }
    
}
