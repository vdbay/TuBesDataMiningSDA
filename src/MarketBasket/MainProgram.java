/*
Program			: MainProgram.java
Author			: Azhar Subhan Fauzi; Johan Salusu
Versi / Tanggal         : 0.7 Alpha/03-Jul-20
 */

package MarketBasket;
import static MarketBasket.Kombinasi.generate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainProgram{
    static ArrayList<TreeSet<String>> datatransaction=new ArrayList<>();
    static int[] support;
    static int threshold;
    public static void makeRandomTransactionCSV(int jumlahtransaksi,int jumlahproduk) throws IOException{
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
        TreeSet<String> temp = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("DataTransaction.csv"));
            int index = -1;
            
            while ((line = br.readLine()) != null) //returns a Boolean value
            {
                i = i + 1;
                temp = new TreeSet<String>();
                String[] barang = line.split(splitBy); // use comma as separator
                for(int j=0;j<jumlahproduk;j++){
                    temp.add(barang[j]);
                }
                index++;
                datatransaction.add(index, temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void hitungSupport(ArrayList<TreeSet<String>> kombinasi,ArrayList<TreeSet<String>> dataTransaksi){
        
        support=new int[kombinasi.size()];
        for(int i=0;i<kombinasi.size();i++){
            for(int j=0;j<dataTransaksi.size();j++){
                if(kombinasi.get(i).equals(dataTransaksi.get(j))){
                    support[i]=support[i]+1;
                }
            }
        }
    }
    
    public static void hitungThreshold(int jmltransaksi,  ArrayList<TreeSet<String>> kombinasi){
        for(int i=0;i<support.length;i++){
            if(support[i]>=threshold){
                System.out.println(kombinasi.get(i)+" recommended");
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah transaksi yang akan dibuat: ");
        int jmltransaksi=input.nextInt();
        System.out.print("Masukkan jumlah barang yang ada di toko: ");
        int jmlbarang=input.nextInt();
        System.out.print("Masukkan threshold barang (jumlah barang): ");
        makeRandomTransactionCSV(jmltransaksi,jmlbarang);
        threshold=input.nextInt();
        readTransaction(jmlbarang);   
        ArrayList<TreeSet<String>> kombinasi = generate(jmlbarang);
        hitungSupport(kombinasi,datatransaction);
        System.out.println("\nsupport: "+Arrays.toString(support));
        hitungThreshold(jmltransaksi,kombinasi);
    }
    
}