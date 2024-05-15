package com.example.userprofileregistration

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userprofileregistration.Adaptar.ProfileAdapter
import com.example.userprofileregistration.Dialog.DeleteDialog
import com.example.userprofileregistration.ViewModel.UserProfileViewModel
import com.example.userprofileregistration.databinding.ActivityProfileListBinding

class ProfileListActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileListBinding
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var profileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        showData()
        setContentView(binding.root)
    }
    fun showData(){
        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        profileAdapter = ProfileAdapter()

        binding.profileList.adapter = profileAdapter
        binding.profileList.layoutManager = LinearLayoutManager(this)

        profileViewModel.getUserProfiles().observe(this, Observer { profiles ->
            profileAdapter.submitList(profiles)
        })

//        profileAdapter.setOnItemClickListener { userProfile ->
//            val intent = Intent(this@ProfileListActivity, ProfileDetailActivity::class.java)
//            intent.putExtra("USER_PROFILE", userProfile)
//            startActivity(intent)
//        }

//        profileAdapter.setOnDeleteClickListener { userProfile ->
//            profileViewModel.deleteUserProfile(userProfile)
//        }
        profileAdapter.setOnDeleteClickListener { userProfile ->
            val customDialog = DeleteDialog(this, userProfile) { shouldDelete ->
                if (shouldDelete) {
                    profileViewModel.deleteUserProfile(userProfile)
                }
            }
            customDialog.show()
        }

        profileAdapter.setOnUpdateClickListener { userProfile ->
            val intent = Intent(this@ProfileListActivity, ProfileEditActivity::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }

        binding.addProfileBtn.setOnClickListener {
            val intent = Intent(this@ProfileListActivity, ProfileAddActivity::class.java)
            startActivity(intent)
        }

    }
}