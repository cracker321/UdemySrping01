package rest;

//https://samtao.tistory.com/m/42 참고


//https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/10469498#reviews
//61.479강 1:09~


//1.'잘못된 요청 URL'이거나(=Bad Request),
//2.'일치하지 않거나 존재하지 않는 Student ID'일 경우,
//아래 에러를 발생시켜준다
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public StudentErrorResponse(){ //'기본 생성자' 생성

    }

    public StudentErrorResponse(int status, String message, long timeStamp){ //'필드를 전체 다 사용(원래는
                                                                             //일부만 취사선택도 가능)하는
                                                                             //사용자 생성자' 생성.
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
