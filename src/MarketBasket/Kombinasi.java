/*
 * Project Name :
 * Author :
 * Date :
 */
package MarketBasket;

import java.util.ArrayList;
import java.util.TreeSet;
public class Kombinasi {
    /**
     * @param args the command line arguments
     */
    static int column[];
    static TreeSet<String> combination;
    static ArrayList<TreeSet<String>> storage;
    static int numberelement;
    public static void combinations(int set, int order, int n) {
        column[set] = column[set - 1];
        while (column[set] < n - order + set) {
            column[set] = column[set] + 1;
            if (set < order)
                combinations(set + 1, order, n);
            else {
                combination = new TreeSet <  > ();
                for (int j = 1; j <= order; j++) {
                    combination.add(String.valueOf(column[j]));
                }
                numberelement++;
                storage.add(numberelement, combination);
                combination = storage.get(numberelement);
            }
        }
    }
    public static ArrayList<TreeSet<String>> generate(int n) {
        column = new int[n + 1];
        storage = new ArrayList<TreeSet<String>>();
        numberelement = -1;
        for (int order = 1; order <= n; order++) {
            column[0] = 0;
            combinations(1, order, n);
        }
        for (int i = 0; i < storage.size(); i++) {
            combination = storage.get(i);
        }
        return storage;
    }
}