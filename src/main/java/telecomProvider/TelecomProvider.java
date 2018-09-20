package telecomProvider;


import java.util.List;


public class TelecomProvider {

    private final long id;


    private List<Phone> numbers;


    private List<Customer> customers;

    TelecomProvider() {
        this.id = getId();
    }

    TelecomProvider(long id, String name,List<Phone> phoneNumbers) {

        this.id = id;
        this.numbers = phoneNumbers;
        this.name = name;
    }



    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Phone> numbers) {
        this.numbers = numbers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }



}
