package id.sharekom.githubuserapp

import android.app.Activity
import android.content.Intent
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.sharekom.githubuserapp.databinding.ListCardBinding


class ProfileAdapter(val username:Array<String>, val name:Array<String>, val location:Array<String>, val repository:Array<String>, val company:Array<String>, val followers:Array<String>, val following:Array<String>, val avatar:TypedArray) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    inner class ProfileViewHolder(val binding: ListCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val card:ListCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_card, parent, false)
        return ProfileViewHolder(card)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.binding.avatar = avatar.resources.getDrawable(avatar.getResourceId(position, -1), null)
        holder.binding.fullName = name[position]
        holder.binding.followers = "Followers : ${followers[position]}"
        holder.binding.repository = "Repository : ${repository[position]}"
        holder.binding.cardView.setOnClickListener{
            val options:ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(it.context as Activity, holder.binding.profileAvatar, ViewCompat.getTransitionName(holder.binding.profileAvatar)!!)
            val i = Intent(it.context, DetailActivity::class.java)

            i.putExtra(Values.Profile, ProfileModel("Username : ${username[position]}", name[position], location[position], "Repository : ${repository[position]}", "Company : ${company[position]}", "Followers : ${followers[position]}", "Following : ${following[position]}", avatar.getResourceId(position, -1)))

            ContextCompat.startActivity(it.context, i, options.toBundle())
        }
    }
}