/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: This interface represents any kind of
 * attack a monster can perform. It extends the Ability interface, making it part of the monster's
 * abilities system.
 */

package Abilities;

import monsters.Monster;

/**
 * Attack defines a method that any implementing class must use to attack a target Monster.
 */
public interface Attack extends Ability {

  /**
   * Performs an attack on the target monster.
   *
   * @param target the Monster that is being attacked
   * @return the damage dealt as an Integer
   */
  Integer attack(Monster target);
}
