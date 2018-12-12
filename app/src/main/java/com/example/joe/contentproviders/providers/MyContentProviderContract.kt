package com.example.joe.contentproviders.providers

import android.net.Uri
import android.provider.BaseColumns
import com.example.joe.contentproviders.common.TABLE_NAME

object MyContentProviderContract {

    val CONTENT_AUTHORITY ="com.example.joe.contentproviders2"
    val BASE_CONTENT_URI = Uri.parse("content://$CONTENT_AUTHORITY")

    object MyContentProviderEntry: BaseColumns{
        val CONTENT_URI = BASE_CONTENT_URI.buildUpon()
            .appendPath(TABLE_NAME)
            .build()

        //Table Columns
        val COLUMN_CONTACT_NAME = "contactName"
        val COLUMN_CONTACT_RELATIONSHIP = "contactRelationship"
        val COLUMN_CONTACT_PRIMARY_NUMBER = "contactPrimaryNumber"
        val COLUMN_CONTACT_SECONDARY_NUMBER = "contactSecondaryNumber"
    }
}