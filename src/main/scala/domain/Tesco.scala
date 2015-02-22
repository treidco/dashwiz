package domain

import scala.slick.driver.H2Driver.simple._

case class TescoTxn(amount: Double, id: Option[Int] = None)

class TescoTxns(tag: Tag) extends Table[TescoTxn](tag, "TESCO") {
  def id: Column[Int] = column[Int]("txn_id", O.AutoInc, O.NotNull, O.PrimaryKey)

  def amount: Column[Double] = column[Double]("amount", O.NotNull)

  def * = (amount, id.?) <>(TescoTxn.tupled, TescoTxn.unapply)
}
