package wasp

class Queen(name: String, isAlive: Boolean = true, hp: Int = 80) extends Wasps {
  override def getHit: Queen = {
    hasHp
  }

  override def hasHp: Queen = {
    if (hp <= 0) {
      println("dead")
      Queen(name, false, 0)
    }
    else {
      if (hp <= 7) Queen(name, isAlive, 0) else Queen(name, isAlive, hp - 40)
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
