import java.util.Calendar
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesDemo {

  def apply(): Unit = {
    val students = DB.students
    val time0 = Calendar.getInstance.getTimeInMillis

    def gpa(s: Student) = s.semesterAVGs.sum / s.semesterAVGs.length

    def calcGPAAvg(sl: List[Student]) = (sl.par map gpa).sum / sl.length

    println("=====Future GPA Average Processing=====")
    val fGpaAvg = Future(calcGPAAvg(students))

    println("=====Future GPAs All Above 60=====")
    val fAllAbove60 = Future(students.forall(gpa(_) > 60))

    fGpaAvg foreach { avg =>
      println(s"Average GPA: $avg")
      println(s"Number of students: ${students.length}")
      println(s"Time taken: ${(Calendar.getInstance.getTimeInMillis - time0) / 1000} seconds")
    }

    fAllAbove60 foreach { bool =>
      println("All Above 60?: " + bool)
    }

  }

}