package dev.datlag.homepage.model

sealed interface Skill {

    val name: String
    val level: Level
    val iconLight: String
    val iconDark: String

    data object AndroidStudio : Skill {
        override val name: String = "Android Studio"
        override val level: Level = Level.Advanced
        override val iconLight: String = "skills/android_studio_dark.svg"
        override val iconDark: String = "skills/android_studio_light.svg"
    }

    data object Compose : Skill {
        override val name: String = "Compose"
        override val level: Level = Level.Intermediate
        override val iconLight: String = "skills/compose.svg"
        override val iconDark: String = "skills/compose.svg"
    }

    data object Firebase : Skill {
        override val name: String = "Firebase"
        override val level: Level = Level.Advanced
        override val iconLight: String = "skills/firebase.svg"
        override val iconDark: String = "skills/firebase.svg"
    }

    data object GitHub : Skill {
        override val name: String = "GitHub"
        override val level: Level = Level.Advanced
        override val iconLight: String = "skills/github_dark.svg"
        override val iconDark: String = "skills/github_light.svg"
    }

    data object Gradle : Skill {
        override val name: String = "Gradle"
        override val level: Level = Level.Intermediate
        override val iconLight: String = "skills/gradle_dark.svg"
        override val iconDark: String = "skills/gradle_light.svg"
    }

    data object Kotlin : Skill {
        override val name: String = "Kotlin"
        override val level: Level = Level.Advanced
        override val iconLight: String = "skills/kotlin.svg"
        override val iconDark: String = "skills/kotlin.svg"
    }

    sealed interface Level {
        val title: String

        data object Beginner : Level {
            override val title: String = "Beginner"
        }

        data object Intermediate : Level {
            override val title: String = "Intermediate"
        }

        data object Advanced : Level {
            override val title: String = "Advanced"
        }
    }
}