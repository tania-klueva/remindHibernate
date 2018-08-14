package entity;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Client client = manager.find(Client.class, 3);
        System.out.println(client);

        TypedQuery<Client> query = manager.createQuery("select c from Client c", Client.class);
        List<Client> resultList = query.getResultList();
        resultList.stream().forEach(client1 -> System.out.println(client1.toString()));
        System.out.println("#################");
        resultList.stream().flatMap(client1 -> client1.getApplication().stream()
                        .filter(application -> application.getCreditState().equals("Returned") && application.getSum() > 7000))
                .forEach(application -> System.out.println(application.getClient().toString()));


        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

}
