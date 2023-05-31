package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;
import java.util.Calendar;;
/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to add a new student to a programme are met.
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with initialise method.
 */
public class AddStudent {

    private Student newStudent;
    private Programme newProgramme;
    private Football team;
	
@BeforeEach
    void setUp()
    {   
        // Create new instance of all objects, it is called before the test
        newStudent = new Student("Brody", 3863355);
        newProgramme = new Programme();
        team = new Football();
        

        // set the start date of the course
        Calendar startdate = Calendar.getInstance();
        startdate.set(2023,Calendar.JULY,18);
        newProgramme.setStartDate(startdate.getTime());

   }

    @Test
    void testEnrollDate()
    {   
        // This method test if the start date has already passed
        Calendar startdate = Calendar.getInstance();
        startdate.set(2023,Calendar.JANUARY,17);
        newProgramme.setStartDate(startdate.getTime());

        assertEquals(false,newProgramme.addStudent(newStudent,team));

    }


    @Test
    void ifStudentAlreadyEnrolled_throwException()
    {
        // This method tests if student is already enrolled and throws exception.
        assertThrows(
            IllegalStudentEnrollException.class,
            () -> 
            {
                newProgramme.addStudent(newStudent,team);
                newProgramme.addStudent(newStudent,team);
            }
        );
    }


    @Test
    void TestNumberOfStudent()
    {
        // This method tests if the course is full and maximum number of student has been reached.
        for(int i = 0; i<250; i++)
        {
            Student student = new Student("name", i);
            newProgramme.addStudent(student,team);
        }

        assertEquals(false,newProgramme.addStudent(newStudent,team));
    }

    @Test
    void Test_IfAllConditions_Satified()
    {
        // This method tests all condition of new student if they are correct.
        assertEquals(true,newProgramme.addStudent(newStudent, team));
    }

    @Test 
    void false_ifStudentIsNull()
    {
        assertEquals(false,newProgramme.addStudent(null,team));
    }


}
