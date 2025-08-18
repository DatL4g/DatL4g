package dev.datlag.homepage.model

sealed interface Skill {

    val name: String
    val level: Level
    val iconLight: String
    val iconDark: String

    data object AndroidStudio : Skill {
        override val name: String = Res.strings.android
        override val level: Level = Level.Advanced
        override val iconLight: String = Res.drawables.skillsAndroidStudioDark
        override val iconDark: String = Res.drawables.skillsAndroidStudioLight
    }

    data object Compose : Skill {
        override val name: String = Res.strings.compose
        override val level: Level = Level.Intermediate
        override val iconLight: String = Res.drawables.skillsCompose
        override val iconDark: String = Res.drawables.skillsCompose
    }

    data object Firebase : Skill {
        override val name: String = Res.strings.firebase
        override val level: Level = Level.Advanced
        override val iconLight: String = Res.drawables.skillsFirebase
        override val iconDark: String = Res.drawables.skillsFirebase
    }

    data object GitHub : Skill {
        override val name: String = Res.strings.github
        override val level: Level = Level.Advanced
        override val iconLight: String = Res.drawables.skillsGitHubDark
        override val iconDark: String = Res.drawables.skillsGitHubLight
    }

    data object Gradle : Skill {
        override val name: String = Res.strings.gradle
        override val level: Level = Level.Intermediate
        override val iconLight: String = Res.drawables.skillsGradleDark
        override val iconDark: String = Res.drawables.skillsGradleLight
    }

    data object Kotlin : Skill {
        override val name: String = Res.strings.kotlin
        override val level: Level = Level.Advanced
        override val iconLight: String = Res.drawables.skillsKotlin
        override val iconDark: String = Res.drawables.skillsKotlin
    }

    data object PHP : Skill {
        override val name: String = Res.strings.php
        override val level: Level = Level.Beginner
        override val iconLight: String = Res.drawables.skillsPHP
        override val iconDark: String = Res.drawables.skillsPHP
    }

    data object JS : Skill {
        override val name: String = Res.strings.js
        override val level: Level = Level.Intermediate
        override val iconLight: String = Res.drawables.skillsJS
        override val iconDark: String = Res.drawables.skillsJS
    }

    data object Git : Skill {
        override val name: String = Res.strings.git
        override val level: Level = Level.Intermediate
        override val iconLight: String = Res.drawables.skillsGit
        override val iconDark: String = Res.drawables.skillsGit
    }

    data object Markdown : Skill {
        override val name: String = Res.strings.markdown
        override val level: Level = Level.Advanced
        override val iconLight: String = Res.drawables.skillsMarkdownDark
        override val iconDark: String = Res.drawables.skillsMarkdownLight
    }

    sealed interface Level {
        val title: String

        data object Beginner : Level {
            override val title: String = Res.strings.beginner
        }

        data object Intermediate : Level {
            override val title: String = Res.strings.intermediate
        }

        data object Advanced : Level {
            override val title: String = Res.strings.advanced
        }
    }
}