package entitys;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@JsonPropertyOrder( { "id" , "cardNumber", "expiredDate" })
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name= "CARD_NUMBER", unique = true)
    private long cardNumber;

    @Column
    private int expiredDate;

    @Column(name = "CARD_STATUS")
    private String status;

    @ManyToOne()
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Card(Account account) {
        this.expiredDate = 2025;
        this.cardNumber = (long) (Math.random() * 1000000000000000L);
        this.account = account;
        this.status = "Active";
    }

    public Card() {
    }

    public long getExpiredDate() {
        return expiredDate;
    }

    public Long getId() {
        return id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "models.Card{id=" + id + "}";
    }

}
