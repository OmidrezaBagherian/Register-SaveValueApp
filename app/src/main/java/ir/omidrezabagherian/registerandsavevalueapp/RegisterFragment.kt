package ir.omidrezabagherian.registerandsavevalueapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ir.omidrezabagherian.registerandsavevalueapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var bindingRegister: FragmentRegisterBinding
    private var gender = "Gender"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingRegister = FragmentRegisterBinding.bind(view)

        valuesPreference = activity!!.getSharedPreferences(nameFile, modeFile)

        setGender()

        bindingRegister.buttonRegister.setOnClickListener {
            saveValue()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setGender() {
        bindingRegister.groupGender.setOnCheckedChangeListener { _, checkedID ->
            gender = when (checkedID) {
                R.id.radio_male -> "Male"
                R.id.radio_female -> "Female"
                else -> "Gender"
            }
            Toast.makeText(activity, gender, Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveValue() {

        if (bindingRegister.editTextSetFullName.text!!.isEmpty()) Toast.makeText(
            activity,
            R.string.toast_fullName,
            Toast.LENGTH_SHORT
        ).show()
        else nameTemp = bindingRegister.editTextSetFullName.text.toString()

        if (bindingRegister.editTextSetUserName.text!!.isEmpty()) Toast.makeText(
            activity,
            R.string.toast_userName,
            Toast.LENGTH_SHORT
        ).show()
        else userTemp = bindingRegister.editTextSetUserName.text.toString()

        if (bindingRegister.editTextSetEmail.text!!.isEmpty()) Toast.makeText(
            activity,
            R.string.toast_email,
            Toast.LENGTH_SHORT
        ).show()
        else emailTemp = bindingRegister.editTextSetEmail.text.toString()

        when {
            bindingRegister.editTextSetPassword.text!!.isEmpty() -> Toast.makeText(
                activity,
                R.string.toast_password,
                Toast.LENGTH_SHORT
            ).show()
            bindingRegister.editTextSetPassword.text == bindingRegister.editTextSetRetypePassword.text -> Toast.makeText(
                activity,
                R.string.toast_match_not_passwords,
                Toast.LENGTH_SHORT
            ).show()
            else -> passwordTemp = bindingRegister.editTextSetPassword.text.toString()
        }

        if (gender == "Gender") Toast.makeText(
            activity,
            "Gender is empty",
            Toast.LENGTH_SHORT
        ).show()
        else genderTemp = gender

        activity!!.supportFragmentManager.commit {
            add(R.id.container_fragments, SaveValueFragment())
            setReorderingAllowed(true)
        }

    }
}