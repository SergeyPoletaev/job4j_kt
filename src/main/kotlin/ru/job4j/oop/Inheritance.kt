package ru.job4j.oop

open class Teacher(private val name: String) {

    open fun getName() = name

    open fun action() = println("Чему-то учит")
}

open class LanguageTeacher(val languageTrainer: String, name: String) : Teacher(name) {

    override fun getName(): String = super.getName() + "--" + "LanguageTeacher"

    override fun action() = println("Учит языкам")
}

class EnglishTeacher(val certificate: String, name: String, languageTrainer: String) :
    LanguageTeacher(languageTrainer, name) {

    override fun getName(): String = super.getName() + "--" + "EnglishTeacher"

    override fun action() = println("Учит английскому языку")
}

class RussianTeacher(val diploma: String, languageTrainer: String, name: String) :
    LanguageTeacher(languageTrainer, name) {

    override fun getName(): String = super.getName() + "--" + "RussianTeacher"

    override fun action() = println("Учит русскому языку")
}

class ChemicalTeacher(val lab: String, name: String) : Teacher(name) {

    override fun getName(): String = super.getName() + "--" + "ChemicalTeacher"

    override fun action() = println("Учит химии")
}


fun main() {
    val teacher0 = Teacher("Anna")
    val teacher1 = LanguageTeacher("b5", "Olya")
    val teacher2 = EnglishTeacher("SDFG", "Katya", "c14")
    val teacher3 = RussianTeacher("MGU", "rus8", "Sonya")
    val teacher4 = ChemicalTeacher("lab312", "Sveta")
}