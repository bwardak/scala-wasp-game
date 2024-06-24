package wasp

class Drone(name: String, isAlive: Boolean = true, hp: Int = 60, lastHit: Boolean = false) extends Wasps{
  val RED = "\u001b[31m"
  val RESET = "\u001b[0m"
  val RED_BACKGROUND = "\u001B[41m"
  val GREEN_BACKGROUND = "\u001b[42m"
  override def getHit: Wasps = {
    hasHp
  }

  override def hasHp: Wasps = {

    if (hp <= 0) {
      println("dead")
      Drone(name, false, 0)
    }
    else {
     if (hp == 12) Drone(name, false, 0, true) else Drone(name, isAlive, hp - 48, true)
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
      s"$RED$name hp: $healthBar ($hp)$RESET     \n"
    } else if (!isAlive) {
      s"$RED_BACKGROUND$name hp:$RESET $healthBar ($hp)     \n"
    } else {
      s"$name hp: $healthBar ($hp)     \n"
    }
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
