plugins {
    id("java")
    id("java-library")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "net.polar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("net.kyori:adventure-text-minimessage:4.12.0")
    compileOnly("org.mongodb:mongodb-driver-sync:4.9.0")
}
