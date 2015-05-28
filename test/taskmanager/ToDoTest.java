package taskmanager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Task Manager
 * @author Kathleen Tran
 */
public class ToDoTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("/********* STARTING TESTS FOR TODO *********/");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("/********* TESTING FOR TODO IS OVER *********/");
    }

    
    /**
     * Testing moveTask method of class ToDo against an INVALID TASK
     */
    @Test
    public void testMovingInvalidTask() {
        System.out.println("moveTask Test Case 1: Invalid Task");
        String invalidTaskName = "";
        String validTaskNameThatDoesNotExist = "This task has not been added";
        ToDo currentList = new ToDo();
        InProg nextList = new InProg();
        int expected = 0;
        int result = currentList.moveTask(invalidTaskName, nextList);
        assertEquals("An invalid String must return the value "+expected, expected, result);
        result = currentList.moveTask(validTaskNameThatDoesNotExist, nextList);
        assertEquals("A valid String that does not exist within the list must return the value "+expected, expected, result);        
    }
    
    /**
     * Testing moveTask method of class ToDo against an EXISTING TASK
     */
    @Test
    public void testMovingExistingTask() {
        System.out.println("moveTask Test Case 2: Existing Task");
        String firstTask = "This task will be added first";
        String existingTask = firstTask;
        ToDo currentList = new ToDo();
        InProg nextList = new InProg();
        nextList.addTask(firstTask);
        currentList.addTask(existingTask);
        int expected = 1;
        int result = currentList.moveTask(existingTask, nextList);
        assertEquals("Moving a task to a list that contains the same task must return "+expected, expected, result);
    }
    
    /**
     * Testing moveTask method of class ToDo against a VALID MOVE
     */
    @Test
    public void testMovingValidMove() {
        System.out.println("moveTask Test Case 3: Valid Move");
        String taskToBeMoved = "This task will be moved";
        ToDo currentList = new ToDo();
        InProg nextList = new InProg();
        currentList.addTask(taskToBeMoved);
        int expected = 2;
        int result = currentList.moveTask(taskToBeMoved, nextList);
        assertEquals("Successfully moving a task from one list to the next must return "+expected, expected, result);
    }
    
}
