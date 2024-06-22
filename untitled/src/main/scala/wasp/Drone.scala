package wasp

class Drone(name: String, isAlive: Boolean = true, hp: Int = 60) extends Wasps{
  override def getHit: Wasps = {
    hasHp
  }

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Drone(name, false, 0)
    }
    else {
      Drone(name, isAlive, hp - 12)
    }
  }

  override def hitpoints: Int = {
    hp
  }

  override def displayWasp: String = {
    s"$name hp: $hp     "
  }

  override def isDead: Boolean = {
    if (isAlive) true
    else false
  }
}
