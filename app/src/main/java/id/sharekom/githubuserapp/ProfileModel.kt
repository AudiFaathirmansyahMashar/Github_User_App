package id.sharekom.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileModel(val username:String, val name:String, val location:String, val repository:String, val company:String, val followers:String, val following:String, val avatar:Int):Parcelable