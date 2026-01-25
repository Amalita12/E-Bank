import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        Bank mabq = new Bank();

        do {
            try {
                System.out.println("\n----Menu------");
                System.out.println("1.Ajouter un client");
                System.out.println("2.Créer un compte");
                System.out.println("3.Afficher tous les comptes");
                System.out.println("4.Consulter le solde");
                System.out.println("5.Déposer argent");
                System.out.println("6.Retirer argent");
                System.out.println("7.Supprimer un compte");
                System.out.println("8.Quitter");
                System.out.print("Entrez votre choix: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Entrée votre ID:");
                        int id = scanner.nextInt();
                        System.out.println("Entrée votre nom:");
                        String nom = scanner.next();
                        System.out.println("Numéro client:");
                        int numClient = scanner.nextInt();
                        Client nvClient = new Client(nom, id, numClient);
                        mabq.ajouterClient(nvClient);
                        System.out.println("Client ajouté avec succès.");
                        break;
                    case 2:
                        System.out.println("numéro de compte: ");
                        String numCompte = scanner.next();
                        System.out.println("Solde initial: ");
                        double solde = scanner.nextDouble();
                        if (solde > 0) {
                            mabq.creerCompte(numCompte, solde);
                        } else {
                            System.out.println("Vous devez entrer un solde positif !");
                        }
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
                            if (montant > 0) {
                                accDepot.deposerArgent(montant);
                                System.out.println("Dépôt effectué.");
                            } else {
                                System.out.println("Le montant doit être positif!");
                            }
                        } else {
                            System.out.println("Compte introuvable.");
                        }
                        break;
                    case 6:
                        scanner.nextLine();
                        System.out.print("Numéro de compte : ");
                        String nRetirer = scanner.nextLine();
                        Account accRetirer = mabq.trouverCompte(nRetirer);
                        if (accRetirer != null) {
                            System.out.print("Montant à retirer: ");
                            double mnt = scanner.nextDouble();
                            accRetirer.retirerArgent(mnt);
                        } else {
                            System.out.println("Compte introuvable!");
                        }
                        break;
                    case 7:
                        System.out.print("Numéro de compte à supprimer : ");
                        String ndelete = scanner.next();
                        mabq.supprimerCompte(ndelete);
                        break;
                    case 8:
                        System.out.println("Merci d'avoir utilisé E-bank. Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Une erreur inattendue est survenue." );
                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 8);

        scanner.close();
    }
}