package SitaApi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2016-03-30T11:31:57.991+02:00
 * Generated source version: 3.1.5
 * 
 */
@WebService(targetNamespace = "http://cims.nl/", name = "SitaApiSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface SitaApiSoap {

    @WebMethod(operationName = "GetMediaOfIncidentF", action = "http://cims.nl/GetMediaOfIncidentF")
    @RequestWrapper(localName = "GetMediaOfIncidentF", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaOfIncidentF")
    @ResponseWrapper(localName = "GetMediaOfIncidentFResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaOfIncidentFResponse")
    @WebResult(name = "GetMediaOfIncidentFResult", targetNamespace = "http://cims.nl/")
    public ArrayOfMedia getMediaOfIncidentF(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "incident", targetNamespace = "http://cims.nl/")
        int incident,
        @WebParam(name = "filter", targetNamespace = "http://cims.nl/")
        java.lang.String filter,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );

    @WebMethod(operationName = "AddToxication", action = "http://cims.nl/AddToxication")
    @RequestWrapper(localName = "AddToxication", targetNamespace = "http://cims.nl/", className = "SitaApi.AddToxication")
    @ResponseWrapper(localName = "AddToxicationResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.AddToxicationResponse")
    @WebResult(name = "AddToxicationResult", targetNamespace = "http://cims.nl/")
    public boolean addToxication(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "name", targetNamespace = "http://cims.nl/")
        java.lang.String name,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description,
        @WebParam(name = "chemicalCompound", targetNamespace = "http://cims.nl/")
        java.lang.String chemicalCompound,
        @WebParam(name = "dangerLevel", targetNamespace = "http://cims.nl/")
        int dangerLevel,
        @WebParam(name = "volatility", targetNamespace = "http://cims.nl/")
        double volatility
    );

    @WebMethod(operationName = "GetMedia", action = "http://cims.nl/GetMedia")
    @RequestWrapper(localName = "GetMedia", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMedia")
    @ResponseWrapper(localName = "GetMediaResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaResponse")
    @WebResult(name = "GetMediaResult", targetNamespace = "http://cims.nl/")
    public ArrayOfMedia getMedia(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );

    @WebMethod(operationName = "Login", action = "http://cims.nl/Login")
    @RequestWrapper(localName = "Login", targetNamespace = "http://cims.nl/", className = "SitaApi.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.LoginResponse")
    @WebResult(name = "LoginResult", targetNamespace = "http://cims.nl/")
    public java.lang.String login(
        @WebParam(name = "username", targetNamespace = "http://cims.nl/")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "http://cims.nl/")
        java.lang.String password
    );

    @WebMethod(operationName = "GetMediaOfIncident", action = "http://cims.nl/GetMediaOfIncident")
    @RequestWrapper(localName = "GetMediaOfIncident", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaOfIncident")
    @ResponseWrapper(localName = "GetMediaOfIncidentResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaOfIncidentResponse")
    @WebResult(name = "GetMediaOfIncidentResult", targetNamespace = "http://cims.nl/")
    public ArrayOfMedia getMediaOfIncident(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "incident", targetNamespace = "http://cims.nl/")
        int incident,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );

    @WebMethod(operationName = "SendMessageWithMedia", action = "http://cims.nl/SendMessageWithMedia")
    @RequestWrapper(localName = "SendMessageWithMedia", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessageWithMedia")
    @ResponseWrapper(localName = "SendMessageWithMediaResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessageWithMediaResponse")
    @WebResult(name = "SendMessageWithMediaResult", targetNamespace = "http://cims.nl/")
    public boolean sendMessageWithMedia(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "team", targetNamespace = "http://cims.nl/")
        int team,
        @WebParam(name = "message", targetNamespace = "http://cims.nl/")
        java.lang.String message,
        @WebParam(name = "mediaId", targetNamespace = "http://cims.nl/")
        int mediaId
    );

    @WebMethod(operationName = "Logout", action = "http://cims.nl/Logout")
    @RequestWrapper(localName = "Logout", targetNamespace = "http://cims.nl/", className = "SitaApi.Logout")
    @ResponseWrapper(localName = "LogoutResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.LogoutResponse")
    @WebResult(name = "LogoutResult", targetNamespace = "http://cims.nl/")
    public boolean logout();

    @WebMethod(operationName = "GetToxications", action = "http://cims.nl/GetToxications")
    @RequestWrapper(localName = "GetToxications", targetNamespace = "http://cims.nl/", className = "SitaApi.GetToxications")
    @ResponseWrapper(localName = "GetToxicationsResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetToxicationsResponse")
    @WebResult(name = "GetToxicationsResult", targetNamespace = "http://cims.nl/")
    public ArrayOfToxication getToxications(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token
    );

    @WebMethod(operationName = "GetMediaF", action = "http://cims.nl/GetMediaF")
    @RequestWrapper(localName = "GetMediaF", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaF")
    @ResponseWrapper(localName = "GetMediaFResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaFResponse")
    @WebResult(name = "GetMediaFResult", targetNamespace = "http://cims.nl/")
    public ArrayOfMedia getMediaF(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "filter", targetNamespace = "http://cims.nl/")
        java.lang.String filter,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );

    @WebMethod(operationName = "SendMessage", action = "http://cims.nl/SendMessage")
    @RequestWrapper(localName = "SendMessage", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessage")
    @ResponseWrapper(localName = "SendMessageResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessageResponse")
    @WebResult(name = "SendMessageResult", targetNamespace = "http://cims.nl/")
    public boolean sendMessage(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "team", targetNamespace = "http://cims.nl/")
        int team,
        @WebParam(name = "message", targetNamespace = "http://cims.nl/")
        java.lang.String message
    );

    @WebMethod(operationName = "EditIncident", action = "http://cims.nl/EditIncident")
    @RequestWrapper(localName = "EditIncident", targetNamespace = "http://cims.nl/", className = "SitaApi.EditIncident")
    @ResponseWrapper(localName = "EditIncidentResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.EditIncidentResponse")
    @WebResult(name = "EditIncidentResult", targetNamespace = "http://cims.nl/")
    public boolean editIncident(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "id", targetNamespace = "http://cims.nl/")
        int id,
        @WebParam(name = "name", targetNamespace = "http://cims.nl/")
        java.lang.String name,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description,
        @WebParam(name = "chemicalCompound", targetNamespace = "http://cims.nl/")
        java.lang.String chemicalCompound,
        @WebParam(name = "dangerLevel", targetNamespace = "http://cims.nl/")
        int dangerLevel,
        @WebParam(name = "volatility", targetNamespace = "http://cims.nl/")
        double volatility
    );

    @WebMethod(operationName = "GetIncidents", action = "http://cims.nl/GetIncidents")
    @RequestWrapper(localName = "GetIncidents", targetNamespace = "http://cims.nl/", className = "SitaApi.GetIncidents")
    @ResponseWrapper(localName = "GetIncidentsResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetIncidentsResponse")
    @WebResult(name = "GetIncidentsResult", targetNamespace = "http://cims.nl/")
    public ArrayOfIncident getIncidents(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );
}
