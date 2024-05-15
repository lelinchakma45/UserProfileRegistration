package com.example.userprofileregistration

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration.Model.UserProfile
import com.example.userprofileregistration.ViewModel.UserProfileViewModel
import com.example.userprofileregistration.databinding.ActivityProfileEditBinding

class ProfileEditActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var userProfile: UserProfile
    private lateinit var binding: ActivityProfileEditBinding

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var districtEditText: EditText
    private lateinit var mobileEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        mainUpdate()
        setContentView(binding.root)
        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun mainUpdate() {
        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        userProfile = intent.getSerializableExtra("USER_PROFILE") as UserProfile

        nameEditText = binding.userNameEt
        emailEditText = binding.emailEt
        dobEditText = binding.userBODEt
        districtEditText = binding.userHomeDistrict
        mobileEditText = binding.userPhone

        populateFields()

        binding.btnUpdate.setOnClickListener {
            updateUserProfile()
        }
    }

    private fun populateFields() {
        nameEditText.setText(userProfile.name)
        emailEditText.setText(userProfile.email)
        dobEditText.setText(userProfile.dob)
        districtEditText.setText(userProfile.district)
        mobileEditText.setText(userProfile.mobile)
    }

    private fun updateUserProfile() {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val dob = dobEditText.text.toString()
        val district = districtEditText.text.toString()
        val mobile = mobileEditText.text.toString()

        val updatedUserProfile = UserProfile(
            id = userProfile.id,
            name = name,
            email = email,
            dob = dob,
            district = district,
            mobile = mobile
        )
        profileViewModel.updateUserProfile(updatedUserProfile)
        finish()
    }
}