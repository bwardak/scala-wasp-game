package wasp

class Worker(name: String, isAlive: Boolean = true, hp: Int = 68, lastHit: Boolean = false) extends Wasps {
  val RED = "\u001b[31m"
  val RESET = "\u001b[0m"
  override def getHit: Wasps = {
    hasHp
  }

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Worker(name, false, 0)
    }
    else {
      if (hp <= 10) Worker(name, isAlive, 0, true) else Worker(name, isAlive, hp - 10, true)
    }
  }

  def resetColor: Wasps = {
    Worker(name, isAlive, hp, false)
  }

  override def hitpoints: Int = {
    hp
  }

  override def displayWasp: String = {
    if (lastHit) s"$RED$name hp: $hp$RESET     " else s"$name hp: $hp     "
  }

  override def isDead: Boolean = {
    if (isAlive) true
    else false
  }
}
