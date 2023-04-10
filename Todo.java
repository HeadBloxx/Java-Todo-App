import java.io.Console;
import java.util.*;  

interface Command {

    void runCommand();
}

public class Todo {

    public static void main(String[] args){

        Scanner Scanner = new Scanner(System.in);

        TodoList TODO_LIST = new TodoList();

        Map<String, Command> methodMap = new HashMap<String, Command>();

        methodMap.put("Help", new Command (){

            public void runCommand() {

                Print("Available commands:");
                Print("----");
                for (String Key : methodMap.keySet()) {
                    
                    Print(Key);
                }
            };
        });

        methodMap.put("Create", new Command (){

            public void runCommand() {
                
                Print("Name of the task:");
                String Name = Scanner.next();

                TODO_LIST.CreateItem(Name);
                Print(Name+" Successfully created!");
            }
        });

        methodMap.put("Mark-As-Done", new Command() {
            
            public void runCommand() {

                Print("Which task would you like to mark as done?");
                String Name = Scanner.next();

                boolean Successful = TODO_LIST.CompleteItem(Name);
                if (!Successful){

                    Print("Could not find task "+Name);
                }
            }
        });

        methodMap.put("Delete", new Command() {
           
            public void runCommand() {

                Print("Which task would you like to delete?");
                String Name = Scanner.next();

                boolean Successful = TODO_LIST.RemoveItem(Name);
                if (!Successful){

                    Print("Could not find task"+Name);
                }
            }
        });

        methodMap.put("See-All-Tasks", new Command() {
            
            public void runCommand(){

                Print("----");
                for (TodoItem Item : TODO_LIST.AllItems) {
                    Print(Item.Name);
                    Print('-');
                }
            }
        });

        methodMap.put("See-Completed-Tasks", new Command() {
           
            public void runCommand(){

                Print("----");
                for (TodoItem Item : TODO_LIST.GetAllItemsWithCompletionCondition(true)) {

                    Print(Item.Name);
                    Print('-');
                }
            }
        });

        methodMap.put("See-Uncompleted-Tasks", new Command() {
            
            public void runCommand() {

                Print("----");
                for (TodoItem Item : TODO_LIST.GetAllItemsWithCompletionCondition(false)) {

                    Print(Item.Name);
                    Print('-');
                }
            }
        });

        while (true){

            Print("What would you like to do today?");

            String Response = Scanner.next();
            methodMap.get(Response).runCommand();
            Print("----");

        }

    }

    public static void Print(java.lang.Object Content){

        System.out.println(Content);
    }

}