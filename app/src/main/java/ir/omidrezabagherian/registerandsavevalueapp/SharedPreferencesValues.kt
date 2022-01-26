package ir.omidrezabagherian.registerandsavevalueapp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

var nameTemp = "FullName"
var userTemp = "UserName"
var emailTemp = "UserName"
var passwordTemp = "UserName"
var genderTemp = "UserName"

const val nameFile = "User-Save"
const val modeFile = MODE_PRIVATE

const val fullNameKey = "FullNameKEY"
const val userNameKey = "UserNameKEY"
const val emailKey = "EmailKEY"
const val passwordKey = "PasswordKEY"
const val genderKey = "GenderKEY"

lateinit var valuesPreference:SharedPreferences