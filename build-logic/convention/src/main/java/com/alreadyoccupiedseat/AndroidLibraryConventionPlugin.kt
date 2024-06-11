package com.alreadyoccupiedseat

import com.android.build.api.dsl.LibraryExtension
import com.alreadyoccupiedseat.convention.configureAppDefault
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-parcelize")
            }
            extensions.configure<LibraryExtension> {
                configureAppDefault(this)
            }
        }
    }
}

