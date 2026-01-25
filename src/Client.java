import java.util.ArrayList;
import java.util.List;

public class Client extends Person{
    private int numClient;
    private List<Account>accounts;

    public Client(String nom, int id , int numClient){
        super (nom,id);
        this.numClient=numClient;
        this.accounts= new ArrayList<>();
    }

    public int getNumClient() {
        return numClient;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}