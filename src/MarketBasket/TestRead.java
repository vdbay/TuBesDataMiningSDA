/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketBasket;

/**
 *
 * @author USER
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestRead {

    //	public static void main(String[] args){
    //		String fileName = "DataTransaction.csv";
    //		String line = "";
    //		String separator = ",";
    //		BufferedReader br = null;
    //		
    //		try{
    //			br = new BufferedReader(new FileReader(fileName));
    //			System.out.println("Sedang membaca file....");
    //			while ((line = br.readLine()) != null){
    //				String[] parsingFile = line.split(separator);
    //				System.out.println("Transaksi{");
    //				System.out.println("\tItem yang dibeli: "+parsingFile[0]+", "+parsingFile[1]+", "+parsingFile[2]+", "+parsingFile[3]);
    //				//System.out.println("\tJenis Kelamin = "+parsingFile[1]);
    //				//System.out.println("\tAlamat = "+parsingFile[2]);
    //				//System.out.println("\tFakultas = "+parsingFile[3]);
    //				//System.out.println("\tJurusan = "+parsingFile[4]);
    //				System.out.println("}");
    //				System.out.println();
    //			}
    //		}catch(FileNotFoundException ex){
    //			System.err.println("File tidak ditemukan!");
    //			ex.printStackTrace();
    //		}catch(IOException ex){
    //			System.err.println("File tidak ditemukan!");
    //		}finally{
    //			if(br != null){
    //				try{
    //					br.close();
    //				}catch(IOException ex){
    //					ex.printStackTrace();
    //				}
    //			}
    //		}
    //	}
    public static void main(String[] args) {
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
                System.out.println("Transaksi " + i + " : " + employee[0] + ", " + employee[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//			System.out.println("Sedang membaca file....");
//			while ((line = br.readLine()) != null){
//				String[] parsingFile = line.split(separator);
//				System.out.println("Mahasiswa{");
//				System.out.println("\tNama = "+parsingFile[0]);
//				System.out.println("\tJenis Kelamin = "+parsingFile[1]);
//				System.out.println("\tAlamat = "+parsingFile[2]);
//				System.out.println("\tFakultas = "+parsingFile[3]);
//				System.out.println("\tJurusan = "+parsingFile[4]);
//				System.out.println("}");
//				System.out.println();