package com.devsuperior.dscommerce.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
		private Instant moment;
		
		@Enumerated(EnumType.ORDINAL)
		private OrderStatus status;
		
		@ManyToOne
		@JoinColumn(name = "client_id")
		private User client;

		@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
		private Payment payment;
		
		@OneToMany(mappedBy = "id.order")
		private Set<OrderItem> items = new HashSet<>();
		
		
		public Order() {
			
		}

		public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
			this.id = id;
			this.moment = moment;
			this.status = status;
			this.client = client;
			this.payment = payment;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Instant getMoment() {
			return moment;
		}

		public void setMoment(Instant moment) {
			this.moment = moment;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public User getClient() {
			return client;
		}

		public void setClient(User client) {
			this.client = client;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public Set<OrderItem> getItems() {
			return items;
		}	
		
		public List<Product> getProduct() {
			return items.stream().map(x -> x.getProduct()).toList();
		}
		
		
}
