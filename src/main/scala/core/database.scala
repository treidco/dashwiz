package core

//import domain.TescoTxns

import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.meta.MTable

object DatabaseCfg {

  val db = Database.forURL("jdbc:h2:mem:dashwiz;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1")

  val tescoTable: TableQuery[TescoTxns] = TableQuery[TescoTxns]

  def init() = {
    db.withTransaction { implicit session =>
      if (MTable.getTables("TESCO").list.isEmpty) {
        tescoTable.ddl.create

        tescoTable += TescoTxn(50.00)
        tescoTable += TescoTxn(150.00)
        tescoTable += TescoTxn(250.00)
        tescoTable += TescoTxn(150.00)
      }
    }
  }


}

case class TescoTxn(amount: Double, id: Option[Int] = None)

class TescoTxns(tag: Tag) extends Table[TescoTxn](tag, "TESCO") {
  def id: Column[Int] = column[Int]("txn_id", O.AutoInc, O.NotNull, O.PrimaryKey)

  def amount: Column[Double] = column[Double]("amount", O.NotNull)

  def * = (amount, id.?) <>(TescoTxn.tupled, TescoTxn.unapply)
}