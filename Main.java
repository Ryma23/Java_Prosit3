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

        magasin2.ajouter(P1);

        int totalProduits = Magasin.getTotalProduits();
        System.out.println("Nombre total de produits dans tous les magasins : " + totalProduits);

        if (P1.comparer(P2)) {
            System.out.println("Produit1 et Produit2 sont identiques.");
        } else {
            System.out.println("Produit1 et Produit2 ne sont pas identiques.");
        }

        if (Produit.comparer(P1, P3)) {
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

        Magasin carrefour = new Magasin(1, "Carrefour", 50);
        Magasin monoprix = new Magasin(2, "Monoprix", 50);

        Caissier caissier1 = new Caissier(101, "Ali", "Tunis", 190, 1);
        Vendeur vendeur1 = new Vendeur(102, "Ahmed", "Tunis", 160, 0.9);
        Responsable responsable1 = new Responsable(103, "Sami", "Tunis", 170, 200);
        carrefour.ajouterEmploye(caissier1);
        carrefour.ajouterEmploye(vendeur1);
        carrefour.ajouterEmploye(responsable1);

        Caissier caissier2 = new Caissier(201, "Mohamed", "Tunis", 180, 2);
        Vendeur vendeur2 = new Vendeur(202, "Hedi", "Tunis", 160, 0.85);
        Vendeur vendeur3 = new Vendeur(203, "Mourad", "Tunis", 160, 0.88);
        Responsable responsable2 = new Responsable(204, "Karim", "Tunis", 180, 250);
        monoprix.ajouterEmploye(caissier2);
        monoprix.ajouterEmploye(vendeur2);
        monoprix.ajouterEmploye(vendeur3);
        monoprix.ajouterEmploye(responsable2);

        System.out.println("Employés du  Carrefour:");
        carrefour.afficherEmployes();

        System.out.println("Employés du Monoprix:");
        monoprix.afficherEmployes();

        System.out.println("Salaires des Carrefour:");
        carrefour.afficherSalaires();

        System.out.println("Salaires des  Monoprix:");
        monoprix.afficherSalaires();

        System.out.println("Primes des responsables Carrefour:");
        carrefour.afficherPrimesResponsables();
        System.out.println("\nComparaison entre caissier1 et caissier3 (différents) : ");
        if (caissier1.equals(caissier2)) {
            System.out.println("caissier1 et caissier2 sont égaux.");
        } else {
            System.out.println("caissier1 et caissier2 ne sont pas égaux.");
        }

        System.out.println("Nb d'employés par type dans  Carrefour:");
        carrefour.affichenbEmployeParType();

        System.out.println("\nNb d'employés par type dans Monoprix:");
        monoprix.affichenbEmployeParType();
    }
}




