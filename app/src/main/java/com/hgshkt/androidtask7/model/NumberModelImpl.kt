package com.hgshkt.androidtask7.model

import android.content.Context
import android.content.SharedPreferences

class NumberModelImpl(
    context: Context
): NumberModel {

    private var sharedPreferences: SharedPreferences

    private val name = "MyPref"
    private val key = "number"
    private val defValue = 0

    init {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    override fun get() = sharedPreferences.getInt(key, defValue)

    override fun add() {
        var number = get()
        number++

        sharedPreferences.edit()
            .putInt(key, number)
            .apply()
    }
}