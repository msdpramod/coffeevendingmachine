package urban.coffeevendingmachine.configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import urban.coffeevendingmachine.DTOs.ItemDTO;
import urban.coffeevendingmachine.DTOs.TransactionDTO;

@Component
public class VendingMachineClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/vendingMachine";

    @Autowired
    public VendingMachineClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String addItem(ItemDTO itemDTO) {
        return restTemplate.postForObject(baseUrl + "/addItem", itemDTO, String.class);
    }

    public TransactionDTO buyItem(String itemName, int cashInserted) {
        return restTemplate.postForObject(baseUrl + "/buyItem?itemName=" + itemName + "&cashInserted=" + cashInserted, null, TransactionDTO.class);
    }
}
