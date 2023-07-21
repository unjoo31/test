package shop.mtcoding.test.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import({
        ProductRepository.class,
        SellerRepository.class
})
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Test
    public void findAll_test(){
        productRepository.save("사과", 1000, 40);
        productRepository.save("호박", 1000, 40);
        List<Product> productList = productRepository.findAll();
        for(Product product : productList){
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQty());
            System.out.println("------------------");
        }
    }

    @Test
    public void findById_test(){
        productRepository.save("바나나", 2000, 40);
        Product product = productRepository.findById(1);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
    }

    @Test
    public void findByIdDTO_test(){
        productRepository.save("바나나", 2000, 40);
        ProductDTO productDTO = productRepository.findByIdDTO(1);
        System.out.println(productDTO.getId());
        System.out.println(productDTO.getName());
        System.out.println(productDTO.getPrice());
        System.out.println(productDTO.getQty());
        System.out.println(productDTO.getDes());
    }

    @Test
    public void findByIdJoinSeller_test(){
        sellerRepository.save("홍길동", "ssar@nate.com");
        productRepository.saveWithFK("바나나", 3000,40, 1);
        Product product = productRepository.findByIdJoinSeller(1);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        System.out.println("-----------" + product.getSeller().getId());
        System.out.println("-----------" + product.getSeller().getName());
        System.out.println("-----------" + product.getSeller().getEmail());
    }

}
