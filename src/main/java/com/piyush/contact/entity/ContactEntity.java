package com.piyush.contact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This entity has been mapped to contact table
 * @author PIYUSH ANJIKAR
 *
 */
@Entity
@Table(name = "contact")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long contactId;

	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	private String lastName;

	@NotNull
	private String email;

	@Column(name = "phone_number")
	@NotNull
	private String phoneNumber;

	@ColumnDefault(value = "ACTIVE")
	private String status;

}
