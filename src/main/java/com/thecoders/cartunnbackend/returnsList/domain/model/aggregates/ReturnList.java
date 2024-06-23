package com.thecoders.cartunnbackend.returnsList.domain.model.aggregates;
import com.thecoders.cartunnbackend.payment.domain.model.aggregates.Cart;
import com.thecoders.cartunnbackend.returnsList.domain.model.commands.CreateReturnListCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "return_list")
public class ReturnList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "return_date", nullable = false)
    private String returnDate;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "image", nullable = false)
    private String image;

    //@ManyToMany(mappedBy = "assignedStatus")
    //private Set<Payment> paymentSet = new HashSet<>();


    public ReturnList(){
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.returnDate = Strings.EMPTY;
        this.status = Strings.EMPTY;
        this.image = Strings.EMPTY;
    }

    public ReturnList(String title,String description,String returnDate, String status, String image){
        this();
        this.title = title;
        this.description = description;
        this.returnDate = returnDate;
        this.status = status;
        this.image = image;
    }

    public ReturnList(CreateReturnListCommand command){
        this();
        this.title = command.title();
        this.description = command.description();
        this.returnDate = command.returnDate();
        this.description = command.description();
        this.image = command.image();
    }

    public ReturnList updateInformation(String title, String description,String returnDate, String status, String image){
        this.title = title;
        this.description = description;
        this.returnDate = returnDate;
        this.status = status;
        this.image = image;
        return this;
    }
}
