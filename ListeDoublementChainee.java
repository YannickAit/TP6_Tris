
public class ListeDoublementChainee {

    private static class Maillon {
        int valeur;
        Maillon precedent;
        Maillon suivant;

        Maillon(int valeur) {
            this.valeur = valeur;
            this.precedent = null;
            this.suivant = null;
        }
    }

    private Maillon tete;
    private Maillon queue;

   
    public void ajouterFin(int valeur) {
        Maillon nouveau = new Maillon(valeur);
        if (tete == null) {
            tete = nouveau;
            queue = nouveau;
        } else {
            queue.suivant = nouveau;
            nouveau.precedent = queue;
            queue = nouveau;
        }
    }

    public void triABulles() {
      
        if (tete == null || tete.suivant == null) {
            return;
        }

        boolean echangeEffectue;

        Maillon limiteFin = null;

        do {
            echangeEffectue = false;
            Maillon courant = tete;


            while (courant.suivant != limiteFin) {
                if (courant.valeur > courant.suivant.valeur) {
                    int temp = courant.valeur;
                    courant.valeur = courant.suivant.valeur;
                    courant.suivant.valeur = temp;

                    echangeEffectue = true;
                }
                courant = courant.suivant;
            }
            limiteFin = courant;

        } while (echangeEffectue);
    }

    
    public void afficher() {
        Maillon courant = tete;
        System.out.print("[");
        while (courant != null) {
            System.out.print(courant.valeur);
            if (courant.suivant != null) {
                System.out.print(" <-> ");
            }
            courant = courant.suivant;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListeDoublementChainee liste = new ListeDoublementChainee();
        int[] valeursTest = {6, 1, 4, 5, 2, 7, 3};

        for (int v : valeursTest) {
            liste.ajouterFin(v);
        }

        System.out.print("Avant le tri : ");
        liste.afficher();

        liste.triABulles();

        System.out.print("Après le tri : ");
        liste.afficher();
    }
}    

