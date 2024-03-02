//package com.example.arabplustask.feature.data.data_source.remote
//
//import com.example.arabplustask.Secure.CustomTrustManager
//import com.example.arabplustask.Secure.TLSSocketFactory
//import okhttp3.OkHttpClient
//import okhttp3.TlsVersion
//import java.io.InputStream
//import java.security.cert.CertificateFactory
//
//fun createOkHttpClient(certificateStream: InputStream): OkHttpClient {
//    val trustManager = CustomTrustManager(certificateStream)
//
//    return OkHttpClient.Builder()
//        .sslSocketFactory(
//            TLSSocketFactory(trustManager),
//            trustManager
//        )
//        .build()
//}
