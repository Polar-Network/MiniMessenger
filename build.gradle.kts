plugins {
    id("java")
    id("java-library")
    id("maven-publish")
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            this.groupId = "net.polar"
            this.artifactId = "MiniMessenger"
            this.version = "1.0-SNAPSHOT"
            from(components["java"])
        }
    }
}