package shop.mtcoding.test.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.test.model.Product;
import shop.mtcoding.test.model.ProductRepository;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("product/delete")
    public String delete(int id){
        productRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("product/update")
    public String update(String name, int price, int qty){
        productRepository.update(name, price, qty);
        return "redirect:/";
    }

    @GetMapping("product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request){
        Product product = productRepository.findById(id);
        request.setAttribute("p", product);
        return "detail";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request){
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/write")
    public String writePage(){
        return "write";
    }

    @PostMapping("/product")
    public String write(String name, int price, int qty){
        System.out.println("name : " + name);
        System.out.println("price : " + price);
        System.out.println("qty : " + qty);
        productRepository.save(name,price,qty);
        return "redirect:/";
    }
}
