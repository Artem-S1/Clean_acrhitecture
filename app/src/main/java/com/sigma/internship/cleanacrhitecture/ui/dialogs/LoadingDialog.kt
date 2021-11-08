package  com.sigma.internship.cleanacrhitecture.ui.dialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.sigma.internship.cleanacrhitecture.R

class LoadingDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_loading_dialog, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    companion object {

        private fun newInstance(): LoadingDialog {
            return LoadingDialog()
        }

        fun start(manager: FragmentManager): LoadingDialog {
            val dialog = newInstance()
            dialog.isCancelable = false
            val transaction = manager.beginTransaction()
            transaction.add(dialog, LoadingDialog::class.java.simpleName)
            transaction.commitAllowingStateLoss()
            return dialog
        }
    }
}
