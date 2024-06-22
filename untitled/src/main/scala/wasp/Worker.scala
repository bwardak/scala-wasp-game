package wasp

class Worker(name: String, isAlive: Boolean = true, hp: Int = 68) extends Wasps {
  override def getHit: Wasps = {
    hasHp
  }

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Worker(name, false, 0)
    }
    else {
      if (hp <= 10) Worker(name, isAlive, 0) else Worker(name, isAlive, hp - 10)
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
