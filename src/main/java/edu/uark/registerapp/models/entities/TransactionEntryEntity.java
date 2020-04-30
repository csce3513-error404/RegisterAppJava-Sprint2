package edu.uark.registerapp.models.entities;

import edu.uark.registerapp.models.api.TransactionEntry;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="transactionEntry")
public class TransactionEntryEntity {
	@Id
	@Column(name="id", updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private final UUID id;
	
	public UUID getId() {
		return this.id;
	}
	
	
	@Column(name="transaction_Id")
	private UUID transactionId;
	
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionEntryEntity setTransactionId(final UUID transactionId) {
		this.transactionId =transactionId;
		return this;
	}
	
	
	@Column(name="product_Id")
	private UUID productId;
	
	public UUID getProductId() {
		return this.productId;
	}
	public TransactionEntryEntity setProductId(final UUID productId) {
		this.productId = productId;
		return this;
	}
	
	
	@Column(name="quantity")
	private int quantity;
	
	public int getQuantity() {
		return this.quantity;
	}
	public TransactionEntryEntity setQuantity(final int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	
	@Column(name="price")
	private int price;
	
	public int getPrice() {
		return this.price;
	}
	public TransactionEntryEntity setPrice(final int price) {
		this.quantity = quantity;
		return this;
	}
	
	
	public TransactionEntryEntity() {
		this.id = new UUID(0, 0);
		this.transactionId = new UUID(0, 0);
		this.productId = new UUID(0, 0);
		this.quantity = 0;
		this.price = 0;
	}
	
	public TransactionEntryEntity(final UUID transactionId, final UUID productId, final int quantity, final int price) {
		this.id = new UUID(0, 0);
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
}
