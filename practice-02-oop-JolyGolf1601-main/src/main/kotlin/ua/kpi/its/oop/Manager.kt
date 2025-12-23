package ua.kpi.its.oop

class Manager(
    name: String,
    surname: String,
    baseSalary: Double,
    experience: Int,
    val team: MutableList<Employee> = mutableListOf()
) : Employee(name, surname, baseSalary, experience) {

    fun addTeamMember(member: Employee) {
        team.add(member)
    }

    override fun calculateSalary(): Double {
        var countedSalary = super.calculateSalary()

        if (team.size > 10) countedSalary += 300
        else if (team.size > 5) countedSalary += 200

        val devCount = team.count { it is Developer }
        if (team.isNotEmpty() && devCount > team.size / 2) {
            countedSalary *= 1.1
        }

        return countedSalary
    }
}
