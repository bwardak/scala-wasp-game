package wasp

object WaspGame extends App {
//  val queen = Queen("queen", true).getHit.getHit.getHit
//  val  worker = Worker("Worker", true).getHit.getHit.getHit
//  val  drone = Drone("Drone", true).getHit.getHit.getHit
  var queen = new Queen("Queen")
  var drone1 = new Drone("d1")
  var drone2 = new Drone("d2")
  var drone3 = new Drone("d3")
  var drone4 = new Drone("d4")
  var drone5 = new Drone("d5")
  var worker1 = new Worker("w1")
  var worker2 = new Worker("w2")
  var worker3 = new Worker("w3")

  


  val menu = Interface()
  val gameInterface = Interface()

//  menu.gameLaunchScreen()
  val game = Game(List(queen))



  
  




}
