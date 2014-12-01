package de.unibonn.iai.eis.luzzu.evaluation.settings;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class EvaluationCase implements Serializable {

	/**
	 * Random Serial Version
	 */
	private static final long serialVersionUID = -3157138489172108209L;
	
	transient private Model metricConfiguration;
	private String datasetURI;
	private long totalTriples;
	private List<Long> tIterations = new ArrayList<Long>();
	private long tAvg;
	private long tMin = Long.MAX_VALUE;
	private long tMax = Long.MIN_VALUE;
	private String caseName;
	private String caseDescription;
	private int metricsInitalised;
	private String metricDump = "";
	
	
	public EvaluationCase(String caseName, String datasetURI, int metricsInitalised){
		this.caseName = caseName;
		this.datasetURI = datasetURI;
		this.metricsInitalised = metricsInitalised;
		this.metricConfiguration = ModelConfiguration.getModelConfiguration(metricsInitalised);
	}
	
	public EvaluationCase(String evaluationCasePath, boolean copy) throws IOException, ClassNotFoundException{
		EvaluationCase e = null;

		FileInputStream fileIn = new FileInputStream(evaluationCasePath);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		e = (EvaluationCase) in.readObject();
		in.close();
		fileIn.close();
		
		this.caseName = e.getCaseName();
		this.datasetURI = e.getDatasetURI();	  
		this.metricsInitalised = e.getMetricsInitalised();
		StringReader sr = new StringReader(e.getMetricDump());
		this.metricConfiguration = ModelFactory.createDefaultModel().read(sr, "RDF/XML");
		this.totalTriples = e.getTotalTriples();
		
		if (!copy){
			this.tIterations = e.gettIterations();
			this.tAvg = e.gettAvg();
			this.tMax = e.gettMax();
			this.tMin = e.gettMax();
			this.caseDescription = e.getCaseDescription();
		}
		
		e = null;
		Runtime.getRuntime().gc();
	}
	
	public EvaluationCase(String evaluationCasePath, int metricsInitialised) throws ClassNotFoundException, IOException{
		this(evaluationCasePath,true);
		this.metricsInitalised = metricsInitialised;
		this.metricConfiguration = ModelConfiguration.getModelConfiguration(metricsInitialised);
	}
	
	public int getMetricsInitalised(){
		return this.metricsInitalised;
	}
	
	public Model getMetricConfiguration() {
		return metricConfiguration;
	}

	public String getDatasetURI() {
		return datasetURI;
	}

	public long getTotalTriples() {
		return totalTriples;
	}

	public void setTotalTriples(long totalTriples) {
		this.totalTriples = totalTriples;
	}

	public List<Long> gettIterations() {
		return tIterations;
	}

	public void setDifference(long difference) {
		tAvg += difference;
		tMax = (tMax < difference) ? difference : tMax;
		tMin = (tMin > difference) ? difference : tMin;
		tIterations.add(difference);
	}

	public long gettAvg() {
		return (tAvg / tIterations.size());
	}

	public long gettMin() {
		return tMin;
	}

	public long gettMax() {
		return tMax;
	}


	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	
	public String getCaseName() {
		return caseName;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getTotalTriples() + ",");
		sb.append(this.getMetricsInitalised() + ",");
		sb.append((this.gettAvg()/ 1000.0) + ",");
		sb.append((this.gettMin()/ 1000.0) + ",");
		sb.append((this.gettMax()/ 1000.0));
		return sb.toString();
	}
	
	public void storeEvaluationCase() throws IOException{	
		OutputStream baos = new ByteArrayOutputStream();
		this.metricConfiguration.write(baos);

		this.metricDump = baos.toString();
		
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date= new Date();
		String timeStamp = dateFormat.format(date);
		 
		File f = new File("evaluation_cases/ec_"+this.metricsInitalised+"_"+this.totalTriples+"_"+timeStamp+".dat");
		f.createNewFile();
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(this);
		oos.close();
	}

	public String getMetricDump() {
		return metricDump;
	}
}