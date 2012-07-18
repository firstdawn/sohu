package com.sohu.suc.request.sce.service;

import java.lang.reflect.Proxy;

import com.sohu.suc.request.sce.adapter.NormalMsgSceServiceAdapter;
import com.sohu.suc.request.sce.adapter.SystemMsgSceServiceAdapter;
import com.sohu.suc.sce.adapter.BlockCutterInvocationHandler;

/**
 * ����ϵͳSCE���񹤳�
 * 
 * @author linhao
 * @version 1.0 Build 2012-3-30
 *
 */
public class RequestSceServiceFactory {
	
	/**
	 * ��ͨ��ϢSCE����
	 */
	private static volatile NormalMsgSceService normalMsgSceService = null;
	
	/**
	 * ϵͳ��ϢSCE����
	 */
	private static volatile SystemMsgSceService systemMsgSceService = null;
	
	public static NormalMsgSceService getNormalMsgSceService() {
		if (normalMsgSceService == null) {
            synchronized (NormalMsgSceService.class) {
                if (normalMsgSceService == null) {
                	normalMsgSceService = 
                			createAdapter(
                					NormalMsgSceService.class, 
                					new NormalMsgSceServiceAdapter(), 
                					"RequestSceNormalMsgService");
                }
            }
        }
		return normalMsgSceService;
	}
	
	public static SystemMsgSceService getSystemMsgSceService() {
		if (systemMsgSceService == null) {
            synchronized (SystemMsgSceService.class) {
                if (systemMsgSceService == null) {
                	systemMsgSceService = 
                			createAdapter(
                					SystemMsgSceService.class, 
                					new SystemMsgSceServiceAdapter(), 
                					"RequestSceSystemMsgService");
                }
            }
        }
		return systemMsgSceService;
	}
	
	
    /**
     * ����������
     * @param c ����
     * @param obj ʵ��
     * @param serviceName ��������
     * @return ������
     */
    private static <T> T createAdapter(Class<?> c, final T obj, final String serviceName) {
        return createAdapter(new Class[] { c }, obj, serviceName);
    }

    /**
     * ����������
     * @param cs ��������
     * @param obj ʵ��
     * @param serviceName ��������
     * @return ������
     */
    @SuppressWarnings("unchecked")
    private static <T> T createAdapter(Class<?>[] cs, final T obj, final String serviceName) {
        for (Class<?> c : cs) {
            if (!c.isInterface()) throw new IllegalArgumentException("the class type " + c.getName() + " must be an interface");
        }
        return (T) Proxy.newProxyInstance(
        		RequestSceServiceFactory.class.getClassLoader(),
                cs,
                new BlockCutterInvocationHandler(serviceName, obj));
    }
	
}
