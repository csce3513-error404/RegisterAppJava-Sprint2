package edu.uark.registerapp.models.api;

import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.TransactionEntity;

import java.util.ArrayList;
import java.util.UUID;

public class Transaction extends edu.uark.registerapp.models.api.ApiResponse {
    private ArrayList<Product> transaction; //this array list is a list made up of products
    private static UUID transactionID;
    private static int employeeID;
    private String productIDs;

    public Transaction() {
        super();

        //this.transaction = new ArrayList<Product>();
        this.transactionID = new UUID(0,0);
        this.employeeID = -1;
        this.productIDs = "";
    }

    public Transaction(final TransactionEntity transactionEntity, final EmployeeEntity employeeEntity){
        super(false);
        // this.transaction = transactionEntity.getTransaction();
        this.transactionID = transactionEntity.get_T_Id();
        this.employeeID = employeeEntity.getEmployeeId();
        this.productIDs= transactionEntity.getProduct_IDs();
    }

    /**
     * adds a product to the transaction arrayList
     */
    public void add(Product product){
        transaction.add(product);
        product.setInCart(true);
        product.setCount(product.getCount()+1);
    }

    //Start of tasks 3-4 and 3-7, Dalton Gillespie
    /*
        removing an item from the transaction
    */
    public void remove(Product product)
    {
        for(int a = 0; a<transaction.size();a++)
        {
            if(transaction.get(a) == product)
            {
                product.setInCart(false);
                product.setCount(0);
            }
        }
    }
    /*
        cancelling the transaction
    */
    public void cancelTransaction()
    {
        for(int a = 0;a<transaction.size();a++)
        {
            Product tmp = transaction.get(a);
            tmp.setInCart(false);
            tmp.setCount(0);
        }
    }

    //-------------------------------- Getters and Setters ---------------------------//
    public UUID get_T_ID(){return this.transactionID;}
    public Transaction set_T_ID(final UUID T_ID) {
        this.transactionID = T_ID;
        return this;
    }

    public int get_employeeID(){return this.employeeID;}
    public Transaction set_employeeID(final int employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public String get_productIDs(){return this.productIDs;}
    public Transaction set_productIDs(final String productIDs) {
        this.productIDs = productIDs;
        return this;
    }
}
