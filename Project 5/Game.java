/***********************************************************
 * The class for the game to run
 * 
 * @author Cameron Sprowls
 * @version 11/20/15
 **********************************************************/
import java.util.*;
public class Game
{
    /** Rooms for the rooms in the game **/
    private Room tBathroom, bedroom, tHallway, attic, closet, 
    mHallway, readingRoom, mBathroom, livingRoom, 
    kitchen, bHallway, storage, utility, hiddenRoom, 
    bossRoom;

    /** Items for the items in the game **/
    //useful items
    private Item page, creepyDoll, lavaLamp, floorTile, picture, 
    axeHead, string, strengthTonic, wrench, axe, tracker,
    speedTonic, axeHandle, gauntlets, deathBlaster;
    //worthless items
    private Item rope, pillow, book, knife, perfume, mirror,
    coffee, skull;

    /** Booleans to keep track of various game objectives **/
    private boolean drankSpeed, drankStrength, gauntletsBuff, waited, hasAxe,
    canWalkThroughWall, cursed, hasSeenCrackedWall, monsterTracker, god;
    public boolean monsterAlive;

    /** ArrayList for the items the player picks up **/
    private ArrayList<Item> inventory;

    /** A room to store the players current location **/
    private Room currentRoom;

    /** A room to store the monsters current room **/
    private Room monsterRoom;

    /** Counter to keep track of the speed buff of the speed tonic **/
    private int counter;

    /** Counter to keep track of the monster path **/
    private int monsterPath;

    /** A string to be updated to show the current message **/
    private String message;
    
    /***********************************************************
     * This is the default constructor
     **********************************************************/
    public Game()
    {
        createRooms();
        setWelcomeMessage();
        setPlayerBuffs();
        inventory = new ArrayList<Item>();
        inventory.add(tracker);
        currentRoom = readingRoom;
        monsterRoom = bedroom;
        monsterPath = 2;
    }   

    //start of accessor methods
    /***********************************************************
     * method to return the games message
     **********************************************************/
    public String getMessage()
    {
        message += "\n\n\n\n";
        return message;
    }
    //end of accessor methods

    //start of helper methods
    /***********************************************************
     * Method to create the rooms of the game
     **********************************************************/
    private void createRooms()
    {
        //instantiate all of the items that are useful
        page = new Item("Piece of paper", 1, false, false, " a piece of paper with strange markings");
        creepyDoll = new Item("Creepy doll", 1, false, false, " a very creepy doll with strange markings on it");
        lavaLamp = new Item("Majestic lava lamp", 3, false, false, " a somewhat majestic lava lamp with strange markings on it");
        floorTile = new Item("Blood stained tile", 10, false, false, " a floor tile with a weird blood stain on it");
        picture = new Item("Picture of strange creature", 1, false, false, " a very disturbing picture with some kind of monster on it");
        strengthTonic = new Item("Tonic of questionable liquid", 1, false, true, " a magic tonic with strange liquid");
        speedTonic = new Item("Tonic of speed", 1, false, true, " magic tonic with strange liquid");
        axeHandle = new Item("Ladder rung", 2, false, false, " a rung in a ladder that looks loose");
        axeHead = new Item("Head of an executioner's axe", 49, false, false, " a stone carved executioner-style axe that\n" +
            "   is covered in blood");
        string = new Item("Some string", 0, false, false, " some string that looks like it has no relevance.");
        wrench = new Item("Wrench", 10, false, false, " a very heavy looking wrench. Maybe it could be used as a weapon.");
        axe = new Item("Complete executioner's axe", 51, false, false, " a crafted executioner's axe. It looks very heavy.");
        gauntlets = new Item("Mysterious gauntlets", 0, true, false, " a weird pair of gauntlets");
        deathBlaster = new Item("SUPER MEGA AWESOME DEATH BLASTER", 51, false, false, " a blaster that you question dropping");
        tracker = new Item("Monster Tracker", 10, false, false, " your trusty monster tracker... Why did you drop it?");

        //instantiate all of the items that are worthless
        book = new Item("Book", 5, false, false, " a book titled 'The Wolf Queen, Book IX'");
        pillow = new Item("Pillow", 1, false, false, " a pillow that is nice and fluffy");
        knife = new Item("Pointy Knife", 1, true, false, " a very pointy, and sharp, knife.");
        perfume = new Item("Powerful Perfume", 1, true, true, " a powerful perfume. Perhaps equipping it will make\n    you smell better.");
        mirror = new Item("Mirror", 10, false, false, " a mirror reflecting a sad man.");
        coffee = new Item("Cold 'n Moldy Coffee", 1, false, true, " coffee that has mold on it, and most likely very cold.");
        rope = new Item("Rope", 5, false, false, " a much manlier string on the floor (rope)");
        skull = new Item("Human Skull", 5, true, false, " a human skull!!! I bet it would look cool if you put it on.");
        
        //instantiate all of the rooms
        tBathroom = new Room("in a bathroom that smells horrible!\n" + 
            "There is a plugged toilet next to a sink\n" + 
            "that has a shattered mirror above it. Other\n" + 
            "than that the bathroom seems empty, how creepy.\n\n" + 
            "There is a door to the West, and there appears to\n" + 
            "be a door to the South, as well.", "bathroom of some kind.");
        tBathroom.addItem(floorTile);

        bedroom = new Room("in a master bedroom that appears to not\n" +
            "have been used in a while. It is tidy except for the\n" +
            "bed itself. Upon closer inspection you spot several\n" + 
            "dubious stains on the sheets, pillows, and blankets.\n" +
            "You surmise that whoever once lived here must have had\n" + 
            "a lot of action. Quite odd indeed.\n\n" +
            "There is a door to the West, and to the North lies\n" + 
            "another door.", "bedroom.");
        bedroom.addItem(creepyDoll);
        bedroom.addItem(pillow);

        tHallway = new Room("in a long winding hallway that serves\n" + 
            "as a junction for the rooms on the top floor. There are\n" + 
            "seventeen pictures of the same sad guy covering the walls.\n" + 
            "No wait... This hallway is full of mirrors.\n\n" + 
            "There is a small looking doorway that is half the\n" +
            "size of any other doorway in the house to the West. There are also\n" +
            "doors inbetween the mirrors to the Northeast and\n" + 
            "to the Southeast. There is also a closet door to the South.",
            "hallway of some kind.");
        tHallway.addItem(mirror);

        attic = new Room("in a very stuffy storage attic with no\n" + 
            "clear lighting source. Good thing it's daytime! If\n" + 
            "only there were windows...\n\n" + 
            "The only door you see is to the East, the door\n" + 
            "from which you came.", "room that cannot be determined");
        attic.addItem(string);
        attic.addItem(rope);

        closet = new Room("in a very cramped closet. The only thing\n" + 
            "in the room is a trap door that looks like it leads\n" + 
            "downstairs.\n\nYou can see the trap door, and a door to " +
            "the North.", "room that cannot be determined");
        

        mHallway = new Room("in a spooky hallway. The only reason it is\n" + 
            "spooky is because there is a lone picture of an eyeless\n" + 
            "Queen Elizabeth II, better not take it.\n\n" +
            "You see doors to the West and South\n" + 
            "leading to mysterious rooms. As well as a stairwell at the\n" + 
            "end of the wallway the goes both upstairs and downstairs.",
            "hallway of some kind.");
        mHallway.addItem(speedTonic);

        readingRoom = new Room("in an ordinary room with books covering\n" + 
            "the four walls.\n\nThe only door you see is to the\n" + 
            "West.", "room that cannot be determined");
        readingRoom.addItem(page);
        readingRoom.addItem(book);

        mBathroom = new Room("in a very clean bathroom. It has a shower\n" + 
            "and a sink, but it is missing a toilet. In all your years\n" +
            "never before have you seen such a horror.\n\nYou see a door\n" + 
            "to the Northeast, and Southeast.", "bathroom of some kind");
        mBathroom.addItem(perfume);

        livingRoom = new Room("in a living room in which the carpet is\n" + 
            "covered in blood. The rest of the living room has been\n" + 
            "kept nice and clean.\n\nYou see a door to the kitchen to\n" + 
            "the South, and a half open door to the West.", "livingroom.");
        livingRoom.addItem(lavaLamp);
        livingRoom.addItem(coffee);

        kitchen = new Room("in a surprisingly well kept kitchen. The\n" + 
            "counters are crafted from fine marble, and the floor tiles\n" +
            "look like they've been polished yesterday.\n\n You can see a " + 
            "ladder leading up to a hatch on the ceiling.\n As well as a " + 
            "door to the North.", "room that cannot be determined");
        kitchen.addItem(axeHandle);
        kitchen.addItem(knife);

        bHallway = new Room("in a damp basement hallway. The floor consists\n" + 
            "of nothing but dirt, and the walls are carved with smooth.\n" +
            "stone\n\nThe darkness makes it difficult to see anything",
            "hallway of some kind.");
        bHallway.addItem(axeHead);
        bHallway.addItem(skull);

        storage = new Room("in food storage area, but all of the food is gone!" +  
            "\n\nThe darkness makes it difficult to see anything", "room where food is stored.");
        storage.addItem(picture);

        utility = new Room("in a room that is extremely dark. You can\n" + 
            "barely make out the pipes all over the wall.\n\n The " + 
            "darkness makes it difficult to see anything", "room with a lot of pipes.");
        utility.addItem(wrench);
        utility.addItem(gauntlets);

        hiddenRoom = new Room("in the hidden room in the wall.\n" +
            "The darkness makes it difficult to see anything.", "room that cannot be determined.");
        hiddenRoom.addItem(strengthTonic);

        bossRoom = new Room("in an empty room. The floor, walls, and ceiling\n" + 
            "all emit an vile aura directing you to the center of the room.\n" + 
            "Which is Except the assiduously beating heart in the center " +
            "of the room.\n\nThere is no escape.", "room that cannot be determined.");

        //Establish all of the neighbors to all of the rooms
        //bathroom on top floor
        tBathroom.addNeighbor("WEST", tHallway);
        tBathroom.addNeighbor("SOUTH", bedroom);

        //bedroom on top floor
        bedroom.addNeighbor("NORTH", tBathroom);
        bedroom.addNeighbor("WEST", tHallway);

        //ladderRoom/closet on topfloor
        closet.addNeighbor("NORTH", tHallway);
        closet.addNeighbor("TRAP DOOR", kitchen);

        //attic on top floor
        attic.addNeighbor("EAST", tHallway);

        //the main junction(hallway) on the top floor
        tHallway.addNeighbor("NORTHEAST", tBathroom);
        tHallway.addNeighbor("SOUTHEAST", bedroom);
        tHallway.addNeighbor("SOUTH", closet);
        tHallway.addNeighbor("WEST", attic);
        tHallway.addNeighbor("DOWNSTAIRS", mHallway);

        //the room in which you start on the middle floor
        readingRoom.addNeighbor("WEST", mHallway);

        //the living room on the second floor
        livingRoom.addNeighbor("NORTH", mHallway);
        livingRoom.addNeighbor("SOUTH", kitchen);
        livingRoom.addNeighbor("WEST", mBathroom);

        //the kitchen on the second floor
        kitchen.addNeighbor("NORTH", livingRoom);
        kitchen.addNeighbor("TRAP DOOR", closet);

        //the bathroom on the second floor
        mBathroom.addNeighbor("NORTHEAST", mHallway);
        mBathroom.addNeighbor("SOUTHEAST", livingRoom);

        //the main junction(hallway) on the second floor
        mHallway.addNeighbor("EAST", readingRoom);
        mHallway.addNeighbor("SOUTH", livingRoom);
        mHallway.addNeighbor("WEST", mBathroom);
        mHallway.addNeighbor("DOWNSTAIRS", bHallway);
        mHallway.addNeighbor("UPSTAIRS", tHallway);

        //the storage room on the bottom floor
        storage.addNeighbor("WEST", bHallway);
        storage.addNeighbor("SOUTH", utility);

        //the utility room on the bottom floor
        utility.addNeighbor("NORTH", storage);
        utility.addNeighbor("SOUTH", hiddenRoom);

        //the hidden room //ssshhhh don't tell anyone
        hiddenRoom.addNeighbor("NORTH", utility);
        hiddenRoom.addNeighbor("TRAP DOOR", bossRoom);

        //the boss room on the bottom floor
        //no way out

        //the main junction(hallway) on the bottom floor
        bHallway.addNeighbor("UPSTAIRS", mHallway);
        bHallway.addNeighbor("EAST", storage);
    }

    /***********************************************************
     * method to set the welcome message of the game
     **********************************************************/
    private void setWelcomeMessage()
    {
        message = "Welcome to my epic game! Prepare to die. A lot.\n\n" + 
        "Your name is Pete Yardle, and you exterminate beasts\n" + 
        "for a living! You are the best there is at what you do!\n" + 
        "Unfortunetly for you, you accepted a brand new job\n" +
        "that is the hardest job you've accepted thus far.\n" +
        "The 'monster', as the clients called it, lives inside of a\n" + 
        "three story house--that it aquired after it killed the tenants.\n\n" +
        "You grabbed all of your monster killing gear to take it\n" + 
        "out swiftly when you arrived. But as you walk onto the scene,\n" + 
        "the cracked pathway that leads up to the house that you were\n" + 
        "walking on started shaking, as if a massive earthquake hit.\n" + 
        "The path opened up into a cavern that was too dark to see\n" +
        "all the way down to the bottom. The out of nowhere you felt\n" +
        "as if someone pushed you in!\n\n" + 
        "When you come to, you realize you only have one of your\n" +
        "items, and to make matters worse, it's broken.\nYou" + 
        " find yourself in a strange room, presumably inside of\n" + 
        "the house. Looks like you'll have to do this the old fasion\n" +
        "way. Through hard work and determination, surely you\n can succeed!\n\n" + 
        "\n\nRight?\n\n";
    }

    /***********************************************************
     * Method to set all of the possible player buffs/objectives
     **********************************************************/
    private void setPlayerBuffs()
    {
        drankSpeed = false;
        drankStrength = false;
        gauntletsBuff = false;
        waited = false;
        hasAxe = false;
        canWalkThroughWall = false;
        monsterAlive = true;
        cursed = false;
        hasSeenCrackedWall = false;
        monsterTracker = false;
        god = false;
    }

    /***********************************************************
     * Method to check the array list for an item, is it is found, return it
     * if it is not, return null
     **********************************************************/
    private Item checkForItem(String name)
    {
        //new item 'null' if item is not found
        Item result = null;
        //go through every item in the inventory and check it
        for(Item i : inventory)
        {
            //if the item matches any in the arraylist, return it
            if(i.getName().toUpperCase().contains(name.toUpperCase()))
            {
                result = i;
            }
        }
        return result;
    }

    /***********************************************************
     * Method to check the rooms items to see if the requested item is in it
     **********************************************************/
    private Item checkRoomItems(String name)
    {
        //new item 'null' if item is not found
        Item result = null;

        //go through every item in the room and check it
        for(Item i : currentRoom.getItems())
        {
            //if the item matches any in the arraylist, return it
            if(i.getName().toUpperCase().contains(name.toUpperCase()))
            {
                result = i;
            }
        }
        return result;
    }
    //end of helper methods

    //start of mutator methods
    /***********************************************************
     * Method to print various help methods to assist the player
     **********************************************************/
    public void help()
    {
        message = "You think:\n";
        if(inventory.contains(picture))
        {
            message += "Alright, I think the time has come. I need to go expel this\n" + 
            "thing before its moving portion finds and ends my life.";
        }
        else if(canWalkThroughWall)
        {
            message += "I broke through it! Nice! But I shouldn't be too hasty. I bet\n" +
            "this corrupt feeling that I have has something to do with those\n" +
            "creepy objects around the house.";
        }
        else if(gauntletsBuff)
        {
            message += "I feel much stronger now! Now to find something to \nsmash that wall!";
        }
        else if(hasSeenCrackedWall)
        {
            message += "That weak wall is too conspicuous, I need to find a way\n" +
            "through it. I need some kind of big heavy weapon to \nsmash it." + 
            " Unfortunetly, anything big enough that I can find \nis too heavy " + 
            "for me to lift.";
        }
        else
        {
            message += "This monster is too powerful to take on by itself.\n" + 
            "But from what I've learned, they all have a weakspot,\n" + 
            "I just have to find it. It's probably in a hidden room.\n" +
            "I should probably repair my monster tracker first, if I\n" + 
            "could find a wrench I could probably repair it. There might\n" +
            "be some kind of wrench in the basement, I better go look.\n" +
            "And from my experience in the past, I can sense corrupt\n" +
            "objects around the house, I better avoid those.";
        }
    }

    /***********************************************************
     * Method to look around the room more indepth, but it actually just updates
     * the message to get the long description of a room
     **********************************************************/
    public void look()
    {
        message = currentRoom.getLongDescription();
    }

    /***********************************************************
     * Method to move the player to another room
     **********************************************************/
    public void move(String direction)
    {
        direction = direction.toUpperCase();
        Room nextRoom = currentRoom.getNeighbor(direction);
        //if the room doesn't exist, don't allow entry
        if(nextRoom == null)
            message = "You walked into a wall. You got nowhere.";
        //if they are trying to get into the secret room
        else if(nextRoom == hiddenRoom)
        {
            //see if they smashed the wall
            if(!canWalkThroughWall)
            {
                message = "You walked into the cracked wall. Nothing happened.";
            }
            //if they did, allow entry
            else
            {
                currentRoom = nextRoom;
                message = currentRoom.getLongDescription();
                moveMonster();
            }
        }
        //allow entry if everything passes
        else
        {
            currentRoom = nextRoom;
            message = currentRoom.getLongDescription();
            moveMonster();
            if(currentRoom == utility)
            {
                hasSeenCrackedWall = true;
            }
            if(currentRoom == bossRoom)
                message += "\nThe house shakes and rocks fall from the ceiling\n" + 
                "blocking the exit. It's now or never.";
        }
    }

    /***********************************************************
     * Method to allow the player to not move, but allow the monster to move
     **********************************************************/
    public void waitCommand()
    {
        waited = true;
        moveMonster();
        message = "You wait in agony as the monster will still probably kill you.";
    }

    /***********************************************************
     * Method to move the player to another room
     **********************************************************/
    public void moveMonster()
    {
        //if the player has either consumed the speed buff and it is the first
        //move, the monster won't move
        if(drankSpeed && counter == 1)
        {
            //if the player use the wait command, don't update the speedbuff counter
            //if they did, don't do anything
            if(!waited)
                counter = 2;
            waited = false;
        }
        else
        {
            //if the plaer used the wait command, don't update the speedbuff counter
            //if the did, don't do anything
            if(!waited)
                counter = 1;
            waited = false;
            //huge switch statement to move the monster in a set path
            switch(monsterPath)
            {
                case 1: 
                monsterRoom = bedroom;
                monsterPath++;
                break;
                case 2: 
                monsterRoom = tHallway;
                monsterPath++;
                break;
                case 3: 
                monsterRoom = tBathroom;
                monsterPath++;
                break;
                case 4: 
                monsterRoom = tHallway;
                monsterPath++;
                break;
                case 5: 
                monsterRoom = mHallway;
                monsterPath++;
                break;
                case 6: 
                monsterRoom = livingRoom;
                monsterPath++;
                break;
                case 7: 
                monsterRoom = mBathroom;
                monsterPath++;
                break;
                case 8: 
                monsterRoom = mHallway;
                monsterPath++;
                break;
                case 9: 
                monsterRoom = bHallway;
                monsterPath++;
                break;
                case 10: 
                monsterRoom = storage;
                monsterPath++;
                break;
                case 11: 
                monsterRoom = utility;
                monsterPath++;
                break;
                case 12: 
                monsterRoom = hiddenRoom;
                monsterPath++;
                break;
                case 13: 
                monsterRoom = utility;
                monsterPath++;
                break;
                case 14: 
                monsterRoom = storage;
                monsterPath++;
                break;
                case 15: 
                monsterRoom = bHallway;
                monsterPath++;
                break;
                case 16: 
                monsterRoom = mHallway;
                monsterPath++;
                break;
                case 17: 
                monsterRoom = mBathroom;
                monsterPath++;
                break;
                case 18: 
                monsterRoom = livingRoom;
                monsterPath++;
                break;
                case 19: 
                monsterRoom = mHallway;
                monsterPath++;
                break;
                case 20: 
                monsterRoom = tHallway;
                monsterPath++;
                break;
                case 21: 
                monsterRoom = tBathroom;
                monsterPath = 1;
                break;
            }
        }
    }

    /***********************************************************
     * Method to update the message to contain every item in the players
     * inventory
     **********************************************************/
    public void list()
    {
        message = "You are holding";

        //if their inventory is greater than 0, add each item to the message
        if(inventory.size() > 0)
        {
            message += ":\n";
            for(Item i : inventory)
            {
                message += i.getName() + "\n";
            }
        }
        //if their inventory is 0, tell them they have no items in their inventory
        else
            message = message + " nothing! What a fool.";
    }

    /***********************************************************
     * Method to pick up an item in a room, if there is one there, if not,
     * update accoringly
     **********************************************************/
    public void pickup(String name)
    {
        //create new item for the tests, to see if it exists
        //create out here for readability
        Item temp = checkRoomItems(name);
        //if the room even has that item
        if(temp != null)
        {
            //for every item in the room, see if it is the item the player wants to collect
            for(Item i: currentRoom.getItems())
            {
                //if the item is found, countine
                if(i == temp)
                {
                    //if the item is too heavy, don't pick it up
                    if(i.getWeight() > 50)
                    {
                        //if they have the gauntlets, allow them to pick it up
                        if(gauntletsBuff)
                        {
                            inventory.add(i);
                            currentRoom.removeItem(i);
                            message = "The " + temp.getName().toLowerCase() + " was added to your inventory. Thief.";
                        }
                        else
                        {
                            message = "What? You think you can lift that item with those\n" +
                            " puny arms? Think again. The item remains.";
                        }
                    }
                    //if everything passes...... pick of the item. Update message.
                    else
                    {
                        inventory.add(i);
                        currentRoom.removeItem(i);
                        message = "The " + temp.getName().toLowerCase() + " was added to your inventory. Thief.";
                    }
                    //if the player picked up one of the cursed item, curse them
                    //for readability, put them on separate lines
                    if(inventory.contains(page) || inventory.contains(lavaLamp))
                        cursed = true;
                    if(inventory.contains(creepyDoll) || inventory.contains(floorTile))
                        cursed = true;
                    if(inventory.contains(picture))
                    {
                        //if the player doesn't pick up the picture last, kill them, but be cryptic about it
                        if(!inventory.contains(page) || !inventory.contains(lavaLamp) || !inventory.contains(creepyDoll) || !inventory.contains(floorTile))
                            monsterRoom = currentRoom;
                    }
                }
            }
        }
        //if it doesn't, tell them that it does not
        else
            message = "This room doesn't even have that item!\n" + 
            "You pick up nothing and add it to your inventory.\n" +
            "You feel no different.";
        //100% for testing
        if(name.equals("g0d m0d3 act1vat3"))
        {
            message += ".";
            cheat();
        }
        if(name.equals("1001001"))
        {
            message += "..";
            unCheat();
        }
    }

    /***********************************************************
     * Method to drop an item from the players inventory
     **********************************************************/
    public void drop(String name)
    {
        //change name to upper so the user doesn't have to deal with it
        name = name.toUpperCase();
        //new item to store and do all of the checks in the method
        //create out here to avoid calling method more than once
        Item temp = checkForItem(name);
        //if the item is found in the players arraylist, continue
        if(temp != null)
        {
            //search every item in the array, then add it to room once found,
            //and drop it
            if(inventory.contains(temp))
            {
                currentRoom.addItem(temp);
                inventory.remove(temp);
                message = "The item has been booted from your inventory! Yay?";
            }
        }
        else
        {
            message = "That item is not in your inventory. You dropped nothing. Feel special?";
        }
    }

    /***********************************************************
     * Method to drink an item if the player is holding it
     **********************************************************/
    public void drink(String name)
    {
        //touppercase so the user doesn't have to worry about it
        name = name.toUpperCase();

        //new item to store and do all of the checks in the method
        //create out here to avoid calling method more than once
        Item temp = checkForItem(name);

        //check to see if they are holding the item
        if(temp != null)
        {
            //see if it is drinkable, if it is, remove it from iventory, update
            //message
            if(temp.isDrinkable())
            {
                inventory.remove(temp);
                message = "You drank the " + temp.getName() + ". It tasted delish!\n";
                //if they drnak the purity tonic, let them pick up the cured item
                //but throw a confusing message
                if(temp == strengthTonic)
                {
                    drankStrength = true;
                    message += "Who knows what that did.";
                }
                //let the palyer know it did something, but be cryptic
                if(temp == speedTonic)
                {
                    drankSpeed = true;
                    message += "You feel much faster!";
                }
            }
            //otherwise don't let them drink it
            else
            {
                message = "You want to drink that? I wouldn't condone it.";
            }
        }
        //message telling them they do not have the item
        else
        {
            message = "You are holding no such item to drink. Your tongue dries.";
        }
    }

    /***********************************************************
     * Method to combine the axe items together to make the full axe
     **********************************************************/
    public void craftAxe()
    {
        //check to see that the player is holding all of the items in their inventory
        //for readability sake, do this on separate lines, outside of an if statement
        boolean axeHeadTemp = inventory.contains(axeHead);
        boolean axeHandleTemp = inventory.contains(axeHandle);
        boolean axeConnectorTemp = inventory.contains(string);
        //if the player has all three parts to the axe, craft it
        if(axeHeadTemp && axeHandleTemp && axeConnectorTemp)
        {
            //simulate axe craftng by removeing the items from their inventory
            inventory.remove(axeHead);
            inventory.remove(axeHandle);
            inventory.remove(string);

            message = "You crafted an awesome executioners axe! It's really heavy.";
            //if the player has picked up the gauntlets, they keep the axe
            if(gauntletsBuff)
            {
                message += "\nGood thing you have those gauntlets. \nItem added to your inventory.";
                inventory.add(axe);
            }
            //otherwise they drop it in their current room
            else
            {
                message += " So heavy in fact, that you dropped the axe!";
                currentRoom.addItem(axe);
            }
        }
        else
        {
            message = "You lack the required componets to craft!";
        }
    }

    /***********************************************************
     * Method to repair the monsterTracker if they have it
     **********************************************************/
    public void repair()
    {
        if(monsterTracker)
        {
            message = "You already repaired the monster tracker!";
        }
        else
        {
            if(!inventory.contains(tracker))
            {
                message = "There is no tracker in your inventory. Why did you drop it?";
            }
            else if(!inventory.contains(wrench))
            {
                message = "You've nothing to repair your tracker with.";
            }
            else
            {
                message = "Monster tracker repaired!";
                monsterTracker = true;
            }
        }
    }

    /***********************************************************
     * Method to use the tracker to track the monster
     **********************************************************/
    public void track()
    {
        if(monsterTracker)
        {
            if(inventory.contains(tracker))
                message += "The monster is in a " + monsterRoom.getSecondDes();
            else
            {
                message = "You dropped the monster tracker. Your omniscience is gone.";
            }
        }
        else
        {
            message = "You foolishly attempt to use a broken monster tracker.";
        }
    }
    
    /***********************************************************
     * Method to end the players life, or craft the final item
     **********************************************************/
    public void endItAll()
    {
        //check to see that the player is holding all of the items in their inventory
        //for readability sake, do this on separate lines, outside of an if statement
        boolean hasPaper = inventory.contains(page);
        boolean hasDoll = inventory.contains(creepyDoll);
        boolean hasLamp = inventory.contains(lavaLamp);
        boolean hasPicture = inventory.contains(picture);
        boolean hasTile = inventory.contains(floorTile);
        //if the player has all three parts to the axe, craft it
        if(currentRoom == bossRoom)
        {
            if(hasPaper && hasDoll && hasLamp && hasPicture && hasTile)
            {
                //simulate weapon craftng by removeing the items from their inventory
                inventory.remove(page);
                inventory.remove(creepyDoll);
                inventory.remove(lavaLamp);
                inventory.remove(picture);
                inventory.remove(floorTile);

                inventory.add(deathBlaster);

                message = "You tried to end it, but before you did, the strange items\n" + 
                "fused themselves into a \nSUPER MEGA AWESOME DEATH BLASTER OF DEATH";
            }
            else
                message = "The corruption from the object seems like to much pressure\n" +
                "and you freeze up as the heart turns into a rancor and eats\n" +
                "you alive";
        }
        else
        {
            monsterRoom = currentRoom;
        }
    }

    /***********************************************************
     * Method to smash through the final wall if the player has the axe
     **********************************************************/
    public void smashWall()
    {
        if(inventory.contains(axe) && (currentRoom == utility))
        {
            canWalkThroughWall = true;
            message = "You thrust the axe into the wall with great force!\n" + 
            "The wall falls apart, revealing a secret room.";
        }
        else
        {
            message = "You cannot smash right now!";
        }
    }

    /***********************************************************
     * Method to equip any items the player may or may not have
     **********************************************************/
    public void equip(String name)
    {
        //touppercase so the user doesn't have to worry about it
        name = name.toUpperCase();

        //new item to store and do all of the checks in the method
        //create out here to avoid calling method more than once
        Item temp = checkForItem(name);

        //check to see if they are holding the item
        if(temp != null)
        {
            //see if it is drinkable, if it is, remove it from iventory, update
            //message
            if(temp.isEquipable())
            {
                inventory.remove(temp);
                message = "You equiped the item!";
                //if the item they equiped were the gauntlets, give them the buff
                if(temp == gauntlets)
                    gauntletsBuff = true;
            }
            //otherwise don't let them drink it
            else
            {
                message = "You can't equip that!";
            }
        }
        //message telling them they do not have the item
        else
        {
            message = "You are holding no such item to equip. You sadden.";
        }
    }

    /***********************************************************
     * Method to attack things in the game
     **********************************************************/
    public void attack(String name)
    {
        //caps so the user doesn't have to deal with it
        name = name.toUpperCase();

        Item temp = checkForItem(name);

        if(temp != null)
        {
            if(currentRoom == bossRoom)
            {
                //if they have the death blaster, they win the game
                if(inventory.contains(deathBlaster) && (temp == deathBlaster))
                {
                    message = "You pulled out the " + deathBlaster.getName() + "\n and blasted the heart to timbuktu!!!";
                    monsterAlive = false;
                }
                else
                {
                    message = "You tried to attack the heart with the " + temp.getName().toLowerCase() + "\n" + 
                    "but unfortunetly for you, the heart transformed\ninto a rancor and ate you alive...";
                    monsterRoom = currentRoom;
                }
            }
            else
            {
                message = "You swung the " + temp.getName().toLowerCase() + " pointlessly at the air. Congrats!";
            }
        }
        else
        {
            message = "Are you trying to attack with air? You aren't the avatar.\nNothing happens.";
        }
    }

    /***********************************************************
     * Method to see if the game has been won or lost
     **********************************************************/
    public boolean gameOver()
    {
        //see if they lost
        if(monsterRoom == currentRoom)
        {
            if(god)
                return false;
            message = "Before you realize what has happened, you stand\n" + 
            "before a hairless creature that has pointed ears\n" + 
            "and razor sharp teeth. It moves around with its three\n" +
            "legs that look like they shouldn't be working. Next to\n" + 
            "those disturbing " +
            "legs you see its arms that are twice the\n length of" +
            "the rest of its body, and its talons are about\n one" +
            "foot in length. Never before have you seen such an\n" +
            "atrocity.\n\nYou are too horrified to move. Game Over.";
            return true;
        }
        if(cursed && !drankStrength)
        {
            message = "Picking that item up corrupts your soul and you die.";
            return true;
        }
        //see if they won
        if(monsterAlive == false)
        {
            message = "You killed the thing!";
            return true;
        }
        return false;
    }

    
    
    
    /***********************************************************
     * Cheat Method to test the game
     **********************************************************/
    private void cheat()
    {
        god = true;
    }

    private void unCheat()
    {
        god = false;
    }
}
