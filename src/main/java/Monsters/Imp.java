/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: This class represents a specific type of monster:
 * Imp. It initializes attributes using randomized values and sets its attack to
 * MeleeAttack.
 */

package Monsters;

import Abilities.MeleeAttack;
import java.util.HashMap;

/**
 * Imp is a Monster that uses melee attacks.
 * Its strength, defense, and agility are initialized using randomized values within specified ranges.
 */
public class Imp extends Monster {

  /**
   * Constructor for the Imp monster.
   * Sets up randomized stats and assigns a MeleeAttack ability.
   *
   * @param maxHP maximum hit points for the Imp
   * @param xp experience points
   * @param items inventory items
   */
  public Imp(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
    super(maxHP, xp, items);

    Integer maxStr = 15;
    Integer maxDef = 6;
    Integer maxAgi = 3;

    attack = new MeleeAttack(this);

    strength = super.getAttribute(strength, maxStr);
    defense = super.getAttribute(defense, maxDef);
    agility = super.getAttribute(agility, maxAgi);
  }

  /**
   * Provides a string representation of the Imp, including its current HP.
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return "Monsters.Imp has : " + super.toString();
  }
}
