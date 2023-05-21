/**
 *
 * Author: Mostafa Ashrafi
 * Created: May 21, 2023
 * Updated: May 21, 2023
 *
 */

fun BottomSheetDialogFragment.safeShow(parentFragmentManager: FragmentManager) {
    if (!this.isAdded)
        this.show(parentFragmentManager, TAG)
}
