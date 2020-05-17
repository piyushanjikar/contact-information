package com.piyush.contact.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.contact.constants.ResponseMessages;
import com.piyush.contact.entity.ContactEntity;
import com.piyush.contact.model.ContactRequest;
import com.piyush.contact.model.ResponseSuccess;
import com.piyush.contact.service.ContactService;

import lombok.extern.slf4j.Slf4j;

/**
 * This Controller has functionality to operate on Contact Information
 * 
 * @author PIYUSH ANJIKAR
 * 
 */
@RestController
@RequestMapping("contact")
@Slf4j
public class ContactController {

	@Autowired
	private ContactService contactService;

	/**
	 * Get list of all active contacts
	 * 
	 * @return ResponseEntity<List<ContactEntity>>
	 */
	@GetMapping("list")
	public ResponseEntity<List<ContactEntity>> getContacts() {
		log.trace("Requesting list of contacts");
		return ResponseEntity.ok(contactService.getContacts());
	}

	/**
	 * Add new contact
	 * 
	 * @param contactRequest
	 * @return ResponseEntity<ResponseSuccess>
	 */
	@PostMapping("add")
	public ResponseEntity<ResponseSuccess> addContact(@RequestBody @Valid ContactRequest contactRequest) {
		log.trace("Request to Create new contact");
		contactService.addContact(contactRequest);
		ResponseSuccess responseSuccess = new ResponseSuccess(HttpStatus.CREATED, ResponseMessages.ENTITY_CREATED);
		log.trace("New contact created");
		return ResponseEntity.status(HttpStatus.CREATED).body(responseSuccess);
	}

	/**
	 * Update existing contact
	 * 
	 * @param contactId
	 * @param contactRequest
	 * @return ResponseEntity<ContactEntity>
	 */
	@PutMapping("update/{contactId}")
	public ResponseEntity<ContactEntity> updateContact(@PathVariable("contactId") final Long contactId,
			@RequestBody @Valid ContactRequest contactRequest) {
		log.trace("Request to update contact : " + contactId);
		ContactEntity responseEntity = contactService.updateContact(contactId, contactRequest);
		log.trace("Updated contact for contactId : " + contactId);
		return ResponseEntity.status(HttpStatus.OK).body(responseEntity);
	}

	/**
	 * Delete existing contact
	 * 
	 * @param contactId
	 * @return ResponseEntity<ResponseSuccess>
	 */
	@RequestMapping(path = "delete/{contactId}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseSuccess> deActivate(@PathVariable("contactId") final Long contactId) {
		log.trace("Request to delete contact : " + contactId);
		contactService.deleteContact(contactId);
		ResponseSuccess responseSuccess = new ResponseSuccess(HttpStatus.OK, ResponseMessages.ENTITY_DELETED);
		log.trace("Delete contact : " + contactId);
		return ResponseEntity.status(HttpStatus.OK).body(responseSuccess);
	}
}
