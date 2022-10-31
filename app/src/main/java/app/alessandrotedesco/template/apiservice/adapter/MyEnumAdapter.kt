package app.alessandrotedesco.template.apiservice.adapter

import app.alessandrotedesco.template.apiservice.model.MyEnum
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class MyEnumAdapter { // TODO example
    @ToJson
    fun toJson(myEnum: MyEnum?): String? {
        return myEnum?.value
    }
    @FromJson
    fun fromJson(myEnumValue: String?): MyEnum? {
        return MyEnum.values().firstOrNull { it.value == myEnumValue }
    }
}