import java.util.ArrayList;

/**
 * Represents an individual in the game
 * Created by Laura on 12/03/2016.
 */
public class Person {
    protected String name;
    protected ArrayList<Item> items;

    /**
     * create a Person
     * @param name the name of the person
     */
    public Person(String name){
        this.name=name;
        items=new ArrayList<Item>();
    }

    public String getName(){
        return name;
    }

    /**
     * Gives the Person the specified item
     * @param item the item to give the person
     */
    public boolean giveItem(Item item) {
        return items.add(item);
    }

    /**
     * takes the specified item from the Person
     * @param item the item to take
     */
    public boolean takeItem(Item item){
        return items.remove(item);
    }

    public boolean hasItem(Item item){
        return items.contains(item);
    }




}
