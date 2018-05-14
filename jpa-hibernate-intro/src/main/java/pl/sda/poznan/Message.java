package pl.sda.poznan;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "messages_table")
public class Message {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //nie tworzy tabeli sequence
    private Long id;

    @Column(name = "message", unique = true)
    private String text;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
