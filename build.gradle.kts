plugins {
    kotlin("jvm") version "1.8.22"
    checkstyle
}
checkstyle {
    configFile = rootProject.file("checkstyle.xml")
}

group = "ru.job4j"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform()
}