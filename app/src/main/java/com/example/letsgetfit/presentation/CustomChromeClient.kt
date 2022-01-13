package com.example.letsgetfit.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.lifecycle.LiveData
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CustomChromeClient(private val context: Activity) : WebChromeClient() {

    private var _mUploadMessage: ValueCallback<Uri>? = null
    val mUploadMessage get() = _mUploadMessage!!

    private var _mCapturedImageURI: Uri? = null
    val mCapturedImageURI get() = _mCapturedImageURI!!

    private var _mFilePathCallback: ValueCallback<Array<Uri>>? = null
    val mFilePathCallback get() = _mFilePathCallback!!

    private var _mCameraPhotoPath: String? = null
    val mCameraPhotoPath get() = _mCameraPhotoPath!!

    companion object {
        const val INPUT_FILE_REQUEST_CODE = 1
        const val FILECHOOSER_RESULTCODE = 1
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        _mFilePathCallback?.let { it.onReceiveValue(null) }
        _mFilePathCallback = filePathCallback
        var takePicIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePicIntent?.resolveActivity(context.packageManager) != null) {
            var photoFile: File? = null
            try {
                photoFile = createImageFile()
                takePicIntent.putExtra("PhotoFile", mCameraPhotoPath)
            } catch (e: IOException) {
                Log.e("CHECK_WEB_FRAGMENT", "CANNOT TO CREATE AN IMAGE FILE CHROME CLIENT", e)
            }
            if (photoFile != null) {
                _mCameraPhotoPath = "file:" + photoFile.absolutePath
                takePicIntent.putExtra(
                    MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(photoFile)
                )
            } else {
                takePicIntent = null
            }
        }
        val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
        contentSelectionIntent.setType("image/*")
        var intentArray: Array<Intent>? = null
        if (takePicIntent != null) {
            intentArray = arrayOf(takePicIntent)
        } else {
            intentArray = arrayOf()
        }
        val chooserIntent = Intent(Intent.ACTION_CHOOSER)
        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
        context.startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE)
        return true
    }

    //android 3.0
    fun openFileChooser(uploadMsg: ValueCallback<Uri>?, acceptType: String) {
        _mUploadMessage = uploadMsg
        val imageStorageDir = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            ), "AndroidExampleFolder"
        )
        if (!imageStorageDir.exists()) {
            // Create AndroidExampleFolder at sdcard
            imageStorageDir.mkdirs()
        }
        // Create camera captured image file path and name
        val file = File(
            imageStorageDir.toString() + File.separator + "IMG_"
                    + System.currentTimeMillis().toString() + ".jpg"
        )
        _mCapturedImageURI = Uri.fromFile(file)
        // Camera capture image intent
        val captureIntent = Intent(
            MediaStore.ACTION_IMAGE_CAPTURE
        )
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI)
        val i = Intent(Intent.ACTION_GET_CONTENT)
        i.addCategory(Intent.CATEGORY_OPENABLE)
        i.type = "image/*"
        // Create file chooser intent
        // Create file chooser intent
        val chooserIntent = Intent.createChooser(i, "Image Chooser")
        // Set camera intent to file chooser
        // Set camera intent to file chooser
        chooserIntent.putExtra(
            Intent.EXTRA_INITIAL_INTENTS, arrayOf<Parcelable>(captureIntent)
        )
        // On select image call onActivityResult method of activity
        // On select image call onActivityResult method of activity
        context.startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE)
    }

    // openFileChooser for Android < 3.0
    fun openFileChooser(uploadMsg: ValueCallback<Uri>?) {
        openFileChooser(uploadMsg, "")
    }

    //openFileChooser for other Android versions
    fun openFileChooser(
        uploadMsg: ValueCallback<Uri>?,
        acceptType: String?,
        capture: String?
    ) {
        openFileChooser(uploadMsg, acceptType!!)
    }

    @SuppressLint("SimpleDateFormat")
    fun createImageFile(): File? {
        val timeStamp:String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_${timeStamp}_"
        val storageDir:File = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES
        )
        return File.createTempFile(
                imageFileName,  /* prefix */
        ".jpg",  /* suffix */
        storageDir /* directory */
        )
    }
}