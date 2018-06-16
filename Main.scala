
object Main extends App {

  ParCollectionsDemo.parallel()

  ParCollectionsDemo.sequential()

  FuturesDemo()

  while (true) {
    println("Main Thread Executing ...")
    Thread.sleep(5000)
  }

}
