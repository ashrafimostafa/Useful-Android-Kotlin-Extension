/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}

fun View.showSuccessSnackBar(message: String, length: Int = Snackbar.LENGTH_LONG) {
    showSnackBar(this, message, length, R.drawable.rounded_charcoal_snack_bar_background)
}

fun View.showErrorSnackBar(message: String, length: Int = Snackbar.LENGTH_LONG) {
    showSnackBar(this, message, length, R.drawable.rounded_red_snack_bar_background)
}

private fun showSnackBar(
    view: View,
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    @DrawableRes background: Int
) {
    val snack: Snackbar = Snackbar.make(view, message, length)
    val snackView = snack.view
    val params = snackView.layoutParams as FrameLayout.LayoutParams
    snackView.background = ContextCompat.getDrawable(view.context, background)
    params.gravity = Gravity.TOP
    snackView.layoutParams = params
    snack.show()
}
