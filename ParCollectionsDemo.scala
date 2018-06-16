import java.util.Calendar

object ParCollectionsDemo {

  //////////////////////////////////////////////////////////////////
  def sequential(): Unit = {
    val students = DB.students
    val time0 = Calendar.getInstance.getTimeInMillis
    println("=====Sequential Processing=====")

    def gpa(s: Student) = s.semesterAVGs.sum / s.semesterAVGs.length

    def calcGPAAvg(sl: List[Student]) = (sl map gpa).sum / sl.length

    println(s"Average GPA: ${calcGPAAvg(students)}")
    println(s"Number of students: ${students.length}")
    println(s"Time taken: ${(Calendar.getInstance.getTimeInMillis - time0) / 1000} seconds")
  }
  //////////////////////////////////////////////////////////////////

  //////////////////////////////////////////////////////////////////
  def parallel(): Unit = {
    val students = DB.students
    val time0 = Calendar.getInstance.getTimeInMillis
    println("=====Parallel Processing=====")

    def gpa(s: Student) = s.semesterAVGs.sum / s.semesterAVGs.length

    def calcGPAAvg(sl: List[Student]) = (sl.par map gpa).sum / sl.length

    println(s"Average GPA: ${calcGPAAvg(students)}")
    println(s"Number of students: ${students.length}")
    println(s"Time taken: ${(Calendar.getInstance.getTimeInMillis - time0) / 1000} seconds")
  }
  //////////////////////////////////////////////////////////////////

}