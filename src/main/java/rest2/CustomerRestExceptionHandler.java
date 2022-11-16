package rest2;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestExceptionHandler {


    //Add 'an exception handler' for '클래스 CustomerNotFoundException'
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){


        //1.< Create 'CustomerErrorResponse 객체' >
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
                                                                exc.getMessage(),
                                                                System.currentTimeMillis());



        //2.< return 'ResponseEntity 객체' >
        return new ResponseEntity<error, HttpStatus.NOT_FOUND>; //'error' : body
                                                                //'HttpStatus.NOT_FOUND': status code
    }




    //'모든 종류의 예외를 다 처리 가능하게 만듦'
    //Add 'another exception handler' for '클래스 CustomerNotFoundException' to 'catch any exception(catch all)'
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){


        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                                                exc.getMessage(),
                                                                System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);



    }

}
