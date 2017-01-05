
package gen.racuni;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "eRacuniWSDL", targetNamespace = "http://transakcije.nmb/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ERacuniWSDL {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<gen.racuni.Racun>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "vrniVseIzdaneRacune", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVseIzdaneRacune")
    @ResponseWrapper(localName = "vrniVseIzdaneRacuneResponse", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVseIzdaneRacuneResponse")
    public List<Racun> vrniVseIzdaneRacune(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns gen.racuni.Racun
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "izdajERacun", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.IzdajERacun")
    @ResponseWrapper(localName = "izdajERacunResponse", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.IzdajERacunResponse")
    public Racun izdajERacun(
        @WebParam(name = "arg0", targetNamespace = "")
        Racun arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "placajERacun", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.PlacajERacun")
    @ResponseWrapper(localName = "placajERacunResponse", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.PlacajERacunResponse")
    public String placajERacun(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<gen.racuni.Racun>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "vrniVseprejetePlacaneRacune", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVseprejetePlacaneRacune")
    @ResponseWrapper(localName = "vrniVseprejetePlacaneRacuneResponse", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVseprejetePlacaneRacuneResponse")
    public List<Racun> vrniVseprejetePlacaneRacune(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<gen.racuni.Racun>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "vrniVsePrejeteRacune", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVsePrejeteRacune")
    @ResponseWrapper(localName = "vrniVsePrejeteRacuneResponse", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVsePrejeteRacuneResponse")
    public List<Racun> vrniVsePrejeteRacune(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<gen.racuni.Racun>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "vrniVseprejeteNeplacaneRacune", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVseprejeteNeplacaneRacune")
    @ResponseWrapper(localName = "vrniVseprejeteNeplacaneRacuneResponse", targetNamespace = "http://transakcije.nmb/", className = "gen.racuni.VrniVseprejeteNeplacaneRacuneResponse")
    public List<Racun> vrniVseprejeteNeplacaneRacune(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

}
