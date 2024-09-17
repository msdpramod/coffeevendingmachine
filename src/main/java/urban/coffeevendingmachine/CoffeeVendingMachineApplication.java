package urban.coffeevendingmachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import urban.coffeevendingmachine.DTOs.ItemDTO;
import urban.coffeevendingmachine.DTOs.TransactionDTO;
import urban.coffeevendingmachine.configurations.VendingMachineClient;

@SpringBootApplication
public class CoffeeVendingMachineApplication implements CommandLineRunner {


    @Autowired
    private VendingMachineClient vendingMachineClient;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeVendingMachineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add an item
        ItemDTO itemDTO = new ItemDTO(null, "Coffee", 100, 10);
        String addItemResponse = vendingMachineClient.addItem(itemDTO);
        System.out.println(addItemResponse);

        // Buy an item
        TransactionDTO transactionDTO = vendingMachineClient.buyItem("Coffee", 100);
        System.out.println("Transaction Status: " + transactionDTO.getStatus());
    }

}
