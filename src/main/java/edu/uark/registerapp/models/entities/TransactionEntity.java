package edu.uark.registerapp.models.entities;

import edu.uark.registerapp.models.api.Transaction;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="transaction")
public class TransactionEntity {

//    @Column(name = "transaction")
//    private ArrayList transaction;
//
//    public ArrayList getTransaction(){
//        return this.transaction;
//    }

//    public TransactionEntity setTransaction(ArrayList transaction){
//        this.transaction = transaction;
//        return this;
//    }

    @Id
    @Column(name="T_id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID transactionID;

    public UUID get_T_Id() {
        return this.transactionID;
    }

    @Column(name="employee_ID")
    private int employee_ID;

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    @Column(name="product_IDs")
    private String product_IDs; //list of product IDs will be , delimitated

    public String getProduct_IDs() {
        return product_IDs;
    }

    public void setProduct_IDs(String product_IDs) {
        this.product_IDs = product_IDs;
    }

    public TransactionEntity(){
        this.transactionID = new UUID(0,0);
        this.employee_ID = -1;
        this.product_IDs = "";
    }

    public TransactionEntity(Transaction transaction){
        this.transactionID = transaction.get_T_ID();
        this.employee_ID = transaction.get_employeeID();
        this.product_IDs = transaction.get_productIDs();
    }
}