package gsa.webland.ecommercex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gsa.webland.ecommercex.model.Product;

public interface ProductRepository  extends JpaRepository<Product,Long>{

    
}