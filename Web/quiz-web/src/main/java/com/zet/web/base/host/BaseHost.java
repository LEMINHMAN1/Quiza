package com.zet.web.base.host;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zet.business.client.BusinessServiceStub;
import com.zet.framework.service.ServicePool;

/**
 * 
 * @author man le
 *
 */

@Component
public class BaseHost {

	@Autowired
	@Resource(name="businessServicePool")
	protected ServicePool<BusinessServiceStub> businessServicePool;
	
	protected BusinessServiceStub releaseServiceStub() throws AxisFault, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		BusinessServiceStub businessServiceStub = null;
		try{
			businessServiceStub = businessServicePool.getStub();
		}finally{
			if(businessServiceStub!=null) businessServicePool.release(businessServiceStub);
		}
		return businessServiceStub;
	}
	
}
