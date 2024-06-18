package wasp

class Queen(name: String, isAlive: Boolean = true, hp: Int = 80) extends Wasps {
  override def getHit: Queen = {
    Queen(name, isAlive, hp - 7)
  }

  override def hasHp(): Unit = {
    if (hp <= 0) Queen(name, false, hp)
    else getHit
  }

  def queenDead(): Unit = {

  }

  def showHp(): Unit = {
    println(hp)
  }
}
