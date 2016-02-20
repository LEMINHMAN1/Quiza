
/**
 * BusinessServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.zet.business.client;

        

        /*
        *  BusinessServiceStub java implementation
        */

        
        public class BusinessServiceStub extends org.apache.axis2.client.Stub
        implements BusinessService{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("BusinessService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://scylla-business.com", "businessAction"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://scylla-business.com", "hello"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         


    }

    /**
      *Constructor that takes in a configContext
      */

    public BusinessServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public BusinessServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public BusinessServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:1234/services/businessService" );
                
    }

    /**
     * Default Constructor
     */
    public BusinessServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:1234/services/businessService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public BusinessServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://localhost:1234/services/businessService
    private static final org.jibx.runtime.IBindingFactory bindingFactory;
    private static final String bindingErrorMessage;
    private static final int[] bindingNamespaceIndexes;
    private static final String[] bindingNamespacePrefixes;
    
          private static final String _type_name0;
  
          private static final String _type_name1;
  
    static {
        org.jibx.runtime.IBindingFactory factory = null;
        String message = null;
        try {
    
            factory = org.jibx.runtime.BindingDirectory.getFactory("binding", "com.zet.business.base.entities", BusinessServiceStub.class.getClassLoader());
      
            message = null;
        } catch (Exception e) { message = e.getMessage(); }
        bindingFactory = factory;
        bindingErrorMessage = message;
    
         _type_name0 =
             "{http://scylla/xsd/business}:BusinessRequest";
  
         _type_name1 =
             "{http://scylla/xsd/business}:BusinessResponse";
  
        int[] indexes = null;
        String[] prefixes = null;
        if (factory != null) {
            
            // check for xsi namespace included
            String[] nsuris = factory.getNamespaces();
            int xsiindex = nsuris.length;
            while (--xsiindex >= 0 &&
                !"http://www.w3.org/2001/XMLSchema-instance".equals(nsuris[xsiindex]));
            
            // get actual size of index and prefix arrays to be allocated
            int nscount = 1;
            int usecount = nscount;
            if (xsiindex >= 0) {
                usecount++;
            }
            
            // allocate and initialize the arrays
            indexes = new int[usecount];
            prefixes = new String[usecount];
      
            indexes[0] = nsIndex("http://scylla/xsd/business", nsuris);
            prefixes[0] = "tns";
      
            if (xsiindex >= 0) {
                indexes[nscount] = xsiindex;
                prefixes[nscount] = "xsi";
            }
            
        }
        bindingNamespaceIndexes = indexes;
        bindingNamespacePrefixes = prefixes;
    }
    
    private static int nsIndex(String uri, String[] uris) {
        for (int i = 0; i < uris.length; i++) {
            if (uri.equals(uris[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("Namespace " + uri + " not found in binding directory information");
    }
    
    private static void addMappingNamespaces(org.apache.axiom.soap.SOAPFactory factory, org.apache.axiom.om.OMElement wrapper, String nsuri, String nspref) {
        String[] nss = bindingFactory.getNamespaces();
        for (int i = 0; i < bindingNamespaceIndexes.length; i++) {
            int index = bindingNamespaceIndexes[i];
            String uri = nss[index];
            String prefix = bindingNamespacePrefixes[i];
            if (!nsuri.equals(uri) || !nspref.equals(prefix)) {
                wrapper.declareNamespace(factory.createOMNamespace(uri, prefix));
            }
        }
    }
    
    private static org.jibx.runtime.impl.UnmarshallingContext getNewUnmarshalContext(org.apache.axiom.om.OMElement param)
        throws org.jibx.runtime.JiBXException {
        if (bindingFactory == null) {
            throw new RuntimeException(bindingErrorMessage);
        }
        org.jibx.runtime.impl.UnmarshallingContext ctx =
            (org.jibx.runtime.impl.UnmarshallingContext)bindingFactory.createUnmarshallingContext();
        org.jibx.runtime.IXMLReader reader = new org.jibx.runtime.impl.StAXReaderWrapper(param.getXMLStreamReaderWithoutCaching(), "SOAP-message", true);
        ctx.setDocument(reader);
        ctx.toTag();
        return ctx;
    }
    
    private org.apache.axiom.om.OMElement mappedChild(Object value, org.apache.axiom.om.OMFactory factory) {
        org.jibx.runtime.IMarshallable mrshable = (org.jibx.runtime.IMarshallable)value;
        org.apache.axiom.om.OMDataSource src = new org.apache.axis2.jibx.JiBXDataSource(mrshable, bindingFactory);
        int index = bindingFactory.getClassIndexMap().get(mrshable.JiBX_getName());
        org.apache.axiom.om.OMNamespace appns = factory.createOMNamespace(bindingFactory.getElementNamespaces()[index], "");
        return factory.createOMElement(src, bindingFactory.getElementNames()[index], appns);
    }
    
    
    private static Object fromOM(org.apache.axiom.om.OMElement param, Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{
        try {
            org.jibx.runtime.impl.UnmarshallingContext ctx = getNewUnmarshalContext(param);
            return ctx.unmarshalElement(type);
        } catch (Exception e) {
             throw new org.apache.axis2.AxisFault(e.getMessage());
        }
    }
  
    
        /**
    
         * Auto generated synchronous call method
         * 
         * @see com.zet.business.client.BusinessService#businessAction
         * @param businessRequest
         */
        public com.zet.business.base.entities.BusinessResponse businessAction(
    com.zet.business.base.entities.BusinessRequest businessRequest
            ) throws java.rmi.RemoteException
    
            {
    
            // create message context
            final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();
            try {
                int _opIndex = 0;
                javax.xml.namespace.QName opname = _operations[_opIndex].getName();
                org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(opname);
                _operationClient.getOptions().setAction("http://scylla-business.com/businessAction");
                _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
    
                // create SOAP envelope with the payload
                org.apache.axiom.soap.SOAPEnvelope env = createEnvelope(_operationClient.getOptions());
                org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                org.apache.axiom.om.OMElement wrapper = factory.createOMElement("businessActionRequest", "http://scylla-business.com", "_");
    
                addMappingNamespaces(factory, wrapper, "http://scylla-business.com", "_");
    
                wrapper.declareNamespace(factory.createOMNamespace("http://scylla-business.com", "_"));
    
                env.getBody().addChild(wrapper);
                org.apache.axiom.om.OMElement child;
    
        if (businessRequest == null) {
        
            throw new org.apache.axis2.AxisFault("Null value for businessRequest");
          
        } else {
        
        if (bindingFactory == null) {
            throw new RuntimeException(bindingErrorMessage);
        }
        org.apache.axiom.om.OMDataSource src = new org.apache.axis2.jibx.JiBXDataSource(businessRequest, _type_name0, "businessRequest", "", "", bindingNamespaceIndexes, bindingNamespacePrefixes, bindingFactory);
        org.apache.axiom.om.OMNamespace appns = factory.createOMNamespace("", "");
        child = factory.createOMElement(src, "businessRequest", appns);
      
        wrapper.addChild(child);
  
        }
      
    
                // add SOAP headers
                _serviceClient.addHeadersToEnvelope(env);
                
                // set that envelope on the message context
                _messageContext.setEnvelope(env);
    
                // add the message context to the operation client
                _operationClient.addMessageContext(_messageContext);
    
    
               // execute the operation client
                _operationClient.execute(true);
                
      
                org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.om.OMElement _response = _returnMessageContext.getEnvelope().getBody().getFirstElement();
                if (_response != null && "businessActionResponse".equals(_response.getLocalName()) &&
                    "http://scylla-business.com".equals(_response.getNamespace().getNamespaceURI())) {
                    org.jibx.runtime.impl.UnmarshallingContext uctx = getNewUnmarshalContext(_response);
                    uctx.parsePastStartTag("http://scylla-business.com", "businessActionResponse");
                    int index;
        com.zet.business.base.entities.BusinessResponse businessResponse = null;
    
            if (uctx.isAt("", "businessResponse")) {
      businessResponse = (com.zet.business.base.entities.BusinessResponse)
        uctx.getUnmarshaller(_type_name1).unmarshal(new com.zet.business.base.entities.BusinessResponse(), uctx)
      ;
    
                uctx.parsePastCurrentEndTag("", "businessResponse");
    
            } else {
                throw new org.apache.axis2.AxisFault("Missing required element {}businessResponse");
            }
      
                    return businessResponse;
                } else {
                    throw new org.apache.axis2.AxisFault("Missing expected return wrapper element {http://scylla-business.com}businessActionResponse");
                }
      
            } catch (Exception e) {
                Exception outex = convertException(e);
      
                // should never happen, but just in case
                throw new RuntimeException("Unexpected exception type: " +
                    outex.getClass().getName(), outex);
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    
    
        /**
    
         * Auto generated synchronous call method
         * 
         * @see com.zet.business.client.BusinessService#hello
         * @param message
         */
        public java.lang.String hello(
    java.lang.String message
            ) throws java.rmi.RemoteException
    
            {
    
            // create message context
            final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();
            try {
                int _opIndex = 1;
                javax.xml.namespace.QName opname = _operations[_opIndex].getName();
                org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(opname);
                _operationClient.getOptions().setAction("http://scylla-business.com/hello");
                _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
    
                // create SOAP envelope with the payload
                org.apache.axiom.soap.SOAPEnvelope env = createEnvelope(_operationClient.getOptions());
                org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                org.apache.axiom.om.OMElement wrapper = factory.createOMElement("helloRequest", "http://scylla-business.com", "");
    
                wrapper.declareDefaultNamespace("http://scylla-business.com");
    
                wrapper.declareNamespace(factory.createOMNamespace("http://scylla-business.com", ""));
    
                env.getBody().addChild(wrapper);
                org.apache.axiom.om.OMElement child;
    
        if (message == null) {
        
            throw new org.apache.axis2.AxisFault("Null value for message");
          
        } else {
        
        child = factory.createOMElement("message", "", "");
        child.setText(message);
      
        wrapper.addChild(child);
  
        }
      
    
                // add SOAP headers
                _serviceClient.addHeadersToEnvelope(env);
                
                // set that envelope on the message context
                _messageContext.setEnvelope(env);
    
                // add the message context to the operation client
                _operationClient.addMessageContext(_messageContext);
    
    
               // execute the operation client
                _operationClient.execute(true);
                
      
                org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.om.OMElement _response = _returnMessageContext.getEnvelope().getBody().getFirstElement();
                if (_response != null && "helloResponse".equals(_response.getLocalName()) &&
                    "http://scylla-business.com".equals(_response.getNamespace().getNamespaceURI())) {
                    org.jibx.runtime.impl.UnmarshallingContext uctx = getNewUnmarshalContext(_response);
                    uctx.parsePastStartTag("http://scylla-business.com", "helloResponse");
                    int index;
        java.lang.String message0 = null;
    
            if (uctx.isAt("", "message")) {
      message0 = (java.lang.String)
        uctx.parseElementText("", "message")
      ;
    
            } else {
                throw new org.apache.axis2.AxisFault("Missing required element {}message");
            }
      
                    return message0;
                } else {
                    throw new org.apache.axis2.AxisFault("Missing expected return wrapper element {http://scylla-business.com}helloResponse");
                }
      
            } catch (Exception e) {
                Exception outex = convertException(e);
      
                // should never happen, but just in case
                throw new RuntimeException("Unexpected exception type: " +
                    outex.getClass().getName(), outex);
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    
    
        /**
    
         * Auto generated asynchronous call method
         * 
         * @see com.zet.business.client.BusinessService#startbusinessAction
         * @param businessRequest
         */
        public void startbusinessAction(
    com.zet.business.base.entities.BusinessRequest businessRequest, final BusinessServiceCallbackHandler _callback
    
            ) throws java.rmi.RemoteException
    
            {
    
            // create message context
            final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();
            try {
                int _opIndex = 0;
                javax.xml.namespace.QName opname = _operations[_opIndex].getName();
                org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(opname);
                _operationClient.getOptions().setAction("http://scylla-business.com/businessAction");
                _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
    
                // create SOAP envelope with the payload
                org.apache.axiom.soap.SOAPEnvelope env = createEnvelope(_operationClient.getOptions());
                org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                org.apache.axiom.om.OMElement wrapper = factory.createOMElement("businessActionRequest", "http://scylla-business.com", "_");
    
                addMappingNamespaces(factory, wrapper, "http://scylla-business.com", "_");
    
                wrapper.declareNamespace(factory.createOMNamespace("http://scylla-business.com", "_"));
    
                env.getBody().addChild(wrapper);
                org.apache.axiom.om.OMElement child;
    
        if (businessRequest == null) {
        
            throw new org.apache.axis2.AxisFault("Null value for businessRequest");
          
        } else {
        
        if (bindingFactory == null) {
            throw new RuntimeException(bindingErrorMessage);
        }
        org.apache.axiom.om.OMDataSource src = new org.apache.axis2.jibx.JiBXDataSource(businessRequest, _type_name0, "businessRequest", "", "", bindingNamespaceIndexes, bindingNamespacePrefixes, bindingFactory);
        org.apache.axiom.om.OMNamespace appns = factory.createOMNamespace("", "");
        child = factory.createOMElement(src, "businessRequest", appns);
      
        wrapper.addChild(child);
  
        }
      
    
                // add SOAP headers
                _serviceClient.addHeadersToEnvelope(env);
                
                // set that envelope on the message context
                _messageContext.setEnvelope(env);
    
                // add the message context to the operation client
                _operationClient.addMessageContext(_messageContext);
    
    
                _operationClient.setCallback(new org.apache.axis2.client.async.Callback() {
                    public void onComplete(org.apache.axis2.client.async.AsyncResult async) {
                        try {
                            org.apache.axiom.om.OMElement result = async.getResponseEnvelope().getBody().getFirstElement();
                            if (result != null && "businessActionResponse".equals(result.getLocalName()) &&
                                "http://scylla-business.com".equals(result.getNamespace().getNamespaceURI())) {
                                org.jibx.runtime.impl.UnmarshallingContext uctx = getNewUnmarshalContext(result);
                                uctx.parsePastStartTag("http://scylla-business.com", "businessActionResponse");
                                int index;
      com.zet.business.base.entities.BusinessResponse businessResponse = null;
    
            if (uctx.isAt("", "businessResponse")) {
      businessResponse = (com.zet.business.base.entities.BusinessResponse)
        uctx.getUnmarshaller(_type_name1).unmarshal(new com.zet.business.base.entities.BusinessResponse(), uctx)
      ;
    
                uctx.parsePastCurrentEndTag("", "businessResponse");
    
            } else {
                throw new org.apache.axis2.AxisFault("Missing required element {}businessResponse");
            }
      
                                _callback.receiveResultbusinessAction(businessResponse);
                            } else {
                                throw new org.apache.axis2.AxisFault("Missing expected result wrapper element {http://scylla-business.com}businessActionResponse");
                            }
                        } catch (Exception e) {
                            onError(e);
                        } finally {
                            try {
                                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                            } catch (org.apache.axis2.AxisFault axisFault) {
                                onError(axisFault);
                            }   
                        }
                    }

                    public void onError(Exception e) {
                        _callback.receiveErrorbusinessAction(e);
                    }
                });
                        
                org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
                if ( _operations[_opIndex].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
                    _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
                    _operations[_opIndex].setMessageReceiver(_callbackReceiver);
                }

                // execute the operation client
                _operationClient.execute(false);
                
            } catch (Exception e) {
                Exception outex = convertException(e);
                throw new RuntimeException("Unexpected exception type: " +
                    outex.getClass().getName(), outex);
            }
        }
    
    
        /**
    
         * Auto generated asynchronous call method
         * 
         * @see com.zet.business.client.BusinessService#starthello
         * @param message
         */
        public void starthello(
    java.lang.String message, final BusinessServiceCallbackHandler _callback
    
            ) throws java.rmi.RemoteException
    
            {
    
            // create message context
            final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();
            try {
                int _opIndex = 1;
                javax.xml.namespace.QName opname = _operations[_opIndex].getName();
                org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(opname);
                _operationClient.getOptions().setAction("http://scylla-business.com/hello");
                _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
    
                // create SOAP envelope with the payload
                org.apache.axiom.soap.SOAPEnvelope env = createEnvelope(_operationClient.getOptions());
                org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                org.apache.axiom.om.OMElement wrapper = factory.createOMElement("helloRequest", "http://scylla-business.com", "");
    
                wrapper.declareDefaultNamespace("http://scylla-business.com");
    
                wrapper.declareNamespace(factory.createOMNamespace("http://scylla-business.com", ""));
    
                env.getBody().addChild(wrapper);
                org.apache.axiom.om.OMElement child;
    
        if (message == null) {
        
            throw new org.apache.axis2.AxisFault("Null value for message");
          
        } else {
        
        child = factory.createOMElement("message", "", "");
        child.setText(message);
      
        wrapper.addChild(child);
  
        }
      
    
                // add SOAP headers
                _serviceClient.addHeadersToEnvelope(env);
                
                // set that envelope on the message context
                _messageContext.setEnvelope(env);
    
                // add the message context to the operation client
                _operationClient.addMessageContext(_messageContext);
    
    
                _operationClient.setCallback(new org.apache.axis2.client.async.Callback() {
                    public void onComplete(org.apache.axis2.client.async.AsyncResult async) {
                        try {
                            org.apache.axiom.om.OMElement result = async.getResponseEnvelope().getBody().getFirstElement();
                            if (result != null && "helloResponse".equals(result.getLocalName()) &&
                                "http://scylla-business.com".equals(result.getNamespace().getNamespaceURI())) {
                                org.jibx.runtime.impl.UnmarshallingContext uctx = getNewUnmarshalContext(result);
                                uctx.parsePastStartTag("http://scylla-business.com", "helloResponse");
                                int index;
      java.lang.String message0 = null;
    
            if (uctx.isAt("", "message")) {
      message0 = (java.lang.String)
        uctx.parseElementText("", "message")
      ;
    
            } else {
                throw new org.apache.axis2.AxisFault("Missing required element {}message");
            }
      
                                _callback.receiveResulthello(message0);
                            } else {
                                throw new org.apache.axis2.AxisFault("Missing expected result wrapper element {http://scylla-business.com}helloResponse");
                            }
                        } catch (Exception e) {
                            onError(e);
                        } finally {
                            try {
                                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                            } catch (org.apache.axis2.AxisFault axisFault) {
                                onError(axisFault);
                            }   
                        }
                    }

                    public void onError(Exception e) {
                        _callback.receiveErrorhello(e);
                    }
                });
                        
                org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
                if ( _operations[_opIndex].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
                    _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
                    _operations[_opIndex].setMessageReceiver(_callbackReceiver);
                }

                // execute the operation client
                _operationClient.execute(false);
                
            } catch (Exception e) {
                Exception outex = convertException(e);
                throw new RuntimeException("Unexpected exception type: " +
                    outex.getClass().getName(), outex);
            }
        }
    
    
    private Exception convertException(Exception ex) throws java.rmi.RemoteException {
        if (ex instanceof org.apache.axis2.AxisFault) {
            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault)ex;
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    try {
                        
                        // first create the actual exception
                        String exceptionClassName = (String)faultExceptionClassNameMap.get(faultElt.getQName());
                        Class exceptionClass = Class.forName(exceptionClassName);
                        Exception e = (Exception)exceptionClass.newInstance();
                        
                        // build the message object from the details
                        String messageClassName = (String)faultMessageMap.get(faultElt.getQName());
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                            new Class[] { messageClass });
                        m.invoke(e, new Object[] { messageObject });
                        return e;
                        
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
            
        } else if (ex instanceof RuntimeException) {
            throw (RuntimeException)ex;
        } else if (ex instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)ex;
        } else {
            throw org.apache.axis2.AxisFault.makeFault(ex);
        }
    }
    
  
   }
   
