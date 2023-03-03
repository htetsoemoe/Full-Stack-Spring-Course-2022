package com.jdc.spring.demo;

import java.util.Map;

import com.jdc.spring.demo.Address.Type;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	
	@Column(nullable = false)
	@Nonnull
	private String name;
	
	@Column(nullable = false)
	@Nonnull
	private String email;
	
	@Column(nullable = false)
	@Nonnull
	private String password;
	
	@Column(nullable = false)
	@Nonnull
	private Role role;
	
	@OneToOne(mappedBy = "account")
	private Profile profile;
	
	@OneToMany
	@MapKeyEnumerated
	@MapKeyColumn(name = "address_type")
	private Map<Type, Address> address;
	
	@Version
	private Integer version;
	
	public enum Role {
		Admin, Member
	}

}
