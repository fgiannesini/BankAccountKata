plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}


tasks.getting(Test::class) {
    useJUnitPlatform()
}