package api

import akka.actor.Props
import core.{Core, CoreActors}
import spray.routing.RouteConcatenation

class Api extends RouteConcatenation {
  this: CoreActors with Core =>

  private implicit val _ = system.dispatcher

  val routes =
    new TescoService(tesco).route

  val routeService = system.actorOf(Props(new RouterService(routes)))
}
