/**
 * 
 */
package com.piyush.contact.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.contact.constants.ContactStatus;
import com.piyush.contact.constants.ResponseMessages;
import com.piyush.contact.entity.ContactEntity;
import com.piyush.contact.exception.DuplicateEntityException;
import com.piyush.contact.exception.EntityNotFoundException;
import com.piyush.contact.model.ContactRequest;
import com.piyush.contact.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This class implements ContactService interface in order to perform define
 * operation for contact
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<ContactEntity> getContacts() {
		return contactRepository.findAllByStatus(ContactStatus.ACTIVE.getStatus());
	}

	@Override
	public ContactEntity addContact(ContactRequest contactRequest) {
		boolean isContactExist = contactRepository.findByEmail(contactRequest.getEmail()).isPresent();

		if (isContactExist) {
			log.error("Contact already exist for email : " + contactRequest.getEmail());
			throw new DuplicateEntityException(ResponseMessages.DUPLICATE_CONTACT, contactRequest.getEmail());
		}

		ContactEntity contactEntity = new ContactEntity();
		contactEntity.setFirstName(contactRequest.getFirstName());
		contactEntity.setLastName(contactRequest.getLastName());
		contactEntity.setEmail(contactRequest.getEmail());
		contactEntity.setPhoneNumber(contactRequest.getPhoneNumber());
		contactEntity.setStatus(ContactStatus.ACTIVE.getStatus());
		return contactRepository.save(contactEntity);
	}

	@Override
	public ContactEntity updateContact(Long contactId, ContactRequest contactRequest) {

		boolean isContactExist = contactRepository.existsByContactIdAndStatus(contactId,
				ContactStatus.ACTIVE.getStatus());
		if (isContactExist) {
			ContactEntity contactEntity = new ContactEntity();
			contactEntity.setContactId(contactId);
			contactEntity.setFirstName(contactRequest.getFirstName());
			contactEntity.setLastName(contactRequest.getLastName());
			contactEntity.setEmail(contactRequest.getEmail());
			contactEntity.setPhoneNumber(contactRequest.getPhoneNumber());
			contactEntity.setStatus(ContactStatus.ACTIVE.getStatus());
			return contactRepository.save(contactEntity);
		} else {
			log.error("Contact does not exist for Contact Id : " + contactId);
			throw new EntityNotFoundException(ResponseMessages.ENTITY_NOT_FOUND, contactId);
		}
	}

	@Override
	public boolean deleteContact(Long contactId) {
		ContactEntity contactEntity = contactRepository.findByContactId(contactId)
				.orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ENTITY_NOT_FOUND, contactId));
		contactEntity.setStatus(ContactStatus.INACTIVE.getStatus());
		contactRepository.save(contactEntity);
		return true;
	}
}
