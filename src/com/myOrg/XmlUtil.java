package com.myOrg;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlUtil {
	
	public static void startXml(StringBuffer xmlStr){
		xmlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>") ;
		xmlStr.append("<game>");
	}
	
	public static void finishXml(StringBuffer xmlStr){
		xmlStr.append("</game>");
	}
	
	
	   public static void adToXML(Object[] args, String rootName, String elemName, StringBuffer xmlStr)
	    {
	        xmlStr.append( "<" + rootName + ">");
	
	        for (Object arg : args)
	        {
	        	if(arg==null)arg="";
	        	xmlStr.append("<" + elemName + ">" + arg.toString() +
	                      "</" + elemName + ">");
	        }

	        xmlStr.append("</" + rootName + ">");

	    }
	   

	   public static String fromXmlToJson(String xsmToConvert){

		   Source xmlInput = new StreamSource(new StringReader(xsmToConvert));

		   ClassLoader loader = XmlUtil.class.getClassLoader();
		   	if(loader==null)
		   		loader = ClassLoader.getSystemClassLoader();
	    	
	       URL urlXslt = loader.getResource("conf/xmlToJson.xslt");
	       
	       Source xsl = new StreamSource(new File(urlXslt.getPath()));
		   Result xmlOutput = new StreamResult(new StringWriter());
		   

		   try {
		       Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
		       transformer.transform(xmlInput, xmlOutput);
		   } catch (TransformerException e) {
		       e.printStackTrace();
		   } 

		   return ((StreamResult)xmlOutput).getWriter().toString();
		   
	   }
}
