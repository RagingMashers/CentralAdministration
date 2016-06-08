package SitaApi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-06-08T11:48:21.688+02:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://cims.nl/", name = "SitaApiSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface SitaApiSoap {

    @WebMethod(operationName = "DeleteIncident", action = "http://cims.nl/DeleteIncident")
    @RequestWrapper(localName = "DeleteIncident", targetNamespace = "http://cims.nl/", className = "SitaApi.DeleteIncident")
    @ResponseWrapper(localName = "DeleteIncidentResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.DeleteIncidentResponse")
    @WebResult(name = "DeleteIncidentResult", targetNamespace = "http://cims.nl/")
    public boolean deleteIncident(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "id", targetNamespace = "http://cims.nl/")
        int id
    );

    @WebMethod(operationName = "GetTeamsNearIncident", action = "http://cims.nl/GetTeamsNearIncident")
    @RequestWrapper(localName = "GetTeamsNearIncident", targetNamespace = "http://cims.nl/", className = "SitaApi.GetTeamsNearIncident")
    @ResponseWrapper(localName = "GetTeamsNearIncidentResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetTeamsNearIncidentResponse")
    @WebResult(name = "GetTeamsNearIncidentResult", targetNamespace = "http://cims.nl/")
    public ArrayOfTeam getTeamsNearIncident(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "longitude", targetNamespace = "http://cims.nl/")
        double longitude,
        @WebParam(name = "latitude", targetNamespace = "http://cims.nl/")
        double latitude,
        @WebParam(name = "radius", targetNamespace = "http://cims.nl/")
        int radius
    );

    @WebMethod(operationName = "AddTask", action = "http://cims.nl/AddTask")
    @RequestWrapper(localName = "AddTask", targetNamespace = "http://cims.nl/", className = "SitaApi.AddTask")
    @ResponseWrapper(localName = "AddTaskResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.AddTaskResponse")
    @WebResult(name = "AddTaskResult", targetNamespace = "http://cims.nl/")
    public boolean addTask(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description
    );

    @WebMethod(operationName = "GetTasksFromActionPlan", action = "http://cims.nl/GetTasksFromActionPlan")
    @RequestWrapper(localName = "GetTasksFromActionPlan", targetNamespace = "http://cims.nl/", className = "SitaApi.GetTasksFromActionPlan")
    @ResponseWrapper(localName = "GetTasksFromActionPlanResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetTasksFromActionPlanResponse")
    @WebResult(name = "GetTasksFromActionPlanResult", targetNamespace = "http://cims.nl/")
    public ArrayOfTask getTasksFromActionPlan(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "actionPlanId", targetNamespace = "http://cims.nl/")
        int actionPlanId
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

    @WebMethod(operationName = "EditActionPlan", action = "http://cims.nl/EditActionPlan")
    @RequestWrapper(localName = "EditActionPlan", targetNamespace = "http://cims.nl/", className = "SitaApi.EditActionPlan")
    @ResponseWrapper(localName = "EditActionPlanResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.EditActionPlanResponse")
    @WebResult(name = "EditActionPlanResult", targetNamespace = "http://cims.nl/")
    public boolean editActionPlan(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "name", targetNamespace = "http://cims.nl/")
        java.lang.String name,
        @WebParam(name = "taskIds", targetNamespace = "http://cims.nl/")
        ArrayOfInt taskIds
    );

    @WebMethod(operationName = "GetMedia", action = "http://cims.nl/GetMedia")
    @RequestWrapper(localName = "GetMedia", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMedia")
    @ResponseWrapper(localName = "GetMediaResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMediaResponse")
    @WebResult(name = "GetMediaResult", targetNamespace = "http://cims.nl/")
    public ArrayOfAnyType getMedia(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );

    @WebMethod(operationName = "GetMessagesOfIncident", action = "http://cims.nl/GetMessagesOfIncident")
    @RequestWrapper(localName = "GetMessagesOfIncident", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMessagesOfIncident")
    @ResponseWrapper(localName = "GetMessagesOfIncidentResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetMessagesOfIncidentResponse")
    @WebResult(name = "GetMessagesOfIncidentResult", targetNamespace = "http://cims.nl/")
    public ArrayOfMessage getMessagesOfIncident(
        @WebParam(name = "directionOfMessages", targetNamespace = "http://cims.nl/")
        DirectionType directionOfMessages
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
    public ArrayOfAnyType getMediaOfIncident(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "incident", targetNamespace = "http://cims.nl/")
        int incident,
        @WebParam(name = "start", targetNamespace = "http://cims.nl/")
        int start,
        @WebParam(name = "limit", targetNamespace = "http://cims.nl/")
        int limit
    );

    @WebMethod(operationName = "AddIncident", action = "http://cims.nl/AddIncident")
    @RequestWrapper(localName = "AddIncident", targetNamespace = "http://cims.nl/", className = "SitaApi.AddIncident")
    @ResponseWrapper(localName = "AddIncidentResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.AddIncidentResponse")
    @WebResult(name = "AddIncidentResult", targetNamespace = "http://cims.nl/")
    public boolean addIncident(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "amountVictims", targetNamespace = "http://cims.nl/")
        int amountVictims,
        @WebParam(name = "amountWounded", targetNamespace = "http://cims.nl/")
        int amountWounded,
        @WebParam(name = "longitude", targetNamespace = "http://cims.nl/")
        double longitude,
        @WebParam(name = "latitude", targetNamespace = "http://cims.nl/")
        double latitude,
        @WebParam(name = "dangerlevel", targetNamespace = "http://cims.nl/")
        int dangerlevel,
        @WebParam(name = "radius", targetNamespace = "http://cims.nl/")
        int radius,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description
    );

    @WebMethod(operationName = "SendMessageWithMedia", action = "http://cims.nl/SendMessageWithMedia")
    @RequestWrapper(localName = "SendMessageWithMedia", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessageWithMedia")
    @ResponseWrapper(localName = "SendMessageWithMediaResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessageWithMediaResponse")
    @WebResult(name = "SendMessageWithMediaResult", targetNamespace = "http://cims.nl/")
    public boolean sendMessageWithMedia(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "teamId", targetNamespace = "http://cims.nl/")
        int teamId,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description,
        @WebParam(name = "title", targetNamespace = "http://cims.nl/")
        java.lang.String title,
        @WebParam(name = "mediaIds", targetNamespace = "http://cims.nl/")
        ArrayOfInt mediaIds
    );

    @WebMethod(operationName = "GetActionPlans", action = "http://cims.nl/GetActionPlans")
    @RequestWrapper(localName = "GetActionPlans", targetNamespace = "http://cims.nl/", className = "SitaApi.GetActionPlans")
    @ResponseWrapper(localName = "GetActionPlansResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetActionPlansResponse")
    @WebResult(name = "GetActionPlansResult", targetNamespace = "http://cims.nl/")
    public ArrayOfActionPlan getActionPlans(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token
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

    @WebMethod(operationName = "GetTasks", action = "http://cims.nl/GetTasks")
    @RequestWrapper(localName = "GetTasks", targetNamespace = "http://cims.nl/", className = "SitaApi.GetTasks")
    @ResponseWrapper(localName = "GetTasksResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.GetTasksResponse")
    @WebResult(name = "GetTasksResult", targetNamespace = "http://cims.nl/")
    public ArrayOfTask getTasks(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token
    );

    @WebMethod(operationName = "AddActionPlan", action = "http://cims.nl/AddActionPlan")
    @RequestWrapper(localName = "AddActionPlan", targetNamespace = "http://cims.nl/", className = "SitaApi.AddActionPlan")
    @ResponseWrapper(localName = "AddActionPlanResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.AddActionPlanResponse")
    @WebResult(name = "AddActionPlanResult", targetNamespace = "http://cims.nl/")
    public boolean addActionPlan(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "name", targetNamespace = "http://cims.nl/")
        java.lang.String name,
        @WebParam(name = "taskIds", targetNamespace = "http://cims.nl/")
        ArrayOfInt taskIds
    );

    @WebMethod(operationName = "SendMessage", action = "http://cims.nl/SendMessage")
    @RequestWrapper(localName = "SendMessage", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessage")
    @ResponseWrapper(localName = "SendMessageResponse", targetNamespace = "http://cims.nl/", className = "SitaApi.SendMessageResponse")
    @WebResult(name = "SendMessageResult", targetNamespace = "http://cims.nl/")
    public boolean sendMessage(
        @WebParam(name = "token", targetNamespace = "http://cims.nl/")
        java.lang.String token,
        @WebParam(name = "teamId", targetNamespace = "http://cims.nl/")
        int teamId,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description,
        @WebParam(name = "title", targetNamespace = "http://cims.nl/")
        java.lang.String title
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
        @WebParam(name = "amountVictims", targetNamespace = "http://cims.nl/")
        int amountVictims,
        @WebParam(name = "amountWounded", targetNamespace = "http://cims.nl/")
        int amountWounded,
        @WebParam(name = "longitude", targetNamespace = "http://cims.nl/")
        double longitude,
        @WebParam(name = "latitude", targetNamespace = "http://cims.nl/")
        double latitude,
        @WebParam(name = "radius", targetNamespace = "http://cims.nl/")
        int radius,
        @WebParam(name = "dangerlevel", targetNamespace = "http://cims.nl/")
        int dangerlevel,
        @WebParam(name = "description", targetNamespace = "http://cims.nl/")
        java.lang.String description
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
