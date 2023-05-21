/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun AppCompatImageView.setTint(@ColorRes color: Int?) {
    if (color == null) {
        ImageViewCompat.setImageTintList(this, null)
    } else {
        ImageViewCompat.setImageTintList(
            this,
            ColorStateList.valueOf(ContextCompat.getColor(context, color))
        )
    }
}

fun AppCompatImageView.makeGrayScale() {
    val matrix = ColorMatrix()
    matrix.setSaturation(0f)
    val filter = ColorMatrixColorFilter(matrix)
    colorFilter = filter
}


/**
 * Load with Glide
 */
fun ImageView.loadImagesWithGlide(id: Int, placeholder: Int = R.drawable.ic_loading) {
    try {
        GlideApp.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(placeholder)
            .into(this)
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}

fun ImageView.loadDrawableWithGlide(drawableImage: Int) {
    try {
        GlideApp.with(this)
            .load(drawableImage)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}

fun ImageView.loadImageFromUriWithGlide(uri: Uri, placeholder: Int) {
    try {
        GlideApp.with(this)
            .load(uri)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(placeholder)
            .into(this)
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}

fun ImageView.loadVideoThumbnailWithGlide(uri: Uri, placeholder: Int) {
    try {
        GlideApp.with(this)
            .load(uri)
            .placeholder(placeholder)
            .into(this);
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}

fun ImageView.loadImagesFromUrlWithGlide(url: String, placeholder: Int = R.drawable.ic_squircle) {
    try {
        GlideApp.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(placeholder)
            .into(this)
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}

fun ImageView.loadImagesFromDrawableWithGlide(drawable: Drawable, placeholder: Int = R.drawable.ic_loading) {
    try {
        GlideApp.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(placeholder)
            .into(this)
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}

fun ImageView.loadImageFromUrlByGifPlaceholderWithGlide(context: Context, url: String) {
    try {
        GlideApp.with(this)
            .load(url)
            .thumbnail(Glide.with(context).load(R.raw.anim_slider_placeholder))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    } catch (e: Exception) {
        Log.e(TAG, e)
    }
}