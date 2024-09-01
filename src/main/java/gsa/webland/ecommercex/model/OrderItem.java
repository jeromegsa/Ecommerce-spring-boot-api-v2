package gsa.webland.ecommercex.model;

import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="orderItems")
public class OrderItem {
    @ManyToOne()
    @JoinColumn(name="orders_id")
    private Orders order;

    @ManyToOne()
    @JoinColumn(name="produit_id")
    private Product product;
    
    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;
    private Integer price;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    

    @PrePersist
    protected void setCreatedDate(){
        this.updated_At=LocalDateTime.now();
        this.created_At=LocalDateTime.now();

    }
    @PreUpdate
    protected void setUpdatedDate(){
        this.updated_At=LocalDateTime.now();
    }
}
