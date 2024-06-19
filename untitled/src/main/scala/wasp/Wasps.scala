package wasp

abstract class Wasps {
  def getHit: Wasps = {
    hasHp
  }
  def hasHp: Wasps
}
