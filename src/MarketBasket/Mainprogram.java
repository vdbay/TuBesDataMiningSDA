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

        for (int i=1;i<=jumlahtransaksi;i++) {
            for(int j=1;j<=jumlahproduk;j++){
                rand_int=(rand.nextInt(jumlahproduk)%jumlahproduk)+1;
                csvWriter.append(Integer.toString(rand_int));
                csvWriter.append(",");
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
        Scanner input = new Scanner(System.in);
        System.out.println("Input berapa jumlah transaksi yang akan dibuat:\n");
        int jmltransaksi=input.nextInt();
        System.out.println("Input jumlah barang yang ada di toko:\n");
        int jmlbarang=input.nextInt();
        makeRandomTransactionCSV(jmltransaksi,jmlbarang);
//        String arr[] = {"buku","sendal", "pulpen"}; 
//	int r; 
//	int n = arr.length; 
//        for(r=1;r<=n;r++)
//	printCombination(arr, n, r);
    }
    
}
