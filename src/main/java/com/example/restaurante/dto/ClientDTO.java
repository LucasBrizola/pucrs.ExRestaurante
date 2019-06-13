package com.example.restaurante.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class ClientDTO {

	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotNull
	@NotEmpty
	private int age;

	@NotNull
	@NotEmpty
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
