package wasp

abstract class Wasps {
  def getHit: Wasps = {
    hasHp
  }
  def hasHp: Wasps
  def displayWasp: String
  def isDead: Boolean
  def hitpoints: Int
  def resetColor: Wasps
  def healthBar: String
}
