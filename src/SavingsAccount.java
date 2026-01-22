public class SavingsAccount extends Account{
    private double tauxInteret;
    public SavingsAccount(String numCompte, double solde, double tauxInteret){
        super(numCompte,solde);
        this.tauxInteret=tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculerInteret() {
            double interets = getSolde() * tauxInteret;
            deposerArgent(interets);
            System.out.println("Intérêts ajoutés : " + interets + " DH. Nouveau solde : " + getSolde());
        }
    }

