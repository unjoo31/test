package shop.mtcoding.test.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SellerRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public void save(String name, String email){
        Query query = em.createNativeQuery("insert into seller_tb(name, email) values(:name, :email)");
        query.setParameter("name", name);
        query.setParameter("email", email);
        query.executeUpdate();
    }

    public List<Seller> findAll(){
        Query query = em.createNativeQuery("select * from seller_tb", Seller.class);
        List<Seller> sellerList = query.getResultList();
        return sellerList;
    }

    public Seller findById(int id){
        Query query = em.createNativeQuery("select * from seller_tb where id = :id", Seller.class);
        query.setParameter("id", id);
        Seller seller = (Seller) query.getSingleResult();
        return seller;
    }

    @Transactional
    public void deleteById(int id){
        Query query = em.createNativeQuery("delete from seller_tb where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void update(String name, String email){
        Query query = em.createNativeQuery("update seller_tb set email = :email where name = :name");
        query.setParameter("name", name);
        query.setParameter("email", email);
        query.executeUpdate();
    }
}
