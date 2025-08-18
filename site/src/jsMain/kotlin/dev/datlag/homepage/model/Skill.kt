package dev.datlag.homepage.model

sealed interface Skill {

    val name: String
    val level: Level
    val iconLight: String
    val iconDark: String

    data object AndroidStudio : Skill {
        override val name: String = "Android"
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

    data object PHP : Skill {
        override val name: String = "PHP"
        override val level: Level = Level.Beginner
        override val iconLight: String = "skills/php.svg"
        override val iconDark: String = "skills/php.svg"
    }

    data object JS : Skill {
        override val name: String = "Javascript"
        override val level: Level = Level.Intermediate
        override val iconLight: String = "skills/js.svg"
        override val iconDark: String = "skills/js.svg"
    }

    data object Git : Skill {
        override val name: String = "Git"
        override val level: Level = Level.Intermediate
        override val iconLight: String = "skills/git.svg"
        override val iconDark: String = "skills/git.svg"
    }

    data object Markdown : Skill {
        override val name: String = "Markdown"
        override val level: Level = Level.Advanced
        override val iconLight: String = "skills/markdown_dark.svg"
        override val iconDark: String = "skills/markdown_light.svg"
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