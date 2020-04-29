package edu.uark.registerapp.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="transaction")
public class TransactionEntity {

    @Column(name = "transaction")
    private ArrayList transaction;

    public ArrayList getTransaction(){
        return this.transaction;
    }

    public TransactionEntity setTransaction(ArrayList transaction){
        this.transaction = transaction;
        return this;
    }

    @Id
    @Column(name="T_id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private static UUID transactionID;

    public UUID getId() {
        return this.transactionID;
    }
}