package rest;

public class StudentNotFoundException extends  RuntimeException{


    //< 'Generate'을 통한 '생성자 만들기' >. 
    //'컨트롤러의 '@ExcpetionHandler' 부분에서 'StudentNotFoundException 객체'를 사용'함. 따라서, 생성자 반드시 생성해줘야 함
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StudentNotFoundException() {
    }
}
