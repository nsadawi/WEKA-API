/*
 *  How to use WEKA API in Java 
 *  Copyright (C) 2014 
 *  @author Dr Noureddin M. Sadawi (noureddin.sadawi@gmail.com)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ... 
 *  I ask you only, as a professional courtesy, to cite my name, web page 
 *  and my YouTube Channel!
 *  
 */

package weka.api;
//import required classes
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;
//import weka.classifiers.functions.SMOreg;
public class Regression{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb1.arff");
		Instances dataset = source.getDataSet();
		//set class index to the last attribute
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		//build model
		LinearRegression lr = new LinearRegression();
		lr.buildClassifier(dataset);
		//output model
		System.out.println(lr);		
		/*
		//build model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(dataset);
		//output model
		System.out.println(smo);
		*/		
	}
}

