package com.example.joe.contentproviders.data.dao

import android.arch.persistence.room.*
import android.database.Cursor
import com.example.joe.contentproviders.data.entities.Contact
import io.reactivex.Flowable

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact): Long

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContact(): Flowable<List<Contact>>

    //Cursor is used to get the result of the query
    //You don't need multiple cursors
    @Query("SELECT * FROM contacts")
    fun getCursorContacts(): Cursor
}