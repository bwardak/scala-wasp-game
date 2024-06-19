package wasp

class Drone(name: String, isAlive: Boolean = true, hp: Int = 60) extends Wasps{
  showHp()
  override def getHit: Wasps = super.getHit

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Drone(name, false, 0)
    }
    else {
      Drone(name, isAlive, hp - 12)
    }
  }

  private def showHp(): Unit = {
    println(hp)
  }
}
