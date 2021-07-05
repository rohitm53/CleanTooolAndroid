package com.cleantool.indiacleantool.utils.parseutils

import android.content.Context
import java.io.InputStream

class ParsingAssets {

    companion object {

        public fun readJSONFromAsset(context: Context): String? {
            var json: String? = null
            try {
                val inputStream: InputStream = context.assets.open("provider_company_details.json")
                json = inputStream.bufferedReader().use { it.readText() }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return null
            }
            return json
        }
    }
}