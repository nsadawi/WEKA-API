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
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.filters.unsupervised.attribute.Remove;

public class ClassifierWithFilter{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/iris.arff");
		Instances dataset = source.getDataSet();
		//set class index to the last attribute
		dataset.setClassIndex(dataset.numAttributes()-1);
				
		//the base classifier
		J48 tree = new J48();
		//the filter
		Remove remove = new Remove();
		//remove.setAttributeIndices("1");
		String[] opts = new String[]{ "-R", "1"};
		//set the filter options
		remove.setOptions(opts);

		//Create the FilteredClassifier object
		FilteredClassifier fc = new FilteredClassifier();
		//specify filter
		fc.setFilter(remove);
		//specify base classifier
		fc.setClassifier(tree);
		//Build the meta-classifier
		fc.buildClassifier(dataset);
		
		//System.out.println(tree.graph());
	}
	
}
