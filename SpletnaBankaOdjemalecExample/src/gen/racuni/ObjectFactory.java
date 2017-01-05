
package gen.racuni;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gen.racuni package. 
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

    private final static QName _IzdajERacunResponse_QNAME = new QName("http://transakcije.nmb/", "izdajERacunResponse");
    private final static QName _Exception_QNAME = new QName("http://transakcije.nmb/", "Exception");
    private final static QName _VrniVseIzdaneRacune_QNAME = new QName("http://transakcije.nmb/", "vrniVseIzdaneRacune");
    private final static QName _VrniVseprejetePlacaneRacune_QNAME = new QName("http://transakcije.nmb/", "vrniVseprejetePlacaneRacune");
    private final static QName _VrniVseprejeteNeplacaneRacune_QNAME = new QName("http://transakcije.nmb/", "vrniVseprejeteNeplacaneRacune");
    private final static QName _VrniVseprejeteNeplacaneRacuneResponse_QNAME = new QName("http://transakcije.nmb/", "vrniVseprejeteNeplacaneRacuneResponse");
    private final static QName _VrniVseprejetePlacaneRacuneResponse_QNAME = new QName("http://transakcije.nmb/", "vrniVseprejetePlacaneRacuneResponse");
    private final static QName _VrniVsePrejeteRacuneResponse_QNAME = new QName("http://transakcije.nmb/", "vrniVsePrejeteRacuneResponse");
    private final static QName _PlacajERacunResponse_QNAME = new QName("http://transakcije.nmb/", "placajERacunResponse");
    private final static QName _VrniVseIzdaneRacuneResponse_QNAME = new QName("http://transakcije.nmb/", "vrniVseIzdaneRacuneResponse");
    private final static QName _IzdajERacun_QNAME = new QName("http://transakcije.nmb/", "izdajERacun");
    private final static QName _PlacajERacun_QNAME = new QName("http://transakcije.nmb/", "placajERacun");
    private final static QName _VrniVsePrejeteRacune_QNAME = new QName("http://transakcije.nmb/", "vrniVsePrejeteRacune");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gen.racuni
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VrniVseprejeteNeplacaneRacune }
     * 
     */
    public VrniVseprejeteNeplacaneRacune createVrniVseprejeteNeplacaneRacune() {
        return new VrniVseprejeteNeplacaneRacune();
    }

    /**
     * Create an instance of {@link VrniVseprejeteNeplacaneRacuneResponse }
     * 
     */
    public VrniVseprejeteNeplacaneRacuneResponse createVrniVseprejeteNeplacaneRacuneResponse() {
        return new VrniVseprejeteNeplacaneRacuneResponse();
    }

    /**
     * Create an instance of {@link VrniVseprejetePlacaneRacune }
     * 
     */
    public VrniVseprejetePlacaneRacune createVrniVseprejetePlacaneRacune() {
        return new VrniVseprejetePlacaneRacune();
    }

    /**
     * Create an instance of {@link VrniVseIzdaneRacune }
     * 
     */
    public VrniVseIzdaneRacune createVrniVseIzdaneRacune() {
        return new VrniVseIzdaneRacune();
    }

    /**
     * Create an instance of {@link IzdajERacunResponse }
     * 
     */
    public IzdajERacunResponse createIzdajERacunResponse() {
        return new IzdajERacunResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link VrniVsePrejeteRacune }
     * 
     */
    public VrniVsePrejeteRacune createVrniVsePrejeteRacune() {
        return new VrniVsePrejeteRacune();
    }

    /**
     * Create an instance of {@link VrniVseIzdaneRacuneResponse }
     * 
     */
    public VrniVseIzdaneRacuneResponse createVrniVseIzdaneRacuneResponse() {
        return new VrniVseIzdaneRacuneResponse();
    }

    /**
     * Create an instance of {@link IzdajERacun }
     * 
     */
    public IzdajERacun createIzdajERacun() {
        return new IzdajERacun();
    }

    /**
     * Create an instance of {@link PlacajERacun }
     * 
     */
    public PlacajERacun createPlacajERacun() {
        return new PlacajERacun();
    }

    /**
     * Create an instance of {@link VrniVseprejetePlacaneRacuneResponse }
     * 
     */
    public VrniVseprejetePlacaneRacuneResponse createVrniVseprejetePlacaneRacuneResponse() {
        return new VrniVseprejetePlacaneRacuneResponse();
    }

    /**
     * Create an instance of {@link VrniVsePrejeteRacuneResponse }
     * 
     */
    public VrniVsePrejeteRacuneResponse createVrniVsePrejeteRacuneResponse() {
        return new VrniVsePrejeteRacuneResponse();
    }

    /**
     * Create an instance of {@link PlacajERacunResponse }
     * 
     */
    public PlacajERacunResponse createPlacajERacunResponse() {
        return new PlacajERacunResponse();
    }

    /**
     * Create an instance of {@link Postavka }
     * 
     */
    public Postavka createPostavka() {
        return new Postavka();
    }

    /**
     * Create an instance of {@link Racun }
     * 
     */
    public Racun createRacun() {
        return new Racun();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzdajERacunResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "izdajERacunResponse")
    public JAXBElement<IzdajERacunResponse> createIzdajERacunResponse(IzdajERacunResponse value) {
        return new JAXBElement<IzdajERacunResponse>(_IzdajERacunResponse_QNAME, IzdajERacunResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseIzdaneRacune }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseIzdaneRacune")
    public JAXBElement<VrniVseIzdaneRacune> createVrniVseIzdaneRacune(VrniVseIzdaneRacune value) {
        return new JAXBElement<VrniVseIzdaneRacune>(_VrniVseIzdaneRacune_QNAME, VrniVseIzdaneRacune.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseprejetePlacaneRacune }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseprejetePlacaneRacune")
    public JAXBElement<VrniVseprejetePlacaneRacune> createVrniVseprejetePlacaneRacune(VrniVseprejetePlacaneRacune value) {
        return new JAXBElement<VrniVseprejetePlacaneRacune>(_VrniVseprejetePlacaneRacune_QNAME, VrniVseprejetePlacaneRacune.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseprejeteNeplacaneRacune }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseprejeteNeplacaneRacune")
    public JAXBElement<VrniVseprejeteNeplacaneRacune> createVrniVseprejeteNeplacaneRacune(VrniVseprejeteNeplacaneRacune value) {
        return new JAXBElement<VrniVseprejeteNeplacaneRacune>(_VrniVseprejeteNeplacaneRacune_QNAME, VrniVseprejeteNeplacaneRacune.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseprejeteNeplacaneRacuneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseprejeteNeplacaneRacuneResponse")
    public JAXBElement<VrniVseprejeteNeplacaneRacuneResponse> createVrniVseprejeteNeplacaneRacuneResponse(VrniVseprejeteNeplacaneRacuneResponse value) {
        return new JAXBElement<VrniVseprejeteNeplacaneRacuneResponse>(_VrniVseprejeteNeplacaneRacuneResponse_QNAME, VrniVseprejeteNeplacaneRacuneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseprejetePlacaneRacuneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseprejetePlacaneRacuneResponse")
    public JAXBElement<VrniVseprejetePlacaneRacuneResponse> createVrniVseprejetePlacaneRacuneResponse(VrniVseprejetePlacaneRacuneResponse value) {
        return new JAXBElement<VrniVseprejetePlacaneRacuneResponse>(_VrniVseprejetePlacaneRacuneResponse_QNAME, VrniVseprejetePlacaneRacuneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVsePrejeteRacuneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVsePrejeteRacuneResponse")
    public JAXBElement<VrniVsePrejeteRacuneResponse> createVrniVsePrejeteRacuneResponse(VrniVsePrejeteRacuneResponse value) {
        return new JAXBElement<VrniVsePrejeteRacuneResponse>(_VrniVsePrejeteRacuneResponse_QNAME, VrniVsePrejeteRacuneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlacajERacunResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "placajERacunResponse")
    public JAXBElement<PlacajERacunResponse> createPlacajERacunResponse(PlacajERacunResponse value) {
        return new JAXBElement<PlacajERacunResponse>(_PlacajERacunResponse_QNAME, PlacajERacunResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseIzdaneRacuneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseIzdaneRacuneResponse")
    public JAXBElement<VrniVseIzdaneRacuneResponse> createVrniVseIzdaneRacuneResponse(VrniVseIzdaneRacuneResponse value) {
        return new JAXBElement<VrniVseIzdaneRacuneResponse>(_VrniVseIzdaneRacuneResponse_QNAME, VrniVseIzdaneRacuneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzdajERacun }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "izdajERacun")
    public JAXBElement<IzdajERacun> createIzdajERacun(IzdajERacun value) {
        return new JAXBElement<IzdajERacun>(_IzdajERacun_QNAME, IzdajERacun.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlacajERacun }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "placajERacun")
    public JAXBElement<PlacajERacun> createPlacajERacun(PlacajERacun value) {
        return new JAXBElement<PlacajERacun>(_PlacajERacun_QNAME, PlacajERacun.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVsePrejeteRacune }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVsePrejeteRacune")
    public JAXBElement<VrniVsePrejeteRacune> createVrniVsePrejeteRacune(VrniVsePrejeteRacune value) {
        return new JAXBElement<VrniVsePrejeteRacune>(_VrniVsePrejeteRacune_QNAME, VrniVsePrejeteRacune.class, null, value);
    }

}
