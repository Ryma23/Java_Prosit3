public class Produit {
    private int id;
    private String lib;
    private String marque;
    private double price;


    public Produit() {
        this.id = 0;
        this.lib = "Inconnu";
        this.marque = "Inconnue";
        this.price = 0.0;
    }

    public Produit(int id, String lib, String marque, double price) {
        this.id = id;
        this.lib = lib;
        this.marque = marque;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public void afficher() {
        System.out.println(id + " " + lib + " " + marque + " " + price);
    }

    @Override
    public String toString() {
        return "Produit [ID: " + id + ", Libellé: " + lib + ", Marque: " + marque + ", Prix: " + price + "]";
    }


    public void addPrice() {
        if (this.lib.equalsIgnoreCase("lait")) {
            this.price += 0.70;
        }
    }


    public void completeProduit(int id, String lib, String marque, double price) {
        this.id = id;
        this.lib = lib;
        this.marque = marque;
        this.price = price;
    }


    public boolean comparer(Produit autreProduit) {
        return this.id == autreProduit.getId() &&
                this.lib.equals(autreProduit.getLib()) &&
                this.price == autreProduit.getPrice();
    }


    public static boolean comparer(Produit produit1, Produit produit2) {
        return produit1.getId() == produit2.getId() &&
                produit1.getLib().equals(produit2.getLib()) &&
                produit1.getPrice() == produit2.getPrice();
    }

}
