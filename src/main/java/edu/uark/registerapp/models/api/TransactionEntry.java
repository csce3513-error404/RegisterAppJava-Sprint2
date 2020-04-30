package edu.uark.registerapp.models.api;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
public class TransactionEntry extends ApiResponse {
	private UUID id;
	private UUID transactionId;
	private UUID productId;
	private int quantity;
	private int price;
	private String dateCreated;

	public TransactionEntry() {
		super();

		this.id = new UUID(0, 0);
		this.transactionId = new UUID(0, 0);
		this.productId = new UUID(0, 0);
		this.quantity = 0;
		this.price = 0;
		this.dateCreated(LocalDateTime.now());
	}

	public TransactionEntry(final TransactionEntryEntity transactionEntryEntity) {
		super(false);

		this.id = transactionEntryEntity.getId();
		this.transactionId = transactionEntryEntity.getTransactionId();
		this.productId = transactionEntryEntity.getProductId();
		this.quanitity = transactionEntryEntity.getQuantity();
		this.price = transactionEntryEntity.getPrice();
		this.dateCreated(transactionEntryEntity.getDateCreated());
	}

	public UUID getId() {
		return this.id;
	}

	public TransactionEntry setId(final UUID id) {
		this.id = id;
		return this;
	}

	public UUID getTransactionId() {
		return this.transactionId;
	}

	public TransactionEntry setTransactionId(final UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	public UUID getProductId() {
		return this.productId;
	}

	public TransactionEntry setProductId(final UUID productId) {
		this.productId = productId;
		return this;
	}

	public int getQuantity() {
		return this.quanitity;
	}

	public TransactionEntry setQuantity(final int quantity) {
		this.quantity = quantity;
		return this;
	}

	public int getPrice() {
		return this.price;
	}

	public TransactionEntry setPrice(final int price) {
		this.price = price;
		return this;
	}

	public String getDateCreated() {
		return this.dateCreated;
	}

	public TransactionEntry setDateCreated(final String dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	public TransactionEntry setDateCreated(final LocalDateTime dateCreated) {
		this.dateCreated = dateCreated.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return this;
	}
}