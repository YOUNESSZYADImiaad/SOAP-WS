import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();
        System.out.println(stub.convert(1999));
        Compte cp = stub.getCompte(22);
        System.out.println("The Code of your account is :" + cp.getCode());
        System.out.println("The Solde of your account is :" + cp.getSolde());
        System.out.println("Liste des comptes");
        List<Compte> cptes = stub.listComptes();
        for (Compte c : cptes) {
            System.out.println(c.getCode() + "----" + c.getSolde());
        }
    }
}
