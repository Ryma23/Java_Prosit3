
public class Main {
    public static void main(String[] args) {


        Produit P1 = new Produit(1020, "Pain", "Baguette", 0.300);
        Produit P2 = new Produit(1021, "Lait", "Delice", 0.0);
        Produit P3 = new Produit(2521, "Yaourt", "Vitalait", 0.0);
        Produit P4 = new Produit(3250, "Tomate", "Sicam", 1.200);


        P1.afficher();
        P2.afficher();
        P3.afficher();
        P4.afficher();


        P2.addPrice();
        P3.addPrice();
        P4.addPrice();


        System.out.println(P2.toString());
        System.out.println(P3.toString());
        System.out.println(P4.toString());


        P2.setPrice(520);
        P2.afficher();
        P3.setPrice(600);
        P3.afficher();


        Magasin magasin1 = new Magasin(1, "123 Rue Principale", 50);
        Magasin magasin2 = new Magasin(2, "456 Rue Secondaire", 50);


        magasin1.ajouter(P1);
        magasin1.ajouter(P2);
        magasin1.ajouter(P3);
        magasin1.ajouter(P4);
        magasin1.afficherMagasin();

        magasin1.ajouter(P2);
        magasin2.ajouter(P1);//pour test
        System.out.println(magasin1.toString());
        int totalProduits = Magasin.getTotalProduits();
        System.out.println("Nombre total de produits dans tous les magasins : " + totalProduits);
        if (P1.comparer(P2)) {
            System.out.println("Produit1 et Produit2 sont identiques.");
        } else {
            System.out.println("Produit1 et Produit2 ne sont pas identiques.");
        }


        if (Produit.comparer(P1, P2)) {
            System.out.println("Produit1 et Produit3 sont identiques.");
        } else {
            System.out.println("Produit1 et Produit3 ne sont pas identiques.");
        }




        if (magasin1.chercherProduit(P1)) {
            System.out.println("Produit1 trouvé dans le magasin.");
        } else {
            System.out.println("Produit1 non trouvé dans le magasin.");
        }

        Magasin plusDeProduits = Magasin.DernierQuestion(magasin1, magasin2);
        if (plusDeProduits != null) {
            System.out.println("Le magasin ayant le plus de produits est : " + plusDeProduits.getAdresse());
        }
        boolean Supp = magasin2.supprimez(P1);
        System.out.println("Produit supprimé : " + Supp);

    }

}


