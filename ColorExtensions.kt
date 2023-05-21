/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun Int.isDarkColor(): Boolean {
    val darkness: Double =
        1 - (0.299 * Color.red(this) + 0.587 * Color.green(this) + 0.114 * Color.blue(this)) / 255
    return darkness >= 0.5
}