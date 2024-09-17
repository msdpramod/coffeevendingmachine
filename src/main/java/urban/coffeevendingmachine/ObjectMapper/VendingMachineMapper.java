// src/main/java/urban/coffeevendingmachine/ObjectMapper/VendingMachineMapper.java
package urban.coffeevendingmachine.ObjectMapper;

import org.springframework.stereotype.Component;
import urban.coffeevendingmachine.DTOs.ItemDTO;
import urban.coffeevendingmachine.DTOs.TransactionDTO;
import urban.coffeevendingmachine.Models.Item;
import urban.coffeevendingmachine.Models.Transaction;

@Component
public class VendingMachineMapper {

    public Item convertToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());
        return item;
    }

    public ItemDTO convertToDto(Item item) {
        return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getQuantity());
    }

    public TransactionDTO convertToDto(Transaction transaction, Item item) {
        return new TransactionDTO(transaction.getId(), item.getName(), transaction.getInsertedCash(), transaction.getStatus());
    }
}