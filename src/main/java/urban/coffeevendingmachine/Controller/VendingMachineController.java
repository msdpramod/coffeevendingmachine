// src/main/java/urban/coffeevendingmachine/Controller/VendingMachineController.java
package urban.coffeevendingmachine.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urban.coffeevendingmachine.DTOs.ItemDTO;
import urban.coffeevendingmachine.DTOs.TransactionDTO;
import urban.coffeevendingmachine.Service.VendingMachineService;

@RestController
@RequestMapping("/vendingMachine")
public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    @Autowired
    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(vendingMachineService.addItem(itemDTO));
    }

    @PostMapping("/buyItem")
    public ResponseEntity<TransactionDTO> buyItem(@RequestParam String itemName, @RequestParam int cashInserted) {
        return ResponseEntity.ok(vendingMachineService.buyItem(itemName, cashInserted));
    }
}