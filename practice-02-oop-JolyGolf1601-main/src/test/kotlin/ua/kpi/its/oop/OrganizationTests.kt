package ua.kpi.its.oop

import kotlin.test.Test
import kotlin.test.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/* #######################################################
*  #######################################################
*                       DO NOT EDIT
*  #######################################################
*  #######################################################
*/

class OrganizationTests {

    @Test
    fun testEmployeeSalary() {
        val employee = Employee("Dev1", "A", 1000.0, 3)
        assertEquals(1200.0, employee.calculateSalary())
    }

    @Test
    fun testDesignerSalary() {
        val designer = Designer("Des1", "B", 1500.0, 6, 0.5)
        assertEquals(1150.0, designer.calculateSalary()) // (1500 * 1.2 + 500) * 0.5
    }

    @Test
    fun testDesignerSalaryHighEfficiency() {
        val designer = Designer("Des1", "B", 1500.0, 6, 15.0)
        assertEquals(2300.0, designer.calculateSalary()) // (1500 * 1.2 + 500) * 0
    }

    @Test
    fun testDesignerSalaryLowEfficiency() {
        val designer = Designer("Des1", "B", 1500.0, 6, -5.0)
        assertEquals(.0, designer.calculateSalary()) // (1500 * 1.2 + 500) * 0
    }

    @Test
    fun testManagerSalaryWithSmallTeam() {
        val manager = Manager("Man1", "C", 2000.0, 4)
        manager.addTeamMember(Developer("Dev1", "A", 1000.0, 1))
        manager.addTeamMember(Designer("Des1", "B", 1200.0, 2, 0.8))
        assertEquals(2200.0, manager.calculateSalary()) // 2000 + 200
    }

    @Test
    fun testManagerSalaryWithLargeTeam() {
        val manager = Manager("Man1", "A", 2500.0, 7)
        repeat(11) { manager.addTeamMember(Developer("Dev$it", "X", 1000.0, 1)) }
        assertEquals(4180.0, manager.calculateSalary()) // ((2500 * 1.2 + 500) + 300) * 1.1
    }

    @Test
    fun testDepartmentGiveSalary() {
        val manager = Manager("Man1", "C", 2000.0, 3)
        manager.addTeamMember(Developer("Dev1", "A", 1000.0, 4))
        manager.addTeamMember(Designer("Des1", "B", 1200.0, 2, 0.9))
        val department = Department(listOf(manager))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        department.giveSalary()

        System.setOut(System.out)

        val expectedOutput = """
            Man1 C received 2200 shekels.
            Dev1 A received 1200 shekels.
            Des1 B received 1080 shekels.
        """.trimIndent()

        assertEquals(expectedOutput, outputStream.toString().trim())
    }
}
