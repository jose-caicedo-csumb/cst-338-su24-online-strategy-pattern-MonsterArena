/**
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Explanation: Abstract base class for all monsters.
 * Provides shared attributes and behavior.
 */

package Monsters;

import Abilities.Attack;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a base monster with common fields and behavior.
 * Includes health, combat attributes, attack logic, and utility methods.
 */
public abstract class Monster {

  protected Integer hp;
  protected Integer xp = 10; // default

  Integer agility = 10;
  Integer defense = 10;
  Integer strength = 10;
  Attack attack;

  protected Integer maxHP;
  protected HashMap<String, Integer> items;

  /**
   * Constructs a Monster with given maxHP, XP, and items.
   *
   * @param maxHP maximum health points
   * @param xp experience points
   * @param items item inventory
   */
  public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
    this.maxHP = maxHP;
    this.hp = maxHP;
    this.xp = xp;
    this.items = items;
  }

  /**
   * Gets the current HP of the monster.
   *
   * @return current HP
   */
  public Integer getHp() {
    return hp;
  }

  /**
   * Sets the monster's HP.
   *
   * @param hp new HP value
   */
  public void setHp(Integer hp) {
    this.hp = hp;
  }

  /**
   * Gets the XP value.
   *
   * @return XP
   */
  public Integer getXp() {
    return xp;
  }

  /**
   * Gets the inventory items.
   *
   * @return item map
   */
  public HashMap<String, Integer> getItems() {
    return items;
  }

  /**
   * Sets the item map.
   *
   * @param items new inventory
   */
  public void setItems(HashMap<String, Integer> items) {
    this.items = items;
  }

  /**
   * Gets the monster's maximum HP.
   *
   * @return max HP
   */
  public Integer getMaxHP() {
    return maxHP;
  }

  /**
   * Gets the agility stat.
   *
   * @return agility
   */
  public Integer getAgility() {
    return agility;
  }

  /**
   * Gets the defense stat.
   *
   * @return defense
   */
  public Integer getDefense() {
    return defense;
  }

  /**
   * Gets the strength stat.
   *
   * @return strength
   */
  public Integer getStrength() {
    return strength;
  }

  /**
   * Generates a random attribute between min and max.
   *
   * @param min lower bound (inclusive)
   * @param max upper bound (exclusive)
   * @return random value between min and max
   */
  public Integer getAttribute(Integer min, Integer max) {
    Random rand = new Random();
    if (min > max) {
      Integer temp = min;
      min = max;
      max = temp;
    }
    return rand.nextInt(max - min) + min;
  }

  /**
   * Applies damage to the monster and checks if it's still alive.
   *
   * @param damage amount of damage taken
   * @return true if HP > 0, false if dead
   */
  public boolean takeDamage(Integer damage) {
    if (damage > 0) {
      System.out.println("The creature was hit for " + damage + " damage");
      hp -= damage;
      if (hp < 0) {
        hp = 0;
      }
    }

    if (hp <= 0) {
      System.out.println("Oh no! the creature has perished");
      System.out.println(this);
      return false;
    }

    return true;
  }

  /**
   * Attacks another monster and applies damage.
   *
   * @param target the monster being attacked
   * @return damage dealt
   */
  public Integer attackTarget(Monster target) {
    return target.takeDamage(attack.attack(target)) ? 1 : 0;
  }

  /**
   * Checks if two monsters are equal based on core fields.
   *
   * @param o other object
   * @return true if equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Monster monster = (Monster) o;
    return Objects.equals(hp, monster.hp) &&
        Objects.equals(xp, monster.xp) &&
        Objects.equals(maxHP, monster.maxHP) &&
        Objects.equals(items, monster.items);
  }

  /**
   * Generates a hash code for this monster.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(hp, xp, maxHP, items);
  }

  /**
   * Returns a string with the monster's HP.
   *
   * @return formatted HP string
   */
  @Override
  public String toString() {
    return "hp=" + hp + "/" + maxHP;
  }
}
