public class CompteBancaire {
    private int numero;
    private double solde;

    public CompteBancaire(int numero) {
        this.numero = numero;
        this.solde = 0.0;
    }

    public void deposerArgent(double montant) {
        if (montant > 0) {
            solde += montant;
            Journalisation.getInstance().ajouterLog("[" + java.time.LocalDateTime.now() + "] Dépôt de " + montant + " FCFA sur le compte " + numero + ".");
        } else {
            Journalisation.getInstance().ajouterLog("[" + java.time.LocalDateTime.now() + "] Tentative de dépôt invalide sur le compte " + numero + ".");
        }
    }

    public void retirerArgent(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            Journalisation.getInstance().ajouterLog("[" + java.time.LocalDateTime.now() + "] Retrait de " + montant + " FCFA du compte " + numero + ".");
        } else {
            Journalisation.getInstance().ajouterLog("[" + java.time.LocalDateTime.now() + "] Tentative de retrait invalide sur le compte " + numero + ".");
        }
    }

    public double getSolde() {
        return solde;
    }
}
