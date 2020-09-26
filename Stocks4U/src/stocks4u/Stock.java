package stocks4u;

/**
 *
Program Name: Stock.java 
Programmer's Name: 
Program Description: Manages the stock activity

 */
public class Stock {
    
    private String company_name;
    private int shares;
    private double purchase_price;
    private double current_price;

    //default constructor
    public Stock() {
    }

    //parametized constructor
    public Stock(String companyName, int no_shares, double purchasePrice, double currentPrice) {
        this.company_name = companyName;
        this.shares = no_shares;
        this.purchase_price = purchasePrice;
        this.current_price = currentPrice;
    }
    
    //getters

    public String getCompany_name() {
        return company_name;
    }

    public int getShares() {
        return shares;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public double getCurrent_price() {
        return current_price;
    }
    
    //setters

    public void setCompany_name(String name) {
        this.company_name = name;
    }

    public void setShares(int no_shares) {
        this.shares = no_shares;
    }

    public void setPurchase_price(double p_price) {
        this.purchase_price = p_price;
    }

    public void setCurrent_price(double c_price) {
        this.current_price = c_price;
    }
    
    /*
    *method to calculate the profit or loss
    *return double
    */
    public double calc(){
        return shares*(current_price-purchase_price);
    }

    @Override
    public String toString() {
        return  company_name;
    }
    
    
}
