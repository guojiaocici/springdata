package com.immoc.dao;

import com.immoc.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDAOImplTest {
    @Test
    public void testQuery(){
        StudentDAO studentDAO=new StudentDAOImpl();
        List<Student> students=studentDAO.query();
        for(Student student:students){
            student.toString();
            System.out.println("id:" +student.getId()
                    +",name:" +student.getName()
                    +",age:" +student.getAge());
        }

    }
//    @Test
    public void testSave(){
        StudentDAO studentDAO=new StudentDAOImpl();
        Student student =new Student();
        student.setName("test13");
        student.setAge(22);
        studentDAO.save(student);

    }

}
