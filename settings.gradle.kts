pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ShowPot"
include(":app")
include(":feature:home")
include(":feature:common")
include(":core:common")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":core:datastore")
include(":core:database")
include(":core:network")
include(":core:notification")
include(":showpot-design")
include(":feature:design-app")
