package com.joyrun.base.core

import android.content.SharedPreferences
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * author: wneJie
 * date: 2019-09-26 14:05
 * desc:
 */
class TextWatcherDSL : TextWatcher {

    private var afterTextChanged: ((s: Editable?) -> Unit)? = null

    private var beforeTextChanged: ((s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)? =
        null

    private var onTextChanged: ((s: CharSequence?, start: Int, before: Int, count: Int) -> Unit)? =
        null


    override fun afterTextChanged(s: Editable?) {
        afterTextChanged?.invoke(s)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        beforeTextChanged?.invoke(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onTextChanged?.invoke(s, start, before, count)
    }


    fun afterTextChanged(after: (s: Editable?) -> Unit) {
        afterTextChanged = after
    }

    fun beforeTextChanged(before: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit) {
        beforeTextChanged = before
    }

    fun onTextChanged(textChanged: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit) {
        onTextChanged = textChanged
    }
}

infix fun EditText.onTextChange(textWatcher: TextWatcherDSL.() -> Unit): TextWatcher {
    val watcher = TextWatcherDSL().apply(textWatcher)

    val watcher2 = TextWatcherDSL().apply{
        textWatcher()
    }

    addTextChangedListener(watcher)
    return watcher
}

inline fun SharedPreferences.edit(
    action: SharedPreferences.Editor.() -> Unit
) {
//    val editor = edit()
//    action(editor)
//    editor.apply()

    edit().run {
        action(this)
        apply()
    }

}


fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sum2(x: Int, y: Int): Int = x + y

var i = { x: Int, y: Int -> x + y }

//var s : ((x:Int , y:Int) -> Unit) = 1