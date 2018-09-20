package telecomProvider;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import telecomProvider.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = TelecomProvider.class, secure = false)
@SpringBootTest
@AutoConfigureMockMvc
public class TelecomProviderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TelecomProviderService telecomProviderService;

    //private TelecomProviderController telecomProviderController = new TelecomProviderController();

    Phone workPhone = new Phone(PhoneType.Work,"Cust123","7474","983839");

    Phone homePhone = new Phone(PhoneType.Home,"Cust123","7474","983838");


    List<Phone> mockPhone = Arrays.asList(workPhone,homePhone);



    Customer mockCustomer = new Customer("Cust123","Shruti Khetan", mockPhone);

    @Test
    public void retrieveNumberForCustomer() throws Exception {

        Mockito.when(
                telecomProviderService.retriveNumberForCustomer(Mockito.anyString())).thenReturn(Arrays.asList(workPhone));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/getAllPhoneNumberCustomer?customerId=Cust123").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().toString());
        String expected = "[{\"type\":\"Work\",\"areaCode\":\"7474\",\"uniqueNumber\":\"983839\",\"customerId\":\"Cust123\",\"active\":false}]";

       JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getAllPhoneNumbers() throws  Exception {
        Mockito.when(
                telecomProviderService.getAllPhoneNumbers()).thenReturn(mockPhone);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/getAllPhoneNumbers").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().toString());
        String expected = "[{\"type\":\"Work\",\"areaCode\":\"7474\",\"uniqueNumber\":\"983839\",\"customerId\":\"Cust123\",\"active\":false},{\"type\":\"Home\",\"areaCode\":\"7474\",\"uniqueNumber\":\"983838\",\"customerId\":\"Cust123\",\"active\":false}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }



}
