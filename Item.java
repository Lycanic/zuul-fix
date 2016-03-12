
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String name;
    private String description;
    private boolean used;
    
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String name)
    {
        this.name=name;
        used=false;
    }

    public void setDescription(String description){
        this.description=description;
    }
    
    public String toString(){
        if (used){
            return "A " + name + " (used)" + ", "+description;
        }
        
        return "A " + name + ", "+description;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void useItem(){
        used=true;
    }
    
    public void restoreItem(){
        used=false;
    }
}
