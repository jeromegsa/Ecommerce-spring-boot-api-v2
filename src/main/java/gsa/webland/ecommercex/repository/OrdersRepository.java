package gsa.webland.ecommercex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gsa.webland.ecommercex.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    
}
