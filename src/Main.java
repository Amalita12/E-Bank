import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int choice;
        Bank mabq= new Bank();
        do {
            System.out.println("----Menu------");
            System.out.println("1.Ajouter un client");
            System.out.println("2.Créer un compte");
            System.out.println("3.Afficher tous les comptes");
            System.out.println("4.Consulter le solde");
            System.out.println("5.Déposer argent");
            System.out.println("6.Retirer argent");
            System.out.println("7.Supprimer un compte");
            System.out.println("8.Quitter");
            System.out.println("Entrez votre choix: ");

            choice=scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Entree votre ID:");
                    int id = scanner.nextInt();
                    System.out.println("Entree votre nom:");
                    String nom = scanner.next();
                    System.out.println("Numéro client:");
                    int numClient = scanner.nextInt();
                    Client nvClient = new Client(nom,id,numClient);
                    mabq.ajouterClient(nvClient);
                    System.out.println("Client ajouté avec succès.");
                    break;
                case 2:

                    System.out.println("numéro de compte: ");
                    String numCompte= scanner.next();

                    System.out.println("Solde initial: ");
                    double solde= scanner.nextDouble();

                    mabq.creerCompte(numCompte,solde);
                    break;
                case 3:
                    mabq.displayAccounts();
                    break;
                case 4:
                    System.out.println("Entrez le numéro de compte:");
                    String numRecherche = scanner.next();
                    mabq.consulterSolde(numRecherche);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Numéro de compte : ");
                    String nDepot = scanner.nextLine();
                    Account accDepot = mabq.trouverCompte(nDepot);
                    if (accDepot != null) {
                        System.out.print("Montant à déposer : ");
                        double montant = scanner.nextDouble();
                        if(montant>0) {
                            accDepot.deposerArgent(montant);
                            System.out.println("Dépôt effectué.");
                        }else {
                            System.out.println("Vous devez déposer un montant positif!");
                        }
                    }
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.print("Numéro de compte : ");
                    String nRetirer = scanner.nextLine();
                    Account accRetirer = mabq.trouverCompte(nRetirer);
                    if (nRetirer!=null){
                        System.out.println("Montant à retirer: ");
                        double montant = scanner.nextDouble();
                        accRetirer.retirerArgent(montant);
                    }else{
                        System.out.println("Compte introuvable!");
                    }
                    break;

                case 7:
                    System.out.println("Numéro de compte à supprimer : ");
                    String ndelete = scanner.next();

                        mabq.supprimerCompte(ndelete);
                        break;


                case 8:
                    System.out.println("Merci d'avoir utilisé E-bank. Au rvoir!");
                    break;


                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;




            }




        }while(choice!=8);
    }
}