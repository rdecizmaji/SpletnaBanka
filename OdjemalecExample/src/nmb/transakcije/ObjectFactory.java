
package nmb.transakcije;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nmb.transakcije package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IzvrsiNalog_QNAME = new QName("http://transakcije.nmb/", "izvrsiNalog");
    private final static QName _IzvrsiNalogResponse_QNAME = new QName("http://transakcije.nmb/", "izvrsiNalogResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nmb.transakcije
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IzvrsiNalogResponse }
     * 
     */
    public IzvrsiNalogResponse createIzvrsiNalogResponse() {
        return new IzvrsiNalogResponse();
    }

    /**
     * Create an instance of {@link IzvrsiNalog }
     * 
     */
    public IzvrsiNalog createIzvrsiNalog() {
        return new IzvrsiNalog();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzvrsiNalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "izvrsiNalog")
    public JAXBElement<IzvrsiNalog> createIzvrsiNalog(IzvrsiNalog value) {
        return new JAXBElement<IzvrsiNalog>(_IzvrsiNalog_QNAME, IzvrsiNalog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzvrsiNalogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "izvrsiNalogResponse")
    public JAXBElement<IzvrsiNalogResponse> createIzvrsiNalogResponse(IzvrsiNalogResponse value) {
        return new JAXBElement<IzvrsiNalogResponse>(_IzvrsiNalogResponse_QNAME, IzvrsiNalogResponse.class, null, value);
    }

}
