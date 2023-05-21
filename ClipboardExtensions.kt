/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun Context.copyToClipboard(text: String, label: String = "label") {
    val clipboard: ClipboardManager? = getSystemService(
        Context.CLIPBOARD_SERVICE
    ) as ClipboardManager?
    val clip = ClipData.newPlainText(label, text)
    clipboard?.setPrimaryClip(clip)
}