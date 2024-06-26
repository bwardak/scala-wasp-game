package wasp

class Queen(name: String, isAlive: Boolean = true, hp: Int = 80, lastHit: Boolean = false) extends Wasps {
  val RED = "\u001b[31m"
  val GOLD = "\u001b[33;1m"
  val RESET = "\u001b[0m"
  val RED_BACKGROUND = "\u001B[41m"
  val GREEN_BACKGROUND = "\u001b[42m"
  val BOLD = "\u001b[1m"
  override def getHit: Queen = {
    hasHp
  }

  override def hasHp: Queen = {
    if (hp <= 0) {
      println("dead")
      Queen(name, false, 0)
    }
    else {
      if (hp <= 7) Queen(name, false, 0, true) else Queen(name, isAlive, hp - 7, true)
    }
  }

  def resetColor: Wasps = {
    Queen(name, isAlive, hp, false)
  }

  override def hitpoints: Int = {
    hp
  }

  override def displayWasp: String = {
    if (lastHit) {
      s"$RED$BOLD$name hp: $healthBar ($hp)$RESET\n"
    }  else s"$GOLD$BOLD$name$RESET$BOLD hp: $healthBar ($hp)$RESET\n"
  }

  def healthBar: String = {
    val repeatAmount = Math.max(0, hp / 5)
    if (hp <= 20) {
      s"$RED_BACKGROUND\u00A0$RESET".repeat(repeatAmount)
    } else s"$GREEN_BACKGROUND\u00A0$RESET".repeat(repeatAmount)
  }

  override def isDead: Boolean = {
    if (isAlive) true
    else false
  }
}
