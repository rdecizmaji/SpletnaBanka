
package gen.komitenti;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gen.komitenti package. 
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

    private final static QName _DodajKomitentaResponse_QNAME = new QName("http://transakcije.nmb/", "dodajKomitentaResponse");
    private final static QName _NajdiKomitentaPoIdResponse_QNAME = new QName("http://transakcije.nmb/", "najdiKomitentaPoIdResponse");
    private final static QName _VrniVseKomitenteResponse_QNAME = new QName("http://transakcije.nmb/", "vrniVseKomitenteResponse");
    private final static QName _Exception_QNAME = new QName("http://transakcije.nmb/", "Exception");
    private final static QName _VrniVseKomitente_QNAME = new QName("http://transakcije.nmb/", "vrniVseKomitente");
    private final static QName _NajdiKomitentaPoTrr_QNAME = new QName("http://transakcije.nmb/", "najdiKomitentaPoTrr");
    private final static QName _VrniTRRjeKomitenta_QNAME = new QName("http://transakcije.nmb/", "vrniTRRjeKomitenta");
    private final static QName _VrniTRRResponse_QNAME = new QName("http://transakcije.nmb/", "vrniTRRResponse");
    private final static QName _NajdiKomitentaPoTrrResponse_QNAME = new QName("http://transakcije.nmb/", "najdiKomitentaPoTrrResponse");
    private final static QName _VrniTRRjeKomitentaResponse_QNAME = new QName("http://transakcije.nmb/", "vrniTRRjeKomitentaResponse");
    private final static QName _VrniTRR_QNAME = new QName("http://transakcije.nmb/", "vrniTRR");
    private final static QName _DodajKomitenta_QNAME = new QName("http://transakcije.nmb/", "dodajKomitenta");
    private final static QName _NajdiKomitentaPoId_QNAME = new QName("http://transakcije.nmb/", "najdiKomitentaPoId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gen.komitenti
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VrniTRRResponse }
     * 
     */
    public VrniTRRResponse createVrniTRRResponse() {
        return new VrniTRRResponse();
    }

    /**
     * Create an instance of {@link NajdiKomitentaPoTrr }
     * 
     */
    public NajdiKomitentaPoTrr createNajdiKomitentaPoTrr() {
        return new NajdiKomitentaPoTrr();
    }

    /**
     * Create an instance of {@link VrniTRRjeKomitenta }
     * 
     */
    public VrniTRRjeKomitenta createVrniTRRjeKomitenta() {
        return new VrniTRRjeKomitenta();
    }

    /**
     * Create an instance of {@link VrniVseKomitente }
     * 
     */
    public VrniVseKomitente createVrniVseKomitente() {
        return new VrniVseKomitente();
    }

    /**
     * Create an instance of {@link DodajKomitentaResponse }
     * 
     */
    public DodajKomitentaResponse createDodajKomitentaResponse() {
        return new DodajKomitentaResponse();
    }

    /**
     * Create an instance of {@link NajdiKomitentaPoIdResponse }
     * 
     */
    public NajdiKomitentaPoIdResponse createNajdiKomitentaPoIdResponse() {
        return new NajdiKomitentaPoIdResponse();
    }

    /**
     * Create an instance of {@link VrniVseKomitenteResponse }
     * 
     */
    public VrniVseKomitenteResponse createVrniVseKomitenteResponse() {
        return new VrniVseKomitenteResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link DodajKomitenta }
     * 
     */
    public DodajKomitenta createDodajKomitenta() {
        return new DodajKomitenta();
    }

    /**
     * Create an instance of {@link NajdiKomitentaPoId }
     * 
     */
    public NajdiKomitentaPoId createNajdiKomitentaPoId() {
        return new NajdiKomitentaPoId();
    }

    /**
     * Create an instance of {@link NajdiKomitentaPoTrrResponse }
     * 
     */
    public NajdiKomitentaPoTrrResponse createNajdiKomitentaPoTrrResponse() {
        return new NajdiKomitentaPoTrrResponse();
    }

    /**
     * Create an instance of {@link VrniTRRjeKomitentaResponse }
     * 
     */
    public VrniTRRjeKomitentaResponse createVrniTRRjeKomitentaResponse() {
        return new VrniTRRjeKomitentaResponse();
    }

    /**
     * Create an instance of {@link VrniTRR }
     * 
     */
    public VrniTRR createVrniTRR() {
        return new VrniTRR();
    }

    /**
     * Create an instance of {@link Transakcija }
     * 
     */
    public Transakcija createTransakcija() {
        return new Transakcija();
    }

    /**
     * Create an instance of {@link TransakcijskiRacun }
     * 
     */
    public TransakcijskiRacun createTransakcijskiRacun() {
        return new TransakcijskiRacun();
    }

    /**
     * Create an instance of {@link Komitent }
     * 
     */
    public Komitent createKomitent() {
        return new Komitent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajKomitentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "dodajKomitentaResponse")
    public JAXBElement<DodajKomitentaResponse> createDodajKomitentaResponse(DodajKomitentaResponse value) {
        return new JAXBElement<DodajKomitentaResponse>(_DodajKomitentaResponse_QNAME, DodajKomitentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NajdiKomitentaPoIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "najdiKomitentaPoIdResponse")
    public JAXBElement<NajdiKomitentaPoIdResponse> createNajdiKomitentaPoIdResponse(NajdiKomitentaPoIdResponse value) {
        return new JAXBElement<NajdiKomitentaPoIdResponse>(_NajdiKomitentaPoIdResponse_QNAME, NajdiKomitentaPoIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseKomitenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseKomitenteResponse")
    public JAXBElement<VrniVseKomitenteResponse> createVrniVseKomitenteResponse(VrniVseKomitenteResponse value) {
        return new JAXBElement<VrniVseKomitenteResponse>(_VrniVseKomitenteResponse_QNAME, VrniVseKomitenteResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseKomitente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniVseKomitente")
    public JAXBElement<VrniVseKomitente> createVrniVseKomitente(VrniVseKomitente value) {
        return new JAXBElement<VrniVseKomitente>(_VrniVseKomitente_QNAME, VrniVseKomitente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NajdiKomitentaPoTrr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "najdiKomitentaPoTrr")
    public JAXBElement<NajdiKomitentaPoTrr> createNajdiKomitentaPoTrr(NajdiKomitentaPoTrr value) {
        return new JAXBElement<NajdiKomitentaPoTrr>(_NajdiKomitentaPoTrr_QNAME, NajdiKomitentaPoTrr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniTRRjeKomitenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniTRRjeKomitenta")
    public JAXBElement<VrniTRRjeKomitenta> createVrniTRRjeKomitenta(VrniTRRjeKomitenta value) {
        return new JAXBElement<VrniTRRjeKomitenta>(_VrniTRRjeKomitenta_QNAME, VrniTRRjeKomitenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniTRRResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniTRRResponse")
    public JAXBElement<VrniTRRResponse> createVrniTRRResponse(VrniTRRResponse value) {
        return new JAXBElement<VrniTRRResponse>(_VrniTRRResponse_QNAME, VrniTRRResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NajdiKomitentaPoTrrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "najdiKomitentaPoTrrResponse")
    public JAXBElement<NajdiKomitentaPoTrrResponse> createNajdiKomitentaPoTrrResponse(NajdiKomitentaPoTrrResponse value) {
        return new JAXBElement<NajdiKomitentaPoTrrResponse>(_NajdiKomitentaPoTrrResponse_QNAME, NajdiKomitentaPoTrrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniTRRjeKomitentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniTRRjeKomitentaResponse")
    public JAXBElement<VrniTRRjeKomitentaResponse> createVrniTRRjeKomitentaResponse(VrniTRRjeKomitentaResponse value) {
        return new JAXBElement<VrniTRRjeKomitentaResponse>(_VrniTRRjeKomitentaResponse_QNAME, VrniTRRjeKomitentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniTRR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniTRR")
    public JAXBElement<VrniTRR> createVrniTRR(VrniTRR value) {
        return new JAXBElement<VrniTRR>(_VrniTRR_QNAME, VrniTRR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajKomitenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "dodajKomitenta")
    public JAXBElement<DodajKomitenta> createDodajKomitenta(DodajKomitenta value) {
        return new JAXBElement<DodajKomitenta>(_DodajKomitenta_QNAME, DodajKomitenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NajdiKomitentaPoId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "najdiKomitentaPoId")
    public JAXBElement<NajdiKomitentaPoId> createNajdiKomitentaPoId(NajdiKomitentaPoId value) {
        return new JAXBElement<NajdiKomitentaPoId>(_NajdiKomitentaPoId_QNAME, NajdiKomitentaPoId.class, null, value);
    }

}
