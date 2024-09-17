package urban.coffeevendingmachine.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TransactionDTO {
    private Long transactionId;
    private String itemName;
    private int cashInserted;
    private String status;

    // Constructors
    public TransactionDTO() {}

    public TransactionDTO(Long transactionId, String itemName, int cashInserted, String status) {
        this.transactionId = transactionId;
        this.itemName = itemName;
        this.cashInserted = cashInserted;
        this.status = status;
    }

    // Getters and Setters
}

