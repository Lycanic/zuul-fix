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
     * @param name
     */
    public Person(String name){
        this.name=name;
    }

    /**
     * Gives the Person the specified item
     * @param item
     */
    public boolean giveItem(Item item) {
        return items.add(item);
    }

    /**
     * takes the specified item from the Person
     * @param item
     */
    public boolean takeItem(Item item){
        return items.remove(item);
    }





}
