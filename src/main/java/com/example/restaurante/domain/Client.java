package com.example.restaurante.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Integer id;

	@NotNull(message = "name can't be null")
	@NotEmpty(message = "name can't be empty")
	private String name;

	@NotNull(message = "cpf can't be null")
	@NotEmpty(message = "cpf can't be empty")
	private String cpf;

	@NotNull(message = "cpf can't be null")
	@NotEmpty(message = "cpf can't be empty")
	private int age;

	@NotNull(message = "cpf can't be null")
	@NotEmpty(message = "cpf can't be empty")
	private String gender;

	public Client(String name, String cpf, int age, String gender) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.gender = gender;
	}

	public Client(Integer id, String name, String cpf, int age, String gender) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
