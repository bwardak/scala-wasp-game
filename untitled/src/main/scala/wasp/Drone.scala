package wasp

class Drone(name: String, isAlive: Boolean = true, hp: Int = 60, lastHit: Boolean = false) extends Wasps{
  val RED = "\u001b[31m"
  val RESET = "\u001b[0m"
  val RED_BACKGROUND = "\u001B[41m"
  override def getHit: Wasps = {
    hasHp
  }

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Drone(name, false, 0)
    }
    else {
     if (hp == 12) Drone(name, false, 0, true) else Drone(name, isAlive, hp - 12, true)
    }
  }

  def resetColor: Wasps = {
    Drone(name, isAlive, hp, false)
  }

  override def hitpoints: Int = {
    hp
  }

  override def displayWasp: String = {
    if (lastHit) {
      s"$RED$name hp: $hp$RESET     "
    } else if (!isAlive) {
      s"$RED_BACKGROUND$name hp: $hp$RESET     "
    } else {
      s"$name hp: $hp     "
    }
  }

  override def isDead: Boolean = {
    if (isAlive) true
    else false
  }
}
