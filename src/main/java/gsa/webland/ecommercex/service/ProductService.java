package gsa.webland.ecommercex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gsa.webland.ecommercex.model.Product;
import gsa.webland.ecommercex.repository.ProductRepository;

@Service
public class ProductService {

     @Autowired
    ProductRepository productRepository;
    
    public List<Product> getAllProduct(){
        return  productRepository.findAll();
    }

    public Product  getProductById (Long id){
        Product Product=productRepository.findById(id)
        .orElseThrow(
            ()->new  RuntimeException("Aucun Product trouvé")
        );
        return Product;
    }

    public  Product saveProduct(Product product){
        Product newProduct=  productRepository.save(product);
        
        return newProduct;
        
    }

    public Product updateProduct(Long id, Product product){
        Product productToUpdate=productRepository.findById(id)
        .orElseThrow(
            ()->  new RuntimeException("Product inexistant")
        );
       
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());

        return productRepository.save(productToUpdate);

    }

    public void  deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    
}
