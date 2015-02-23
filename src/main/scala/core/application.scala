package core

import service.executeTxns


object Dashwiz extends App with BootStrap {

  //shorthand with trait
  val txns = new executeTxns {} getTxns()

}





