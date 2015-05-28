package taskmanager;

import java.util.HashMap;

/** The Task Manager.
 * CLASS  : InProg.java
 * PURPOSE: This class is a derivation of the TaskList class. It contains
 *          all tasks that belong under the "In Progress" label. While it
 *          overrides three of the methods of its parent class, only one
 *          of them is truly utilized (the method used to advance a task
 *          onto the subsequent list).
 * 
 * @author Kathleen Tran
 */
public class InProg extends TaskList{
    
    public InProg() {
        this.listName = "In Progress";
        this.numberOfTasks = 0;
        this.listContainer = new HashMap(13);
    }    
    
    
    
    /**
     * Method to move the specified task to the subsequent list
     * @param taskName
     * @param listName 
     * @return 0 if invalid task, 1 if exists in subsequent list, 2 if success
     */
    @Override
    public int moveTask(String taskName, TaskList listName) {
        if(validTask(taskName) && listName.validTask(taskName))
            return 1;
        else if (validTask(taskName) && listName instanceof Done) {
            String taskToMove = selectTask(taskName);
            listName.addTask(taskToMove);
            this.listContainer.remove(getKey(taskToMove));
            this.numberOfTasks -= 1;
            return 2;
        }
        else
            return 0;
    }
    
    
    
    //Methods not supported by this derived class
    @Override
    public boolean deleteTask(String taskName) { return false; };
    @Override
    public boolean permanentlyDeleteTask(String taskName) { return false; };
    
}