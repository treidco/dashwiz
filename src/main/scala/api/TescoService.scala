package api

import akka.actor.ActorRef
import spray.routing.Directives

import scala.concurrent.ExecutionContext

class TescoService(actor: ActorRef)(implicit executionContext: ExecutionContext) extends Directives {


  val route = {
    path("transactions") {
      get {
        //        handleWith { gt: GetTransactions => actor ! gt; "{}"}
        complete {
          "OK"
        }
      }
    }
  }

}
