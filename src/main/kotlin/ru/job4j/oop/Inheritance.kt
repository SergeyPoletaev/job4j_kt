package ru.job4j.oop

open class Teacher(val name: String)

open class LanguageTeacher(val languageTrainer: String, name: String) : Teacher(name)

class EnglishTeacher(val certificate: String, name: String, languageTrainer: String) :
    LanguageTeacher(languageTrainer, name)

class RussianTeacher(val diploma: String, languageTrainer: String, name: String) :
    LanguageTeacher(languageTrainer, name)

class ChemicalTeacher(val lab: String, name: String) : Teacher(name)


fun main() {
    val teacher0 = Teacher("Anna")
    val teacher1 = LanguageTeacher("b5", "Olya")
    val teacher2 = EnglishTeacher("SDFG", "Katya", "c14")
    val teacher3 = RussianTeacher("MGU", "rus8", "Sonya")
    val teacher4 = ChemicalTeacher("lab312", "Sveta")
}