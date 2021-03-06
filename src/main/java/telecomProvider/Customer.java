package telecomProvider;


import java.util.List;

public class Customer {


    private String customerId;


    private String customerName;


    private List<Phone> customerNumbers;

    Customer(String id,String name,List<Phone> phoneNumbers){

        this.customerId = id;

        this.customerName = name;

        this.customerNumbers = phoneNumbers;

    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Phone> getCustomerNumbers() {
        return customerNumbers;
    }

    public void setCustomerNumbers(List<Phone> customerNumbers) {
        this.customerNumbers = customerNumbers;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else if (!customerId.equals(other.customerId))
            return false;
        return true;
    }



}
