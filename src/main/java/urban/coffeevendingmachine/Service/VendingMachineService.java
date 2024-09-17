package urban.coffeevendingmachine.Service;


import urban.coffeevendingmachine.DTOs.ItemDTO;
import urban.coffeevendingmachine.DTOs.TransactionDTO;

public interface VendingMachineService {
    String addItem(ItemDTO itemDTO);
    TransactionDTO buyItem(String itemName, int cashInserted);
}