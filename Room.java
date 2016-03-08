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
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room upExit;
    private Room downExit;
    private static final String[] POSSIBLE_DIRECTIONS={"North","South","East","West","Up","Down"};

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     * @param up The upwards exit.
     * @param down the downwards exit
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(up != null)
            upExit = up;
        if(down != null)
            downExit = down;
    }

    /**
     * @return the Room in the specified direction
     */
    public Room getExit(String direction){
        if(direction.equalsIgnoreCase("north")){
            return northExit;
        }
        if(direction.equalsIgnoreCase("south")){
            return southExit;
        }
        if(direction.equalsIgnoreCase("east")){
            return eastExit;
        }
        if(direction.equalsIgnoreCase("west")){
            return westExit;
        }
        if(direction.equalsIgnoreCase("up")){
            return upExit;
        }
        if(direction.equalsIgnoreCase("down")){
            return downExit;
        }
        
        return null;
    }
    
     /**
     * Prints the description and directions for the current room
     */
    public String getExitString(){
        String exits = "";
        String split=System.lineSeparator();
        exits="You are " + description;
        exits=exits+split;
        exits=exits+"Exits: ";
        
        for (String direction:POSSIBLE_DIRECTIONS){
            if(getExit(direction)!=null){
                exits=exits+direction+" ";
            }
        }
        
        return exits;
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
