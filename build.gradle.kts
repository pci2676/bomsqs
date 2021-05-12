import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version Dependencies.Versions.springDependencyManagement
    id("org.springframework.boot") version Dependencies.Versions.springBoot apply false

    kotlin("jvm") version Dependencies.Versions.kotlin
    kotlin("plugin.spring") version Dependencies.Versions.kotlin apply false
    kotlin("plugin.jpa") version Dependencies.Versions.kotlin apply false
    kotlin("kapt") version Dependencies.Versions.kotlin apply false
    kotlin("plugin.allopen") version Dependencies.Versions.kotlin
    kotlin("plugin.noarg") version Dependencies.Versions.kotlin
}

allprojects {
    apply {
        plugin("idea")
    }

    repositories {
        mavenCentral()
    }

    group = "${property("projectGroup")}"
    version = "${property("projectVersion")}"
}

val kotlinProjects = listOf(
    project(":bom-api"),
    project(":bom-application"),
    project(":bom-core"),
    project(":bom-worker"),
    project(":bom-clients:bom-message")
)
configure(kotlinProjects) {
    apply {
        plugin<JavaLibraryPlugin>()
        plugin<KotlinPlatformJvmPlugin>()
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
    }

    dependencyManagement {
        imports {
            mavenBom("org.jetbrains.kotlin:kotlin-bom:${Dependencies.Versions.kotlin}")
            mavenBom("org.springframework.boot:spring-boot-dependencies:${Dependencies.Versions.springBoot}")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Dependencies.Versions.springCloud}")
            mavenBom("com.amazonaws:aws-java-sdk-bom:${Dependencies.Versions.awsSdk}")
            mavenBom("org.testcontainers:testcontainers-bom:${Dependencies.Versions.testcontainer}")
        }

        dependencies {
            dependencySet("io.kotest:${Dependencies.Versions.kotest}") {
                entry("kotest-runner-junit5-jvm")
                entry("kotest-assertions-core-jvm")
                entry("kotest-property-jvm")
                entry("kotest-extensions-spring-jvm")
            }
            dependencySet("io.github.microutils:${Dependencies.Versions.kotlinLogging}") {
                entry("kotlin-logging-jvm")
                entry("kotlin-logging-common")
            }
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("io.github.microutils:kotlin-logging-jvm")

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

        testImplementation("org.springframework.boot:spring-boot-starter-test")

        /** @see <a href="https://kotest.io/">kotest</a>*/
        testImplementation("io.kotest:kotest-runner-junit5-jvm")
        testImplementation("io.kotest:kotest-assertions-core-jvm")
        testImplementation("io.kotest:kotest-property-jvm")
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.withType<KotlinCompile> {
        sourceCompatibility = "11"

        kotlinOptions {
            freeCompilerArgs.plus("-Xjsr305=strict")
            freeCompilerArgs.plus("-Xjvm-default=enable")
            freeCompilerArgs.plus("-progressive")
            freeCompilerArgs.plus("-XXLanguage:+InlineClasses")

            jvmTarget = "11"
        }

        dependsOn("processResources")
    }

    tasks.withType<Test> {
        useJUnitPlatform {}
    }
}
