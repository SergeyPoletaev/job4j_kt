package ru.job4j.oop

class Student {
    var name = ""
    var surname = ""
    var phone = ""
    var email = ""

    constructor()

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, surname: String) : this(name) {
        this.surname = surname
    }

    constructor(name: String, surname: String, phone: String, email: String) : this(name, surname) {
        this.phone = phone
        this.email = email
    }
}