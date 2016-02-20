
/**
 * BusinessServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.zet.business.server;

        /**
        *  BusinessServiceMessageReceiverInOut message receiver
        */

        public class BusinessServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        BusinessServiceSkeletonInterface skel = (BusinessServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("businessAction".equals(methodName)){
                
                
                        envelope = jibxReceiver0(msgContext.getEnvelope().getBody().getFirstElement(), skel, getSOAPFactory(msgContext));
                    } else 

            if("hello".equals(methodName)){
                
                
                        envelope = jibxReceiver1(msgContext.getEnvelope().getBody().getFirstElement(), skel, getSOAPFactory(msgContext));
                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
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
    
            factory = org.jibx.runtime.BindingDirectory.getFactory("binding", "com.zet.business.base.entities", BusinessServiceMessageReceiverInOut.class.getClassLoader());
      
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
  
      public org.apache.axiom.soap.SOAPEnvelope jibxReceiver0(org.apache.axiom.om.OMElement element, BusinessServiceSkeletonInterface skel, org.apache.axiom.soap.SOAPFactory factory) throws org.apache.axis2.AxisFault
      
      {
          org.apache.axiom.soap.SOAPEnvelope envelope = null;
          try {
              org.jibx.runtime.impl.UnmarshallingContext uctx = getNewUnmarshalContext(element);
              uctx.next();
              int index;
    com.zet.business.base.entities.BusinessRequest businessRequest = null;
    
            if (uctx.isAt("", "businessRequest")) {
      businessRequest = (com.zet.business.base.entities.BusinessRequest)
        uctx.getUnmarshaller(_type_name0).unmarshal(new com.zet.business.base.entities.BusinessRequest(), uctx)
      ;
    
                uctx.parsePastCurrentEndTag("", "businessRequest");
    
            } else {
                throw new org.apache.axis2.AxisFault("Missing required element {}businessRequest");
            }
      
              envelope = factory.getDefaultEnvelope();
              org.apache.axiom.om.OMElement wrapper = factory.createOMElement("businessActionResponse", "http://scylla-business.com", "_");
        
              addMappingNamespaces(factory, wrapper, "http://scylla-business.com", "_");
        
              wrapper.declareNamespace(factory.createOMNamespace("http://scylla-business.com", "_"));
        
              envelope.getBody().addChild(wrapper);
              com.zet.business.base.entities.BusinessResponse result = skel.businessAction(
    businessRequest
    )
  ;
        
              if (result == null) {
            
                  throw new org.apache.axis2.AxisFault("Missing required result");
              
              } else {
                  if (bindingFactory == null) {
                      throw new RuntimeException(bindingErrorMessage);
                  }
            
                  org.apache.axiom.om.OMDataSource src = new org.apache.axis2.jibx.JiBXDataSource(result, _type_name1, "businessResponse", "", "", bindingNamespaceIndexes, bindingNamespacePrefixes, bindingFactory);
                  org.apache.axiom.om.OMNamespace appns = factory.createOMNamespace("", "");
                  org.apache.axiom.om.OMElement child = factory.createOMElement(src, "businessResponse", appns);
                  wrapper.addChild(child);
              
              }
          
          } catch (org.jibx.runtime.JiBXException e) {
              throw org.apache.axis2.AxisFault.makeFault(e);
          }
          return envelope;
      }
  
      public org.apache.axiom.soap.SOAPEnvelope jibxReceiver1(org.apache.axiom.om.OMElement element, BusinessServiceSkeletonInterface skel, org.apache.axiom.soap.SOAPFactory factory) throws org.apache.axis2.AxisFault
      
      {
          org.apache.axiom.soap.SOAPEnvelope envelope = null;
          try {
              org.jibx.runtime.impl.UnmarshallingContext uctx = getNewUnmarshalContext(element);
              uctx.next();
              int index;
    java.lang.String message = null;
    
            if (uctx.isAt("", "message")) {
      message = (java.lang.String)
        uctx.parseElementText("", "message")
      ;
    
            } else {
                throw new org.apache.axis2.AxisFault("Missing required element {}message");
            }
      
              envelope = factory.getDefaultEnvelope();
              org.apache.axiom.om.OMElement wrapper = factory.createOMElement("helloResponse", "http://scylla-business.com", "");
        
            wrapper.declareDefaultNamespace("http://scylla-business.com");
        
              wrapper.declareNamespace(factory.createOMNamespace("http://scylla-business.com", ""));
        
              envelope.getBody().addChild(wrapper);
              java.lang.String result = skel.hello(
    message
    )
  ;
        
              org.apache.axiom.om.OMElement child = factory.createOMElement("message",  "", "");
            
              if (result == null) {
                  org.apache.axiom.om.OMNamespace xsins = factory.createOMNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
                  child.declareNamespace(xsins);
                  child.addAttribute("nil", "true", xsins);
              } else {
                
              child.setText(result.toString());
      
              }
              
              wrapper.addChild(child);
          
          } catch (org.jibx.runtime.JiBXException e) {
              throw org.apache.axis2.AxisFault.makeFault(e);
          }
          return envelope;
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

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    