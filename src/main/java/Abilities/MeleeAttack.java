/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: This class represents a melee attack
 * ability. It implements the Attack interface and performs a basic strength vs. defense
 * calculation.
 */

package Abilities;

import monsters.Monster;

/**
 * MeleeAttack is a concrete implementation of the Attack interface.
 * It uses the attacker's strength and the target's defense to determine damage.
 */
public class MeleeAttack implements Attack {

  Monster attacker;

  /**
   * Constructor assigns the attacking monster.
   *
   * @param attacker the monster performing the attack
   */
  public MeleeAttack(Monster attacker) {
    this.attacker = attacker;
  }

  /**
   * Executes the melee attack and prints the action.
   *
   * @param target the monster being attacked
   * @return the damage dealt (strength - defense)
   */
  @Override
  public Integer attack(Monster target) {
    String message = attacker + " uses a melee attack on " + target;
    System.out.println(message);
    return attacker.getStrength() - target.getDefense();
  }
}
