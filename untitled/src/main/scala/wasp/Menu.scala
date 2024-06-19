package wasp

import scala.io.StdIn._

class Menu {

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
    val choice = readInt()
    if (choice == 1) gameLaunchScreen()
    else if (choice == 2) rules()
  }
}
