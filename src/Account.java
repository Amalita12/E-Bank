import java.sql.SQLOutput;

public class Account {
    private String numCompte;
    private double solde;

    public Account(String numCompte, double solde) {
        this.numCompte= numCompte;
        this.solde=solde;
    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public void deposerArgent(double amount){

         solde+=amount;

    }

    public void retirerArgent(double amount){
        if (amount<=solde){
             solde-=amount;
            System.out.println("Retrait réussi");

        }else{
            System.out.println("solde insuffisant!");
        }
    }



}
