package com.jdc.spring.demo;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Profile {
	
	@Id
	private Integer id;
	
	@Nonnull
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Account account;
	
	@Nonnull
	private LocalDate dob;
	private String image;
	private String description;

	@Version
	private int version;

}
