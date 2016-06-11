
package nmb.transakcije;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for racun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="racun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datumIzdaje" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumPlacila" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idKn" type="{http://transakcije.nmb/}kodaNamena" minOccurs="0"/>
 *         &lt;element name="idTr" type="{http://transakcije.nmb/}transakcijskiRacun" minOccurs="0"/>
 *         &lt;element name="izbrisan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="namen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sifraRacuna" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRRprejmnika" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="znesek" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "racun", propOrder = {
    "datumIzdaje",
    "datumPlacila",
    "id",
    "idKn",
    "idTr",
    "izbrisan",
    "namen",
    "placan",
    "sifraRacuna",
    "trRprejmnika",
    "znesek"
})
public class Racun {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumIzdaje;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumPlacila;
    protected int id;
    protected KodaNamena idKn;
    protected TransakcijskiRacun idTr;
    protected boolean izbrisan;
    protected String namen;
    protected boolean placan;
    protected String sifraRacuna;
    @XmlElement(name = "TRRprejmnika")
    protected String trRprejmnika;
    protected BigDecimal znesek;

    /**
     * Gets the value of the datumIzdaje property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzdaje() {
        return datumIzdaje;
    }

    /**
     * Sets the value of the datumIzdaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzdaje(XMLGregorianCalendar value) {
        this.datumIzdaje = value;
    }

    /**
     * Gets the value of the datumPlacila property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPlacila() {
        return datumPlacila;
    }

    /**
     * Sets the value of the datumPlacila property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPlacila(XMLGregorianCalendar value) {
        this.datumPlacila = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the idKn property.
     * 
     * @return
     *     possible object is
     *     {@link KodaNamena }
     *     
     */
    public KodaNamena getIdKn() {
        return idKn;
    }

    /**
     * Sets the value of the idKn property.
     * 
     * @param value
     *     allowed object is
     *     {@link KodaNamena }
     *     
     */
    public void setIdKn(KodaNamena value) {
        this.idKn = value;
    }

    /**
     * Gets the value of the idTr property.
     * 
     * @return
     *     possible object is
     *     {@link TransakcijskiRacun }
     *     
     */
    public TransakcijskiRacun getIdTr() {
        return idTr;
    }

    /**
     * Sets the value of the idTr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransakcijskiRacun }
     *     
     */
    public void setIdTr(TransakcijskiRacun value) {
        this.idTr = value;
    }

    /**
     * Gets the value of the izbrisan property.
     * 
     */
    public boolean isIzbrisan() {
        return izbrisan;
    }

    /**
     * Sets the value of the izbrisan property.
     * 
     */
    public void setIzbrisan(boolean value) {
        this.izbrisan = value;
    }

    /**
     * Gets the value of the namen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamen() {
        return namen;
    }

    /**
     * Sets the value of the namen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamen(String value) {
        this.namen = value;
    }

    /**
     * Gets the value of the placan property.
     * 
     */
    public boolean isPlacan() {
        return placan;
    }

    /**
     * Sets the value of the placan property.
     * 
     */
    public void setPlacan(boolean value) {
        this.placan = value;
    }

    /**
     * Gets the value of the sifraRacuna property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraRacuna() {
        return sifraRacuna;
    }

    /**
     * Sets the value of the sifraRacuna property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraRacuna(String value) {
        this.sifraRacuna = value;
    }

    /**
     * Gets the value of the trRprejmnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRRprejmnika() {
        return trRprejmnika;
    }

    /**
     * Sets the value of the trRprejmnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRRprejmnika(String value) {
        this.trRprejmnika = value;
    }

    /**
     * Gets the value of the znesek property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZnesek() {
        return znesek;
    }

    /**
     * Sets the value of the znesek property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZnesek(BigDecimal value) {
        this.znesek = value;
    }

}
