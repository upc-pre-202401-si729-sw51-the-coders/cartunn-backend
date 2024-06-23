package com.thecoders.cartunnbackend.productRefunds.domain.model.aggregates;


import com.thecoders.cartunnbackend.productRefunds.domain.model.commands.CreateProductRefundCommand;
import com.thecoders.cartunnbackend.profiles.domain.model.aggregates.Profile;
import com.thecoders.cartunnbackend.profiles.domain.model.commands.CreateProfileCommand;
import com.thecoders.cartunnbackend.purchasing.domain.model.aggregates.Order;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
@Table(name = "product_refunds")

public class ProductRefund {

    @Getter
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private String status;


    public ProductRefund(){
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.status = Strings.EMPTY;
    }

    public ProductRefund(Order order,String title,String description, String status){
        this();
        this.order = order;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public ProductRefund(CreateProductRefundCommand command, Order order){
        this(order, command.title(), command.description(), command.status());
    }

    public ProductRefund updateInformation(String title, String description, String status){
        this.title = title;
        this.description = description;
        this.status = status;
        return this;
    }

}
