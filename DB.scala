
case class Student(name: String, semesterAVGs: Seq[Double])

object DB {

  def students: List[Student] =
    scala.io.Source.fromFile("students.txt")
      .getLines.map { line =>
      val words = line.split("\t")
      Student(words.head, (words drop 1).map(_.toDouble))
    }.toList

}