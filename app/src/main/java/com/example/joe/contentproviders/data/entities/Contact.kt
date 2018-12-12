package com.example.joe.contentproviders.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.joe.contentproviders.common.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Contact(@PrimaryKey(autoGenerate = true)
                   val contactId: Int? = null,
                   val contactName: String,
                   val contactRelationship: String,
                   val contactPrimaryNumber: String,
                   val coontactSecondaryNumber: String)