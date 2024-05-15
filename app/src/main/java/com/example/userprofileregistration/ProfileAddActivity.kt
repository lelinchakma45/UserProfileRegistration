package com.example.userprofileregistration

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration.Model.UserProfile
import com.example.userprofileregistration.ViewModel.UserProfileViewModel
import com.example.userprofileregistration.databinding.ActivityProfileAddBinding

class ProfileAddActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileAddBinding
    private lateinit var profileViewModel: UserProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        binding.signEmailBtn.setOnClickListener {
            val name = binding.userNameEt.text.toString()
            val email = binding.emailEt.text.toString()
            val dob = binding.userBODEt.text.toString()
            val district = binding.userHomeDistrict.text.toString()
            val mobile = binding.userPhone.text.toString()

            val userProfile = UserProfile(name = name, email = email, dob = dob, district = district, mobile = mobile)
            profileViewModel.insertUserProfile(userProfile)

            finish()
        }
        binding.backBtn.setOnClickListener {
            finish()
        }
        setContentView(binding.root)
    }
}