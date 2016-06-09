
package nmb.transakcije;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for eRacun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eRacun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datumDo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumIzdaje" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumOd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumZapadlosti" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idKn" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idTr" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="izbrisan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="krajIzdaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nacinPlacila" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="referenca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stevilkaRacuna" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TRRprejmnika" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eRacun", propOrder = {
    "datumDo",
    "datumIzdaje",
    "datumOd",
    "datumZapadlosti",
    "id",
    "idKn",
    "idTr",
    "izbrisan",
    "krajIzdaje",
    "nacinPlacila",
    "placan",
    "referenca",
    "stevilkaRacuna",
    "trRprejmnika"
})
public class ERacun {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumDo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumIzdaje;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumOd;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumZapadlosti;
    protected int id;
    protected long idKn;
    protected long idTr;
    protected boolean izbrisan;
    protected String krajIzdaje;
    protected String nacinPlacila;
    protected boolean placan;
    protected String referenca;
    protected long stevilkaRacuna;
    @XmlElement(name = "TRRprejmnika")
    protected String trRprejmnika;

    /**
     * Gets the value of the datumDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDo() {
        return datumDo;
    }

    /**
     * Sets the value of the datumDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDo(XMLGregorianCalendar value) {
        this.datumDo = value;
    }

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
     * Gets the value of the datumOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOd() {
        return datumOd;
    }

    /**
     * Sets the value of the datumOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOd(XMLGregorianCalendar value) {
        this.datumOd = value;
    }

    /**
     * Gets the value of the datumZapadlosti property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumZapadlosti() {
        return datumZapadlosti;
    }

    /**
     * Sets the value of the datumZapadlosti property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumZapadlosti(XMLGregorianCalendar value) {
        this.datumZapadlosti = value;
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
     */
    public long getIdKn() {
        return idKn;
    }

    /**
     * Sets the value of the idKn property.
     * 
     */
    public void setIdKn(long value) {
        this.idKn = value;
    }

    /**
     * Gets the value of the idTr property.
     * 
     */
    public long getIdTr() {
        return idTr;
    }

    /**
     * Sets the value of the idTr property.
     * 
     */
    public void setIdTr(long value) {
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
     * Gets the value of the krajIzdaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKrajIzdaje() {
        return krajIzdaje;
    }

    /**
     * Sets the value of the krajIzdaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKrajIzdaje(String value) {
        this.krajIzdaje = value;
    }

    /**
     * Gets the value of the nacinPlacila property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacinPlacila() {
        return nacinPlacila;
    }

    /**
     * Sets the value of the nacinPlacila property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacinPlacila(String value) {
        this.nacinPlacila = value;
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
     * Gets the value of the referenca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenca() {
        return referenca;
    }

    /**
     * Sets the value of the referenca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenca(String value) {
        this.referenca = value;
    }

    /**
     * Gets the value of the stevilkaRacuna property.
     * 
     */
    public long getStevilkaRacuna() {
        return stevilkaRacuna;
    }

    /**
     * Sets the value of the stevilkaRacuna property.
     * 
     */
    public void setStevilkaRacuna(long value) {
        this.stevilkaRacuna = value;
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

}
