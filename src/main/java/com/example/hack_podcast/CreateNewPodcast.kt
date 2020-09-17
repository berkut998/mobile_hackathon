package com.example.hack_podcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.opengl.Visibility
import android.os.Build.*
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_create_new_podcast.*


class CreateNewPodcast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_podcast)

        imageView2.setOnClickListener {
            //check runtime permission
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }

    }

    fun open_EditeAudio(view: View) {
        val intent = Intent(this, EditeAudio::class.java).apply{}
        startActivity(intent)
    }
    fun open_PreviewPodCast(view: View) {
        val intent = Intent(this, PreView_PodCast::class.java).apply{}
        startActivity(intent)
    }

    fun load_Podcast(view: View) {
        textView5.visibility = View.INVISIBLE;
        textView6.visibility = View.INVISIBLE;
        view.visibility = View.INVISIBLE;
        imageView5.visibility = View.VISIBLE;
        label_time_audio.visibility = View.VISIBLE;
        lable_nameaudio.visibility = View.VISIBLE;
        edite_audio.visibility = View.VISIBLE
    }



    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            imageView2.setImageURI(data?.data)
        }
    }
}