
package nmb.transakcije;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bancnaKartica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bancnaKartica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datumObracuna" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumVeljavnosti" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTk" type="{http://transakcije.nmb/}tipKartice" minOccurs="0"/>
 *         &lt;element name="idTr" type="{http://transakcije.nmb/}transakcijskiRacun" minOccurs="0"/>
 *         &lt;element name="pinKoda" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stKartice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="veljavana" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bancnaKartica", propOrder = {
    "datumObracuna",
    "datumVeljavnosti",
    "id",
    "idTk",
    "idTr",
    "pinKoda",
    "stKartice",
    "veljavana"
})
public class BancnaKartica {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumObracuna;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumVeljavnosti;
    protected int id;
    protected TipKartice idTk;
    protected TransakcijskiRacun idTr;
    protected int pinKoda;
    protected int stKartice;
    protected boolean veljavana;

    /**
     * Gets the value of the datumObracuna property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumObracuna() {
        return datumObracuna;
    }

    /**
     * Sets the value of the datumObracuna property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumObracuna(XMLGregorianCalendar value) {
        this.datumObracuna = value;
    }

    /**
     * Gets the value of the datumVeljavnosti property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumVeljavnosti() {
        return datumVeljavnosti;
    }

    /**
     * Sets the value of the datumVeljavnosti property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumVeljavnosti(XMLGregorianCalendar value) {
        this.datumVeljavnosti = value;
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
     * Gets the value of the idTk property.
     * 
     * @return
     *     possible object is
     *     {@link TipKartice }
     *     
     */
    public TipKartice getIdTk() {
        return idTk;
    }

    /**
     * Sets the value of the idTk property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipKartice }
     *     
     */
    public void setIdTk(TipKartice value) {
        this.idTk = value;
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
     * Gets the value of the pinKoda property.
     * 
     */
    public int getPinKoda() {
        return pinKoda;
    }

    /**
     * Sets the value of the pinKoda property.
     * 
     */
    public void setPinKoda(int value) {
        this.pinKoda = value;
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
     * Gets the value of the veljavana property.
     * 
     */
    public boolean isVeljavana() {
        return veljavana;
    }

    /**
     * Sets the value of the veljavana property.
     * 
     */
    public void setVeljavana(boolean value) {
        this.veljavana = value;
    }

}
