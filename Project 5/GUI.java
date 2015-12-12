/***********************************************************
 * GUI for a text based adventure game!
 * 
 * @author Cameron Sprowls
 * @version 11/20/15
 ***********************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.DefaultCaret;
public class GUI extends JFrame implements ActionListener{
    /** Buttons for the directions in-game **/
    JButton trapDoor;
    JButton upstairs;
    JButton downstairs;
    JButton northeast;
    JButton southeast;
    JButton north;
    JButton south;
    JButton east;
    JButton west;
    JButton blank1;
    JButton blank2;

    /** Buttons for the commands in-game **/
    JButton wait;
    JButton craft;
    JButton pickup;
    JButton drop;
    JButton look;
    JButton equip;
    JButton drink;
    JButton inventory;
    JButton help;
    JButton smash;
    JButton attack;
    JButton endItAll;
    JButton clear;
    JButton repair;
    JButton track;
    
    /** Field for where all of the text in the game is displayed **/
    JTextArea textArea;

    /** Text fields for very brief instuctions **/
    JLabel directions;
    JLabel commands;

    /** Menu items **/
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem newItem;  

    /** Panels to make the buttons look good while containing them**/
    JPanel forCommands;
    JPanel forDirections;

    /** Object for the game **/
    Game game;//I lost the game
    
    /** Death counter, for fun **/
    int deathCounter;
    /***********************************************************
     * Main Method
     **********************************************************/
    public static void main(String args[]){
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Cameron Sprowls");
        gui.pack();
        gui.setVisible(true);
        gui.getContentPane().setBackground(Color.BLACK);
    }

    /***********************************************************
     * constructor installs all of the GUI components
     **********************************************************/
    public GUI(){
        //deathcounter for fun
        deathCounter = 0;
        
        //instantiate the game object for use   
        game = new Game();

        //set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        //create the text area to display the messages in-game
        textArea = new JTextArea(30,30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        //code Josh told me about to automatically 
        //update the scoll bar in textArea
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        loc.gridx = 0;
        loc.gridy = 0;
        loc.gridheight = 20;
        loc.gridwidth = 1; 
        loc.insets.right = 20;
        add(scrollPane, loc);
        loc = new GridBagConstraints();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setOpaque(true);

        //create commands label
        loc.gridx = 5;
        loc.gridy = 10;
        loc.insets.top = 40;
        commands = new JLabel("Commands");
        commands.setForeground(Color.RED);
        add(commands, loc);

        //create direction label
        loc.gridx = 5;
        loc.gridy = 0;
        directions = new JLabel("Directions");
        directions.setForeground(Color.RED);
        add(directions, loc);
        
        loc = new GridBagConstraints();
        //create Jpanel to make the direction look better
        
        //create the direction buttons
        //create and label upstairs button
        loc.gridx = 9;
        loc.gridy = 1;
        loc.insets = new Insets(10, 5, 0, 0);
        upstairs = new JButton("Upstairs");
        upstairs.setPreferredSize(new Dimension(100, 25));
        upstairs.setBackground(Color.BLUE);
        upstairs.setForeground(Color.WHITE);
        upstairs.setOpaque(true);
        add(upstairs, loc);
        loc = new GridBagConstraints();

        //create and label downstairs button
        loc.gridx = 9;
        loc.gridy = 3;
        loc.insets = new Insets(10, 5, 0, 0);
        downstairs = new JButton("Downstairs");
        downstairs.setPreferredSize(new Dimension(100, 25));
        downstairs.setBackground(Color.BLUE);
        downstairs.setForeground(Color.WHITE);
        downstairs.setOpaque(true);
        add(downstairs, loc);
        loc = new GridBagConstraints();

        //create and label west button
        loc.gridx = 1;
        loc.gridy = 2;
        loc.insets = new Insets(10, 0, 0, 10);
        west = new JButton("West");
        west.setPreferredSize(new Dimension(100, 25));
        west.setBackground(Color.ORANGE);
        west.setForeground(Color.WHITE);
        west.setOpaque(true);
        add(west, loc);
        loc = new GridBagConstraints();

        //create blank button to make it look nicer
        loc.gridx = 1;
        loc.gridy = 1;
        loc.insets = new Insets(10, 0, 0, 10);
        blank1 = new JButton("");
        blank1.setPreferredSize(new Dimension(100, 25));
        blank1.setBackground(Color.ORANGE);
        blank1.setForeground(Color.WHITE);
        blank1.setOpaque(true);
        blank1.setEnabled(false);
        add(blank1, loc);
        loc = new GridBagConstraints();

        //create blank button to make it look nicer
        loc.gridx = 1;
        loc.gridy = 3;
        loc.insets = new Insets(10, 0, 0, 10);
        blank2 = new JButton("");
        blank2.setPreferredSize(new Dimension(100, 25));
        blank2.setBackground(Color.ORANGE);
        blank2.setForeground(Color.WHITE);
        blank2.setEnabled(false);
        blank2.setOpaque(true);
        add(blank2, loc);
        loc = new GridBagConstraints();

        //create and label trapdoor button
        loc.gridx = 9;
        loc.gridy = 2;
        loc.insets = new Insets(10, 5, 0, 0);
        trapDoor = new JButton("Trap Door");
        trapDoor.setPreferredSize(new Dimension(100, 25));
        trapDoor.setBackground(Color.BLUE);
        trapDoor.setForeground(Color.WHITE);
        trapDoor.setOpaque(true);
        add(trapDoor, loc);
        loc = new GridBagConstraints();

        //create and label north button
        loc.gridx = 3;
        loc.gridy = 1;
        loc.insets = new Insets(10, 0, 0, 0);
        north = new JButton("North");
        north.setPreferredSize(new Dimension(100, 25));
        north.setBackground(Color.ORANGE);
        north.setForeground(Color.WHITE);
        north.setOpaque(true);
        add(north, loc);
        loc = new GridBagConstraints();

        //create and label south button
        loc.gridx = 3;
        loc.gridy = 3;
        loc.insets = new Insets(10, 0, 0, 0);
        south = new JButton("South");
        south.setPreferredSize(new Dimension(100, 25));
        south.setBackground(Color.ORANGE);
        south.setForeground(Color.WHITE);
        south.setOpaque(true);
        add(south, loc);
        loc = new GridBagConstraints();

        //create and label east button
        loc.gridx = 5;
        loc.gridy = 2;
        loc.insets = new Insets(10, 10, 0, 0);
        east = new JButton("East");
        east.setPreferredSize(new Dimension(100, 25));
        east.setBackground(Color.ORANGE);
        east.setForeground(Color.WHITE);
        east.setOpaque(true);
        add(east, loc);
        loc = new GridBagConstraints();

        //create and label northeast button
        loc.gridx = 5;
        loc.gridy = 1;
        loc.insets = new Insets(10, 10, 0, 0);
        northeast = new JButton("Northeast");
        northeast.setPreferredSize(new Dimension(100, 25));
        northeast.setBackground(Color.ORANGE);
        northeast.setForeground(Color.WHITE);
        northeast.setOpaque(true);
        add(northeast, loc);
        loc = new GridBagConstraints();

        //create and label southeast button
        loc.gridx = 5;
        loc.gridy = 3;
        loc.insets = new Insets(10, 10, 0, 0);
        southeast = new JButton("Southeast");
        southeast.setPreferredSize(new Dimension(100, 25));
        southeast.setBackground(Color.ORANGE);
        southeast.setForeground(Color.WHITE);
        southeast.setOpaque(true);
        add(southeast, loc);
        loc = new GridBagConstraints();

        
        //create and label help button
        loc.gridx = 5;
        loc.gridy = 11;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        help = new JButton("Help");
        help.setPreferredSize(new Dimension(100, 25));
        help.setBackground(Color.RED);
        help.setForeground(Color.WHITE);
        help.setOpaque(true);
        add(help, loc);
        loc = new GridBagConstraints();

        //create and label the smash button
        loc.gridx = 1;
        loc.gridy = 11;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        smash = new JButton("Smash");
        smash.setPreferredSize(new Dimension(100, 25));
        smash.setBackground(Color.RED);
        smash.setForeground(Color.WHITE);
        smash.setOpaque(true);
        add(smash, loc);
        loc = new GridBagConstraints();
        
        //create and label the repair button
        loc.gridx = 1;
        loc.gridy = 13;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        repair = new JButton("Repair");
        repair.setPreferredSize(new Dimension(100, 25));
        repair.setBackground(Color.RED);
        repair.setForeground(Color.WHITE);
        repair.setOpaque(true);
        add(repair, loc);
        loc = new GridBagConstraints();
        
        //create and label the clear button
        loc.gridx = 1;
        loc.gridy = 15;
        loc.gridwidth = 2;
        loc.insets = new Insets(50, 0, 0, 0);
        clear = new JButton("Clear Text");
        clear.setPreferredSize(new Dimension(100, 25));
        clear.setBackground(Color.GREEN);
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        add(clear, loc);
        loc = new GridBagConstraints();
        
        //create and label wait button
        loc.gridx = 9;
        loc.gridy = 12;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 5, 0, 20);
        wait = new JButton("Wait");
        wait.setPreferredSize(new Dimension(100, 25));
        wait.setBackground(Color.RED);
        wait.setForeground(Color.WHITE);
        wait.setOpaque(true);
        add(wait, loc);
        loc = new GridBagConstraints();

        //create and label drink button
        loc.gridx = 5;
        loc.gridy = 13;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        drink = new JButton("Drink");
        drink.setPreferredSize(new Dimension(100, 25));
        drink.setBackground(Color.RED);
        drink.setForeground(Color.WHITE);
        drink.setOpaque(true);
        add(drink, loc);
        loc = new GridBagConstraints();

        //create and label equip button
        loc.gridx = 2;
        loc.gridy = 13;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        equip = new JButton("Equip");
        equip.setPreferredSize(new Dimension(100, 25));
        equip.setBackground(Color.RED);
        equip.setForeground(Color.WHITE);
        equip.setOpaque(true);
        add(equip, loc);
        loc = new GridBagConstraints();

        //create and label look button
        loc.gridx = 7;
        loc.gridy = 11;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        look = new JButton("Look");
        look.setPreferredSize(new Dimension(100, 25));
        look.setBackground(Color.RED);
        look.setForeground(Color.WHITE);
        look.setOpaque(true);
        add(look, loc);
        loc = new GridBagConstraints();

        //create and label inventory button
        loc.gridx = 7;
        loc.gridy = 12;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        inventory = new JButton("Inventory");
        inventory.setPreferredSize(new Dimension(100, 25));
        inventory.setBackground(Color.RED);
        inventory.setForeground(Color.WHITE);
        inventory.setOpaque(true);
        add(inventory, loc);
        loc = new GridBagConstraints();

        //create and label craft button
        loc.gridx = 7;
        loc.gridy = 13;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        craft = new JButton("Craft");
        craft.setPreferredSize(new Dimension(100, 25));
        craft.setBackground(Color.RED);
        craft.setForeground(Color.WHITE);
        craft.setOpaque(true);
        add(craft, loc);
        loc = new GridBagConstraints();

        //create and label drop button
        loc.gridx = 3;
        loc.gridy = 12;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        drop = new JButton("Drop");
        drop.setPreferredSize(new Dimension(100, 25));
        drop.setBackground(Color.RED);
        drop.setForeground(Color.WHITE);
        drop.setOpaque(true);
        add(drop, loc);
        loc = new GridBagConstraints();

        //create and label attack button
        loc.gridx = 9;
        loc.gridy = 11;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 5, 0, 20);
        attack = new JButton("Attack");
        attack.setPreferredSize(new Dimension(100, 25));
        attack.setBackground(Color.RED);
        attack.setForeground(Color.WHITE);
        attack.setOpaque(true);
        add(attack, loc);
        loc = new GridBagConstraints();
        
        //create and label endItAll button
        loc.gridx = 9;
        loc.gridy = 13;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 5, 0, 20);
        endItAll = new JButton("End It All");
        endItAll.setPreferredSize(new Dimension(100, 25));
        endItAll.setBackground(Color.RED);
        endItAll.setForeground(Color.WHITE);
        endItAll.setOpaque(true);
        add(endItAll, loc);
        loc = new GridBagConstraints();
        
        //create and label pickup button
        loc.gridx = 3;
        loc.gridy = 11;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        pickup = new JButton("Pick up");
        pickup.setPreferredSize(new Dimension(100, 25));
        pickup.setBackground(Color.RED);
        pickup.setForeground(Color.WHITE);
        pickup.setOpaque(true);
        add(pickup, loc);
        loc = new GridBagConstraints();
        
        //create and label track button
        loc.gridx = 1;
        loc.gridy = 12;
        loc.gridwidth = 2;
        loc.insets = new Insets(10, 0, 0, 0);
        track = new JButton("Track");
        track.setPreferredSize(new Dimension(100, 25));
        track.setBackground(Color.RED);
        track.setForeground(Color.WHITE);
        track.setOpaque(true);
        add(track, loc);
        loc = new GridBagConstraints();

        //action listeners for the buttons
        north.addActionListener(this);
        south.addActionListener(this);
        east.addActionListener(this);
        west.addActionListener(this);
        northeast.addActionListener(this);
        southeast.addActionListener(this);
        upstairs.addActionListener(this);
        downstairs.addActionListener(this);
        trapDoor.addActionListener(this);
        wait.addActionListener(this);
        drink.addActionListener(this);
        equip.addActionListener(this);
        look.addActionListener(this);
        inventory.addActionListener(this);
        craft.addActionListener(this);
        drop.addActionListener(this);
        pickup.addActionListener(this);
        smash.addActionListener(this);
        attack.addActionListener(this);
        endItAll.addActionListener(this);
        help.addActionListener(this);
        clear.addActionListener(this);
        repair.addActionListener(this);
        track.addActionListener(this);
        
        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newItem = new JMenuItem("New Game...");
        fileMenu.add(newItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        //set the action listener for the menu items
        fileMenu.addActionListener(this);
        quitItem.addActionListener(this);
        newItem.addActionListener(this);

        //get welcome message
        textArea.append(game.getMessage());
    }

    /***********************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     **********************************************************/
    public void actionPerformed(ActionEvent e){
        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();

        //if the north button was pressed
        if(buttonPressed == north)
        {
            game.move("north");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the south button was pressed
        if(buttonPressed == south)
        {
            game.move("south");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the east button was pressed
        if(buttonPressed == east)
        {
            game.move("east");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the west button was pressed
        if(buttonPressed == west)
        {
            game.move("west");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the southeast button was pressed
        if(buttonPressed == southeast)
        {
            game.move("southeast");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the northeast button was pressed
        if(buttonPressed == northeast)
        {
            game.move("northeast");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the upstairs button was pressed
        if(buttonPressed == upstairs)
        {
            game.move("upstairs");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the downstairs button was pressed
        if(buttonPressed == downstairs)
        {
            game.move("downstairs");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the trapDoor button was pressed
        if(buttonPressed == trapDoor)
        {
            game.move("trap door");
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the repair button was pressed
        if(buttonPressed == repair)
        {
            game.repair();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the eat button was pressed
        if(buttonPressed == equip)
        {
            //ask for unput
            String name = JOptionPane.showInputDialog(
                    null, "What do you want to equp?", "Equip", JOptionPane.INFORMATION_MESSAGE);
            //if their input is less than 3 characters, warn them, and don't do anything
            if(name.length() < 3)
            {
                JOptionPane.showMessageDialog(
                    null, "Could you be more specific?", "Specify", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                game.equip(name);
                textArea.append(game.getMessage());
                    if(game.gameOver())
                        gameIsOver();
            }
        }
        //if the drink button was pressed
        if(buttonPressed == drink)
        {
            //ask for input
            String name = JOptionPane.showInputDialog(
                    null, "What do you want to drink?", "Drink", JOptionPane.INFORMATION_MESSAGE);
            //if their input is less than 3 characters, warn them, and don't do anything
            if(name.length() < 3)
            {
                JOptionPane.showMessageDialog(
                    null, "Could you be more specific?", "Specify", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                game.drink(name);
                textArea.append(game.getMessage());
                if(game.gameOver())
                    gameIsOver();
            }
        }
        //if the attack button was pressed
        if(buttonPressed == attack)
        {
            //ask for input
            String name = JOptionPane.showInputDialog(
                    null, "What do you want to use to attack?", "ATTACK", JOptionPane.INFORMATION_MESSAGE);
            //if their input is less than 3 characters, warn them, and don't do anything
            if(name.length() < 3)
            {
                JOptionPane.showMessageDialog(
                    null, "Could you be more specific?", "Specify", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                game.attack(name);
                textArea.append(game.getMessage());
                if(game.gameOver())
                    gameIsOver();
            }
        }
        //if the end it all button was pressed
        if(buttonPressed == endItAll)
        {
            game.endItAll();
            if(game.gameOver())
                gameIsOver();
        }
        //if the craft button was pressed
        if(buttonPressed == craft)
        {
            game.craftAxe();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the look button was pressed
        if(buttonPressed == look)
        {
            game.look();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the help button was pressed
        if(buttonPressed == help)
        {
            game.help();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the pickup button was pressed
        if(buttonPressed == pickup)
        {
            String name = JOptionPane.showInputDialog(
                    null, "What do you want to pick up?", "Pick up", JOptionPane.INFORMATION_MESSAGE);
            //if their input is less than 3 characters, warn them, and don't do anything
            if(name.length() < 3)
            {
                JOptionPane.showMessageDialog(
                    null, "Could you be more specific?", "Specify", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                game.pickup(name);
                textArea.append(game.getMessage());
                if(game.gameOver())
                    gameIsOver();
            }
        }
        //if the drop button was pressed
        if(buttonPressed == drop)
        {
            String name = JOptionPane.showInputDialog(
                    null, "What do you want to drop?", "Drop item", JOptionPane.INFORMATION_MESSAGE);
            //if their input is less than 3 characters, warn them, and don't do anything
            if(name.length() < 3)
            {
                JOptionPane.showMessageDialog(
                    null, "Could you be more specific?", "Specify", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                game.drop(name);
                textArea.append(game.getMessage());
                if(game.gameOver())
                    gameIsOver();
            }
        }
        //if the inventory button was pressed
        if(buttonPressed == inventory)
        {
            game.list();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the wait button was pressed
        if(buttonPressed == wait)
        {
            game.waitCommand();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the Smash button was pressed
        if(buttonPressed == smash)
        {
            game.smashWall();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the clear button was pressed
        if(buttonPressed == clear)
        {
            textArea.setText("");
        }
        //if the track button was pressed
        if(buttonPressed == track)
        {
            game.track();
            textArea.append(game.getMessage());
            if(game.gameOver())
                gameIsOver();
        }
        //if the newItem button was pressed
        if(buttonPressed == newItem)
        {
            newGame();
        }
        //if the quitItem button was pressed
        if(buttonPressed == quitItem)
        {
            System.exit(0);
        }

    }

    /***********************************************************
     * Method disable all of the buttons and print one last message
     **********************************************************/
    private void gameIsOver()
    {
        //disable all of the buttons
        trapDoor.setEnabled(false);
        upstairs.setEnabled(false);
        downstairs.setEnabled(false);
        northeast.setEnabled(false);
        southeast.setEnabled(false);
        north.setEnabled(false);
        south.setEnabled(false);
        east.setEnabled(false);
        west.setEnabled(false);
        wait.setEnabled(false);
        craft.setEnabled(false);
        pickup.setEnabled(false);
        drop.setEnabled(false);
        look.setEnabled(false);
        equip.setEnabled(false);
        drink.setEnabled(false);
        inventory.setEnabled(false);
        help.setEnabled(false);
        smash.setEnabled(false);
        attack.setEnabled(false);
        endItAll.setEnabled(false);
        clear.setEnabled(false);
        repair.setEnabled(false);
        track.setEnabled(false);
        
        //call the message one final time
        if(game.monsterAlive)
        {
            textArea.append(game.getMessage());
            JOptionPane.showMessageDialog(
            null, "You Lost...", "Oh My!", JOptionPane.INFORMATION_MESSAGE);
            deathCounter++;
            textArea.append("Total deaths: " + deathCounter);
        }
        else
        {
            textArea.append(game.getMessage());
            JOptionPane.showMessageDialog(
            null, "You WIN!!!", "Congrats!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /***********************************************************
     * Method to enable all of the buttons and restart message
     **********************************************************/
    private void newGame()
    {
        //enable all of the buttons
        trapDoor.setEnabled(true);
        upstairs.setEnabled(true);
        downstairs.setEnabled(true);
        northeast.setEnabled(true);
        southeast.setEnabled(true);
        north.setEnabled(true);
        south.setEnabled(true);
        east.setEnabled(true);
        west.setEnabled(true);
        wait.setEnabled(true);
        craft.setEnabled(true);
        pickup.setEnabled(true);
        drop.setEnabled(true);
        look.setEnabled(true);
        equip.setEnabled(true);
        drink.setEnabled(true);
        inventory.setEnabled(true);
        help.setEnabled(true);
        smash.setEnabled(true);
        attack.setEnabled(true);
        endItAll.setEnabled(true);
        clear.setEnabled(true);
        repair.setEnabled(true);
        track.setEnabled(true);
        
        //call the message to start it off
        game = new Game();
        textArea.setText(game.getMessage());
    }
}