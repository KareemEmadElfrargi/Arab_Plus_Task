package com.example.arabplustask.Secure
import java.io.InputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
class CustomTrustManager(private val certificateStream: InputStream) : X509TrustManager {

    private val trustManager: X509TrustManager

    init {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())

        keyStore.load(null, null)

        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificate = certificateFactory.generateCertificate(certificateStream)

        keyStore.setCertificateEntry("server", certificate)

        trustManagerFactory.init(keyStore)
        trustManager = trustManagerFactory.trustManagers.firstOrNull {
            it is X509TrustManager
        } as X509TrustManager? ?: throw IllegalStateException("No X509TrustManager found")
    }

    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        trustManager.checkClientTrusted(chain, authType)
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        chain?.forEach {
            it.checkValidity()
        }

        if (chain.isNullOrEmpty() || !chain.any { it.issuerDN == chain[0].issuerDN }) {
            throw Exception("Invalid certificate chain")
        }

        trustManager.checkServerTrusted(chain, authType)
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
}
