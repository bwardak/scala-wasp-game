package wasp

import scala.io.StdIn._

class Interface {

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
    if (choice == 1) gameLaunchScreen()
    else if (choice == 2) rules()
    else if (choice == 3) println("Thanks for playing!")
  }

  def playAgain(waspList: List[Wasps]): Unit = {
    println("Do you want to play again? (Y/N)")
    val choice = readLine()
    if (choice.toUpperCase().equals("Y")) new Game(waspList) else startGameOrReadRules()
  }
}
