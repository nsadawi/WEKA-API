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
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Clustering {
	public static void main(String args[]) throws Exception{
		//load dataset
		String dataset = "/home/likewise-open/ACADEMIC/csstnns/Desktop/weather.nominal.arff";
		DataSource source = new DataSource(dataset);
		//get instances object 
		Instances data = source.getDataSet();
		// new instance of clusterer
		SimpleKMeans model = new SimpleKMeans();//Simple EM (expectation maximisation)
		//number of clusters
		model.setNumClusters(4);
		//set distance function
		//model.setDistanceFunction(new weka.core.ManhattanDistance());
		// build the clusterer
		model.buildClusterer(data);
		System.out.println(model);
		
		//to cluster an instance .. returns cluster number as int
		//model.clusterInstance(instance);
		
		//returns an array containing the estimated membership probabilities of the test instance in each cluster (this should sum to at most 1)
		//model.distributionForInstance(instance);
		
		/*
		We can evaluate a clusterer with the ClusterEvaluation class
		For instance, separate train and test datasets can be used
		we can print out the number of clusters found
		 */
		ClusterEvaluation clsEval = new ClusterEvaluation();
		//load dataset
		String dataset1 = "/home/likewise-open/ACADEMIC/csstnns/Desktop/weather.test.arff";
		DataSource source1 = new DataSource(dataset1);
		//get instances object 
		Instances data1 = source1.getDataSet();

		clsEval.setClusterer(model);
		clsEval.evaluateClusterer(data1);//this should be a test dataset!
		
		System.out.println("# of clusters: " + clsEval.getNumClusters());

	}
}
