package com.jlhg.wizeline.remote

import java.util.Locale
import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .addQueryParameter("language", Locale.getDefault().language)
            .addQueryParameter("region", Locale.getDefault().country)
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
