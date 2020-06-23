package id.sharekom.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.sharekom.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)
        val company = resources.getStringArray(R.array.company)
        val followers = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)
        val avatar = resources.obtainTypedArray(R.array.avatar)

        val adapter = ProfileAdapter(username, name, location, repository, company, followers, following, avatar)

        binding.recycerView.setHasFixedSize(true)
        binding.recycerView.adapter = adapter
    }
}