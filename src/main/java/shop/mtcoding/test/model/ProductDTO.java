package shop.mtcoding.test.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private String des;

    @Builder
    public ProductDTO(Integer id, String name, Integer price, Integer qty, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.des = des;
    }
}
