package ua.kpi.its.oop

class Designer(
    name: String,
    surname: String,
    baseSalary: Double,
    experience: Int,
    effCoefficient: Double
) : Employee(name, surname, baseSalary, experience) {

    private val efficiencyCoefficient: Double = effCoefficient.coerceIn(0.0, 1.0)

    override fun calculateSalary(): Double {
        return super.calculateSalary() * efficiencyCoefficient
    }
}
