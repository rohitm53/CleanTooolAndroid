package com.cleantool.indiacleantool.utils.stringutils

import java.util.*


fun getUniqueStringId() : String{
    return UUID.randomUUID().toString()
}