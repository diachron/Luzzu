/* CVS $Id: $ */
package de.unibonn.iai.eis.luzzu.semantics.vocabularies; 
import com.hp.hpl.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from src/main/resources/vocabularies/qpro/qpro.ttl 
 * @author Auto-generated by schemagen on 01 Apr 2015 16:15 
 */
public class QPRO {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.org/eis/vocab/qpro#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>Represents the dataset URI on which quality metrics where computed</p> */
    public static final Property computedOn = m_model.createProperty( "http://purl.org/eis/vocab/qpro#computedOn" );
    
    /** <p>Describes a particular exception raised by the Resource or Triple in question, 
     *  causing a quality problem</p>
     */
    public static final Property exceptionDescription = m_model.createProperty( "http://purl.org/eis/vocab/qpro#exceptionDescription" );
    
    /** <p>Identifies problem instances in the report</p> */
    public static final Property hasProblem = m_model.createProperty( "http://purl.org/eis/vocab/qpro#hasProblem" );
    
    /** <p>This property enables the reification of quads by creating a new property 
     *  to define the context of a triple statement.</p>
     */
    public static final Property inGraph = m_model.createProperty( "http://purl.org/eis/vocab/qpro#inGraph" );
    
    /** <p>Represent the URI of the metric which instantiated this problem</p> */
    public static final Property isDescribedBy = m_model.createProperty( "http://purl.org/eis/vocab/qpro#isDescribedBy" );
    
    /** <p>Represent the actual problematic instance from the dataset. This could be 
     *  a list of resources (rdf:Seq), a list of reified statements, or a model representing 
     *  a list of statements.</p>
     */
    public static final Property problematicThing = m_model.createProperty( "http://purl.org/eis/vocab/qpro#problematicThing" );
    
    /** <p>Represents an Exception that causes the dataset to have Quality Problems. 
     *  This is an abstract class</p>
     */
    public static final Resource Exception = m_model.createResource( "http://purl.org/eis/vocab/qpro#Exception" );
    
    /** <p>Represents a quality problem detected during the assessment of quality metrics 
     *  on triples.</p>
     */
    public static final Resource QualityProblem = m_model.createResource( "http://purl.org/eis/vocab/qpro#QualityProblem" );
    
    /** <p>Represents a report on the problems detected during the assessment of quality 
     *  on a dataset.</p>
     */
    public static final Resource QualityReport = m_model.createResource( "http://purl.org/eis/vocab/qpro#QualityReport" );
    
}
