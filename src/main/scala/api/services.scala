package api

import akka.actor.{Actor, ActorLogging, ActorRefFactory}
import spray.routing._
import spray.util.LoggingContext

class RouterService(route: Route) extends Actor with HttpService with ActorLogging {

  implicit def actorRefFactory: ActorRefFactory = context

  implicit val handler = ExceptionHandler.default

  def receive: Receive = {
    runRoute(route)(handler, RejectionHandler.Default, context,
      RoutingSettings.default, LoggingContext.fromActorRefFactory)
  }

}