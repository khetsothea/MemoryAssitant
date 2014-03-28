/*
 * <P>Title:      任务管理器 V1.0</P>
 * <P>Description:数据管理接口</P>
 * <P>Copyright:  Copyright (c) 2008</P>
 * <P>Company:    BoRoBoRoMe Co. Ltd.</P>
 * @author        BoRoBoRoMe
 * @version       1.0 2011-6-24
 */
package com.boroborome.footstone.svc;

import com.boroborome.footstone.exception.MessageException;
import com.boroborome.footstone.model.EventContainer;
import com.boroborome.footstone.model.IBufferIterator;

/**
 * @author BoRoBoRoMe
 *
 */
public interface IDataSvc<E>
{
    /**
     * 创建一系列对象
     * @param it
     * @throws MessageException
     */
    void create(IBufferIterator<E> it) throws MessageException;
    
    /**
     * 修改一系列信息
     * @param it
     * @throws MessageException
     */
    void modify(IBufferIterator<E> it) throws MessageException;
    
    /**
     * 删除一系列东西
     * @param it
     * @throws MessageException
     */
    void delete(IBufferIterator<E> it) throws MessageException;
    
    /**
     * 根据条件查询数据
     * @param condtion
     * @return
     * @throws MessageException
     */
    IBufferIterator<E> query(IDataCondition<E> condition) throws MessageException;
    
    /**
     * 获取事件容器。通过这个容易可以监视这个数据管理服务处理数据的增加、删除、修改事件
     * @return
     */
    EventContainer<IDataChangeListener<E>> getEventContainer();
}