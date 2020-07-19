/*
 * Project Name :
 * Author :
 * Date :
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
    static String[] namabarang;
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
            //System.out.println("\nHasil:");
            int index = -1;
            
            while ((line = br.readLine()) != null) //returns a Boolean value
            {
                i = i + 1;
                temp = new TreeSet<String>();
                String[] employee = line.split(splitBy); // use comma as separator
                //System.out.println("\nTransaksi ke-" + i + ":");
                for(int j=0;j<jumlahproduk;j++){
                    //System.out.print(employee[j]+", ");
                    temp.add(employee[j]);
                }
                index++;
               //System.out.println(temp);
                datatransaction.add(index, temp);
            }
            //System.out.println(datatransaction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void hitungSupport(ArrayList<TreeSet<String>> kombinasi,ArrayList<TreeSet<String>> dataTransaksi){
        
        support=new int[kombinasi.size()];
//        Object[] kombinasiArray=kombinasi.toArray();
//        Object[] dataTransaksiArray=dataTransaksi.toArray();
//        System.out.println(kombinasiArray[0]);
//        System.out.print(dataTransaksiArray[0]);
        for(int i=0;i<kombinasi.size();i++){
            for(int j=0;j<dataTransaksi.size();j++){
                //System.out.print(kombinasi.get(i)+" "+dataTransaksi.get(j));
                //System.out.println(kombinasi.get(i).equals(dataTransaksi.get(j)));
                if(kombinasi.get(i).equals(dataTransaksi.get(j))){
                    //System.out.println(kombinasi.get(i)+" "+dataTransaksi.get(j));
                    support[i]=support[i]+1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah transaksi yang akan dibuat: ");
        int jmltransaksi=input.nextInt();
        System.out.println("Masukkan jumlah barang yang ada di toko: ");
        int jmlbarang=input.nextInt();
        namabarang=new String[jmlbarang];
        for(int i=1;i<=jmlbarang;i++){
            System.out.println("Nama barang ke "+i);
            namabarang[i-1]=input.next();
        }
        makeRandomTransactionCSV(jmltransaksi,jmlbarang);
        readTransaction(jmlbarang);   
        ArrayList<TreeSet<String>> kombinasi = generate(jmlbarang);
        //System.out.println("\n");
        //System.out.println(kombinasi);
        //System.out.println(datatransaction);
        hitungSupport(kombinasi,datatransaction);
        System.out.println("\nsupport : "+Arrays.toString(support));
        for(int i=0;i<namabarang.length;i++)System.out.println(namabarang[i]);
        
    }
    
}
