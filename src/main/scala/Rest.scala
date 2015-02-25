import api.Api
import core.{CoreActors, BootStrap}
import web.Web

object Rest extends App with BootStrap with CoreActors with Api with Web
