import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.9.10"
	application
}

group = "com.gildedrose"
version = "1.0-SNAPSHOT"

object Versions {
    const val JUNIT = "5.10.1"
    const val MOCKK = "1.13.9"
    const val ASSERTJ = "3.25.2"
    const val KOTEST_ASSERTIONS = "5.8.0"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
    testImplementation("com.approvaltests:approvaltests:23.0.0")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
    testImplementation("org.junit.jupiter:junit-jupiter:${Versions.JUNIT}")
    testImplementation(group = "org.assertj", name = "assertj-core", version = Versions.ASSERTJ)
    testImplementation(group = "io.kotest", name = "kotest-assertions-core-jvm", version = Versions.KOTEST_ASSERTIONS)
}

application {
    mainClass.set("pets.AppKt")
}

tasks.apply {
    test {
        maxParallelForks = 1
        enableAssertions = true
        useJUnitPlatform {}
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xinline-classes", "-Xcontext-receivers")
        }
    }
}

application {
	mainClass.set("com.gildedrose.TexttestFixtureKt")
}
