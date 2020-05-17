package com.piyush.contact.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piyush.contact.entity.ContactEntity;

/**
 * Repository to fetch data from ContactEntity
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

	List<ContactEntity> findAllByStatus(String status);

	boolean existsByContactIdAndStatus(Long contactId, String status);

	Optional<ContactEntity> findByEmail(String email);

	Optional<ContactEntity> findByContactId(Long contactId);

}