package api

import spray.routing.HttpServiceActor

class TescoService extends HttpServiceActor {

  def receive = runRoute {
    path("transactions") {
      get {
        complete {
          "OK"
        }
      }
    }
  }

}
