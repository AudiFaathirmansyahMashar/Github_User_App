package id.sharekom.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import id.sharekom.githubuserapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val profile = intent.getParcelableExtra<ProfileModel>(Values.Profile)

        binding.avatar = resources.getDrawable(profile!!.avatar, null)
        binding.name = profile.name
        binding.company = profile.company
        binding.location = profile.location
        binding.repository = profile.repository
        binding.followers = profile.followers
        binding.following = profile.following
        binding.username = profile.username
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) onBackPressed()

        return super.onOptionsItemSelected(item)
    }
}