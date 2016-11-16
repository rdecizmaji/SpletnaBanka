
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

    private final static QName _TestirajPovezavo_QNAME = new QName("http://transakcije.nmb/", "testirajPovezavo");
    private final static QName _IzvrsiNalog_QNAME = new QName("http://transakcije.nmb/", "izvrsiNalog");
    private final static QName _VrniTransakcije_QNAME = new QName("http://transakcije.nmb/", "vrniTransakcije");
    private final static QName _VrniTransakcijeResponse_QNAME = new QName("http://transakcije.nmb/", "vrniTransakcijeResponse");
    private final static QName _IzvrsiNalogResponse_QNAME = new QName("http://transakcije.nmb/", "izvrsiNalogResponse");
    private final static QName _TestirajPovezavoResponse_QNAME = new QName("http://transakcije.nmb/", "testirajPovezavoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nmb.transakcije
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestirajPovezavoResponse }
     * 
     */
    public TestirajPovezavoResponse createTestirajPovezavoResponse() {
        return new TestirajPovezavoResponse();
    }

    /**
     * Create an instance of {@link IzvrsiNalogResponse }
     * 
     */
    public IzvrsiNalogResponse createIzvrsiNalogResponse() {
        return new IzvrsiNalogResponse();
    }

    /**
     * Create an instance of {@link VrniTransakcijeResponse }
     * 
     */
    public VrniTransakcijeResponse createVrniTransakcijeResponse() {
        return new VrniTransakcijeResponse();
    }

    /**
     * Create an instance of {@link TestirajPovezavo }
     * 
     */
    public TestirajPovezavo createTestirajPovezavo() {
        return new TestirajPovezavo();
    }

    /**
     * Create an instance of {@link IzvrsiNalog }
     * 
     */
    public IzvrsiNalog createIzvrsiNalog() {
        return new IzvrsiNalog();
    }

    /**
     * Create an instance of {@link VrniTransakcije }
     * 
     */
    public VrniTransakcije createVrniTransakcije() {
        return new VrniTransakcije();
    }

    /**
     * Create an instance of {@link ERacun }
     * 
     */
    public ERacun createERacun() {
        return new ERacun();
    }

    /**
     * Create an instance of {@link Transakcija }
     * 
     */
    public Transakcija createTransakcija() {
        return new Transakcija();
    }

    /**
     * Create an instance of {@link TipKartice }
     * 
     */
    public TipKartice createTipKartice() {
        return new TipKartice();
    }

    /**
     * Create an instance of {@link KodaNamena }
     * 
     */
    public KodaNamena createKodaNamena() {
        return new KodaNamena();
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
     * Create an instance of {@link Racun }
     * 
     */
    public Racun createRacun() {
        return new Racun();
    }

    /**
     * Create an instance of {@link BancnaKartica }
     * 
     */
    public BancnaKartica createBancnaKartica() {
        return new BancnaKartica();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestirajPovezavo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "testirajPovezavo")
    public JAXBElement<TestirajPovezavo> createTestirajPovezavo(TestirajPovezavo value) {
        return new JAXBElement<TestirajPovezavo>(_TestirajPovezavo_QNAME, TestirajPovezavo.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniTransakcije }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniTransakcije")
    public JAXBElement<VrniTransakcije> createVrniTransakcije(VrniTransakcije value) {
        return new JAXBElement<VrniTransakcije>(_VrniTransakcije_QNAME, VrniTransakcije.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniTransakcijeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "vrniTransakcijeResponse")
    public JAXBElement<VrniTransakcijeResponse> createVrniTransakcijeResponse(VrniTransakcijeResponse value) {
        return new JAXBElement<VrniTransakcijeResponse>(_VrniTransakcijeResponse_QNAME, VrniTransakcijeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzvrsiNalogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "izvrsiNalogResponse")
    public JAXBElement<IzvrsiNalogResponse> createIzvrsiNalogResponse(IzvrsiNalogResponse value) {
        return new JAXBElement<IzvrsiNalogResponse>(_IzvrsiNalogResponse_QNAME, IzvrsiNalogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestirajPovezavoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://transakcije.nmb/", name = "testirajPovezavoResponse")
    public JAXBElement<TestirajPovezavoResponse> createTestirajPovezavoResponse(TestirajPovezavoResponse value) {
        return new JAXBElement<TestirajPovezavoResponse>(_TestirajPovezavoResponse_QNAME, TestirajPovezavoResponse.class, null, value);
    }

}
