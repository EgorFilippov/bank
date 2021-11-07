package entitys;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "accounts")
@JsonPropertyOrder( { "id" , "accountNumber", "balance" })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column (name = "ACCOUNT_NUMBER")
    private long accountNumber;

    @Column
    private long balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Card> cards;


    public User getUser() {
        return user;
    }

    public Account() {
        this.accountNumber = (long) (Math.random() * 1000000000000000L);
        this.balance = (long) (Math.random() * 100000L);
        cards = new ArrayList<>();
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCard(Card card) {
        card.setAccount(this);
        cards.add(card);
    }

    @Override
    public String toString() {
        return "models.Account{id=" + accountNumber + "}";
    }


}
