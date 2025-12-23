[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/0nIcz1oH)
# Практика 02: Обʼєктно-орієнтоване програмування

Реалізуйте об'єктну модель організації з трьома типами робітників: `Developer`, `Designer` та `Manager`.

1. Базовий клас: `Employee`
    - Поля:
        - `name: String` - ім'я робітника.
        - `surname: String` - прізвище робітника.
        - `baseSalary: Double` - базова заробітна плата.
        - `experience: Int` - досвід роботи у роках.
    - Метод:
        - `fun calculateSalary(): Double` - метод, що обчислює базову заробітну плату з урахуванням досвіду.
            - Якщо досвід роботи більше 2 років: `baseSalary + 200`
            - Якщо досвід більше 5 років: `baseSalary * 1.2 + 500`

2. Похідні класи:
    - `Developer`, `Designer` та `Manager`
        - Наслідують клас `Employee`.
    - `Designer`
        - Додаткове поле:
            - `efficiencyCoefficient: Double` - коефіцієнт ефективності від 0 до 1.
        - Валідація: значення обмежується від 0 до 1.
        - Перевизначений метод `calculateSalary()` враховує коефіцієнт ефективності.
    - `Manager`
        - Додаткове поле:
            - `team: MutableList<Employee>` - команда, що складається з `Developer` та `Designer`.
        - Метод:
            - `fun addTeamMember(member: Employee)` - додає учасника до команди.
        - Перевизначений метод `calculateSalary()` враховує розмір команди та її склад.
            - Якщо в команді більше 5 людей: `countedSalary + 200`
            - Якщо в команді більше 10 людей: `countedSalary + 300`
            - Якщо в команді більше половини `Developer`, зарплата збільшується ще на 10%.

3. Клас `Department`:
    - Поле:
        - `managers: List<Manager>` - список менеджерів у відділі.
    - Метод:
        - `fun giveSalary()` - роздруковує зарплату всіх робітників організації у форматі `<name> <surname> received <salary> shekels.`.

> [!NOTE]
> Де `<salary>` округлене до найближчого **цілого** числа.

Додаткова інформація:
- Для використання методів з суперкласу можна використати ключове слово `super`.
- Пройти циклом по списку можна за допомогою його методу `forEach`.
- Перевизначити методи чи проперті можна за допомогою ключового слова `override`.
- Перевірити чи є об’єкт екземпляром класу за допомогою оператора `is`. Наприклад, для екземпляра автобуса що є транспортним засобом `println(myBusInstance is Vehicle)` виведе `true`.