package com.firefly.net.tcp.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class NoCheckSSLContextFactory extends AbstractSSLContextFactory {

	@Override
	public SSLContext getSSLContext() {
		try {
			X509TrustManager tm = new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			return getSSLContextWithManager(null, new TrustManager[] { tm }, null);
		} catch (Throwable e) {
			log.error("get SSL context error", e);
			return null;
		}
	}
}
