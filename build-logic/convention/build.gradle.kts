import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.android.tools.build.gradle)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {

        register("androidApplication") {
            id = "showpot.android.application"
            implementationClass = "com.alreadyoccupiedseat.AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "showpot.android.library"
            implementationClass = "com.alreadyoccupiedseat.AndroidLibraryConventionPlugin"
        }

        register("androidFirebase") {
            id = "showpot.android.firebase"
            implementationClass = "com.alreadyoccupiedseat.AndroidFirebaseConventionPlugin"
        }

        register("androidRoom") {
            id = "showpot.android.room"
            implementationClass = "com.alreadyoccupiedseat.AndroidRoomConventionPlugin"
        }

        register("androidHilt") {
            id = "showpot.android.hilt"
            implementationClass = "com.alreadyoccupiedseat.AndroidHiltConventionPlugin"
        }

    }
}