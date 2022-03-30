package com.example.mymovieinfo
import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import java.io.InputStream
import android.content.Context;
import android.content.Intent
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


class SearchActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchable)
        handleIntent(intent)

        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }
    }

    private fun doMySearch(query: String) {

    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }
    }
    //temporary
    var JARGON = null

    override fun onSearchRequested(): Boolean {
        val appData = Bundle().apply {
            putBoolean(JARGON, true)
        }
        startSearch(null, false, appData, false)
        return true
    }

    val jargon: Boolean = intent.getBundleExtra(SearchManager.APP_DATA)?.getBoolean(JARGON) ?: false

}