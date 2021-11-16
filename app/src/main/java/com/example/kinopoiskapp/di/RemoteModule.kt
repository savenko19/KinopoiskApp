package com.example.kinopoiskapp.di

import com.example.kinopoiskapp.BuildConfig
import com.example.kinopoiskapp.data.remote.MoviesApi
import com.example.kinopoiskapp.data.remote.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(okHttpClient = get(), BuildConfig.BASE_URL) }
    single { provideMoviesApi(retrofit = get()) }
    single { provideRemoteDataSource(moviesApi = get()) }
}

private fun provideRemoteDataSource(moviesApi: MoviesApi) =
    RemoteDataSource(moviesApi)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient.Builder().build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideMoviesApi(retrofit: Retrofit): MoviesApi =
    retrofit.create(MoviesApi::class.java)