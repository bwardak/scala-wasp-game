package wasp

class Worker(name: String, isAlive: Boolean = true, hp: Int = 68) extends Wasps {
  showHp()
  override def getHit: Wasps = super.getHit

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Worker(name, false, 0)
    }
    else {
      Worker(name, isAlive, hp - 10)
    }
  }

  private def showHp(): Unit = {
    println(hp)
  }
}
