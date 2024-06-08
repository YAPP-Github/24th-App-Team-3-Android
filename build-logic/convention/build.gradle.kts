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
    compileOnly(libs.android.tools.build.gradle)
    compileOnly(libs.kotlin.gradle.plugin)
    // compileOnly(libs.firebase.crashlytics)
//    compileOnly(libs.plugins.gms)
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

    }
}