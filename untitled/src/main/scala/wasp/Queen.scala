package wasp

class Queen(name: String, isAlive: Boolean = true, hp: Int = 80) extends Wasps {
  showHp()
  override def getHit: Queen = {
    hasHp
  }

  override def hasHp: Queen = {
    if (hp <= 0) {
      println("dead")
      Queen(name, false, 0)
    }
    else {
      Queen(name, isAlive, hp - 40)
    }
  }

  private def showHp(): Unit = {
    println(hp)
  }
}
