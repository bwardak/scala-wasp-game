package wasp

import scala.io.Source
import scala.io.StdIn.*

class Interface(var playerName: String) {

  def gameLaunchScreen(): Unit = {
    println("Welcome to wasp game")
    println("Pick an option:")
    startGameOrReadRules()
  }

  def rules(): Unit = {
    println(" - You must face 14 wasps and eliminate the queen")
    println(" - Write the attack word to attack")
    startGameOrReadRules()
  }

  def startGameOrReadRules(): Unit = {
    println("1) Start Game")
    println("2) Read Rules")
    println("3) Leaderboard")
    println("4) Quit")
    val choice = readInt()
    if (choice == 1){
      println("Enter your name: ")
      playerName = readLine()
      val waspList = WaspGame.createNewWasps()
      Game(waspList, playerName, 0, 0)
    }
    else if (choice == 2) rules()
    else if (choice == 3) displayLeaderboard()
    else if (choice == 4) println("Thanks for playing!")
  }

  def displayLeaderboard(): Unit = {
    val statsFile = "C:\\Users\\bahee\\nology\\scala\\projects\\wasp-game\\scala-wasp-game\\untitled\\src\\scores.csv"
    val playerStats = Source.fromFile(statsFile).getLines().toList
    val individualStats = playerStats.map { player =>
      val splittedStats = player.split(" ")
      val username = splittedStats(0)
      val userHits = splittedStats(1).toInt
      val userTimeTaken = splittedStats(2).toDouble
      (username, userHits, userTimeTaken)
    }
    val sortedByTimeTaken = individualStats.sortBy(_._3)

    println(f"Rank  Player Name       Hits  Time Taken")
    sortedByTimeTaken.zipWithIndex.foreach {
      case ((pName, pHits, pTimeTaken), index) => println(f"${index + 1}%-4d  $pName%-16s  $pHits%-4d  $pTimeTaken%-5.2f seconds")
    }
    startGameOrReadRules()
  }

  def playAgain(): Unit = {
    println("Do you want to play again? (Y/N)")
    val choice = readLine()
    if (choice.toUpperCase().equals("Y")){
      println("666666666666666666666666")
      val waspList = WaspGame.createNewWasps()
      Game(waspList, playerName)
    }  else startGameOrReadRules()
  }
}
