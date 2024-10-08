package com.easybytes.eazyschool.service;

import com.easybytes.eazyschool.constants.EazySchoolConstants;
import com.easybytes.eazyschool.model.Contact;
import com.easybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
    boolean isSaved = false;
    contact.setStatus(EazySchoolConstants.OPEN);

    Contact savedContact = contactRepository.save(contact);
    if(savedContact != null && savedContact.getContactId()>0)
    {
        isSaved= true;
    }
    return isSaved;
}


    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatusWithQuery(
                EazySchoolConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatusNative(EazySchoolConstants.CLOSE,contactId);
        if(rows > 0) {
            isUpdated = true;
        }
        return isUpdated;

    }}


