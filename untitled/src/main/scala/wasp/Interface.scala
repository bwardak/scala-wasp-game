package wasp

import scala.io.Source
import scala.io.StdIn.*

class Interface(var playerName: String) {
  val GOLD = "\u001b[33m"
  val RESET = "\u001b[0m"

  def gameLaunchScreen(): Unit = {
    println("Welcome to wasp game")
    println(s"${GOLD}__      ____ _ ___ _ __      \" ,  ,\n\\ \\ /\\ / / _` / __| '_ \\         \", ,\n \\ V  V / (_| \\__ \\ |_) |          \"\"     _---.    ..;%%%;, .\n  \\_/\\_/ \\__,_|___/ .__/             \"\" .\",  ,  .==% %%%%%%% ' .\n                  | |                 \"\", %%%   =%% %%%%%%;  ; ;-_\n                  |_|                 %; %%%%%  .;%;%%%\"%p ---; _  '-_\n                                      %; %%%%% __;%%;p/; O        --_ \"-,_\n                                       q; %%% /v \\;%p ;%%%%%;--__    \"'-__'-._\n                                       //\\\\\" // \\  % ;%%%%%%%;',/%\\_  __  \"'-_'\\_\n                                       \\  / //   \\/   ;%% %; %;/\\%%%%;;;;\\    \"- _\\\n                                          ,\"             %;  %%;  %%;;'  ';%       -\\-_\n                                     -=\\=\"             __%    %%;_ |;;    %%%\\          \\\n                                                   _/ _=      \\==_;;,_ %%%; % -_      /\n                                                  / /-          =%- ;%%%%; %%;  \"--__/\n                                                 //=             ==%-%%;  %; %\n                                                 /             _=_-  d  ;%; ;%;  :F_P:\n                                                 \\            =,-\"    d%%; ;%%;\n                                                             //        %  ;%%;\n                                                            //          d%%%\"\n                                                             \\           %%\n                                                                         V$RESET")
    Thread.sleep(2000)
    println("Pick an option:")
    startGameOrReadRules()
  }

  private def rules(): Unit = {
    println(" - You must face 14 wasps and eliminate the queen")
    println(" - Write the given word to attack")
    println(" - You may write 'quit' to exit the game early")
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
      playerName = readLine().trim
      playerName = playerName.replaceAll("\\s", "")
      val waspList = WaspList().createNewWasps()
      Game(waspList, playerName, 0, 0)
    }
    else if (choice == 2) rules()
    else if (choice == 3) displayLeaderboard()
    else if (choice == 4) println("Thanks for playing!")
    else {
      println("Please input a valid number")
      startGameOrReadRules()
    }
  }

  private def displayLeaderboard(): Unit = {
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
    println("\n".repeat(5))
    println(f"Rank  Player Name       Hits  Time Taken")
    sortedByTimeTaken.zipWithIndex.foreach {
      case ((pName, pHits, pTimeTaken), index) => println(f"${index + 1}%-4d  $pName%-16s  $pHits%-4d  $pTimeTaken%-5.2f seconds")
    }
    println("\n".repeat(5))
    startGameOrReadRules()
  }

  def playAgain(): Unit = {
    println("Do you want to play again? (Y/N)")
    val choice = readLine()
    if (choice.toUpperCase().equals("Y")){
      val waspList = WaspList().createNewWasps()
      Game(waspList, playerName)
    }  else if (choice.toUpperCase().equals("N")) startGameOrReadRules()
    else {
      println("Invalid input. Please select Y or N")
      playAgain()
    }
  }
}
