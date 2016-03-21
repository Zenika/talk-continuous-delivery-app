package startup.business;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by poussma on 03/03/16.
 */
@Entity
@NamedQuery(name = "Message.getLatestMessageId", query = "select max(id) from Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "the_date")
    private String date;

    // add-column: uncomment following lines
    // @Column(name = "dateAsDate")
    // private Date dateAsDate;

    private String owner;

    private String message;

    public Message() {
        // void
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // add-column: uncomment following lines
    // public Date getDateAsDate() {
    //     return dateAsDate;
    // }

    // public void setDateAsDate(Date dateAsDate) {
    //     this.dateAsDate = dateAsDate;
    // }
}
