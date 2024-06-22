package wasp

import wasp.WaspGame.{drone1, drone2, drone3, drone4, drone5, queen, worker1, worker2, worker3}

import scala.io.StdIn.*
import scala.language.postfixOps
import scala.util.Random

class Game(enemyWasps: List[Wasps] = List[Wasps]()) {
  val originalWasps: List[Wasps] = List(queen, drone1, drone2, drone3, drone4, drone5, worker1, worker2, worker3)
  enemyWasps.foreach(w => if (w.hitpoints == 0) removeDeadWasp())
  winCondition()
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

  def winCondition(): Unit = {
    if (enemyWasps.isEmpty) {
      println("YOU KILLED THE QUEEN. YOU WIN!!!")
      Interface().playAgain(originalWasps)
    } else if (enemyWasps.nonEmpty & enemyWasps.head.hitpoints != 0){
      displayWasps()
    }
  }
}
