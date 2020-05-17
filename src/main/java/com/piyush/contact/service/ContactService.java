/**
 * 
 */
package com.piyush.contact.service;

import java.util.List;

import com.piyush.contact.entity.ContactEntity;
import com.piyush.contact.model.ContactRequest;

/**
 * This service interface define the operations to be performed for contact
 * Information
 * 
 * @author PIYUSH ANJIKAR
 * 
 */
public interface ContactService {

	/**
	 * Get List of contact
	 * 
	 * @return List<ContactEntity>
	 */
	public List<ContactEntity> getContacts();

	/**
	 * Add new contact
	 * 
	 * @param contactRequest
	 * @return ContactEntity
	 */
	public ContactEntity addContact(ContactRequest contactRequest);

	/**
	 * update details for contact
	 * 
	 * @param contactId
	 * @param contactRequest
	 * @return ContactEntity
	 */
	public ContactEntity updateContact(Long contactId, ContactRequest contactRequest);

	/**
	 * delete contact by contactId
	 * 
	 * @param contactId
	 * @return
	 */
	public boolean deleteContact(Long contactId);

}
