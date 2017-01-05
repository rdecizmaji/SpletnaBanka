
package gen.racuni;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for postavka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="postavka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cena_na_enoto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="enota_mere" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kolicina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "postavka", propOrder = {
    "cenaNaEnoto",
    "enotaMere",
    "id",
    "kolicina",
    "naziv",
    "vrednostZddv"
})
public class Postavka {

    @XmlElement(name = "cena_na_enoto")
    protected BigDecimal cenaNaEnoto;
    @XmlElement(name = "enota_mere")
    protected String enotaMere;
    protected int id;
    protected int kolicina;
    protected String naziv;
    protected BigDecimal vrednostZddv;

    /**
     * Gets the value of the cenaNaEnoto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCenaNaEnoto() {
        return cenaNaEnoto;
    }

    /**
     * Sets the value of the cenaNaEnoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCenaNaEnoto(BigDecimal value) {
        this.cenaNaEnoto = value;
    }

    /**
     * Gets the value of the enotaMere property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnotaMere() {
        return enotaMere;
    }

    /**
     * Sets the value of the enotaMere property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnotaMere(String value) {
        this.enotaMere = value;
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
     * Gets the value of the kolicina property.
     * 
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * Sets the value of the kolicina property.
     * 
     */
    public void setKolicina(int value) {
        this.kolicina = value;
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
