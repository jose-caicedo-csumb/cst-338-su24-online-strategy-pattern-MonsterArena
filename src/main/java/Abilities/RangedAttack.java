/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: This class represents a ranged attack
 * ability. It implements the Attack interface and calculates damage using agility.
 */

package Abilities;

import monsters.Monster;

/**
 * RangedAttack is a type of Attack that uses agility to determine damage.
 */
public class RangedAttack implements Attack {

  Monster attacker;

  /**
   * Constructor that sets the attacking monster.
   *
   * @param attacker the monster performing the ranged attack
   */
  public RangedAttack(Monster attacker) {
    this.attacker = attacker;
  }

  /**
   * Executes the ranged attack and prints out the action.
   *
   * @param target the monster being attacked
   * @return the damage dealt (attacker's agility - target's agility)
   */
  @Override
  public Integer attack(Monster target) {
    String message = attacker + " uses a ranged attack on " + target;
    System.out.println(message);
    return attacker.getAgility() - target.getAgility();
  }
}
