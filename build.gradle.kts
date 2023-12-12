plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
}

group = "com.zzz.pgn"
version = "1.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.aliyun.com/repository/central")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }

    maven {
        url = uri("https://maven.aliyun.com/repository/google")
    }

    maven {
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
}

dependencies{
    implementation("commons-io:commons-io:2.15.1")
    testImplementation(kotlin("test"))
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.2.5")
    type.set("IU") // Target IDE Platform
    plugins.set(listOf("com.intellij.database"))
}



tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("233.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    /*用于测试*/
    runIde {
        jvmArgs("-javaagent:/iriswork/tools/JetBrains/jetbra/ja-netfilter.jar=jetbrains")
        jvmArgs("--add-opens=java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED")
        jvmArgs("--add-opens=java.base/jdk.internal.org.objectweb.asm.tree=ALL-UNNAMED")
    }

   test {
        useJUnitPlatform()
    }
}
