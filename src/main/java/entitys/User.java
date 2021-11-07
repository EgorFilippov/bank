package entitys;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
@JsonPropertyOrder( { "id" , "login" })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "login")
    private String login;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public User() {
    }

    public User(String login) {
        this.login = login;
        accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public void setAccount(Account account) {
        account.setUser(this);
        accounts.add(account);

    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + login + '\'' +
                '}';
    }
}