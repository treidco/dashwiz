package core

import core.DatabaseCfg._

import scala.slick.driver.H2Driver.simple._

object Dashwiz extends BootSystem with doStuff {

  def main(args: Array[String]): Unit = {
    getTxns()
  }


}


trait doStuff {

  def getTxns(txn_id: Int = 123) = {
    db.withSession { implicit session =>
      tescoTable.list.filter(_.amount > 100).map(tx => tx.amount).foreach(println)
    }
  }

}


//object Dashwiz extends App with BootSystem with doStuff
