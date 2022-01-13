package com.example.letsgetfit.ui


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.letsgetfit.R
import com.example.letsgetfit.data.network.models.RequestDto
import com.example.letsgetfit.databinding.FragmentWebViewBinding
import com.example.letsgetfit.presentation.CustomChromeClient
import com.example.letsgetfit.presentation.CustomWebClient
import com.example.letsgetfit.presentation.ViewModelWebView


class WebViewFragment : Fragment() {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ViewModelWebView
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var chromeClient: CustomChromeClient

    companion object {
        const val INPUT_FILE_REQUEST_CODE = 1
        const val FILECHOOSER_RESULTCODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init
        webView = binding.webView
        progressBar = binding.progressBar
        swipeRefreshLayout = binding.swipeRefreshLayout
        chromeClient = CustomChromeClient(requireActivity())

        viewModel = ViewModelProvider(this)[ViewModelWebView::class.java]

        var request: RequestDto? = null

        viewModel.getLocale.observe(viewLifecycleOwner, {
            request = it
            Log.d("CHECK_WEB_FRAGMENT", "webviewLocale - > ${it.request}")
        })

        val response = request?.let { viewModel.callToServer(it) }

        response?.observe(viewLifecycleOwner, {
            viewModel.setWebViewSettings(webView.settings)
            webView.webChromeClient = chromeClient
            webView.webViewClient = CustomWebClient(requireContext(), progressBar)
        })
    }

    @SuppressLint("ObsoleteSdkInt")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode != INPUT_FILE_REQUEST_CODE || chromeClient.mFilePathCallback == null) {
                super.onActivityResult(requestCode, resultCode, data)
                return
            }
            var results: Array<Uri>? = null
            // Check that the response is a good one
            if (resultCode == AppCompatActivity.RESULT_OK) {
                if (R.attr.data == null) {
                    // If there is not data, then we may have taken a photo
                    if (chromeClient.mCameraPhotoPath != null) {
                        results = arrayOf(Uri.parse(chromeClient.mCameraPhotoPath))
                    }
                } else {
                    val dataString: String? = data?.getDataString()
                    if (dataString != null) {
                        results = arrayOf(Uri.parse(dataString))
                    }
                }
            }
            chromeClient.mFilePathCallback?.onReceiveValue(results)
        } else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            if (requestCode != FILECHOOSER_RESULTCODE || chromeClient.mUploadMessage == null) {
                super.onActivityResult(requestCode, resultCode, data)
                return
            }
            if (requestCode == FILECHOOSER_RESULTCODE) {
                if (null == chromeClient.mUploadMessage) {
                    return
                }
                var result: Uri? = null
                try {
                    if (resultCode != AppCompatActivity.RESULT_OK) {
                        result = null
                    } else {
                        // retrieve from the private variable if the intent is null
                        result = data?.let { chromeClient.mCapturedImageURI ?: it.data }
                    }
                } catch (e: Exception) {
                    Log.e("CHECK_WEB_FRAGMENT", "onActivityResult", e)
                }
                chromeClient.mUploadMessage.onReceiveValue(result)
            }
        }
        return
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}