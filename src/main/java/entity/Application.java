package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idApplication;
    private int sum;
    private String creditState;
    private String currency;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Client client;

    public Application() {
    }

    public Application(int sum, String creditState, String currency) {
        this.sum = sum;
        this.creditState = creditState;
        this.currency = currency;
    }

    public int getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(int idApplication) {
        this.idApplication = idApplication;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCreditState() {
        return creditState;
    }

    public void setCreditState(String creditState) {
        this.creditState = creditState;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return idApplication == that.idApplication &&
                sum == that.sum &&
                Objects.equals(creditState, that.creditState) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApplication, sum, creditState, currency, client);
    }

    @Override
    public String toString() {
        return "Application{" +
                "idApplication=" + idApplication +
                ", sum=" + sum +
                ", creditState='" + creditState + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
