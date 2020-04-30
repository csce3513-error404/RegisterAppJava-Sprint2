package edu.uark.registerapp.models.api;

import edu.uark.registerapp.commands.products.ProductByLookupCodeQuery;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.TransactionEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Transaction extends ApiResponse {
    private ArrayList<Product> transaction; //this array list is a list made up of products
    private static UUID transactionID;
    private static int employeeID;
    private String productIDs; // this is a list of all transactions. it is ',' deliminator
    private static int totalCount;
    private static int totalCost;

    public Transaction() {
        super();

        this.transaction = new ArrayList<Product>();
        this.transactionID = new UUID(0,0);
        this.employeeID = -1;
        this.productIDs = "";
        this.totalCount = 0;
        this.totalCost = 0;
    }

    public Transaction(final TransactionEntity transactionEntity, final EmployeeEntity employeeEntity){
        super(false);

        this.transactionID = transactionEntity.get_T_Id();
        this.employeeID = employeeEntity.getEmployeeId();
        this.productIDs= transactionEntity.getProduct_IDs();
        this.totalCount = 0;
        this.totalCost = 0;
        this.transaction = new ArrayList<Product>();
        this.createList(productIDs);
    }

    public Transaction(TransactionEntity transactionEntity) {
        this.transactionID = transactionEntity.get_T_Id();
        this.employeeID = transactionEntity.getEmployee_ID();
        this.productIDs= transactionEntity.getProduct_IDs();
        this.totalCount = 0;
        this.totalCost = 0;
        this.transaction = new ArrayList<Product>();
        this.createList(productIDs);
    }

    /**
     * creates the array list that is the transaction
     */
    public void createList(String productIDs){
        //creates as a list of strings
        //needs a list of products from the ids
        ArrayList productIDsList = new ArrayList<String>(Arrays.asList(productIDs.split("'")));
        ProductByLookupCodeQuery code = new ProductByLookupCodeQuery();
        for(int i = 0; i < productIDsList.size() - 1; i++){
            transaction.set(i, code.execute((String) productIDsList.get(0)));
            totalCount += 1;
            totalCost += transaction.get(i).getPrice();
        }
    }

    /**
     * adds a product to the transaction arrayList
     */
    public void add(Product product){
        transaction.add(product);
        product.setCount(product.getCount()+1);
        totalCost += product.getPrice();
        totalCount += 1;
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

    public int getTotalCount(){ return this.totalCount; }
    public Transaction set_total_count(int totalCount){
        this.totalCount = totalCount;
        return this;
    }

    public int getTotalCost(){ return this.totalCost; }
    public Transaction set_total_cost(int totalCost){
        this.totalCost = totalCost;
        return this;
    }
}
