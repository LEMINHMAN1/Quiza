package com.zet.framework.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

/**
 * 
 * @author manle
 *
 */
public class BindingUtil {

	public static String appliedXsltTemplate(Object obj, File xsltFile) throws JAXBException, TransformerException{
		
		// marshaller with jaxb
		JAXBContext jc = JAXBContext.newInstance(obj.getClass());
	    Marshaller marshaller = jc.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    marshaller.setProperty("jaxb.encoding", "UTF-8");
	    
	    // and output to Document
	    Document xmlDoc = new DocumentImpl();
	    @SuppressWarnings("unchecked")
		JAXBElement<Object> jaxbElement = new JAXBElement<Object>(new QName(obj.getClass().getSimpleName()), (Class<Object>) obj.getClass(), obj);
	    marshaller.marshal(jaxbElement, xmlDoc);
	    
	    // open xslt file to source
	    Source xsltSource = new StreamSource(xsltFile);
	    
	    // transform from Source to Transformer of xsltSource
	    TransformerFactory transFact = TransformerFactory.newInstance();
	    Transformer trans = transFact.newTransformer(xsltSource);
	    trans.setOutputProperty("encoding", "UTF-8");
		
	    StringWriter writer = new StringWriter();
	    PrintWriter out = new PrintWriter(writer);
	    Result result = new StreamResult(out);
	    
	    // transform from Transformer to XML Source and output to Result
	    Source xmlSource = new DOMSource(xmlDoc);
	    trans.transform(xmlSource, result);
	   
	    return writer.toString();
	}
	
	public static String appliedHtmlTemplate(File htmlFile, String... paramMessageSource) throws FileNotFoundException{
		String text = new Scanner(htmlFile, "UTF-8" ).useDelimiter("\\A").next();
		return String.format(text, paramMessageSource);
	}
	
}
