package com.example.newapihomework6_android4.data.remote.interseptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey", "d0e4e3d9df4a4f57b4a9f173820ee959").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
