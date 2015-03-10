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
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;
import java.io.File;

public class Arff2CSV {
  
  public static void main(String[] args) throws Exception {
    
    // load ARFF
    ArffLoader loader = new ArffLoader();
    loader.setSource(new File("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb.arff"));
    Instances data = loader.getDataSet();//get instances object

    // save CSV
    CSVSaver saver = new CSVSaver();
    saver.setInstances(data);//set the dataset we want to convert
    //and save as CSV
    saver.setFile(new File("/home/likewise-open/ACADEMIC/csstnns/Desktop/nqdb.csv"));
    saver.writeBatch();
  }
} 

