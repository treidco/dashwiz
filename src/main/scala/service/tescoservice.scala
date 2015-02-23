package service

import core.DatabaseCfg._

import scala.slick.driver.H2Driver.simple._

trait TescoService {

  def getTxns(txn_id: Int = 123) = {
    db.withSession { implicit session =>
      tescoTable.list.filter(_.amount > 100).map(tx => tx.amount).foreach(println)
    }
  }

  def listTxns() = tescoTable.list

}