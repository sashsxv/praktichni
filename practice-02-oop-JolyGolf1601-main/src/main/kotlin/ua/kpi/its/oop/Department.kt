package ua.kpi.its.oop

class Department(
    private val managers: List<Manager>
) {
    fun giveSalary() {
        managers.forEach { manager ->
            println("${manager.name} ${manager.surname} received ${manager.calculateSalary().toInt()} shekels.")
            manager.team.forEach { member ->
                println("${member.name} ${member.surname} received ${member.calculateSalary().toInt()} shekels.")
            }
        }
    }
}
