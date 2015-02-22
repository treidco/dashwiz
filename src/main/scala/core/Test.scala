//package core
//
//import domain.{TescoTxn, TescoTxns}
//
//import scala.slick.driver.H2Driver.simple._
//
///**
// * Created by treid on 2/22/15.
// */
//object Test extends App {
//
//  println("Starting Test: 9:36")
//
//  println("Configuring DB")
//  val db = Database.forURL("jdbc:h2:mem:dashwiz;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1")
//
//  println("DB session")
//  db.withSession { implicit session =>
//
//    println("Creating Tesco Table Query Definition")
//    val tescoTable: TableQuery[TescoTxns] = TableQuery[TescoTxns]
//
//    println("Creating schema")
//    tescoTable.ddl.create
//
//    println("Populating db")
//    tescoTable += TescoTxn(50.00)
//    tescoTable += TescoTxn(150.00)
//    tescoTable += TescoTxn(250.00)
//    tescoTable += TescoTxn(150.00)
//
//    println("Running query")
//    tescoTable foreach { txn =>
//      println("###: " + txn.id + " " + txn.amount)
//    }
//
//    tescoTable.list filter {_.amount > 100}
//
//    val allTxns: List[TescoTxn] = tescoTable.list
//    allTxns.filter(_.amount >= 100).foreach(t => println(t.amount))
//
//  }
//
//}
//
//
////case class TescoTxn(amount: Double, id: Option[Int] = None)
////
////class TescoTxns(tag: Tag) extends Table[TescoTxn](tag, "TESCO") {
////  def id: Column[Int] = column[Int]("txn_id", O.AutoInc, O.NotNull, O.PrimaryKey)
////
////  def amount: Column[Double] = column[Double]("amount", O.NotNull)
////
////  def * = (amount, id.?) <>(TescoTxn.tupled, TescoTxn.unapply)
////}