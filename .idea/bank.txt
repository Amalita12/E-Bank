import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private List<Client> clients;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void creerCompte(String num, double solde) {

        if (trouverCompte(num) != null) {
            System.out.println("Compte  existant!");
            return;
        }
        else{
            Account nvAccount = new Account(num,solde);
            accounts.add(nvAccount);
            System.out.println("Account added successfully");
        }



    }


    public void creerCompteEpargne ( Client c, String numCompte, double solde, double tauxInteret){
        SavingsAccount nvCompte = new SavingsAccount(numCompte,solde,tauxInteret);
        accounts.add(nvCompte);
        System.out.println("Compte épargne créé avec succès.");
    }

    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Aucun compte trouvé");
        } else {
            System.out.println("--- Liste des comptes de la banque ---");
            for (Account a : accounts) {
                System.out.println("Compte n°: " + a.getNumCompte() + " | Solde: " + a.getSolde() + " DH");
            }
        }
    }

    public void supprimerCompte (String num){
        Account a = trouverCompte(num);
        if (a!=null){
                if(a.getSolde()>0){
                    System.out.println("Veuillez retirer le solde restant avant de supprimer le compte.");
                }else{
                    accounts.remove(a);
                    System.out.println("Votre compte est supprimé avec succès.");

            }

        }else{
            System.out.println("Erreur! Compte introuvable.");
        }

    }
    public Account trouverCompte(String num) {
        for (Account a : accounts) {
            if (a.getNumCompte().equals(num))
                return a;
        }
        return null;
    }

    public Client trouverClient(int id){
        for (Client c :clients) {
            if (c.getId() == id) {
                return c;
            }

        }
        return null;

    }

    public void consulterSolde(String num){
        Account a = trouverCompte(num);
        if(a!=null){
            System.out.println("Le solde du compte: "+num+"="+a.getSolde()+"DH");

        }else {
            System.out.println("Erreur! Compte introuvable.");
        }
    }
}




