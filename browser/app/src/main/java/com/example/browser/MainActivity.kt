package com.example.browser

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import com.google.android.material.textview.MaterialTextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browser = findViewById<WebView>(R.id.web_browser)
        browser.loadUrl("https://www.google.com")
        browser.settings.javaScriptEnabled = true
        browser.canGoBack()
        browser.webViewClient = WebClient(this)

        val search = findViewById<ImageButton>(R.id.search_btn)
        search.setOnClickListener(){
            val url = findViewById<EditText>(R.id.url_txt).text.toString()
            browser.loadUrl(url)
        }


        findViewById<ImageButton>(R.id.back_btn).setOnClickListener(){
            browser.goBack()
        }

        findViewById<ImageButton>(R.id.reload_btn).setOnClickListener(){
            browser.reload()
        }

        findViewById<MaterialTextView>(R.id.tabs_btn).setOnClickListener(){
//            val popup = PopupMenu(this, browser)
//            popup.inflate(R.layout.tab)

        }




    }

    class WebClient internal constructor(private val activity: Activity):WebViewClient(){
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }
    }


}