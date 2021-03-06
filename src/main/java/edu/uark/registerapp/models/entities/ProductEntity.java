package edu.uark.registerapp.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import edu.uark.registerapp.models.api.Product;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

	public UUID getId() {
		return this.id;
	}

	@Column(name = "lookupcode")
	private String lookupCode;

	public String getLookupCode() {
		return this.lookupCode;
	}

	public ProductEntity setLookupCode(final String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	@Column(name = "count")
	private int count;

	public int getCount() {
		return this.count;
	}

	public ProductEntity setCount(final int count) {
		this.count = count;
		return this;
	}

	@Column(name = "inCart")
	private boolean inCart;

	public ProductEntity setInCart(final boolean inCart){
		this.inCart = inCart;
		return this;
	}

	public boolean getInCart(){return this.inCart;}

	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	@Column(name="price")
	private int price;
	
	public int getPrice() {
		return this.price;
	}
	
	public ProductEntity setPrice(final int price) {
		this.price = price;
		return this;
	}

	public Product synchronize(final Product apiProduct) {
		this.setCount(apiProduct.getCount());
		this.setLookupCode(apiProduct.getLookupCode());

		apiProduct.setId(this.getId());
		apiProduct.setCreatedOn(this.getCreatedOn());

		return apiProduct;
	}

	public ProductEntity() {
		this.count = -1;
		this.id = new UUID(0, 0);
		this.lookupCode = StringUtils.EMPTY;
		this.price = 0;
	}

	public ProductEntity(final String lookupCode, final int count) {
		this.count = count;
		this.id = new UUID(0, 0);
		this.lookupCode = lookupCode;
		this.price = price;
	}

	public ProductEntity(final Product apiProduct) {
    		this.id = new UUID(0, 0);
		this.count = apiProduct.getCount();
		this.lookupCode = apiProduct.getLookupCode();
		this.price = 0;
	}
}
