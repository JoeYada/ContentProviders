package com.example.joe.contentproviders.ui

import android.content.ContentValues
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.CursorLoader
import android.support.v4.content.Loader
import android.view.View
import android.widget.Toast
import com.example.joe.contentproviders.R
import com.example.joe.contentproviders.common.URL_LOADER
import com.example.joe.contentproviders.providers.MyContentProviderContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportLoaderManager.initLoader(URL_LOADER, null, this)
    }

    override fun onCreateLoader(loaderId: Int, bundle: Bundle?): Loader<Cursor> {
        return when (loaderId) {
            URL_LOADER -> CursorLoader(
                this, //Context
                MyContentProviderContract.MyContentProviderEntry.CONTENT_URI, // Table to query
                null,
                null,
                null,
                null
            )else -> throw NullPointerException()
        }
    }

    override fun onLoadFinished(p0: Loader<Cursor>, p1: Cursor?) {
        Toast.makeText(this, "Load Done", Toast.LENGTH_SHORT).show()
    }

    override fun onLoaderReset(p0: Loader<Cursor>) {
    }


    fun insertContact(view: View) {
        val contentValue = ContentValues()
        contentValue.put(
            MyContentProviderContract.MyContentProviderEntry.COLUMN_CONTACT_NAME,
            etContactName.text.toString()
        )
        contentValue.put(
            MyContentProviderContract.MyContentProviderEntry.COLUMN_CONTACT_RELATIONSHIP,
            etContactRelationship.text.toString()
        )
        contentValue.put(
            MyContentProviderContract.MyContentProviderEntry.COLUMN_CONTACT_PRIMARY_NUMBER,
            etPrimaryNumber.text.toString()
        )
        contentValue.put(
            MyContentProviderContract.MyContentProviderEntry.COLUMN_CONTACT_SECONDARY_NUMBER,
            etSecondaryNumber.text.toString()
        )

        contentResolver.insert(MyContentProviderContract.MyContentProviderEntry.CONTENT_URI, contentValue)
    }
}
