package com.piyush.contact;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.piyush.contact.entity.ContactEntity;
import com.piyush.contact.model.ContactRequest;
import com.piyush.contact.repository.ContactRepository;
import com.piyush.contact.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ContactInformationApplicationTests {

	@Autowired
	private ContactService contactService;

	@MockBean
	private ContactRepository contactRepository;

	@Test
	public void testGetContacts() {
		when(contactRepository.findAllByStatus("Active")).thenReturn(
				Stream.of(new ContactEntity(new Long(1), "John", "Marsh", "john@gmail.com", "1234567890", "Active"))
						.collect(Collectors.toList()));
		assertEquals(1, contactService.getContacts().size());
	}

	@Test
	public void testSaveContact() {
		ContactRequest contactRequest = new ContactRequest("John", "Marsh", "john@gmail.com", "1234567890");
		ContactEntity contatEntity = new ContactEntity(null, "John", "Marsh", "john@gmail.com", "1234567890", "Active");
		ContactEntity contatEntitySaved = new ContactEntity(Long.valueOf(1), "John", "Marsh", "john@gmail.com", "1234567890", "Active");
		when(contactRepository.save(contatEntity)).thenReturn(contatEntitySaved);
		assertEquals(contatEntitySaved, contactService.addContact(contactRequest));
	}

	@Test
	public void testUpdateContact() {
		ContactRequest contactRequest = new ContactRequest("John", "Marsh", "john@gmail.com", "1234567890");
		ContactEntity contatEntity = new ContactEntity(Long.valueOf(1), "John", "Marsh", "john@gmail.com", "1234567890", "Active");
		when(contactRepository.save(contatEntity)).thenReturn(contatEntity);
		when(contactRepository.existsByContactIdAndStatus(Long.valueOf(1), "Active")).thenReturn(true);
		assertEquals(contatEntity, contactService.updateContact(Long.valueOf(1), contactRequest));
	}

}
