package com.better.reads.ui.main.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.better.reads.R
import com.better.reads.databinding.DialogFragmentConfirmationBinding

private const val KEY_MESSAGE = "com.better.reads.ui.main.dialog.ConfirmationDialogFragment.KEY_MESSAGE"

class ConfirmationDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFragmentConfirmationBinding
    private var onOkClicked: (() -> Unit)? = null
    private var onCancelClicked: (() -> Unit)? = null

    override fun getTheme() = R.style.AppTheme_Alert

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val message = arguments?.getString(KEY_MESSAGE) ?: ""
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_fragment_confirmation,
            null,
            false
        )

        binding.message = message
        binding.onClickedOk = View.OnClickListener {
            onOkClicked?.invoke()
            dismiss()
        }
        binding.onClickedCancel = View.OnClickListener {
            onCancelClicked?.invoke()
            dismiss()
        }
        return binding.root
    }

    /**
     * set ok button unit callback
     *
     * @param onOkClicked unit callback when ok button is clicked
     */
    fun setOnOkClicked(onOkClicked: () -> Unit) {
        this.onOkClicked = onOkClicked
    }

    /**
     * set cancel button unit callback
     *
     * @param onCancelClicked unit callback when cancel button is clicked
     */
    fun setOnCancelClicked(onCancelClicked: () -> Unit) {
        this.onCancelClicked = onCancelClicked
    }

    companion object {
        fun newInstance(message: String) = ConfirmationDialogFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_MESSAGE, message)
            }
        }
    }
}