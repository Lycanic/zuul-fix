
/**
 * Represents an Item within the game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String name;
    private String description;
    
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String name)
    {
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }
    
    public String toString(){
        return "A " + name + ", "+description;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
}
