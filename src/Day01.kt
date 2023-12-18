fun main() {
    fun part1(input: List<String>): Int {
        return input
                .map { it.find { c -> c in '0'..'9' }.toString() + it.findLast { c -> c in '0'..'9' }.toString() }
                .sumOf { Integer.parseInt(it) }
    }

    fun match(s: String, i: Int): String {
        val values = mapOf<String, String>(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )

        if (s[i] in '0' .. '9') return s[i].toString();

        for ((a, b) in values)
            if (i + a.length - 1 < s.length && s.substring(i..<i + a.length) == a)
                return b

        return "";
    }

    fun part2(input: List<String>): Int {
        return input
                .map {
                    it.indices.map { i -> match(it, i) }
                    .filter { s -> s.isNotEmpty() } }
                .sumOf { Integer.parseInt(it.first() + it.last()) }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
