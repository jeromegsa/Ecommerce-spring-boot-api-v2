package gsa.webland.ecommercex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gsa.webland.ecommercex.model.Orders;
import gsa.webland.ecommercex.repository.OrdersRepository;

@Service
public class OrderService {
    
      @Autowired
    OrdersRepository ordersRepository;
    
    public List<Orders> getAllOrders(){
        return  ordersRepository.findAll();
    }

    public Orders  getOrdersById (Long id){
        Orders order=ordersRepository.findById(id)
        .orElseThrow(
            ()->new  RuntimeException("Aucun Orders trouvé")
        );
        return order;
    }

    public  Orders saveOrders(Orders orders){
        Orders newOrders=  ordersRepository.save(orders);
        return newOrders;
        
    }

    public Orders updateOrders(Long id, Orders orders){
        Orders ordersToUpdate=ordersRepository.findById(id)
        .orElseThrow(
            ()->  new RuntimeException("Orders inexistant")
        );
       ordersToUpdate.setStatus(orders.getStatus());
       ordersToUpdate.setTotal_amount(orders.getTotal_amount());       

        return ordersRepository.save(ordersToUpdate);

    }

    public void  deleteOrders(Long id){
        ordersRepository.deleteById(id);
    }
    
}
