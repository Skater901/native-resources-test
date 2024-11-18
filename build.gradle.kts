plugins {
    kotlin("jvm") version "2.0.20"
    id("org.graalvm.buildtools.native") version "0.10.2"
}

group = "au.com.skater901"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.webjars:swagger-ui:5.17.11")
}

kotlin {
    jvmToolchain(21)
}

graalvmNative {
    binaries.named("main") {
        mainClass = "au.com.skater901.Main"

//        resources.includedPatterns.add("META-INF/resources/webjars/swagger-ui/5.17.11/swagger-ui.css") <---- works
        resources.includedPatterns.add("META-INF/resources/webjars/swagger-ui/5.17.11/*") // <----- doesn't work

        buildArgs("-H:Log=registerResource:5", "-H:+UnlockExperimentalVMOptions")
    }
}