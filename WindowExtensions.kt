/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun Window.setStatusColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.statusBarColor = color
    }
}

fun Window.setAppearanceLightStatusBars(isAppearanceLightStatusBars: Boolean) {
    WindowCompat.getInsetsController(this, this.decorView).isAppearanceLightStatusBars =
        isAppearanceLightStatusBars
}

fun Window.preventScreenCapture() =
    this.setFlags(
        WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE
    )
