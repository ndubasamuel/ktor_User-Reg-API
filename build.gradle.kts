
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val postgres_version: String by project
val hikaricp_version: String by project
val ktor_version: String by project

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.ktor.plugin") version "2.3.10"

}

group = "net.frex"
version = "0.0.1"

application {
    mainClass.set("net.frex.ApplicationKt")


    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}



dependencies {
        implementation("io.ktor:ktor-server-core:$ktor_version")
        implementation("io.ktor:ktor-server-tomcat:$ktor_version")
        implementation("ch.qos.logback:logback-classic:$logback_version")
        implementation("io.ktor:ktor-jackson:1.5.4")
        implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
        implementation("io.ktor:ktor-auth-jwt:1.0.0")
        implementation("io.ktor:ktor-auth:1.6.8")
        implementation("commons-codec:commons-codec:1.16.0")
        implementation("org.jetbrains.exposed:exposed-core:0.37.3")
        implementation("org.jetbrains.exposed:exposed-dao:0.37.3")
        implementation("org.jetbrains.exposed:exposed-jdbc:0.37.3")
        implementation("org.jetbrains.exposed:exposed-java-time:0.37.3")
        implementation("org.postgresql:postgresql:42.3.3")
        implementation("com.zaxxer:HikariCP:5.0.1")
        implementation("io.ktor:ktor-server-netty:$ktor_version")


        testImplementation("io.ktor:ktor-server-tests:$ktor_version")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
