package urban.coffeevendingmachine.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int quantity;

    // Constructors
    public ItemDTO() {}

    public ItemDTO(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    // Optionally add toString(), equals(), and hashCode()
}
