package com.example.letsgetfit.presentation

import android.content.Context
import android.graphics.Bitmap
import android.net.http.SslError
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import android.widget.Toast

class CustomWebClient(
    private val context: Context,
    private val progressBar: ProgressBar
) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url.toString())
        return true
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        Toast.makeText(context, "Проверьте интернет соединение.", Toast.LENGTH_SHORT).show()
    }

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        super.onReceivedSslError(view, handler, error)
        handler?.cancel()
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        progressBar.visibility = View.VISIBLE
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }

}