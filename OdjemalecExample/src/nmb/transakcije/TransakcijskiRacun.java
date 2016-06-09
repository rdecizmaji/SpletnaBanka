
package nmb.transakcije;

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
 * <p>Java class for transakcijskiRacun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transakcijskiRacun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bancneKartice" type="{http://transakcije.nmb/}bancnaKartica" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datumOdprtja" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumZaprtja" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="komitent" type="{http://transakcije.nmb/}komitent" minOccurs="0"/>
 *         &lt;element name="racuni" type="{http://transakcije.nmb/}racun" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="stanje" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="stevilkaTRR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transakcije" type="{http://transakcije.nmb/}transakcija" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="zaprt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transakcijskiRacun", propOrder = {
    "bancneKartice",
    "datumOdprtja",
    "datumZaprtja",
    "id",
    "komitent",
    "racuni",
    "stanje",
    "stevilkaTRR",
    "transakcije",
    "zaprt"
})
public class TransakcijskiRacun {

    @XmlElement(nillable = true)
    protected List<BancnaKartica> bancneKartice;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumOdprtja;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumZaprtja;
    protected int id;
    protected Komitent komitent;
    @XmlElement(nillable = true)
    protected List<Racun> racuni;
    protected BigDecimal stanje;
    protected String stevilkaTRR;
    @XmlElement(nillable = true)
    protected List<Transakcija> transakcije;
    protected boolean zaprt;

    /**
     * Gets the value of the bancneKartice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bancneKartice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBancneKartice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BancnaKartica }
     * 
     * 
     */
    public List<BancnaKartica> getBancneKartice() {
        if (bancneKartice == null) {
            bancneKartice = new ArrayList<BancnaKartica>();
        }
        return this.bancneKartice;
    }

    /**
     * Gets the value of the datumOdprtja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOdprtja() {
        return datumOdprtja;
    }

    /**
     * Sets the value of the datumOdprtja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOdprtja(XMLGregorianCalendar value) {
        this.datumOdprtja = value;
    }

    /**
     * Gets the value of the datumZaprtja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumZaprtja() {
        return datumZaprtja;
    }

    /**
     * Sets the value of the datumZaprtja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumZaprtja(XMLGregorianCalendar value) {
        this.datumZaprtja = value;
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
     * Gets the value of the komitent property.
     * 
     * @return
     *     possible object is
     *     {@link Komitent }
     *     
     */
    public Komitent getKomitent() {
        return komitent;
    }

    /**
     * Sets the value of the komitent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Komitent }
     *     
     */
    public void setKomitent(Komitent value) {
        this.komitent = value;
    }

    /**
     * Gets the value of the racuni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the racuni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRacuni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Racun }
     * 
     * 
     */
    public List<Racun> getRacuni() {
        if (racuni == null) {
            racuni = new ArrayList<Racun>();
        }
        return this.racuni;
    }

    /**
     * Gets the value of the stanje property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStanje() {
        return stanje;
    }

    /**
     * Sets the value of the stanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStanje(BigDecimal value) {
        this.stanje = value;
    }

    /**
     * Gets the value of the stevilkaTRR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStevilkaTRR() {
        return stevilkaTRR;
    }

    /**
     * Sets the value of the stevilkaTRR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStevilkaTRR(String value) {
        this.stevilkaTRR = value;
    }

    /**
     * Gets the value of the transakcije property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transakcije property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransakcije().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transakcija }
     * 
     * 
     */
    public List<Transakcija> getTransakcije() {
        if (transakcije == null) {
            transakcije = new ArrayList<Transakcija>();
        }
        return this.transakcije;
    }

    /**
     * Gets the value of the zaprt property.
     * 
     */
    public boolean isZaprt() {
        return zaprt;
    }

    /**
     * Sets the value of the zaprt property.
     * 
     */
    public void setZaprt(boolean value) {
        this.zaprt = value;
    }

}
