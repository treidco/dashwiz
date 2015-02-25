package actors

import actors.TescoActor.{GetTransactions, TescoTransaction}
import akka.actor.Actor
import core.DatabaseCfg._
import domain.TescoTxn

import scala.slick.driver.H2Driver.simple._


object TescoActor {

  case class GetTransactions()

  case class TescoTransaction(txns: List[TescoTxn])

}

class TescoActor extends Actor {
  def receive: Receive = {

    case GetTransactions => sender ! new TescoTransaction(listTxns)

  }

  def listTxns = {
    db.withSession { implicit session =>
      tescoTable.list
    }
  }
}
