import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class TodoList implements Serializable {
    public ArrayList<TodoItem> AllItems = new ArrayList<TodoItem>();

    public TodoItem GetItemByName(String Name){

        for (TodoItem TodoItem : AllItems) {
            
            if (TodoItem.Name.equals(Name)){

                return TodoItem;
            }
        }

        return null;
    }

    public TodoItem GetItemByUUID(UUID UUID){

        for (TodoItem TodoItem : AllItems) {
            
            if (TodoItem.ID.equals(UUID)){

                return TodoItem;
            }
        }

        return null;
    }

    public ArrayList<TodoItem> GetAllItemsWithCompletionCondition(Boolean Condition){

        ArrayList<TodoItem> ToReturn = new ArrayList<TodoItem>();

        for (TodoItem todoItem : AllItems) {
            
            if (todoItem.Completed == Condition){

                ToReturn.add(todoItem);
            }
        }

        return ToReturn;
    }

    public TodoItem CreateItem(String Name){

        TodoItem NewItem = new TodoItem();

        NewItem.Name = Name;

        AllItems.add(NewItem);

        return NewItem;
    }

    public boolean RemoveItem(String Name){

        TodoItem Item = GetItemByName(Name);

        if ( Item == null ) return false;

        AllItems.remove(Item);

        return true;
    }

    public boolean CompleteItem(String Name){

        TodoItem Item = GetItemByName(Name);

        return CompleteItemInternal(Item);
    }

    public boolean CompleteItem(UUID ID){

        TodoItem Item = GetItemByUUID(ID);

        return CompleteItemInternal(Item);
    }

    private boolean CompleteItemInternal(TodoItem Item){
        if (Item == null) return false;

        Item.Completed = true;

        return true;
    }

}
