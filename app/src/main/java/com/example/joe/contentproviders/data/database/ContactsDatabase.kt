package com.example.joe.contentproviders.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.joe.contentproviders.common.DATABASE_VERSION
import com.example.joe.contentproviders.data.dao.ContactsDao
import com.example.joe.contentproviders.data.entities.Contact

@Database(entities = [Contact::class], version = DATABASE_VERSION)
abstract class ContactsDatabase: RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}