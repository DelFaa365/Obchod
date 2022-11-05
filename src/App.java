import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean repeat = true;

        String[][] arrayPekarstvi = {
                { "Rohlík", "3" },
                { "Houska", "8" },
                { "Chleba", "23" }
        };
        String[][] arrayReznictvi = {
                { "Salám", "23" },
                { "Debrecínka", "44" },
                { "Maso", "155" }
        };
        String[][] arrayElektronika = {
                { "Mobil", "3000" },
                { "Televize", "8000" },
                { "Notebook", "23000" }
        };

        int price = 0;

        String ShoppingCart = " ";
        while (repeat) {
            System.out.println("Vyber si kategorii");
            System.out.println("Pekařství - 1");
            System.out.println("Řeznictví - 2");
            System.out.println("Elektronika - 3");
            System.out.println("Košík - 4");
            int vyber = sc.nextInt();
            int pickItem;
            switch (vyber) {
                case 1:
                    System.out.println("Produkty:");
                    for (int i = 0; i < arrayPekarstvi.length; i++) {
                        System.out.println(
                                i + 1 + " - " + arrayPekarstvi[i][0] + " Cena: " + arrayPekarstvi[i][1] + "Kč");
                        System.out.println(" ");
                    }
                    pickItem = sc.nextInt();
                    if (pickItem >= arrayPekarstvi.length) {
                        continue;
                    }
                    ShoppingCart +=  arrayPekarstvi[pickItem - 1][0] + " ";
                    if (pickItem - 1 != 4) {

                        price += Integer.parseInt(arrayPekarstvi[pickItem - 1][1]);
                    }

                    break;
                case 2:
                    System.out.println("Produkty:");
                    for (int i = 0; i < arrayReznictvi.length; i++) {
                        System.out.println(
                                i + 1 + " - " + arrayReznictvi[i][0] + " Cena: " + arrayReznictvi[i][1] + "Kč");
                        System.out.println(" ");
                    }
                    pickItem = sc.nextInt();
                    if (pickItem >= arrayReznictvi.length) {
                        continue;
                    }
                    ShoppingCart +=  arrayReznictvi[pickItem - 1][0] + " ";
                    if (pickItem - 1 != 4) {

                        price += Integer.parseInt(arrayReznictvi[pickItem - 1][1]);
                    }
                    break;
                case 3:
                    System.out.println("Produkty:");
                    for (int i = 0; i < arrayElektronika.length; i++) {
                        System.out.println(
                                i + 1 + " - " + arrayElektronika[i][0] + " Cena: " + arrayElektronika[i][1] + "Kč");
                        System.out.println(" ");
                    }
                    pickItem = sc.nextInt();
                    if (pickItem >= arrayElektronika.length) {
                        continue;
                    }
                    ShoppingCart +=  arrayElektronika[pickItem - 1][0] + " ";
                    if (pickItem - 1 != 4) {

                        price += Integer.parseInt(arrayElektronika[pickItem - 1][1]);
                    }
                    break;
                case 4:
                    String[] arrayWords = ShoppingCart.split(" ");
                    Map<String, Integer> map = new HashMap<String, Integer>();

                    for (String word : arrayWords) {
                        Integer count = map.get(word);
                        if (count == null) {
                            count = 0;
                        }
                        map.put(word, count + 1);
                    }
                    for (String word : map.keySet()) {
                        System.out.println(word + " " + map.get(word) + "x");
                    }
                    System.out.println("Celková cena: " + price + "Kč");
                    System.out.println(" ");
                    System.out.println("1 - Chcete pokračovat?");
                    int repeatAnswer = sc.nextInt();
                    if (repeatAnswer != 1) repeat = false;
                    break;

                default:
                    break;
            }
        }
    }
}
