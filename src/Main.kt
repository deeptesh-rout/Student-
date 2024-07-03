import java.util.*

data class Student(
    var name: String,
    var rollNumber: Int,
    var age: Int,
    var grade: Double
) {
    override fun toString(): String {
        return "Name: $name, Roll Number: $rollNumber, Age: $age, Grade: $grade"
    }
}

object StudentManagementSystem {

    private val students = ArrayList<Student>()
    private val scanner = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        var isRunning = true

        while (isRunning) {
            println("\nStudent Management System")
            println("1. Add Student")
            println("2. Display Students")
            println("3. Update Student")
            println("4. Delete Student")
            println("5. Calculate Average Grade")
            println("6. Exit")
            print("Enter your choice: ")
            val choice = scanner.nextInt()
            scanner.nextLine() // Consume newline

            when (choice) {
                1 -> addStudent()
                2 -> displayStudents()
                3 -> updateStudent()
                4 -> deleteStudent()
                5 -> calculateAverageGrade()
                6 -> {
                    isRunning = false
                    println("Thank you ..exiting ")
                }
                else -> println("Invalid choice. Please enter a number between 1 and 6.")
            }
        }
        scanner.close()
    }

    private fun addStudent() {
        print("Enter student name: ")
        val name = scanner.nextLine()
        print("Enter roll number: ")
        val rollNumber = scanner.nextInt()
        print("Enter age: ")
        val age = scanner.nextInt()
        print("Enter grade: ")
        val grade = scanner.nextDouble()

        val student = Student(name, rollNumber, age, grade)
        students.add(student)
        println("Student added successfully!")
    }

    private fun displayStudents() {
        if (students.isEmpty()) {
            println("No students found.")
            return
        }
        println("\nStudents:")
        for (student in students) {
            println(student)
        }
    }

    private fun updateStudent() {
        print("Enter roll number of student to update: ")
        val rollNumber = scanner.nextInt()
        scanner.nextLine()

        val iterator = students.iterator()
        var found = false
        while (iterator.hasNext()) {
            val student = iterator.next()
            if (student.rollNumber == rollNumber) {
                print("Enter new name: ")
                val name = scanner.nextLine()
                print("Enter new age: ")
                val age = scanner.nextInt()
                print("Enter new grade: ")
                val grade = scanner.nextDouble()

                student.name = name
                student.age = age
                student.grade = grade
                println("Student updated successfully!")
                found = true
                break
            }
        }
        if (!found) {
            println("Student with roll number $rollNumber not found.")
        }
    }

    private fun deleteStudent() {
        print("Enter roll number of student to delete: ")
        val rollNumber = scanner.nextInt()

        val iterator = students.iterator()
        var found = false
        while (iterator.hasNext()) {
            val student = iterator.next()
            if (student.rollNumber == rollNumber) {
                iterator.remove()
                println("Student deleted successfully!")
                found = true
                break
            }
        }
        if (!found) {
            println("Student with roll number $rollNumber not found.")
        }
    }

    private fun calculateAverageGrade() {
        if (students.isEmpty()) {
            println("No students found.")
            return
        }
        val totalGrade = students.sumOf { it.grade }
        val averageGrade = totalGrade / students.size
        println("Average Grade: $averageGrade")
    }
}
