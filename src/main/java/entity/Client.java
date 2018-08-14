package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String firstName;
    private String lastName;
    private String education;
    private String passport;
    private String city;
    private String age;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
    private List<Application> application;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Department department;

    public Client() {
    }

    public Client(String firstName, String lastName, String education, String passport, String city, String age, List<Application> application, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.education = education;
        this.passport = passport;
        this.city = city;
        this.age = age;
        this.application = application;
        this.department = department;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Application> getApplication() {
        return application;
    }

    public void setApplication(List<Application> application) {
        this.application = application;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(education, client.education) &&
                Objects.equals(passport, client.passport) &&
                Objects.equals(city, client.city) &&
                Objects.equals(age, client.age) &&
                Objects.equals(application, client.application) &&
                Objects.equals(department, client.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, firstName, lastName, education, passport, city, age, application, department);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", education='" + education + '\'' +
                ", passport='" + passport + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", application=" + application +
                ", department=" + department +
                '}';
    }
}
