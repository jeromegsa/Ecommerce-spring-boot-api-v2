package gsa.webland.ecommercex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gsa.webland.ecommercex.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
