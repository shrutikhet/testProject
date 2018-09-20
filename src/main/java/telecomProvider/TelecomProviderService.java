package telecomProvider;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TelecomProviderService {

    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        Phone workPhone = new Phone(PhoneType.Work,"Cust124","234","567899");

        Phone homePhone = new Phone(PhoneType.Home,"Cust124","235","567878");

        Customer customer1 = new Customer("Cust124","Rohit", Arrays.asList(workPhone,homePhone));

        Customer customer2 = new Customer("Cust125","Riaan", Arrays.asList(workPhone));

        customers.add(customer1);

        customers.add(customer2);

    }

    List<Phone> retriveNumberForCustomer(String customerId) {
        System.out.println("---------->>>>"+customerId);
        Customer customer = retriveCustomer(customerId);

        if (customer == null) {
            return null;

        }

       return customer.getCustomerNumbers();

    }

    Customer retriveCustomer(String customerId){
        System.out.println("Inside retrive customer"+customers);
        for(Customer cus:customers){
            System.out.println(cus.getCustomerId().equals(customerId));
            if(cus.getCustomerId().equals(customerId)){
                return cus;
            }

        }
        return null;
    }

    List<Phone> getAllPhoneNumbers(){
        List<Phone> allNumbers = new ArrayList<Phone>();
        for(Customer cus : customers){
            for(Phone phone : cus.getCustomerNumbers()){
                allNumbers.add(phone);
            }
        }
        return allNumbers;
    }

    String activateNumber(String areaCode,String uniqueNum){
        for(Customer cus:customers){
            for(Phone phone:cus.getCustomerNumbers()){
                if(phone.getAreaCode().equals(areaCode) && phone.getUniqueNumber().equals(uniqueNum)) {
                    phone.setActive();
                    return "Done";
                }

            }

        }
        return "Not Valid";
    }

}



