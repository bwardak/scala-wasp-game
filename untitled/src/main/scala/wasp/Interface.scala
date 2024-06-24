package wasp

import scala.io.StdIn._

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
    println("3) Quit")
    val choice = readInt()
    if (choice == 1){
      println("Enter your name: ")
      playerName = readLine()
      val waspList = WaspGame.createNewWasps()
      Game(waspList, playerName, 0, 0)
    }
    else if (choice == 2) rules()
    else if (choice == 3) println("Thanks for playing!")
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
