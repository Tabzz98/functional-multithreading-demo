import java.io._

object StudentFileGenerator {
  def apply(n: Int): Unit = {
    val random = new java.util.Random()
    val writer = new PrintWriter(new File("students.txt"))
    def randMark() = {
      val mark = random.nextInt(100)
      if (mark > 50) mark else mark + 50
    }
    (1 to n) foreach { n =>
      writer.println(
        s"Name${n}\t${randMark()}\t${randMark()}\t${randMark()}\t${randMark()}\t${randMark()}\t${randMark()}\t${randMark()}\t${randMark()}")
    }
    writer.close()
  }
}