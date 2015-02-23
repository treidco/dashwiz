package core

import service.TescoService


object Dashwiz extends App with BootStrap {

  //shorthand with trait
  val txns = new TescoService {} getTxns()

}





