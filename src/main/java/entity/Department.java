package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartment;
    private String departmentCity;
    private int countOfWorkers;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
    private List<Client> client;

    public Department() {
    }

    public Department(String departmentCity, int countOfWorkers) {
        this.departmentCity = departmentCity;
        this.countOfWorkers = countOfWorkers;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDepartmentCity() {
        return departmentCity;
    }

    public void setDepartmentCity(String departmentCity) {
        this.departmentCity = departmentCity;
    }

    public int getCountOfWorkers() {
        return countOfWorkers;
    }

    public void setCountOfWorkers(int countOfWorkers) {
        this.countOfWorkers = countOfWorkers;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return idDepartment == that.idDepartment &&
                countOfWorkers == that.countOfWorkers &&
                Objects.equals(departmentCity, that.departmentCity) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, departmentCity, countOfWorkers, client);
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", departmentCity='" + departmentCity + '\'' +
                ", countOfWorkers=" + countOfWorkers +
                '}';
    }
}
