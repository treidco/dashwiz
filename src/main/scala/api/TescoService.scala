package api

import akka.actor.ActorRef
import spray.routing.{HttpServiceActor, Directives}

import scala.concurrent.ExecutionContext

class TescoService(actor: ActorRef)(implicit executionContext: ExecutionContext) extends HttpServiceActor {


  def receive =  runRoute{
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
