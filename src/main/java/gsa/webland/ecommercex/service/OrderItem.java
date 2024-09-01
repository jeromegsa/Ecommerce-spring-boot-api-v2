// package gsa.webland.ecommercex.service;

// @Service
// public class OrderItem {
      
//     @Autowired
//     OrderItemRepository OrderItemRepository;
    
//     public List<OrderItem> getAllOrderItem(){
//         return  OrderItemRepository.findAll();
//     }

//     public OrderItem  getOrderItemById (Long id){
//         OrderItem orderItem=OrderItemRepository.findById(id)
//         .orElseThrow(
//             ()->new  RuntimeException("Aucun OrderItem trouvé")
//         );
//         return orderItem;
//     }

//     public  OrderItem saveOrderItem(OrderItem OrderItem){
//         OrderItem newOrderItem=  OrderItemRepository.save(OrderItem);
//         return newOrderItem;
        
//     }

//     public OrderItem updateOrderItem(Long id, OrderItem OrderItem){
//         OrderItem OrderItemToUpdate=OrderItemRepository.findById(id)
//         .orElseThrow(
//             ()->  new RuntimeException("OrderItem inexistant")
//         );
//        OrderItemToUpdate.set
//        OrderItemToUpdate  

//         return OrderItemRepository.save(OrderItemToUpdate);

//     }

//     public void  deleteOrderItem(Long id){
//         OrderItemRepository.deleteById(id);
//     }
    
// }
