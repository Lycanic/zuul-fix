import java.util.*;

/**
 * Represents the player's character
 */

public class Player extends Person{
   private int bagSize;

    public Player(String name){
        super(name);
        bagSize=5;

    }

    /**
     * Lists the items in the player's bag
     */
    public String getItemList(){
        String things="In your bag you have: ";

        for (Item item:items){
            things=things+item.getName()+" ";
        }
        return things;
    }

    /**
     * Gives the Person the specified item only if they have space
     * @param item the item to give to the player
     * @return false if no space remains in the bag
     */
    public boolean giveItem(Item item) {
        if (items.size()<bagSize) {
            items.add(item);
            return true;
        } else{
            return false;
        }

    }


}