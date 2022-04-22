package com.ssafy.example.repository;

import com.ssafy.example.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepository {

    private final EntityManager em;

    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    public String save(Customer customer) {
        em.persist(customer);
        return customer.getId();
    }

    public Customer findById(String id) {
        try {
            return em.find(Customer.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Customer> findByIdContaining(String id) {
        return em.createQuery("select c from Customer c where c.id like :id")
                .setParameter("id", "%"+id+"%")
                .getResultList();
    }
}
