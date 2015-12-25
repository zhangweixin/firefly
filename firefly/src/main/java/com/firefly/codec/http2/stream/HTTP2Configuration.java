package com.firefly.codec.http2.stream;

public class HTTP2Configuration {

	// TCP settings
	private int tcpIdleTimeout = 10 * 1000;

	// SSL/TLS settings
	private boolean secure;
	private String credentialPath, keystorePassword, keyPassword;

	// HTTP2 settings
	private int maxDynamicTableSize = 4096;
	private int streamIdleTimeout = 10 * 1000;
	private String flowControlStrategy = "buffer";
	private int initialStreamSendWindow = FlowControlStrategy.DEFAULT_WINDOW_SIZE;
	private int initialSessionRecvWindow = FlowControlStrategy.DEFAULT_WINDOW_SIZE;
	private int maxConcurrentStreams = -1;
	private int maxHeaderBlockFragment = 0;
	private int maxRequestHeadLength = 4 * 1024;

	public int getTcpIdleTimeout() {
		return tcpIdleTimeout;
	}

	public void setTcpIdleTimeout(int tcpIdleTimeout) {
		this.tcpIdleTimeout = tcpIdleTimeout;
	}

	public int getMaxDynamicTableSize() {
		return maxDynamicTableSize;
	}

	public void setMaxDynamicTableSize(int maxDynamicTableSize) {
		this.maxDynamicTableSize = maxDynamicTableSize;
	}

	public int getStreamIdleTimeout() {
		return streamIdleTimeout;
	}

	public void setStreamIdleTimeout(int streamIdleTimeout) {
		this.streamIdleTimeout = streamIdleTimeout;
	}

	public String getFlowControlStrategy() {
		return flowControlStrategy;
	}

	public void setFlowControlStrategy(String flowControlStrategy) {
		this.flowControlStrategy = flowControlStrategy;
	}

	public int getInitialSessionRecvWindow() {
		return initialSessionRecvWindow;
	}

	public void setInitialSessionRecvWindow(int initialSessionRecvWindow) {
		this.initialSessionRecvWindow = initialSessionRecvWindow;
	}

	public int getInitialStreamSendWindow() {
		return initialStreamSendWindow;
	}

	public void setInitialStreamSendWindow(int initialStreamSendWindow) {
		this.initialStreamSendWindow = initialStreamSendWindow;
	}

	public int getMaxConcurrentStreams() {
		return maxConcurrentStreams;
	}

	public void setMaxConcurrentStreams(int maxConcurrentStreams) {
		this.maxConcurrentStreams = maxConcurrentStreams;
	}

	public int getMaxHeaderBlockFragment() {
		return maxHeaderBlockFragment;
	}

	public void setMaxHeaderBlockFragment(int maxHeaderBlockFragment) {
		this.maxHeaderBlockFragment = maxHeaderBlockFragment;
	}

	public int getMaxRequestHeadLength() {
		return maxRequestHeadLength;
	}

	public void setMaxRequestHeadLength(int maxRequestHeadLength) {
		this.maxRequestHeadLength = maxRequestHeadLength;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getCredentialPath() {
		return credentialPath;
	}

	public void setCredentialPath(String credentialPath) {
		this.credentialPath = credentialPath;
	}

	public String getKeystorePassword() {
		return keystorePassword;
	}

	public void setKeystorePassword(String keystorePassword) {
		this.keystorePassword = keystorePassword;
	}

	public String getKeyPassword() {
		return keyPassword;
	}

	public void setKeyPassword(String keyPassword) {
		this.keyPassword = keyPassword;
	}

}