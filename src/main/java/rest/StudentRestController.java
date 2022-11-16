package rest;


import entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;


    // define endpoint for "/students" - return list of students
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }




    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getTheStudents(){

        return theStudents;
    }



    //61.479강 1:09~
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){


        //< just 'index' into the 'list' >



        //< check the 'studentId' against 'list size' >
        if((studentId >= theStudents.size()) || (studentId < 0)){ // '||': 또는
            throw new StudentNotFoundException("Student id not found!!!" + studentId);
        }
        return theStudents.get(studentId); //'ArrayList의 메소드 get(int index)': 해당 인덱스의 값 리턴해줌.
                                           //Happy Path.
    }





}
