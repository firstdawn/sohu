package com.sohu.suc.request.sce.service;

import sce.proto.request.Request.SystemMsg;
import sce.slice.request.MsgTypeEnum;
import sce.slice.request.PagedPbSystemMsgList;
import sce.slice.request.RequestSceServerException;

/**
 * ����SCE����ӿ�
 * 
 * @author linhao
 * @version  Build 2012-4-27
 *
 */
public interface SystemMsgSceService {
	
	/**
	 * ����ϵͳ��Ϣ
	 * @param systemMsg ϵͳ��Ϣʵ��
	 * @return ����ID
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	long createOne(SystemMsg systemMsg) throws RequestSceServerException;

	/**
	 * ɾ��ϵͳ��Ϣ
	 * @param id ����ID
	 * @param msgType ��Ϣ����
	 * @return �Ƿ�ɹ�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	boolean delete(long id, MsgTypeEnum msgType) throws RequestSceServerException;

	/**
	 * ��ȡϵͳ��Ϣ�б�
	 * @param msgType ��Ϣ����
	 * @param start ��ʼ��������0��ʼ
	 * @param count ��ȡ����
	 * @return ��ҳ��ϵͳ��Ϣ�б�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	PagedPbSystemMsgList getList(MsgTypeEnum msgType, int start, int count) throws RequestSceServerException;

	/**
	 * ��ȡϵͳ��Ϣ
	 * @param id ����ID
	 * @param msgType ��Ϣ����
	 * @return ϵͳ��Ϣ
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	SystemMsg getOne(long id, MsgTypeEnum msgType) throws RequestSceServerException;

	/**
	 * ����ϵͳ��Ϣ
	 * @param systemMsg ϵͳ��Ϣʵ��
	 * @return �Ƿ�ɹ�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	boolean update(SystemMsg systemMsg) throws RequestSceServerException;

}