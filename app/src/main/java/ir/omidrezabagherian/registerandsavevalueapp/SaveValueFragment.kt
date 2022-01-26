package ir.omidrezabagherian.registerandsavevalueapp

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ir.omidrezabagherian.registerandsavevalueapp.databinding.FragmentSaveValueBinding

class SaveValueFragment : Fragment(R.layout.fragment_save_value) {

    private lateinit var bindingSaveValue: FragmentSaveValueBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        valuesPreference = activity!!.getSharedPreferences(nameFile, modeFile)


    }

    private fun showValue() {
        val editorValue: SharedPreferences.Editor = valuesPreference.edit();

        bindingSaveValue.textViewShowFullName.text = nameTemp
        bindingSaveValue.textViewShowUserName.text = userTemp
        bindingSaveValue.textViewShowEmail.text = emailTemp
        bindingSaveValue.textViewShowPassword.text = passwordTemp
        bindingSaveValue.textViewShowGender.text = genderTemp

    }
}