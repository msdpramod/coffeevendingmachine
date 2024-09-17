package urban.coffeevendingmachine.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urban.coffeevendingmachine.DTOs.ItemDTO;
import urban.coffeevendingmachine.DTOs.TransactionDTO;
import urban.coffeevendingmachine.ObjectMapper.VendingMachineMapper;
import urban.coffeevendingmachine.Repositories.ItemRepository;
import urban.coffeevendingmachine.Repositories.TransactionRepository;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    private final ItemRepository itemRepository;
    private final TransactionRepository transactionRepository;
    private final VendingMachineMapper vendingMachineMapper;
    private final TransactionProcessor transactionProcessor;

    @Autowired
    public VendingMachineServiceImpl(ItemRepository itemRepository, TransactionRepository transactionRepository, VendingMachineMapper vendingMachineMapper) {
        this.itemRepository = itemRepository;
        this.transactionRepository = transactionRepository;
        this.vendingMachineMapper = vendingMachineMapper;
        this.transactionProcessor = new TransactionProcessor(itemRepository, transactionRepository, vendingMachineMapper);
    }

    @Override
    public String addItem(ItemDTO itemDTO) {
        itemRepository.save(vendingMachineMapper.convertToEntity(itemDTO));
        return "Item added successfully!";
    }

    @Override
    public TransactionDTO buyItem(String itemName, int cashInserted) {
        return transactionProcessor.processTransaction(itemName, cashInserted);
    }
}