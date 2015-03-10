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
//imports
import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;

public class Sparse {
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/sparse.arff");
		Instances dataset = source.getDataSet();
		//create NonSparseToSparse object to save in sparse ARFF format    
	    NonSparseToSparse sp = new NonSparseToSparse();        
        
		//specify the dataset
		sp.setInputFormat(dataset);
		//apply
		Instances newData = Filter.useFilter(dataset, sp);
		//save
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb3.arff"));
		saver.writeBatch();
	}
}
