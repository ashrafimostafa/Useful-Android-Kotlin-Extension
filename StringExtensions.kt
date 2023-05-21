/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun String.titleCaseFirstChar() = replaceFirstChar(Char::titlecase)

fun String.containIllegalCharacters(): Boolean {
    val illegalCharacters = setOf(
        '.', '$', '!', '#', '%', '^', '-', '+', '~', '`', '÷',
        '؟', '/', '*', '@', '>', '<', '?', '[', '=', '{', '}'
    )
    return this.any(illegalCharacters::contains)
}

fun SpannableStringBuilder.appendSpace(): SpannableStringBuilder {
    val length: Int = length
    return replace(length, length, " ", 0, " ".length)
}