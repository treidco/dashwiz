package web

import akka.io.IO
import core.{Core, CoreActors}
import spray.can.Http

trait Web {
  this: CoreActors with Core =>

  IO(Http)(system) ! Http.Bind(tesco, "localhost", port = 8083)

}
