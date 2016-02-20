

/**
 * BusinessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.zet.business.client;

    /*
     *  BusinessService java interface
     */

    public interface BusinessService {
          

        /**
          * Auto generated method signature
          * 
                    * @param businessActionRequest
                
         */

         
                     public com.zet.business.base.entities.BusinessResponse businessAction(

                        com.zet.business.base.entities.BusinessRequest businessRequest)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param businessActionRequest
            
          */
        public void startbusinessAction(

            com.zet.business.base.entities.BusinessRequest businessRequest,

            final com.zet.business.client.BusinessServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param helloRequest
                
         */

         
                     public java.lang.String hello(

                        java.lang.String message)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param helloRequest
            
          */
        public void starthello(

            java.lang.String message,

            final com.zet.business.client.BusinessServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    
