package telecomProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TelecomProviderController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    TelecomProviderService telecomProviderService;


    @RequestMapping("/getAllPhoneNumbers")
    public List<Phone> getAllPhoneNumbers(@RequestParam(value="name", defaultValue="Wrong provider") String name) {
         return  telecomProviderService.getAllPhoneNumbers();

    }

    @RequestMapping("/getAllPhoneNumberCustomer")
    public List<Phone> getAllPhoneNUmberCustomer(@RequestParam(value="customerId",defaultValue="Wrong Input") String customerId){
        return telecomProviderService.retriveNumberForCustomer(customerId);
    }

    @RequestMapping("/activateNumber")
    public String activateNumber(@RequestParam(value="areaCode",defaultValue="Incorrect number") String areaCode,
                               @RequestParam(value="uniqueNum") String uniqueNum){
        return telecomProviderService.activateNumber(areaCode,uniqueNum);
    }

}
