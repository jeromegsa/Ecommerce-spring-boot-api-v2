package gsa.webland.ecommercex.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Orders {

    @ManyToOne()
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem;

    @Id
    @GeneratedValue
    private Long id;
    private Double total_amount;
    private String status;
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
