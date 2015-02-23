package actors

import actors.TescoActor.{GetTransactions, TescoTransaction}
import akka.actor.Actor
import domain.TescoTxn
import api.TescoService


object TescoActor {

  case object GetTransactions

  case class TescoTransaction(txns: List[TescoTxn])

}

class TescoActor extends Actor with TescoService {
  def receive: Receive = {

    case GetTransactions => sender ! new TescoTransaction(listTxns())

  }
}
