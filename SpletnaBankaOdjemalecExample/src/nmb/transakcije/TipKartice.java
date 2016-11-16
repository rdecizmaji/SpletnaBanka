
package nmb.transakcije;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipKartice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipKartice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="debetna" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kartice" type="{http://transakcije.nmb/}bancnaKartica" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="kreditna" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nazivTipa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipKartice", propOrder = {
    "debetna",
    "id",
    "kartice",
    "kreditna",
    "nazivTipa"
})
public class TipKartice {

    protected boolean debetna;
    protected int id;
    @XmlElement(nillable = true)
    protected List<BancnaKartica> kartice;
    protected boolean kreditna;
    protected String nazivTipa;

    /**
     * Gets the value of the debetna property.
     * 
     */
    public boolean isDebetna() {
        return debetna;
    }

    /**
     * Sets the value of the debetna property.
     * 
     */
    public void setDebetna(boolean value) {
        this.debetna = value;
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
     * Gets the value of the kartice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kartice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKartice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BancnaKartica }
     * 
     * 
     */
    public List<BancnaKartica> getKartice() {
        if (kartice == null) {
            kartice = new ArrayList<BancnaKartica>();
        }
        return this.kartice;
    }

    /**
     * Gets the value of the kreditna property.
     * 
     */
    public boolean isKreditna() {
        return kreditna;
    }

    /**
     * Sets the value of the kreditna property.
     * 
     */
    public void setKreditna(boolean value) {
        this.kreditna = value;
    }

    /**
     * Gets the value of the nazivTipa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivTipa() {
        return nazivTipa;
    }

    /**
     * Sets the value of the nazivTipa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivTipa(String value) {
        this.nazivTipa = value;
    }

}
