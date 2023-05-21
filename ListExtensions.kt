/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun MutableList<String>.addIfNotExists(item: String) {
    if (!contains(item)) add(item)
}