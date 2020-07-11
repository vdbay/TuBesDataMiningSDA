/*
 * Project Name :
 * Author :
 * Date :
 */
package MarketBasket;
import java.io.BufferedReader;
import java.io.FileReader;
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
    public static void readTransaction(int jumlahproduk){
        String line = "";
        String splitBy = ",";
        int i = 0;
        try {
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("DataTransaction.csv"));
            while ((line = br.readLine()) != null) //returns a Boolean value  
            {
                i = i + 1;
                String[] employee = line.split(splitBy); // use comma as separator  
                System.out.println("Transaksi " + i + " : ");
                for(int j=0;j<jumlahproduk;j++){
                    System.out.println(employee[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) throws IOException {
     System.out.println("Masukkan pilihan Anda:\n");
     System.out.println("1. Buat Transaksi\n");
     Scanner input = new Scanner(System.in);
        System.out.println("Input berapa jumlah transaksi yang akan dibuat:\n");
        int jmltransaksi=input.nextInt();
        System.out.println("Input jumlah barang yang ada di toko:\n");
        int jmlbarang=input.nextInt();
        makeRandomTransactionCSV(jmltransaksi,jmlbarang);
        readTransaction(jmlbarang);
     System.out.println("2. Close?\n");
     
    }
    
}
