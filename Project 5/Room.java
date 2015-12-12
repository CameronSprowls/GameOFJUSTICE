/***********************************************************
 * A class for all of the rooms in the house
 * 
 * @author Cameron Sprowls
 * @version 11/20/15
 **********************************************************/
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.*;
public class Room
{
    /** Item arrayList to store all of the room's items **/
    private ArrayList<Item> items;

    /** Room Description **/
    private String description;
    
    /** Secondary description for various uses **/
    private String secondDes;

    /** Adjacent Rooms **/
    private HashMap<String,Room> neighbors;

    
    /***********************************************************
     * This is the default constructior
     * 
     * @param string for the longer description of the room
     * @param string for the secondary description of the room
     **********************************************************/
    public Room(String pDescription, String sDescription)
    {
        items = new ArrayList<Item>();
        description = pDescription;
        secondDes = sDescription;
        neighbors = new HashMap<String,Room>();
    }
    
    /***********************************************************
     * This is an alternate constructior if a person has no need
     * for a secondary description
     * 
     * @param string for the longer description of the room
     **********************************************************/
    public Room(String pDescription)
    {
        items = new ArrayList<Item>();
        description = pDescription;
        secondDes = null;
        neighbors = new HashMap<String,Room>();
    }

    /***********************************************************
     * Method to add an item to a room
     * 
     * @param item to add to the room
     **********************************************************/
    public void addItem(Item i)
    {
        if(i != null)
            items.add(i);
    }

    /***********************************************************
     * Method to see if the room is containing an item
     * 
     * @return boolean to see if the room has an item
     **********************************************************/
    public boolean hasItem()
    {
        //if the array list is bigger than size 0
        //May have to change this is include "&& items does not contain null"
        if(items.size() > 0)
            return true;
        return false;
    }

    /***********************************************************
     * Method to add a new neighbor to a room
     * 
     * @param direction to add the previous room
     * @param room to be the new room
     **********************************************************/
    public void addNeighbor(String pDirection, Room r)
    {
        pDirection = pDirection.toUpperCase();
        neighbors.put(pDirection, r);
    }

    /***********************************************************
     * Method to get the neighbors of a room in a given direction
     * 
     * @return room to be new room
     * @param direction to do the searching
     ***********************************************************/
    public Room getNeighbor(String pDirection)
    {
        pDirection = pDirection.toUpperCase();
        Room result = neighbors.get(pDirection);
        return result;
    }

    /***********************************************************
     * Method to remove an item from a room (for the player to pick up)
     * 
     * @return item that was "picked up"/ deleted from room
     * @param item to check/remove/pickup from the room
     **********************************************************/
    public Item removeItem(Item tempItem)
    {
        //go through every item in the room
        for(Item i: items)
        {
            //if the item is found, delete it, and return it
            if(i.itemName.equals(tempItem.getName()))
            {
                //this may crash FIX LATER
                items.remove(i);
                return i;
            }
        }
        return null;
    }

    /***********************************************************
     * Method to get the longDescription of a room
     **********************************************************/
    public String getLongDescription()
    {
        String longDes = "You are " +  description;
        //see if the room even has any items
        //if the room has an item in it, add to the description
        if(hasItem())
        {
            //for every item in the room, print a description
            for(Item i : items)
            {
                longDes += "\n" + "   You see" + i.getDescription();
            }
        }
        return longDes;
    }
    
    /***********************************************************
     * Method to return the secondary description
     **********************************************************/
    public String getSecondDes()
    {
        return secondDes;
    }

    /***********************************************************
     * Method to return all of the items in a room
     **********************************************************/
    public ArrayList<Item> getItems()
    {
        //create new arraylist to  store items
        ArrayList<Item> result = new ArrayList<Item>();
        //aquire all of the items
        for(Item i : items)
        {
            result.add(i);
        }
        return result;
    }
}

