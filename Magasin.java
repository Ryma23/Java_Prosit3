public class Magasin {
    private int identifiant;
    private String adresse;
    private int capaciteMax;
    private Produit[] produits;
    private int nombreProduits;
    private static int compteurTotalProduits = 0;

    private Employe[] employes;
    private int nombreEmployes;

    public Magasin(int identifiant, String adresse, int capaciteMax) {
        this.identifiant = identifiant;
        this.adresse = adresse;
        this.capaciteMax = capaciteMax;
        this.produits = new Produit[capaciteMax];
        this.nombreProduits = 0;
        this.employes = new Employe[20];  // Limite de 20 employés
        this.nombreEmployes = 0;

    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public Produit[] getProduits() {
        return produits;
    }

    public int getNombreProduits() {
        return nombreProduits;
    }


    public void ajouter(Produit p) {
        if (chercherProduit(p)) {
            System.out.println("Produit déjà présent dans le magasin. Ajout annulé.");
        } else if (nombreProduits < capaciteMax) {
            produits[nombreProduits] = p;
            nombreProduits++;
            compteurTotalProduits++;
            System.out.println("Produit ajouté avec succès.");
        } else {
            System.out.println("Impossible d'ajouter le produit. Capacité maximale atteinte.");
        }
    }


    public void afficherMagasin() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Magasin ID: ").append(identifiant)
                .append(", Adresse: ").append(adresse)
                .append(", Capacité: ").append(capaciteMax)
                .append("\nProduits dans le magasin:\n");

        for (int i = 0; i < nombreProduits; i++) {
            sb.append("- ").append(produits[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static int getTotalProduits() {
        return compteurTotalProduits;
    }

    public boolean chercherProduit(Produit p) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].comparer(p)) {
                return true;
            }
        }
        return false;
    }

    public static Magasin DernierQuestion(Magasin magasin1, Magasin magasin2) {
        if (magasin1.getNombreProduits() > magasin2.getNombreProduits()) {
            return magasin1;
        } else if (magasin2.getNombreProduits() > magasin1.getNombreProduits()) {
            return magasin2;
        } else {
            System.out.println("Les deux magasins ont le même nombre de produits.");
            return null;
        }
    }

    public boolean supprimez(Produit p) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].comparer(p)) {
                for (int j = i; j < nombreProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[nombreProduits - 1] = null;
                nombreProduits--;
                compteurTotalProduits--;
                System.out.println("Produit supprimé avec succès.");
                return true;
            }
        }
        System.out.println("Produit non trouvé dans le magasin.");
        return false;
    }
    public void ajouterEmploye(Employe e) {
        if (nombreEmployes < employes.length) {
            employes[nombreEmployes] = e;
            nombreEmployes++;
        } else {
            System.out.println("Impossible d'ajouter l'employé. Limite atteinte.");
        }
    }

    public void afficherEmployes() {
        for (int i = 0; i < nombreEmployes; i++) {
            System.out.println(employes[i]);
        }
    }

    public void afficherSalaires() {
        for (int i = 0; i < nombreEmployes; i++) {
            System.out.println("Salaire de " + employes[i].getNom() + ": " + employes[i].calculerSalaire());
        }
    }
    public void affichenbEmployeParType() {
        int nbCaissiers = 0;
        int nbVendeurs = 0;
        int nbResponsables = 0;


        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i] instanceof Caissier) {
                nbCaissiers++;
            } else if (employes[i] instanceof Vendeur) {
                nbVendeurs++;
            } else if (employes[i] instanceof Responsable) {
                nbResponsables++;
            }
        }
        System.out.println("Nombre de Caissiers : " + nbCaissiers);
        System.out.println("Nombre de Vendeurs : " + nbVendeurs);
        System.out.println("Nombre de Responsables : " + nbResponsables);
    }
    public void afficherPrimesResponsables() {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i] instanceof Responsable) {
                System.out.println("Prime de " + employes[i].getNom() + ": " + ((Responsable) employes[i]).getPrime());
            }
        }
    }

}
