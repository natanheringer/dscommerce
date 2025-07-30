package com.devsuperior.dscommerce.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		private String email;
		private String phone;
		private LocalDate birthDate;
		private String password;
		
		
		public User() {}
		
		/*
		 * client can have many lists = one to many 
		 */
		@OneToMany(mappedBy = "client")
		private List<Order> order = new ArrayList<>();


		public User(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
	
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.birthDate = birthDate;
			this.password = password;
			
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public LocalDate getBirthDate() {
			return birthDate;
		}


		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		@Override
		public int hashCode() {
			return Objects.hash(id, name, birthDate, phone, password);
		}

		
		
		

		public List<Order> getOrder() {
			return order;
		}


		public void setOrder(List<Order> order) {
			this.order = order;
		}


		
		
		
		
}
