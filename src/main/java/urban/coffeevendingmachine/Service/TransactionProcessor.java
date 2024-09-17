package urban.coffeevendingmachine.Service;

import urban.coffeevendingmachine.DTOs.TransactionDTO;
import urban.coffeevendingmachine.Exceptions.InsufficientFundsException;
import urban.coffeevendingmachine.Exceptions.ItemNotFoundException;
import urban.coffeevendingmachine.Exceptions.OutOfStockException;
import urban.coffeevendingmachine.Models.Item;
import urban.coffeevendingmachine.Models.Transaction;
import urban.coffeevendingmachine.ObjectMapper.VendingMachineMapper;
import urban.coffeevendingmachine.Repositories.ItemRepository;
import urban.coffeevendingmachine.Repositories.TransactionRepository;

import java.util.Optional;

public class TransactionProcessor {

    private final ItemRepository itemRepository;
    private final TransactionRepository transactionRepository;
    private final VendingMachineMapper vendingMachineMapper;

    public TransactionProcessor(ItemRepository itemRepository, TransactionRepository transactionRepository, VendingMachineMapper vendingMachineMapper) {
        this.itemRepository = itemRepository;
        this.transactionRepository = transactionRepository;
        this.vendingMachineMapper = vendingMachineMapper;
    }

    public TransactionDTO processTransaction(String itemName, int cashInserted) {
        Optional<Item> optionalItem = itemRepository.findByName(itemName);
        if (optionalItem.isEmpty()) {
            throw new ItemNotFoundException("Item not found");
        }
        Item item = optionalItem.get();

        if (item.getPrice() > cashInserted) {
            throw new InsufficientFundsException("Insufficient cash inserted");
        }
        if (item.getQuantity() == 0) {
            throw new OutOfStockException("Item out of stock");
        }

        // Process transaction
        item.setQuantity(item.getQuantity() - 1);
        itemRepository.save(item);

        Transaction transaction = new Transaction();
        transaction.setItemId(item.getId().intValue());
        transaction.setInsertedCash(cashInserted);
        transaction.setStatus("Success");
        transactionRepository.save(transaction);

        return vendingMachineMapper.convertToDto(transaction, item);
    }
}
