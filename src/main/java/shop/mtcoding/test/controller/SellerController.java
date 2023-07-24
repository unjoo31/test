package shop.mtcoding.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.test.model.Seller;
import shop.mtcoding.test.model.SellerRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping("/seller")
    public String sellerList(HttpServletRequest request){
        List<Seller> sellerList = sellerRepository.findAll();
        request.setAttribute("sellerList", sellerList);
        return "seller";
    }

    @GetMapping("/seller/write")
    public String sellerWrite(){
        return "sellerWrite";
    }

    @PostMapping("/seller/writer")
    public String write(String name, String email){
        sellerRepository.save(name, email);
        return "redirect:/seller";
    }

    @GetMapping("/seller/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request){
        Seller seller = sellerRepository.findById(id);
        request.setAttribute("s", seller);
        return "sellerDetail";
    }

    @PostMapping("/seller/delete")
    public String delete(int id){
        sellerRepository.deleteById(id);
        return "redirect:/seller";
    }

    @PostMapping("/seller/update")
    public String update(String name, String email){
        sellerRepository.update(name, email);
        return "redirect:/seller";
    }
}
