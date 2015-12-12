/****************************************************
 * A simple main method to test my game
 * 
 * @author Cameron Sprowls
 * @version 12/3/15
 ***************************************************/
public class TestGame
{
    public static void main(String[] args)
    {
        Game game = new Game();
        
        //player dies by picking up a tainted item
        System.out.println(game.getMessage());
        game.pickup("paper");
        System.out.println("Player should be dead.");
        game.gameOver();
        System.out.println(game.getMessage());
        
        //player dies by waiting in the hall
        game = new Game();
        game.move("West");
        game.waitCommand();
        game.gameOver();
        game.waitCommand();
        game.gameOver();
        game.waitCommand();
        System.out.println("Player should be dead.");
        game.gameOver();
        System.out.println(game.getMessage());
        
        //player wins the game (tests EVERY button)
        game = new Game();
        game.move("west");
        game.move("upstairs");
        game.move("West");
        game.pickup("string");
        game.move("east");
        game.move("south");
        game.move("trap door");
        game.pickup("rung");
        game.move("north");
        game.move("north");
        game.move("east");
        game.move("West");
        game.move("downstairs");
        game.move("east");
        game.move("south");
        game.pickup("gauntlets");
        game.move("north");
        game.move("West");
        game.pickup("axe");
        game.equip("gauntlets");
        game.craftAxe();
        game.move("east");
        game.move("south");
        game.smashWall();
        game.move("south");
        game.pickup("tonic");
        game.drink("tonic");
        game.move("north");
        game.move("north");
        game.move("West");
        game.waitCommand();
        game.waitCommand();
        game.move("upstairs");
        game.move("east");
        game.pickup("paper");
        game.waitCommand();
        game.waitCommand();
        game.waitCommand();
        game.move("west");
        game.move("upstairs");
        game.move("northeast");
        game.pickup("tile");
        game.move("south");
        game.pickup("doll");
        game.move("west");
        game.move("south");
        game.move("trap door");
        game.waitCommand();
        game.waitCommand();
        game.waitCommand();
        game.move("north");
        game.pickup("lava");
        game.move("north");
        game.move("downstairs");
        game.move("east");
        game.pickup("picture");
        game.move("south");
        game.move("south");
        game.move("trap door");
        game.endItAll();
        game.attack("super");
        System.out.println("After all of that crap, the player should have won.");
        System.out.println(game.getMessage());
    }
}
