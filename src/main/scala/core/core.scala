package core

import actors.TescoActor
import akka.actor.{Props, ActorSystem}

trait Core {

  implicit val system: ActorSystem

}

trait BootStrap extends Core {

  // Setup Actor System
  implicit lazy val system = ActorSystem("dashwiz")

  // Initialise Database
  DatabaseCfg.init()

  // Shutdown gracefully
  sys.addShutdownHook(system.shutdown())

}

trait CoreActors {
  this: Core =>

  val tesco = system.actorOf(Props[TescoActor])

}