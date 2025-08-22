package dev.datlag.homepage.model

data object KanaConverter {

    private val vowels = setOf('a', 'e', 'i', 'o', 'u')

    private val accentMap = mapOf(
        // a
        'á' to 'a','à' to 'a','ä' to 'a','â' to 'a','ã' to 'a','å' to 'a','ā' to 'a','ă' to 'a','ą' to 'a',
        // e
        'é' to 'e','è' to 'e','ë' to 'e','ê' to 'e','ě' to 'e','ē' to 'e','ę' to 'e',
        // i
        'í' to 'i','ì' to 'i','ï' to 'i','î' to 'i','ī' to 'i',
        // o
        'ó' to 'o','ò' to 'o','ö' to 'o','ô' to 'o','õ' to 'o','ō' to 'o',
        // u
        'ú' to 'u','ù' to 'u','ü' to 'u','û' to 'u','ū' to 'u',
        // c/n/s/z/l/ß/đ/ț/ş etc.
        'ç' to 'c','ñ' to 'n','ś' to 's','š' to 's','ß' to 's','ș' to 's','ş' to 's',
        'ž' to 'z','ź' to 'z','ż' to 'z',
        'ł' to 'l','đ' to 'd','ț' to 't','ţ' to 't'
    )

    private val dict = mapOf(
        // Vowels
        "a" to "ア", "i" to "イ", "u" to "ウ", "e" to "エ", "o" to "オ",

        // Germanic/Slavic clusters
        "sch" to "シュ",
        "tch" to "ッチ",

        // Polish-ish clusters
        "usz" to "ウシュ",
        "sz" to "シュ",
        "cz" to "チ",
        "rz" to "ジ",

        // English th / ti / di / tu / du / ph
        "the" to "ゼ", "thi" to "ティ", "tho" to "ト", "thu" to "トゥ", "tha" to "サ",
        "ti" to "ティ", "tu" to "トゥ",
        "di" to "ディ", "du" to "ドゥ",
        "ph" to "フ",

        // J / Sh / Ch
        "she" to "シェ", "sha" to "シャ", "shu" to "シュ", "sho" to "ショ", "shi" to "シ",
        "che" to "チェ", "cha" to "チャ", "chu" to "チュ", "cho" to "チョ", "chi" to "チ",
        "je" to "ジェ", "ja" to "ジャ", "ju" to "ジュ", "jo" to "ジョ", "ji" to "ジ",

        // K/G + y
        "kyo" to "キョ", "kyu" to "キュ", "kya" to "キャ",
        "gyo" to "ギョ", "gyu" to "ギュ", "gya" to "ギャ",

        // R/L (y) rows
        "ryo" to "リョ", "ryu" to "リュ", "rya" to "リャ",

        // H/B/P (y) rows
        "hyo" to "ヒョ", "hyu" to "ヒュ", "hya" to "ヒャ",
        "byo" to "ビョ", "byu" to "ビュ", "bya" to "ビャ",
        "pyo" to "ピョ", "pyu" to "ピュ", "pya" to "ピャ",

        // W & foreign v/f variants
        "wi" to "ウィ", "we" to "ウェ", "wo" to "ウォ",
        "va" to "ヴァ", "vi" to "ヴィ", "vu" to "ヴ", "ve" to "ヴェ", "vo" to "ヴォ",
        "fa" to "ファ", "fi" to "フィ", "fe" to "フェ", "fo" to "フォ",

        // Basic CV rows
        "ka" to "カ", "ki" to "キ", "ku" to "ク", "ke" to "ケ", "ko" to "コ",
        "ca" to "カ", "ci" to "キ", "cu" to "ク", "ce" to "ケ", "co" to "コ", // Matches Nico to ニコ
        "ga" to "ガ", "gi" to "ギ", "gu" to "グ", "ge" to "ゲ", "go" to "ゴ",
        "sa" to "サ", "su" to "ス", "se" to "セ", "so" to "ソ",
        "za" to "ザ", "zu" to "ズ", "ze" to "ゼ", "zo" to "ゾ",
        "ta" to "タ", "tsu" to "ツ", "te" to "テ", "to" to "ト",
        "da" to "ダ", "de" to "デ", "do" to "ド",
        "na" to "ナ", "ni" to "ニ", "nu" to "ヌ", "ne" to "ネ", "no" to "ノ",
        "ha" to "ハ", "hi" to "ヒ", "fu" to "フ", "he" to "ヘ", "ho" to "ホ",
        "ba" to "バ", "bi" to "ビ", "bu" to "ブ", "be" to "ベ", "bo" to "ボ",
        "pa" to "パ", "pi" to "ピ", "pu" to "プ", "pe" to "ペ", "po" to "ポ",
        "ma" to "マ", "mi" to "ミ", "mu" to "ム", "me" to "メ", "mo" to "モ",
        "ya" to "ヤ", "yu" to "ユ", "yo" to "ヨ", "ye" to "イェ",
        "ra" to "ラ", "ri" to "リ", "ru" to "ル", "re" to "レ", "ro" to "ロ",
        "la" to "ラ", "li" to "リ", "lu" to "ル", "le" to "レ", "lo" to "ロ",
        "wa" to "ワ",
        "n" to "ン"
    )

    private val maxKey = dict.keys.maxOf { it.length }

    private fun stripDiacritics(input: String): String = buildString(input.length) {
        input.forEach { ch -> append(accentMap[ch] ?: accentMap[ch.lowercaseChar()] ?: ch) }
    }

    private fun isVowelAt(s: String, i: Int) = i < s.length && s[i] in vowels

    // Detect "Polish-like" orthography to switch j/ w behavior (no name exceptions)
    private fun looksPolish(word: String): Boolean {
        val w = word.lowercase()
        return "sz" in w || "cz" in w || "rz" in w || w.endsWith("usz") || "w" in w
    }

    // Fallback single-letter closest kana (never leave Latin behind)
    private fun fallbackKana(c: Char): String = when (c) {
        'a' -> "ア"; 'i' -> "イ"; 'u' -> "ウ"; 'e' -> "エ"; 'o' -> "オ"
        'b' -> "ブ"; 'c' -> "ク"; 'd' -> "ド"; 'f' -> "フ"; 'g' -> "グ"
        'h' -> "ハ"; 'j' -> "ジ"; 'k' -> "ク"; 'l' -> "ル"; 'm' -> "ム"
        'n' -> "ン"; 'p' -> "プ"; 'q' -> "ク"; 'r' -> "ル"; 's' -> "ス"
        't' -> "ト"; 'v' -> "ヴ"; 'w' -> "ウ"; 'x' -> "クス"; 'y' -> "イ"; 'z' -> "ズ"
        else -> "・"
    }

    fun convertToKana(input: String): String = buildString {
        if (input.isBlank()) return@buildString

        val raw = stripDiacritics(input).lowercase()
        var i = 0

        var wordStart = true
        var polishMode = false

        fun updateWordMode(startIndex: Int) {
            polishMode = looksPolish(buildString {
                var j = startIndex
                while (j < raw.length && !raw[j].isWhitespace() && raw[j] != '-' && raw[j] != '·' && raw[j] != '・') {
                    append(raw[j])
                    j++
                }
            })
        }

        updateWordMode(0)

        while (i < raw.length) {
            val ch = raw[i]

            if (ch.isWhitespace() || ch == '-' || ch == '·' || ch == '・' || ch == '_') {
                append('・')
                i++
                wordStart = true
                if (i < raw.length) {
                    updateWordMode(i)
                }
                continue
            }

            if (wordStart && raw.startsWith("tho", i) ) {
                append("トー")
                i += 3
                wordStart = true
                continue
            }

            if (raw.startsWith("th", i)) {
                val next = raw.getOrNull(i + 2)
                if (next != null && next in vowels) {
                    append("テ")
                } else {
                    append("ト")
                }
                i += 2
                continue
            }

            if (raw.startsWith("tz", i)) {
                val next = raw.getOrNull(i + 2)
                if (next != null && next in vowels) {
                    if (next == 'u') {
                        append("ツ")
                        i += 2
                        continue
                    }
                } else {
                    append("ツ")
                    i += 2
                    continue
                }
            }

            if (raw[i] in vowels && i + 1 < raw.length && raw[i + 1] == 'h') {
                val next = raw.getOrNull(i + 2)
                if (next == null || next !in vowels) {
                    dict[raw[i].toString()]?.let {
                        append(it)
                        append('ー')
                        i += 2
                        continue
                    }
                }
            }

            if (i + 1 < raw.length && raw[i] =='f' && raw[i + 1] == 'f') {
                val next = i + 2
                if (isVowelAt(raw, next)) {
                    val key = "f${raw[next]}"
                    append(dict[key] ?: "フ${dict[raw[next].toString()] ?: ""}")
                    i += 3
                } else {
                    append("フ")
                    i += 2
                }
                wordStart = false
                continue
            }

            if (i + 1 < raw.length && raw[i] == 'p' && raw[i + 1] == 'h') {
                append("フ")
                i += 2
                wordStart = false
                continue
            }

            if (i + 1 < raw.length && raw[i] == raw[i + 1] && raw[i] !in vowels && raw[i] != 'n' && raw[i] != 'f') {
                append("ッ")
                i += 1
                wordStart = false
                continue
            }

            if (i + 1 < raw.length && (raw[i] == 'c' || raw[i] == 'k') &&(raw[i + 1] == 'c' || raw[i + 1] == 'k')) {
                append("ッ")
                i += 1
                wordStart = false
                continue
            }

            if (polishMode && raw[i] == 'j' && i + 1 < raw.length && raw[i + 1] in vowels) {
                when (raw[i + 1]) {
                    'a' -> append("ヤ")
                    'e' -> append("イェ")
                    'i' -> append("イ")
                    'o' -> append("ヨ")
                    'u' -> append("ユ")
                }
                i += 2
                wordStart = false
                continue
            }

            if (i + 1 < raw.length && raw[i] == 'n' && (raw[i + 1] == 'g' || raw[i + 1] == 'k')) {
                append(if (raw[i + 1] == 'g') "ング" else "ンク")
                i += 2
                wordStart = false
                continue
            }

            var matched = false
            val maxLen = minOf(maxKey, raw.length - i)
            for (len in maxLen downTo 1) {
                val chunk = raw.substring(i, i + len)

                if (len == 1 && chunk == "c") {
                    val nxt = raw.getOrNull(i + 1)
                    when (nxt) {
                        'a' -> append("カ")
                        'o' -> append("コ")
                        'u' -> append("ク")
                        'e' -> append("セ")
                        'i' -> append("シ")
                        else -> append("ク")
                    }
                    i += 1
                    matched = true
                    break
                }

                dict[chunk]?.let {
                    append(it)
                    i += len
                    matched = true
                    break
                }
            }
            if (matched) {
                wordStart = false
                continue
            }

            if (ch == 'q') {
                append("ク")
                i++
                wordStart = false
                continue
            }

            if (ch == 'x') {
                append("クス")
                i++
                wordStart = false
                continue
            }

            if (ch == 'n') {
                val next = raw.getOrNull(i + 1)
                if (next == null || (next !in vowels && !(next == 'y' && isVowelAt(raw, i + 2)))) {
                    append("ン")
                    i++
                    wordStart = false
                    continue
                }
            }

            if (polishMode && ch == 'w') {
                // If vowel follows, use ヴ + vowel; else default ヴ
                val nxt = raw.getOrNull(i + 1)
                if (nxt != null && nxt in vowels) {
                    val key = "v$nxt"
                    append(dict[key] ?: ("ヴ" + (dict[nxt.toString()] ?: "")))
                    i += 2
                } else {
                    append("ヴ")
                    i++
                }
                wordStart = false
                continue
            }

            // Generic single-character fallback
            append(fallbackKana(ch))
            i++
            wordStart = false
        }
    }.replace("アア$".toRegex(), "ア")
        .replace("イイ$".toRegex(), "イ")
        .replace("ウウ$".toRegex(), "ウ")
        .replace("エエ$".toRegex(), "エ")
        .replace("オオ$".toRegex(), "オ")
        .replace("カア$".toRegex(), "カ")
        .replace("キイ$".toRegex(), "キ")
        .replace("クウ$".toRegex(), "ク")
        .replace("ケエ$".toRegex(), "ケ")
        .replace("コオ$".toRegex(), "コ")
}