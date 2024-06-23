package wasp



import scala.io.StdIn.*
import scala.language.postfixOps
import scala.util.Random

class Game(enemyWasps: List[Wasps] = List[Wasps]()) {
  var terminateInstance = false
  val originalWasps: List[Wasps] = enemyWasps


  if (!terminateInstance) {
    winCondition()
  }

  def displayWasps(): Unit = {
    enemyWasps.foreach(w => println(w.displayWasp))
    println("")
    nextAction()
  }

  def removeDeadWasp(): Unit = {
    val deadWaspRemovedList = enemyWasps.filter(w => w.hitpoints > 0)
    println("11111111111111111")
    Game(deadWaspRemovedList)
  }


  def attack(): Game = {
    val random = new Random()
    println("")
    println("")
    val randomNumber = random.nextInt(enemyWasps.length)
    val colorResetWasps = enemyWasps.map(w => w.resetColor)
    val (firstHalf, secondHalf) = colorResetWasps.splitAt(randomNumber)
    val newWasps = firstHalf ::: (colorResetWasps(randomNumber).getHit :: secondHalf.tail)
    println("222222222")
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
      terminateInstance = true
      println("YOU KILLED THE QUEEN. YOU WIN!!!")
      Interface(originalWasps).playAgain()
    } else if (enemyWasps.nonEmpty & enemyWasps.head.hitpoints != 0){
      displayWasps()
    }
  }

  def changeTextColorBack(): Unit = {

  }
}
