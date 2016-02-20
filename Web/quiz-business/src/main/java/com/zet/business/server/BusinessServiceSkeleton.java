/**
 * CategoryServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.zet.business.server;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.zet.business.base.entities.BusinessRequest;
import com.zet.business.base.entities.BusinessResponse;
import com.zet.business.base.entities.FacadeType;
import com.zet.business.base.entities.StatusType;
import com.zet.business.base.facade.UserFacade;

/**
 * CategoryServiceSkeleton java skeleton for the axisService
 */
public class BusinessServiceSkeleton extends SpringBeanAutowiringSupport implements BusinessServiceSkeletonInterface {

    private static final Log LOG = LogFactory.getLog(BusinessServiceSkeleton.class.getName());

    @Autowired
    @Resource(name = "userFacade")
    protected UserFacade userFacade;
  
    /**
     * Auto generated method signature
     * 
     * @param message
     * @return helloResponse
     */

    public java.lang.String hello(java.lang.String message) {

        return "I'm here " + new Date();
    }

    public BusinessResponse businessAction(BusinessRequest req) {
        BusinessResponse res = new BusinessResponse();
        res.setStatusType(StatusType.SUCCESS);

        FacadeType facadeType = req.getFacadeType();
        
        switch(facadeType){
        case USER:
            userFacade.adapt(req, res);
            break;
        }
        return res;
    }

}
