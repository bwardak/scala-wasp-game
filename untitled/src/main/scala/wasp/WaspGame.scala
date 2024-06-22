package wasp

object WaspGame extends App {
//  val queen = Queen("queen", true).getHit.getHit.getHit
//  val  worker = Worker("Worker", true).getHit.getHit.getHit
//  val  drone = Drone("Drone", true).getHit.getHit.getHit
  var queen = new Queen("Queen")
  var worker1 = new Worker("w1")
  var worker2 = new Worker("w2")
  var worker3 = new Worker("w3")
  var worker4 = new Worker("w4")
  var worker5 = new Worker("w5")
  var drone1 = new Drone("d1")
  var drone2 = new Drone("d2")
  var drone3 = new Drone("d3")
  var drone4 = new Drone("d4")
  var drone5 = new Drone("d5")
  var drone6 = new Drone("d6")
  var drone7 = new Drone("d7")
  var drone8 = new Drone("d8")



  val menu = Interface(List(queen, worker1, worker2, worker3, worker4, worker5, drone1, drone2, drone3, drone4, drone5, drone6, drone7, drone8))


  menu.gameLaunchScreen()




  
  




}
