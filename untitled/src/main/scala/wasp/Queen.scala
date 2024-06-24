package wasp

class Queen(name: String, isAlive: Boolean = true, hp: Int = 80, lastHit: Boolean = false) extends Wasps {
  val RED = "\u001b[31m"
  val RESET = "\u001b[0m"
  override def getHit: Queen = {
    hasHp
  }

  override def hasHp: Queen = {
    if (hp <= 0) {
      println("dead")
      Queen(name, false, 0)
    }
    else {
      if (hp <= 7) Queen(name, false, 0, true) else Queen(name, isAlive, hp - 80, true)
    }
  }

  def resetColor: Wasps = {
    Queen(name, isAlive, hp, false)
  }

  override def hitpoints: Int = {
    hp
  }

  override def displayWasp: String = {
    if (lastHit) s"$RED$name hp: $hp$RESET\n" else s"$name hp: $hp\n"
  }

  override def isDead: Boolean = {
    if (isAlive) true
    else false
  }
}
