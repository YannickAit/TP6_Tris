import java.util.Arrays;

public class Exercice2 {


    public static int[] quickSort(int[] nombres) {
       
        if (nombres.length <= 1) {
            return nombres;
        }

        int It1 = nombres[0];
        int[] tab = new int[nombres.length];
        int[] grand = new int[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] < It1) {
                tab[i] = nombres[i];
            } else if (nombres[i] > It1) {
                grand[i] = nombres[i];
            }
        }

        int[] sansZeros1 = Arrays.stream(tab).filter(valeur -> valeur != 0).toArray();
        int[] sansZeros2 = Arrays.stream(grand).filter(valeur -> valeur != 0).toArray();

    
        int[] petitsTries = quickSort(sansZeros1);
        int[] grandsTries = quickSort(sansZeros2);

        
        int[] resultat = new int[nombres.length];
        int position = 0;

     
        for (int valeur : petitsTries) {
            resultat[position] = valeur;
            position++;
        }

        resultat[position] = It1;
        position++;

        for (int valeur : grandsTries) {
            resultat[position] = valeur;
            position++;
        }

      
        return resultat;
    }

    public static void main(String[] args) {
        int[] nombres = new int[7];
        nombres[0] = 6;
        nombres[1] = 1;
        nombres[2] = 4;
        nombres[3] = 5;
        nombres[4] = 2;
        nombres[5] = 7;
        nombres[6] = 3;

        int[] tableauTrie = quickSort(nombres);
        System.out.println("Résultat trié : " + Arrays.toString(tableauTrie));
    }
}