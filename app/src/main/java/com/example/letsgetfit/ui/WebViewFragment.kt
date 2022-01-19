package com.example.letsgetfit.ui


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.letsgetfit.R
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as AppCompatActivity).supportActionBar?.hide()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init
        webView = binding.webView
        progressBar = binding.progressBar
        swipeRefreshLayout = binding.swipeRefreshLayout
        chromeClient = CustomChromeClient(requireActivity())

        webView.webViewClient = CustomWebClient(requireContext(), progressBar)
        webView.webChromeClient = chromeClient

        viewModel = ViewModelProvider(this)[ViewModelWebView::class.java]
        viewModel.setWebViewSettings(webView.settings)
        viewModel.callToServer(webView)

        viewModel.isResponseNegative.observe(viewLifecycleOwner,{
            if (it == true){
                findNavController().navigate(R.id.action_webViewFragment_to_chooseFragment)
                Log.d("CHECK_CHECK",it.toString())
            }
        })

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            Handler(Looper.getMainLooper()).postDelayed({
                swipeRefreshLayout.isRefreshing = false
                webView.loadUrl(webView.url.toString())
            }, 900)
        }

        webView.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                webView.canGoBack()
            ) {
                webView.goBack()
                return@OnKeyListener true
            }
            false
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        chromeClient.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}