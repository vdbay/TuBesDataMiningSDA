/*
 * Project Name :
 * Author :
 * Date :
 */
package MarketBasket;
import java.util.*;
/**
 *
 * @author Acer
 */
public class Mainprogram extends Combination{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String arr[] = {"buku","sendal", "pulpen"}; 
	int r; 
	int n = arr.length; 
        for(r=1;r<=n;r++)
	printCombination(arr, n, r);
    }
    
}