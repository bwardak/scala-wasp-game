package wasp

import wasp.WaspGame.{drone1, drone2, drone3, drone4, drone5, drone6, drone7, drone8, queen, worker1, worker2, worker3, worker4, worker5}

import scala.io.StdIn.*
import scala.language.postfixOps
import scala.util.Random

class Game(enemyWasps: List[Wasps] = List[Wasps]()) {
  val originalWasps: List[Wasps] = List(queen, worker1, worker2, worker3, worker4, worker5, drone1, drone2, drone3, drone4, drone5, drone6, drone7, drone8)



  enemyWasps.foreach(w => if (w.hitpoints == 0) removeDeadWasp())
  winCondition()
  def displayWasps(): Unit = {
    println("                                                      " + enemyWasps.head.displayWasp)
    print("              ")
    for (i <- Range(1, 6)) {
      print("        " + enemyWasps(i).displayWasp)
    }
    println("\n")
    print("    ")
    for (i <- Range(6, 14)) {
      print("  " + enemyWasps(i).displayWasp)
    }
    println("")
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
    println(enemyWasps.length)
    val randomNumber = random.nextInt(enemyWasps.length)
    println(randomNumber)
    val colorResetWasps = enemyWasps.map(w => w.resetColor)
    val (firstHalf, secondHalf) = colorResetWasps.splitAt(randomNumber)
    val newWasps = firstHalf ::: (colorResetWasps(randomNumber).getHit :: secondHalf.tail)
    Game(newWasps)
  }

  def nextAction(): Unit = {
    println("\nType fire to fire: ")
    val choice = readLine
    if (choice.toLowerCase().equals("fire")) attack()
  }

  def winCondition(): Unit = {
    val setOfCurrentWasps = enemyWasps.toSet
    val isQueenAlive = setOfCurrentWasps.exists {
      case queen: Queen => true
      case _ => false
    }
    if (!isQueenAlive) {
      println("YOU KILLED THE QUEEN. YOU WIN!!!")
      Interface(originalWasps).playAgain()
    } else if (enemyWasps.nonEmpty & enemyWasps.head.hitpoints != 0){
      displayWasps()
    }
  }

  def changeTextColorBack(): Unit = {

  }
}
