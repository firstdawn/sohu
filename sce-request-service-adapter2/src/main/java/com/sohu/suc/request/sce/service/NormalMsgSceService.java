package com.sohu.suc.request.sce.service;

import java.util.List;

import sce.proto.request.Request.InformMsg;
import sce.proto.request.Request.RequestMsg;
import sce.slice.request.MsgTypeEnum;
import sce.slice.request.RequestSceServerException;

/**
 * ��ͨ��ϢSCE����ӿ�
 * 
 * @author linhao
 * @version Build 2012-5-16
 *
 */
public interface NormalMsgSceService {
	
	/**
	 * ����֪ͨ
	 * @param informMsg ֪ͨ��Ϣʵ��
	 * @return ����ID
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	long createInform(InformMsg informMsg) throws RequestSceServerException;

	/**
	 * ��������֪ͨ
	 * @param informMsgList ֪ͨ��Ϣʵ���б�
	 * @return �Ƿ�ɹ�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	boolean createInforms(List<InformMsg> informMsgList) throws RequestSceServerException;

	/**
	 * ɾ��֪ͨ
	 * @param id ����ID
	 * @param passport �����ߵ�Passport
	 * @param msgType ��Ϣ����
	 * @return �Ƿ�ɹ�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	boolean deleteInform(long id, String passport, MsgTypeEnum msgType) throws RequestSceServerException;
	
	/**
	 * ��������
	 * @param requestMsg ������Ϣʵ��
	 * @return ����ID
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	long createRequest(RequestMsg requestMsg) throws RequestSceServerException;

	/**
	 * ������������
	 * @param requestMsgList ������Ϣʵ���б�
	 * @return �Ƿ�ɹ�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	boolean createRequests(List<RequestMsg> requestMsgList) throws RequestSceServerException;

	/**
	 * ɾ������
	 * @param id ����ID
	 * @param passport �����ߵ�Passport
	 * @param msgType ��Ϣ����
	 * @return �Ƿ�ɹ�
	 * @throws RequestSceServerException ����ʱ�׳����쳣
	 */
	boolean deleteRequest(long id, String passport, MsgTypeEnum msgType) throws RequestSceServerException;

}
