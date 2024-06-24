package wasp



import java.io.{File, PrintWriter}
import scala.io.StdIn.*
import scala.language.postfixOps
import scala.util.Random

class Game(enemyWasps: List[Wasps] = List[Wasps](), playerName: String) {

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
    Game(deadWaspRemovedList, playerName)
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
    Game(newWasps, playerName)
  }

  def nextAction(): Unit = {
    println("\nType fire to fire: ")
    val choice = readLine
    if (choice.toLowerCase().equals("fire")) attack()
  }

  def winCondition(): Unit = {
    if (enemyWasps.head.hitpoints == 0) {
      val removedQueen = enemyWasps.tail
      Game(removedQueen, playerName)
    }
    val setOfCurrentWasps = enemyWasps.toSet
    val isQueenAlive = setOfCurrentWasps.exists {
      case queen: Queen => true
      case _ => false
    }
    if (!isQueenAlive) {
      terminateInstance = true
      println("YOU KILLED THE QUEEN. YOU WIN!!!")
      val csvFile = "C:\\Users\\bahee\\nology\\scala\\projects\\wasp-game\\scala-wasp-game\\untitled\\src\\scores.csv"
      val writer = new PrintWriter(new File(csvFile))
      println(playerName)
      writer.println(playerName)
      writer.close()
      Interface(originalWasps).playAgain()
    } else if (enemyWasps.nonEmpty & enemyWasps.head.hitpoints != 0){
      displayWasps()
    }
  }

  def changeTextColorBack(): Unit = {

  }
}
