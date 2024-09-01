package gsa.webland.ecommercex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gsa.webland.ecommercex.model.Orders;
import gsa.webland.ecommercex.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    OrderService ordersService;

    @GetMapping
    public List<Orders> getAllOrderss() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable Long id) {
        Orders Orders = ordersService.getOrdersById(id);
        return ResponseEntity.ok(Orders);
    }

    @PostMapping
    public ResponseEntity<Orders> saveOrders(@RequestBody Orders Orders) {
        Orders newOrders = ordersService.saveOrders(Orders);
        return ResponseEntity.ok(newOrders);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Orders> updateOrders(@PathVariable Long id, @RequestBody Orders Orders) {
        Orders OrdersToUpdate = ordersService.updateOrders(id, Orders);
        return ResponseEntity.ok(OrdersToUpdate);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
        return ResponseEntity.noContent().build();
    }

}
