/*
 * Author: Jose Caicedo
 * Created on: 7/13/25
 * Description: This class contains unit tests for the abstract Monster class using an inner subclass
 * (TestMonster) to instantiate concrete objects. The tests verify expected behavior for
 * getter/setter methods, combat logic, equality, and string representation.
 */

package monsters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Monster class functionality.
 */
public class MonsterTest {

  /**
   * A simple concrete subclass of Monster for testing.
   * Implements a fixed attack of 5 damage.
   */
  static class TestMonster extends Monster {
    public TestMonster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
      super(maxHP, xp, items);
      this.attack = (target) -> 5; // fixed damage for consistent testing
    }
  }

  private TestMonster monster;
  private TestMonster target;

  /**
   * Sets up a test monster and a target monster before each test.
   */
  @BeforeEach
  void setUp() {
    monster = new TestMonster(100, 20, new HashMap<>());
    target = new TestMonster(50, 10, new HashMap<>());
  }

  /** Tests getHp() returns correct current HP. */
  @Test
  void getHp() {
    assertEquals(100, monster.getHp());
  }

  /** Tests setHp() correctly updates HP. */
  @Test
  void setHp() {
    monster.setHp(80);
    assertEquals(80, monster.getHp());
  }

  /** Tests getXp() returns correct experience points. */
  @Test
  void getXp() {
    assertEquals(20, monster.getXp());
  }

  /** Tests getItems() is not null by default. */
  @Test
  void getItems() {
    assertNotNull(monster.getItems());
  }

  /** Tests setItems() correctly updates the items HashMap. */
  @Test
  void setItems() {
    HashMap<String, Integer> items = new HashMap<>();
    items.put("potion", 2);
    monster.setItems(items);
    assertEquals(items, monster.getItems());
  }

  /** Tests getMaxHP() returns the monster's max HP value. */
  @Test
  void getMaxHP() {
    assertEquals(100, monster.getMaxHP());
  }

  /** Tests getAgility() returns default agility value. */
  @Test
  void getAgility() {
    assertEquals(10, monster.getAgility());
  }

  /** Tests getDefense() returns default defense value. */
  @Test
  void getDefense() {
    assertEquals(10, monster.getDefense());
  }

  /** Tests getStrength() returns default strength value. */
  @Test
  void getStrength() {
    assertEquals(10, monster.getStrength());
  }

  /** Tests getAttribute() returns a random value within a range. */
  @Test
  void getAttribute() {
    int value = monster.getAttribute(1, 5);
    assertTrue(value >= 1 && value < 5);
  }

  /** Tests takeDamage() reduces HP and returns correct alive/dead state. */
  @Test
  void takeDamage() {
    boolean alive = monster.takeDamage(20);
    assertTrue(alive);
    assertEquals(80, monster.getHp());

    alive = monster.takeDamage(100);
    assertFalse(alive);
    assertEquals(0, monster.getHp());
  }

  /** Tests attackTarget() causes damage and returns combat result. */
  @Test
  void attackTarget() {
    int result = monster.attackTarget(target);
    assertEquals(1, result);
    assertEquals(45, target.getHp());
  }

  /** Tests equals() logic between identical and modified monsters. */
  @Test
  void testEquals() {
    TestMonster m2 = new TestMonster(100, 20, new HashMap<>());
    assertEquals(monster, m2);
    m2.setHp(90);
    assertNotEquals(monster, m2);
  }

  /** Tests hashCode() consistency for equal objects. */
  @Test
  void testHashCode() {
    TestMonster m2 = new TestMonster(100, 20, new HashMap<>());
    assertEquals(monster.hashCode(), m2.hashCode());
  }

  /** Tests toString() formatting of HP output. */
  @Test
  void testToString() {
    assertEquals("hp=100/100", monster.toString());
  }
}
