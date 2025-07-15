/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: This is the main class used to test Monster
 * behavior. It creates a list of monsters and runs a battle loop where
 * they attack each other until one dies.
 */

import Monsters.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Driver is the main class that runs the program.
 * It demonstrates how Imp and Kobold monsters interact and attack.
 */
public class Driver {

    /**
     * Entry point of the program. Initializes monsters and simulates a turn-based battle.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        // Create shared items for both monsters
        HashMap<String, Integer> items = new HashMap<>();
        items.put("gold", 5);

        // Create list and add two monsters: one Imp and one Kobold
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Imp(15, 20, items));
        monsters.add(new Kobold(1, 5, items));

        // Print initial status of each monster
        for (Monster m : monsters) {
            System.out.println(m);
        }

        // Simulate turn-based battle until one of the monsters dies
        while (monsters.get(0).getHp() > 0 && monsters.get(1).getHp() > 0) {
            System.out.println(monsters.get(0).attackTarget(monsters.get(1)));
            if (monsters.get(1).getHp() > 0) {
                System.out.println(monsters.get(1).attackTarget(monsters.get(0)));
            }
        }
    }
}
