package wasp


import Words.words
import java.io.{File, FileWriter, PrintWriter}
import scala.io.StdIn.*
import scala.language.postfixOps
import scala.util.Random

class Game(enemyWasps: List[Wasps] = List[Wasps](), playerName: String, hits: Int = 0, timeTaken: Long = 0) {
  val startTimer: Long = System.nanoTime()
  val originalWasps: List[Wasps] = enemyWasps



  winCondition()


  def displayWasps(): Unit = {
    printLine()
    enemyWasps.foreach(w => println(w.displayWasp))
    println("")
    nextAction()
  }

  def removeDeadWasp(): Unit = {
    val deadWaspRemovedList = enemyWasps.filter(w => w.hitpoints > 0)
    val endTimer = System.nanoTime()
    val elapsedTime = endTimer - startTimer
    Game(deadWaspRemovedList, playerName, hits, timeTaken + elapsedTime)
  }


  def attack(): Game = {
    val random = new Random()
    println("")
    println("")
    var randomNumber = random.nextInt(enemyWasps.length)
    while (enemyWasps(randomNumber).hitpoints == 0) {
      randomNumber = random.nextInt(enemyWasps.length)
    }
    val colorResetWasps = enemyWasps.map(w => w.resetColor)
    val (firstHalf, secondHalf) = colorResetWasps.splitAt(randomNumber)
    val newWasps = firstHalf ::: (colorResetWasps(randomNumber).getHit :: secondHalf.tail)
    val endTimer = System.nanoTime()
    val elapsedTime = endTimer - startTimer
    Game(newWasps, playerName, hits + 1, timeTaken + elapsedTime)
  }

  def nextAction(): Unit = {
    val random = new Random()
    val randomWord = words(random.nextInt(words.length))
    println(s"\nType $randomWord to fire: ")
    val choice = readLine
    if (choice.toLowerCase().equals(s"$randomWord")) attack()
    else {
      println("INCORRECT!")
      nextAction()
    }
  }

  def winCondition(): Unit = {
    if (enemyWasps.head.hitpoints == 0) {
      val removedQueen = enemyWasps.tail
      val endTimer = System.nanoTime()
      val elapsedTime = endTimer - startTimer
      Game(removedQueen, playerName, hits, timeTaken + elapsedTime)
    }
    val setOfCurrentWasps = enemyWasps.toSet
    val isQueenAlive = setOfCurrentWasps.exists {
      case queen: Queen => true
      case _ => false
    }
    if (!isQueenAlive) {
//      terminateInstance = true
      println("YOU KILLED THE QUEEN. YOU WIN!!!")
      val csvFile = "C:\\Users\\bahee\\nology\\scala\\projects\\wasp-game\\scala-wasp-game\\untitled\\src\\scores.csv"
      val writer = new PrintWriter(new FileWriter(new File(csvFile), true))
      val totalTime: Double = timeTaken / 1e9
      val twoDecimalPointTotalTime = f"$totalTime%.2f"
      println("hits: "  + hits + " Time: " + twoDecimalPointTotalTime)
      writer.println(playerName + " " + hits + " " + twoDecimalPointTotalTime)
      writer.close()
      Interface(playerName).playAgain()
    } else if (enemyWasps.nonEmpty & enemyWasps.head.hitpoints != 0){
      displayWasps()
    }
  }

  def printLine(): Unit = {
    println("\n".repeat(3))
    println("-".repeat(200))
    println("\n".repeat(3))
  }
}
