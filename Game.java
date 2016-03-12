import java.util.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    /**
     * The main playable method of the Game
     *
     * @param args
     */
    public void main(String[] args){
        Game game = new Game();
        game.play();

    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room bar, mainCorridor, passage, lift0, lift1, lift2, lift3, janitor, infirm, intern, shower, supply, cryptozoo, dark, vault, myth;
        
        String west = "west";
        String east = "east";
        String north = "north";
        String south = "south";
        String up = "up";
        String down = "down";
        
        bar = new Room("in the break room of the DoP");
        mainCorridor = new Room("in the main corridor");
        passage = new Room("in the passage between the bar and the vaults");
        lift0=new Room("in the lift, on the top floor");
        lift1 = new Room("in the lift, on the middle floor");
        lift2 = new Room("in the lift, on the bottom floor");
        lift3= new Room("dropping from the incinerator chute");
        janitor = new Room("in the janitor's closet. It's spotless");
        infirm = new Room("in the infirmary");
        intern = new Room("in the intern rooms");
        shower = new Room("in the intern shower room");
        supply = new Room("in the intern supply closet");
        cryptozoo = new Room("in the cryptozoology main room");
        dark = new Room("in a very dark room");
        vault = new Room("in the departmental vaults");
        myth = new Room("in a dark, mysteriously creepy area of the department");
        
        bar.addExit(north, mainCorridor);
        bar.addExit(west, passage);
        mainCorridor.addExit(south, bar);
        mainCorridor.addExit("south-west",lift0);
        mainCorridor.addExit(west, vault);
        mainCorridor.addExit(east, janitor);
        mainCorridor.addExit(north, cryptozoo);
        passage.addExit(east,bar);
        passage.addExit(west,vault);
        lift0.addExit(north, mainCorridor);
        lift0.addExit(down, lift1);
        lift1.addExit(down, lift2);
        lift1.addExit(up, lift0);
        lift1.addExit(north, intern);
        lift2.addExit(up,lift1);
        lift2.addExit(down,lift3);
        janitor.addExit(west, mainCorridor);
        infirm.addExit(south, intern);
        intern.addExit(north, infirm);
        intern.addExit(east, supply);
        intern.addExit(west,shower);
        intern.addExit(south,lift1);
        shower.addExit(east,intern);
        supply.addExit(west,intern);
        cryptozoo.addExit(south,mainCorridor);
        
        
        currentRoom = bar;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Department of Peculiarities!");
        System.out.println("You are a young intern, freshly brought in from the streets.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You have been left to explore");
        System.out.println("the Department of Peculiarities.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is nothing there!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }
    
    /**
     * Prints the description and directions for the current room
     */
    private void printLocationInfo(){
        System.out.println(currentRoom.getExitString());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
