package core

import domain.{TescoTxn, TescoTxns}

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

