package com.example.imagegallery.networking.services

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

object APIResponse {
    private val TAG = APIResponse::class.java.simpleName
    fun <T> callRetrofit(call: Call<T>, strApiName: String?, apiListener: ApiListener) {
        call.enqueue(object : Callback<T?> {
            override fun onResponse(call: Call<T?>, response: Response<T?>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().toString())
                    }
                    apiListener.success(strApiName, response.body())
                } else {
                    try {
                        assert(response.errorBody() != null)
                        val jObjError = JSONObject(response.errorBody()!!.string())
                        try {
                            if (jObjError.has("errors") && jObjError.getJSONObject("errors") != null) {
                                parseErrors(strApiName, jObjError.getJSONObject("errors"), apiListener)
                            } else {
                                apiListener.error(strApiName, jObjError.getString("message").replace("[", "").replace("]", ""))
                            }
                        } catch (e: Exception) {
                            apiListener.error(strApiName, jObjError.getString("message").replace("[", "").replace("]", ""))
                            e.printStackTrace()
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<T?>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
                apiListener.failure(strApiName, t.toString())
            }
        })
    }

    private fun parseErrors(apiName: String?, errors: JSONObject, apiListener: ApiListener) {
        val builder = StringBuilder()
        val iter: Iterator<*> = errors.keys()
        while (iter.hasNext()) {
            val key = iter.next() as String
            var valueObj: JSONArray
            try {
                valueObj = errors.getJSONArray(key)
                builder.append(valueObj.toString().replace("[", "").replace("]", "")).append("\n")
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            apiListener.error(apiName, builder.toString())
        }
    }
}