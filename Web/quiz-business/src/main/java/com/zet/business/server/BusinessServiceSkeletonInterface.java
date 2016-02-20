
/**
 * BusinessServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.zet.business.server;
    /**
     *  BusinessServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface BusinessServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                        * @param businessRequest
         */

        
                public com.zet.business.base.entities.BusinessResponse businessAction
                (
                  com.zet.business.base.entities.BusinessRequest businessRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param message
         */

        
                public java.lang.String hello
                (
                  java.lang.String message
                 )
            ;
        
         }
    