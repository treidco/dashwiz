package core

import akka.actor.ActorSystem

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

  //actors...

}