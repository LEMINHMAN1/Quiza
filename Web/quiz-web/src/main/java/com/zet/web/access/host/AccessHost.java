package com.zet.web.access.host;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import com.zet.business.base.entities.ActionType;
import com.zet.business.base.entities.BusinessRequest;
import com.zet.business.base.entities.BusinessResponse;
import com.zet.business.base.entities.FacadeType;
import com.zet.business.base.entities.User;
import com.zet.business.client.BusinessServiceStub;
import com.zet.web.access.model.AccessModel;
import com.zet.web.base.host.BaseHost;

/**
 * 
 * @author man le
 *
 */
@Component("accessHost")
public class AccessHost extends BaseHost{

	public BusinessResponse login(final AccessModel accessModel) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException,
    InvocationTargetException, NoSuchMethodException, RemoteException {

		BusinessServiceStub businessServiceStub = releaseServiceStub();
		User user = new User();
		user.setName(accessModel.getName());
		user.setEmail(accessModel.getEmail());
		user.setTimeAntiSpam(accessModel.getTimeSpam());
		
		BusinessRequest req = new BusinessRequest();
		req.setFacadeType(FacadeType.USER);
		req.setActionType(ActionType.SIGNIN);
		
		req.getUserList().add(user);
		
		return businessServiceStub.businessAction(req);
	}
}