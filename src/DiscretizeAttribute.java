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
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public class DiscretizeAttribute{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb1.arff");
		Instances dataset = source.getDataSet();		
		//set options
		String[] options = new String[5];
		//choose the number of intervals, e.g. 2 :
		options[0] = "-B"; options[1] = "4";
		//choose the range of attributes on which to apply the filter:
		options[2] = "-R";
		options[3] = "1-3";
		options[4] = "-V";
		//Apply discretization:
		Discretize discretize = new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, discretize);

		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb2.arff"));
		saver.writeBatch();
	}
}
