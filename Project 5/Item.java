/***********************************************************
 * A  class to deal with the items in the game
 * 
 * @author Cameron Sprowls 
 * @version 11/20/15
 **********************************************************/
public class Item
{
    /** Is item able to be equiped **/
    boolean equipable;
    
    /** Is item able to be drank **/
    boolean drink;
    
    /** Item weight **/
    int weight;
    
    /** Item's description **/
    String description;
    
    /** Name of Item **/
    String itemName;
    
    /***********************************************************
    * Default constructor for the items
    * 
    * @param string for the name of the item
    * @param int for the weight of the item
    * @param boolean if the item can be equiped
    * @param boolean if the item can be drank
    * @param string for the description pf the item
    ***********************************************************/
    public Item(String name,int tempWeight,boolean canEquip,boolean canDrink,String tempDescription)
    {
        equipable = canEquip;
        drink = canDrink;
        weight = tempWeight;
        description = tempDescription;
        itemName = name;
    }
    
    //start of accessor methods
    /***********************************************************
     * Method to return the name of the string
     * 
     * @return the items name
     **********************************************************/
    public String getName()
    {
        return itemName;
    }
    
    
    /***********************************************************
     * Method to return the weight of the item
     * 
     * @return the weight of the item in question
     **********************************************************/
    public int getWeight()
    {
        return weight;
    }
    
    
    /***********************************************************
     * Method to return the description of the item
     * 
     * @return the descrption of the item in question
     **********************************************************/
    public String getDescription()
    {
        return description;
    }
    
    
    /***********************************************************
     * Method to check if the item is edible
     * 
     * @return true or false based on if the item is edible
     **********************************************************/
    public boolean isEquipable()
    {
        return equipable;
    }
    
    
    /***********************************************************
     * Method to check if the item is drinkable
     * 
     * @return true or false based on if the item is drinkable
    **********************************************************/
    public boolean isDrinkable()
    {
        return drink;
    }
    //end of the accessor methods
    
    
    //Start of the mutator methods
    /***********************************************************
     * Method to change the name of an item to given string
     * 
     * @param String to be the new name of the item
     **********************************************************/
    public void changeName(String tName)
    {
        itemName = tName;
    }
    
    
    /***********************************************************
     * Method to change the weight of any item
     * 
     * @param Int to be the new weight of the item
     **********************************************************/
    public void changeWeight(int tWeight)
    {
        weight = tWeight;
    }
    
    
    /***********************************************************
     * Method to change the description of any item
     * 
     * @param String to be the new description of the item
     **********************************************************/
    public void changeDescription(String tDes)
    {
        description = tDes;
    }
    
    
    /***********************************************************
     * Method to swap the drinkability of an item
     **********************************************************/
    public void swapDrinkable()
    {
        drink = !drink;
    }
    //end of mutator methods
}
