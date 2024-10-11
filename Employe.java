public class Employe {
    private int id;
    private String nom;
    private String adresse;
    private int nbr_heures;

    public Employe(int id, String nom, String adresse, int nbr_heures) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbr_heures = nbr_heures;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNbrHeures() {
        return nbr_heures;
    }

    public double calculerSalaire() {
        return 0;
    }

    @Override
    public String toString() {
        return "Employe [ID: " + id + ", Nom: " + nom + ", Adresse: " + adresse + ", Nombre d'heures: " + nbr_heures + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id == employe.id &&
                nbr_heures == employe.nbr_heures &&
                nom.equals(employe.nom) &&
                adresse.equals(employe.adresse);
    }
}

class Caissier extends Employe {
    private int numeroDeCaisse;

    public Caissier(int id, String nom, String adresse, int nbr_heures, int numeroDeCaisse) {
        super(id, nom, adresse, nbr_heures);
        this.numeroDeCaisse = numeroDeCaisse;
    }

    @Override
    public double calculerSalaire() {
        double salaire = getNbrHeures() * 5;
        if (getNbrHeures() > 180) {
            salaire += (getNbrHeures() - 180) * 5 * 0.15;
        }
        return salaire;
    }

    @Override
    public String toString() {
        return super.toString() + ", Caissier [Numéro de caisse: " + numeroDeCaisse + "]";
    }
}

class Vendeur extends Employe {
    private double tauxDeVente;

    public Vendeur(int id, String nom, String adresse, int nbr_heures, double tauxDeVente) {
        super(id, nom, adresse, nbr_heures);
        this.tauxDeVente = tauxDeVente;
    }

    @Override
    public double calculerSalaire() {
        return 450 * tauxDeVente;
    }

    @Override
    public String toString() {
        return super.toString() + ", Vendeur [Taux de vente: " + tauxDeVente + "]";
    }
}

class Responsable extends Employe {
    private double prime;

    public Responsable(int id, String nom, String adresse, int nbr_heures, double prime) {
        super(id, nom, adresse, nbr_heures);
        this.prime = prime;
    }

    @Override
    public double calculerSalaire() {
        double salaire = getNbrHeures() * 10;
        if (getNbrHeures() > 160) {
            salaire += (getNbrHeures() - 160) * 10 * 0.20;
        }
        return salaire + prime;
    }

    @Override
    public String toString() {
        return super.toString() + ", Responsable [Prime: " + prime + "]";
    }

    public double getPrime() {
        return prime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responsable responsable = (Responsable) o;
        return super.equals(o) && prime == responsable.prime;
    }

}
