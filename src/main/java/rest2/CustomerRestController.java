package rest2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/custoemrs")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }


    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        Customer theCustomer = customerService.getCustomer(customerId);

        //< '예외처리 학습 전'이라면, 만약 'customer'가 'null'인 경우, '비어있는 JSON 객체'를 리턴한다 >



        //< 그러나, '예외처리 학습 후'에는, '예외처리문'을 작성하여 예외를 던져준다 >
        if(theCustoemr == null){
            throw new CustomerNotFoundException("Customer id not found!!!" + customerId);
        }

        return theCustomer;
    }


}
