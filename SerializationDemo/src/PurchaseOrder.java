
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseOrder implements Serializable {

    public PurchaseOrder(String orderId, double price, int qty, String company) {
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
        this.company = company;
    }

    private String orderId;
    private String company;
    private int qty;
    transient private double price;
}