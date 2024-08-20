package com.easybytes.eazyschool.service;

import com.easybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact){
    boolean isSaved = true;
    log.info(contact.toString());
    return isSaved;
}
}
