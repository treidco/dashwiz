package core

import core.DatabaseCfg._

import scala.slick.driver.H2Driver.simple._

object Dashwiz extends App with BootStrap with executeTxns {

  getTxns()

}


trait executeTxns {

  def getTxns(txn_id: Int = 123) = {
    db.withSession { implicit session =>
      tescoTable.list.filter(_.amount > 100).map(tx => tx.amount).foreach(println)
    }
  }

}


