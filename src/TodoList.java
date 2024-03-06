import java.util.ArrayList;
import java.util.Collections;

public class TodoList {

    private String owner;
    private ArrayList<Task> tasks;

    public TodoList(String owner) {
        this.owner = owner;
        this.tasks = new ArrayList<Task>();
    }

    public boolean addTask(String name, int urgency) {
        for (Task task: tasks) {
            if (task.getName().equals(name))
                return false;
        }
        tasks.add(new Task(name, urgency));
        return true;
    }

    public boolean removeTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskUrgency(String name, int urgency) {

        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setUrgency(urgency);
                return true;
            }
        }
        return false;
    }

    /**
     * The method mostUrgent will return the name of the task that is the most urgent (i.e. the task with the
     * highest urgency). If there are multiple tasks whose urgency is equal to the maximum, the first task
     * with that urgency will be returned.
     * @return the name of the task with the current highest urgency (a String).
     */
    public String mostUrgent() {
        ArrayList<Integer> urgency = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++){
            Task urgent = tasks.get(i);
            urgency.add(urgent.getUrgency());
        }
        Collections.sort(urgency);
        int most = urgency.get(urgency.size()-1);
        String result = null;
        for(int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            if (task.getUrgency()==most){
                return task.getName();
            }
        }
        return null;
    }

    /**
     * The method averageUrgency will return the average (arithmetic mean) of the urgency across all tasks
     * @return the average urgency across all tasks (a double).
     */
    public double averageUrgency() {
        double average = 0;
        for (int i= 0; i<tasks.size(); i++){
            Task urgency = tasks.get(i);
            average += urgency.getUrgency();
        }
        average/=tasks.size();

        return average;

    }

    /**
     * The method toString will return all tasks with their urgency in the form of a String.
     * The returned String will be in the following format:
     *
     * To-do List of [owner]
     * [Task 1] [tab] [urgency]
     * [Task 2] [tab] [urgency]
     * [Task 3] [tab] [urgency]
     * [Task 4] [tab] [urgency]
     * ...
     * @return the printable representation of the to-do list (a String).
     *
     * BONUS Challenge:  Sort your to-do list in descending order of urgency
     */
    public String toString() {
        String result = "To-do List of " + owner;
        ArrayList<Integer> descend = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++){
            Task urgent = tasks.get(i);
            descend.add(urgent.getUrgency());
        }
        Collections.sort(descend, Collections.reverseOrder());
        System.out.println(descend);

        ArrayList<Task> descending = new ArrayList<>();
        for (int i = 0; i < descend.size(); i++){
            int urgency = descend.get(i);
            for(int x = 0; x < tasks.size(); x++){
                Task task = tasks.get(x);
                if (task.getUrgency()==urgency){
                    descending.add(task);
                }
            }
        }



        for (int i = 0; i<descending.size(); i++){
            Task task = descending.get(i);
            result += "\n"+task.getName()+"\t"+task.getUrgency();
        }
        System.out.println(result);
        return result;
        
    }

}
