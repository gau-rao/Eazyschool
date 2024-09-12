package com.easybytes.eazyschool.repository;


import com.easybytes.eazyschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface  ContactRepository  extends CrudRepository<Contact, Integer> {

List<Contact> findByStatus(String Status);

    Page<Contact> findByStatus(String status, Pageable pageable);

}
