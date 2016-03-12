
import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */


public class Room 
{
    private String description;
    private HashMap<String,Room> exits;
    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String,Room>();
        items = new ArrayList<Item>();
    }
    
    /**
     * Adds an exit to the room
     */
    public void addExit(String direction, Room destination){
        exits.put(direction,destination);
    }

    /**
     * adds an item in the room
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * takes an item from the room
     * @param item the item to remove
     */
    public void removeItem(Item item){
        items.remove(item);

    }
    
    /**
     * @return the Room in the specified direction
     */
    public Room getExit(String direction){
        if (exits.containsKey(direction)){
            return exits.get(direction);
        }
        
        return null;
    }
    
     /**
     * Prints the description and directions for the current room
     */
    public String getExitString(){
        String doors;
        String split=System.lineSeparator();
        doors="You are " + description;
        doors=doors+split;
        doors=doors+"Exits: ";
        
        for (String direction:exits.keySet()){
            doors=doors+direction+" ";
        }
        return doors;
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
