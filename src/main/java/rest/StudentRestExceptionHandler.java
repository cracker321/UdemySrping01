package rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


//61.485강  1:10~
@RestController
public class StudentRestExceptionHandler {



    //< add 'exception handling code' here>

    //[ Add an 'Exception Handler' using '@ExceptionHandler' ]
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

//        //1.< create a 'StudentErrorResponse' >
//        StudentErrorResponse error = new StudentErrorResponse(); //'기존에 생성한 사용자 정의 ErrorResponse 객체'
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage("오류 좀 내지 마세용 좀"));
//        error.setTimeStamp(System.currentTimeMillis());


//        //2.< return 'ResponseEntity' >
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);



        //< '사용자'에게 전달되는 'JSON 객체'의 모습 >
//        {
//            "status": 404,
//            "message": "Student id not fuound!!! 9999",
//            "timeStamp": 1526149650271
//        }
//    }


    //[ add 'another exception handler' to 'catch' 'any type of exception' ]:
    // 바로 위의 '@ExceptionHandler'는 '사용자 지정 핸들러 StudentNotFoundException'만 처리하지만,
    //('if((studentId >= theStudents.size()) || (studentId < 0))'의 경우만 처리),
    //이제 아래서는 '모든 종류(모든 제네릭)'의 예외를 다 처리하기 위해서 아래와 같이 설정해줌.
    //즉, 'int 타입'으로 'URL 요청'이 들어왔을 때 뿐 아니라, 'String 타입'으로 'URL 요청'이 들어와도, 그 예외를 처리 가능하게 해준다!
    @ExceptionHandler //61.483강 0:30~
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){ //'모든 종류(제네릭)의 예외'를 처리해야 하니


        //가장 포괄적인 'Exception 객체'를 넣음.
        //1.< create a 'StudentErrorResponse' >
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value()); //'BAD_REQUEST'는 '400 에러'를 만들어주고, '모든 예외 처리' 가능!
        error.setMessage(exc.getMessage()); //'내가 쓰고 싶은 에러 메세지 써도 되고, 그냥 비어있게 냅둬도 됨'
        error.setTimeStamp(System.currentTimeMillis());


        //2.< return ResponseEntity >
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
