package com.zet.framework.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.client.Stub;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;

/**
 * 
 * @author manle
 * 
 */
public class ServicePool<T extends Stub> {
	private Class<T> clazz;
	private String serviceURL = null;
	private long timeout;

	private final static Logger LOG = Logger.getLogger(ServicePool.class);
	
	private MultiThreadedHttpConnectionManager httpConnectionManager = null;
	private HttpClient httpClient = null;

	public ServicePool(String serviceURL, long timeout, Class<T> clazz) {
		this.serviceURL = serviceURL;
		this.timeout = timeout;
		this.clazz = clazz;
	}
	
	private final List<T> servicePool = new ArrayList<T>();

	private void setupHttpConnectionManager(String host, int port, String scheme) {
		if (httpConnectionManager == null) {
			LOG.info("setupHttpConnectionManager:" + scheme + " " + host + " "+ port);
			httpConnectionManager = new MultiThreadedHttpConnectionManager();
			HttpConnectionManagerParams params = new HttpConnectionManagerParams();
			HostConfiguration hostConfiguration = new HostConfiguration();
			hostConfiguration.setHost(host, port, scheme);
			params.setMaxTotalConnections(100);
			params.setMaxConnectionsPerHost(hostConfiguration, 25);
			httpConnectionManager.setParams(params);
			httpClient = new HttpClient(httpConnectionManager);
		}
	}
	
	private void configureConnection(T client, String serviceURL) {
		LOG.info("configureConnection: " + serviceURL);
		if (httpConnectionManager == null) {
			String host = "";
			int port = 80;
			int portIndex = -1;
			String scheme = serviceURL.substring(0, serviceURL.indexOf(":"));
			if (scheme.equalsIgnoreCase("https")) {
				port = 443;
			}
			for (int i = scheme.length() + 3; i < serviceURL.length(); i++) {
				if (serviceURL.charAt(i) == ':') {
					portIndex = i + 1;
				} else if (serviceURL.charAt(i) == '/') {
					if (portIndex > -1) {
						port = Integer.parseInt(serviceURL.substring(portIndex, i));
						host = serviceURL.substring(scheme.length() + 3, portIndex - 1);
					} else {
						host = serviceURL.substring(scheme.length() + 3, i);
					}
					break;
				}
			}
			LOG.info("Configuring connection manager for URL [" + serviceURL + "]: scheme = [" + scheme + "] host = [" + host + "] port = [" + port + "]");
			setupHttpConnectionManager(host, port, scheme);
		}
		client._getServiceClient().getOptions().setProperty(HTTPConstants.REUSE_HTTP_CLIENT, Constants.VALUE_TRUE);
		client._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);
	}
	
	public synchronized T getStub() throws AxisFault,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		LOG.debug("Method call: borrowService [serviceURL = " + serviceURL + "]");
		T result = null;
		if (servicePool.size() > 0) {
			result = servicePool.remove(0);
		} else {
			result = (T) clazz.getDeclaredConstructor(String.class).newInstance(serviceURL);
			configureConnection(result, serviceURL);
		}
		LOG.debug("Method exit: borrowService [" + result + "]");
		return result;
	}

	public synchronized void release(T service) {
	    LOG.debug( "Method call: returnService [service = " +service + "]");
	    httpConnectionManager.closeIdleConnections(timeout);
	    servicePool.add( service);
	    LOG.debug( "Method exit: returnService");
	}
	

}
