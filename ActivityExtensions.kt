/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun Activity.changeStatusBarIconsColor(isDark: Boolean) {
    WindowCompat.getInsetsController(
        window,
        window.decorView.rootView
    ).isAppearanceLightStatusBars = isDark
}

fun Activity.setStatusColor(color: Int) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        this.window?.statusBarColor = ContextCompat.getColor(
            this,
            color
        )
    }
}

fun Activity.setStatusColorFromColor(color: Int) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        this.window?.statusBarColor = color
    }
}

fun Activity.setupLauncherMode(view: View) {
    WindowCompat.getInsetsController(window, view)?.apply {
        hide(WindowInsetsCompat.Type.navigationBars())
        systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
    WindowCompat.setDecorFitsSystemWindows(window, false)
    window.setStatusColor(Color.TRANSPARENT)
}