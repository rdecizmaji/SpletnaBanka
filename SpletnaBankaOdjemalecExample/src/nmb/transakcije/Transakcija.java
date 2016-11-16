
package nmb.transakcije;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transakcija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transakcija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTran" type="{http://transakcije.nmb/}transakcijskiRacun" minOccurs="0"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="racun" type="{http://transakcije.nmb/}racun" minOccurs="0"/>
 *         &lt;element name="stKartice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TRRprejemnika" type="{http://transakcije.nmb/}transakcijskiRacun" minOccurs="0"/>
 *         &lt;element name="trenutnoStanje" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="znesek" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="eRacun" type="{http://transakcije.nmb/}eRacun" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transakcija", propOrder = {
    "datum",
    "id",
    "idTran",
    "naziv",
    "racun",
    "stKartice",
    "trRprejemnika",
    "trenutnoStanje",
    "znesek",
    "eRacun"
})
public class Transakcija {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datum;
    protected int id;
    protected TransakcijskiRacun idTran;
    protected String naziv;
    protected Racun racun;
    protected int stKartice;
    @XmlElement(name = "TRRprejemnika")
    protected TransakcijskiRacun trRprejemnika;
    protected BigDecimal trenutnoStanje;
    protected BigDecimal znesek;
    protected ERacun eRacun;

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
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
     * Gets the value of the idTran property.
     * 
     * @return
     *     possible object is
     *     {@link TransakcijskiRacun }
     *     
     */
    public TransakcijskiRacun getIdTran() {
        return idTran;
    }

    /**
     * Sets the value of the idTran property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransakcijskiRacun }
     *     
     */
    public void setIdTran(TransakcijskiRacun value) {
        this.idTran = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the racun property.
     * 
     * @return
     *     possible object is
     *     {@link Racun }
     *     
     */
    public Racun getRacun() {
        return racun;
    }

    /**
     * Sets the value of the racun property.
     * 
     * @param value
     *     allowed object is
     *     {@link Racun }
     *     
     */
    public void setRacun(Racun value) {
        this.racun = value;
    }

    /**
     * Gets the value of the stKartice property.
     * 
     */
    public int getStKartice() {
        return stKartice;
    }

    /**
     * Sets the value of the stKartice property.
     * 
     */
    public void setStKartice(int value) {
        this.stKartice = value;
    }

    /**
     * Gets the value of the trRprejemnika property.
     * 
     * @return
     *     possible object is
     *     {@link TransakcijskiRacun }
     *     
     */
    public TransakcijskiRacun getTRRprejemnika() {
        return trRprejemnika;
    }

    /**
     * Sets the value of the trRprejemnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransakcijskiRacun }
     *     
     */
    public void setTRRprejemnika(TransakcijskiRacun value) {
        this.trRprejemnika = value;
    }

    /**
     * Gets the value of the trenutnoStanje property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrenutnoStanje() {
        return trenutnoStanje;
    }

    /**
     * Sets the value of the trenutnoStanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrenutnoStanje(BigDecimal value) {
        this.trenutnoStanje = value;
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

    /**
     * Gets the value of the eRacun property.
     * 
     * @return
     *     possible object is
     *     {@link ERacun }
     *     
     */
    public ERacun getERacun() {
        return eRacun;
    }

    /**
     * Sets the value of the eRacun property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERacun }
     *     
     */
    public void setERacun(ERacun value) {
        this.eRacun = value;
    }

}
