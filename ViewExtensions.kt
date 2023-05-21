/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visibleOrInvisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun View.setBackground(drawable: Int) {
    background = ContextCompat.getDrawable(context, drawable)

}

fun View.setOnClickListenerWithDebounce(debounceTime: Long = 1_000L, action: (View) -> Unit) {
    this.setOnClickListener {
        val uptimeMillis = SystemClock.uptimeMillis()
        if (uptimeMillis - ClickDebounceStore.lastDebounce > debounceTime) {
            ClickDebounceStore.lastDebounce = uptimeMillis
            action(this)
        }
    }
}

fun View.onGlobalLayout(callback: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            callback()
        }
    })
}


inline fun <T : View> T.afterMeasured(crossinline f: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}

object ClickDebounceStore {
    var lastDebounce = 0L
}
