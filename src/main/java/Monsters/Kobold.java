/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: This class represents a Kobold monster. It
 * initializes stats using randomized values and uses a RangedAttack ability.
 */

package Monsters;

import Abilities.RangedAttack;
import java.util.HashMap;

/**
 * Kobold is a Monster that specializes in ranged attacks.
 * Its strength, defense, and agility are set using randomized values based on custom max values.
 */
public class Kobold extends Monster {

  /**
   * Constructor for the Kobold monster.
   * Sets up randomized stats and assigns a RangedAttack ability.
   *
   * @param maxHP maximum hit points for the Kobold
   * @param xp experience points
   * @param items inventory items
   */
  public Kobold(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
    super(maxHP, xp, items);

    Integer maxStr = 8;
    Integer maxDef = 5;
    Integer maxAgi = 12;

    attack = new RangedAttack(this);
    strength = super.getAttribute(strength, maxStr);
    defense = super.getAttribute(defense, maxDef);
    agility = super.getAttribute(agility, maxAgi);
  }

  /**
   * Provides a string representation of the Kobold, including its current HP.
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return "Monsters.Kobold has : " + super.toString();
  }
}
