
package gen.komitenti;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for komitent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="komitent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="davcnaSt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geslo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postnaSt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priimek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transakcijskiRacuni" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="uporabniskoIme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "komitent", propOrder = {
    "davcnaSt",
    "drzava",
    "email",
    "emso",
    "geslo",
    "id",
    "ime",
    "naslov",
    "posta",
    "postnaSt",
    "priimek",
    "transakcijskiRacuni",
    "uporabniskoIme"
})
public class Komitent {

    protected String davcnaSt;
    protected String drzava;
    protected String email;
    protected String emso;
    protected String geslo;
    protected int id;
    protected String ime;
    protected String naslov;
    protected String posta;
    protected String postnaSt;
    protected String priimek;
    @XmlElement(nillable = true)
    protected List<String> transakcijskiRacuni;
    protected String uporabniskoIme;

    /**
     * Gets the value of the davcnaSt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDavcnaSt() {
        return davcnaSt;
    }

    /**
     * Sets the value of the davcnaSt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDavcnaSt(String value) {
        this.davcnaSt = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the emso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmso() {
        return emso;
    }

    /**
     * Sets the value of the emso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmso(String value) {
        this.emso = value;
    }

    /**
     * Gets the value of the geslo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeslo() {
        return geslo;
    }

    /**
     * Sets the value of the geslo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeslo(String value) {
        this.geslo = value;
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
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the posta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosta() {
        return posta;
    }

    /**
     * Sets the value of the posta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosta(String value) {
        this.posta = value;
    }

    /**
     * Gets the value of the postnaSt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostnaSt() {
        return postnaSt;
    }

    /**
     * Sets the value of the postnaSt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostnaSt(String value) {
        this.postnaSt = value;
    }

    /**
     * Gets the value of the priimek property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriimek() {
        return priimek;
    }

    /**
     * Sets the value of the priimek property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriimek(String value) {
        this.priimek = value;
    }

    /**
     * Gets the value of the transakcijskiRacuni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transakcijskiRacuni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransakcijskiRacuni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTransakcijskiRacuni() {
        if (transakcijskiRacuni == null) {
            transakcijskiRacuni = new ArrayList<String>();
        }
        return this.transakcijskiRacuni;
    }

    /**
     * Gets the value of the uporabniskoIme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUporabniskoIme() {
        return uporabniskoIme;
    }

    /**
     * Sets the value of the uporabniskoIme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUporabniskoIme(String value) {
        this.uporabniskoIme = value;
    }

}
