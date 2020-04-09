package edu.uark.registerapp.models.api;

import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.TransactionEntity;

import java.util.ArrayList;
import java.util.UUID;

public class Transaction extends ApiResponse{
    private ArrayList transaction; //this array list is a list made up of products
    private static UUID transactionID;
    private static int employeeID;

    public Transaction() {
        super();

        this.transaction = new ArrayList();
        this.transactionID = new UUID(0,0);
        this.employeeID = -1;
    }

    public Transaction(final TransactionEntity transactionEntity, final EmployeeEntity employeeEntity){
        super(false);
        this.transaction = transactionEntity.getTransaction();
        this.transactionID = transactionEntity.getId();
        this.employeeID = employeeEntity.getEmployeeId();
    }

    /**
     * adds a product to the transaction arrayList
     */
    public void add(Product product){
        transaction.add(product);
        product.setInCart(true);
        product.setCount(product.getCount()+1);
    }
}
