package com.prathamchikitse.app.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TTSManager(context: Context, private val onInitSuccess: () -> Unit = {}) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // Set Kannada language if available
            val kannadaLocale = Locale("kn", "IN")
            val result = tts?.setLanguage(kannadaLocale)
            
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTSManager", "Kannada language is not supported or missing data. Falling back to English.")
                tts?.setLanguage(Locale.ENGLISH)
            } else {
                isInitialized = true
                onInitSuccess()
            }
        } else {
            Log.e("TTSManager", "TTS Initialization failed!")
        }
    }

    fun speak(text: String, isKannada: Boolean) {
        if (isInitialized) {
            val locale = if (isKannada) Locale("kn", "IN") else Locale.ENGLISH
            val result = tts?.setLanguage(locale)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Fallback to English if Kannada is not supported
                tts?.setLanguage(Locale.ENGLISH)
            }
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            Log.w("TTSManager", "TTS not initialized yet")
        }
    }

    fun stop() {
        if (isInitialized) {
            tts?.stop()
        }
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}
