import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean repeat = true;

        String[][] arrayPekarstvi = {
                { "Rohlík", "3" },
                { "Houska", "8" },
                { "Chleba", "23"}
        };
        String[][] arrayReznictvi = {
                { "Klobasa", "Debrecinka", "Salám" },
                { "34", "22", "43" }
        };
        String[][] arrayElektronika = {
                { "Mobil", "Televize", "Notebook" },
                { "3000", "8000", "16000" }
        };

        int price = 0;

        String ShoppingCart = "";
        int itemsBought = 0;
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
                        System.out.println(i+1 + " - " + arrayPekarstvi[i][0] + " Cena: " + arrayPekarstvi[i][1] + "Kč");
                        System.out.println(" ");
                    }
                    pickItem = sc.nextInt();
                    ShoppingCart += arrayPekarstvi[pickItem-1][0];
                    if (pickItem-1!= 4) {
                        itemsBought += 1;
                        price += Integer.parseInt(arrayPekarstvi[pickItem-1][1]);
                    }

                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println(addToShoppingCart(ShoppingCart) + " " + price + "Kč");
                    repeat = false;
                    break;

                default:
                    break;
            }
        }
    }

    static String addToShoppingCart(String  shopping) {
        String [] array = shopping.split(" ");
        String itema = "";
        int itemCount = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i].equals(array[j])){
                    itemCount=itemCount+1; 
                    array[j]="0";
                }
            }
            if(array[i]!="0")
            System.out.println(array[i] + "-" + itemCount);
            itema += array[i] + "-" + itemCount;
            itemCount=1;
        }
        return itema;
    }
}
