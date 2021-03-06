/* CVS $Id: $ */
package de.unibonn.iai.eis.luzzu.semantics.vocabularies; 
import com.hp.hpl.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from src/main/resources/vocabularies/lmi/lmi.ttl 
 * @author Auto-generated by schemagen on 01 Apr 2015 16:15 
 */
public class LMI {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.org/eis/vocab/lmi#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    public static final Property after = m_model.createProperty( "http://purl.org/eis/vocab/lmi#after" );
    
    public static final Property before = m_model.createProperty( "http://purl.org/eis/vocab/lmi#before" );
    
    public static final Property javaPackageName = m_model.createProperty( "http://purl.org/eis/vocab/lmi#javaPackageName" );
    
    public static final Property metric = m_model.createProperty( "http://purl.org/eis/vocab/lmi#metric" );
    
    public static final Property parameter = m_model.createProperty( "http://purl.org/eis/vocab/lmi#parameter" );
    
    public static final Property referTo = m_model.createProperty( "http://purl.org/eis/vocab/lmi#referTo" );
    
    public static final Property type = m_model.createProperty( "http://purl.org/eis/vocab/lmi#type" );
    
    public static final Resource LuzzuAfterArg = m_model.createResource( "http://purl.org/eis/vocab/lmi#LuzzuAfterArg" );
    
    public static final Resource LuzzuBeforeArg = m_model.createResource( "http://purl.org/eis/vocab/lmi#LuzzuBeforeArg" );
    
    /** <p>This is an abstract class that is extended by lmi:LuzzuBeforeArg and lmi:LuzzuAfterArg. 
     *  This should not be used directly.</p>
     */
    public static final Resource LuzzuMetricArg = m_model.createResource( "http://purl.org/eis/vocab/lmi#LuzzuMetricArg" );
    
    public static final Resource LuzzuMetricJavaImplementation = m_model.createResource( "http://purl.org/eis/vocab/lmi#LuzzuMetricJavaImplementation" );
    
    public static final Resource MetricConfiguration = m_model.createResource( "http://purl.org/eis/vocab/lmi#MetricConfiguration" );
    
}
