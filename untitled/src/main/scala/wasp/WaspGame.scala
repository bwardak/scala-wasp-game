package wasp

object WaspGame extends App {
//  val queen = Queen("queen", true).getHit.getHit.getHit
//  val  worker = Worker("Worker", true).getHit.getHit.getHit
//  val  drone = Drone("Drone", true).getHit.getHit.getHit
def createNewWasps(): List[Wasps] = {
  List(
    new Queen("Queen"),
    new Worker("w1"),
    new Worker("w2"),
    new Worker("w3"),
    new Worker("w4"),
    new Worker("w5"),
    new Drone("d1"),
    new Drone("d2"),
    new Drone("d3"),
    new Drone("d4"),
    new Drone("d5"),
    new Drone("d6"),
    new Drone("d7"),
    new Drone("d8")
  )
}

  val menu = new Interface("")
  menu.gameLaunchScreen()




  
  




}
