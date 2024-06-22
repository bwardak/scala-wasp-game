package wasp

import scala.io.StdIn.readInt
import scala.util.Random

class Game(enemyWasps: List[Wasps] = List[Wasps]()) {
  enemyWasps.foreach(w => if (w.hitpoints == 0) removeDeadWasp())
  displayWasps()
  def displayWasps(): Unit = {
    enemyWasps.foreach(w => print(w.displayWasp))
    nextAction()
  }

  def removeDeadWasp(): Unit = {
    val deadWaspRemovedList = enemyWasps.filter(w => w.hitpoints != 0)
    Game(deadWaspRemovedList)
  }

  def attack(): Game = {
    val random = new Random()
    println("")
    println("")
    val randomNumber = random.nextInt(enemyWasps.length)
    val (firstHalf, secondHalf) = enemyWasps.splitAt(randomNumber)
    val newWasps = firstHalf ::: (enemyWasps(randomNumber).getHit :: secondHalf.tail)
    Game(newWasps)
  }

  def nextAction(): Unit = {
    println("\nType 1 to fire: ")
    val choice = readInt()
    if (choice == 1) attack()
  }

}
