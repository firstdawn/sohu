package com.sohu.suc.request.sce.adapter;

import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;

import com.sohu.suc.adventure.core.MyLogger;
import com.sohu.suc.adventure.core.MyLoggerFactory;

/**
 * �����ļ�������
 * @author haolin
 */
public class PropertiesAgent {
	
	/**
	 * ��־����
	 */
	private final MyLogger log = MyLoggerFactory.getLogger(this.getClass());
	
	/**
	 * ������ʵ������
	 */
	private Properties properties = null;
	
	/**
	 * ���췽��
	 * @param bundleFilePath �����ļ�·��
	 */
	public PropertiesAgent(String bundleFilePath) {
		try{
			properties = getPropertiesFromBundle(bundleFilePath);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * ���ƶ��������ļ���
	 * @param bundleFilePath �����ļ�·��
	 * @return ���������ļ���������Propertiesʵ��
	 * @throws Exception �����ʧ�����׳����쳣
	 */
	public Properties getPropertiesFromBundle(String bundleFilePath) throws Exception {
	    String key,value;
		Properties properties = new Properties();
		PropertyResourceBundle propertyResourceBundle = null;
		try {
			propertyResourceBundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle(bundleFilePath);
		} catch (Exception e) {
			throw new Exception(e);
		}
		Enumeration<String> keys = propertyResourceBundle.getKeys();
	    while (keys.hasMoreElements()) {
	    	key = (String) keys.nextElement();
	    	value = propertyResourceBundle.getString(key);
	    	if (value != null) {
	    		properties.put(key, value);
	    	}
	    }
		return properties;
	}
	
	/**
	 * �������Լ���ȡ�ַ�����ʽ������ֵ������������ڻ�ֵΪ�գ������ȱʡ����ֵ��
	 * @param key ���Լ�
	 * @param defaultValue ȱʡ����ֵ
	 * @return ����ֵ
	 */
	public String getStringProperty(String key, String defaultValue) {
		String value = null;
		if (properties != null) {
			value = properties.getProperty(key);
		}
		if (null == value || value.trim().length() == 0) {
			value = defaultValue;
		} else {
			value.trim();
		}
		return value;
	}
	  
	/**
	 * �������Լ���ȡ������ʽ������ֵ������������ڻ�ֵΪ�գ������ȱʡ����ֵ��
	 * @param key ���Եļ�
	 * @param defaultValue Ĭ������ֵ
	 * @return ����ֵ
	 */
	public Integer getIntegerProperty(String key, int defaultValue) {
		Integer intValue = null;
		String stringValue = getStringProperty(key, null);
		try {
			intValue = Integer.valueOf(stringValue);
		} catch(NumberFormatException nfe) {
			//
		}
		if (intValue == null) {
			return  defaultValue;
		} else {
			return intValue;
		}
	}
	
	/**
	 * �������Լ���ȡ��������ʽ������ֵ������������ڻ�ֵΪ�գ������ȱʡ����ֵ��
	 * @param key ���Եļ�
	 * @param defaultValue Ĭ������ֵ
	 * @return ����ֵ
	 */
	public Long getLongProperty(String key, long defaultValue) {
		Long longValue = null;
		String stringValue = getStringProperty(key, null);
		try {
			longValue = Long.valueOf(stringValue);
		} catch(NumberFormatException nfe) {
			//
		}
		if (longValue == null) {
			return  defaultValue;
		} else {
			return longValue;
		}
	}

}
