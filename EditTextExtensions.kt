/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

inline fun EditText.onTextChange(crossinline listener: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(edt: Editable?) {
            listener(normalizeArabicWords(edt.toString()))
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    })
}

fun EditText.onTextChangedWithDebounce(
    debounceDuration: Long = 300L,
    coroutineScope: CoroutineScope,
    onTextChanged: (String) -> Unit
) {
    val editText = this
    val textChangeFlow = callbackFlow<String> {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let { trySend(it).isSuccess }
            }
        }
        editText.addTextChangedListener(textWatcher)
        awaitClose { editText.removeTextChangedListener(textWatcher) }
    }
    textChangeFlow.debounce(debounceDuration).onEach { onTextChanged(it) }.launchIn(coroutineScope)
}