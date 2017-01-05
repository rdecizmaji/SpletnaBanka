
package gen.racuni;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="datumZapadlosti" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="krajIzdaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="postavke" type="{http://transakcije.nmb/}postavka" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="referenca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stevilkaRacuna" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trrIzdajatelja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trrPrejemnika" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vrednost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="vrednostZddv" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    "datumZapadlosti",
    "id",
    "krajIzdaje",
    "placan",
    "postavke",
    "referenca",
    "stevilkaRacuna",
    "trrIzdajatelja",
    "trrPrejemnika",
    "vrednost",
    "vrednostZddv"
})
public class Racun {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumIzdaje;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumZapadlosti;
    protected int id;
    protected String krajIzdaje;
    protected boolean placan;
    @XmlElement(nillable = true)
    protected List<Postavka> postavke;
    protected String referenca;
    protected long stevilkaRacuna;
    protected String trrIzdajatelja;
    protected String trrPrejemnika;
    protected BigDecimal vrednost;
    protected BigDecimal vrednostZddv;

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
     * Gets the value of the postavke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postavke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostavke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Postavka }
     * 
     * 
     */
    public List<Postavka> getPostavke() {
        if (postavke == null) {
            postavke = new ArrayList<Postavka>();
        }
        return this.postavke;
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
     * Gets the value of the trrIzdajatelja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrrIzdajatelja() {
        return trrIzdajatelja;
    }

    /**
     * Sets the value of the trrIzdajatelja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrrIzdajatelja(String value) {
        this.trrIzdajatelja = value;
    }

    /**
     * Gets the value of the trrPrejemnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrrPrejemnika() {
        return trrPrejemnika;
    }

    /**
     * Sets the value of the trrPrejemnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrrPrejemnika(String value) {
        this.trrPrejemnika = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVrednost(BigDecimal value) {
        this.vrednost = value;
    }

    /**
     * Gets the value of the vrednostZddv property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVrednostZddv() {
        return vrednostZddv;
    }

    /**
     * Sets the value of the vrednostZddv property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVrednostZddv(BigDecimal value) {
        this.vrednostZddv = value;
    }

}
