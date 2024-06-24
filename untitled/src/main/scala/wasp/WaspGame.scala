package wasp

object WaspGame extends App {
def createNewWasps(): List[Wasps] = {
  List(
    new Queen("QUEEN   "),
    new Worker("WORKER 1"),
    new Worker("WORKER 2"),
    new Worker("WORKER 3"),
    new Worker("WORKER 4"),
    new Worker("WORKER 5"),
    new Drone("DRONE  1"),
    new Drone("DRONE  2"),
    new Drone("DRONE  3"),
    new Drone("DRONE  4"),
    new Drone("DRONE  5"),
    new Drone("DRONE  6"),
    new Drone("DRONE  7"),
    new Drone("DRONE  8")
  )
}

  val menu = new Interface("")
  menu.gameLaunchScreen()




  
  




}
