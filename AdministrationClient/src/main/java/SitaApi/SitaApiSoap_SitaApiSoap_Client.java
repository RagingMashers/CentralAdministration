
package SitaApi;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-05-18T14:08:21.084+02:00
 * Generated source version: 3.1.6
 * 
 */
public final class SitaApiSoap_SitaApiSoap_Client {

    private static final QName SERVICE_NAME = new QName("http://cims.nl/", "SitaApi");

    private SitaApiSoap_SitaApiSoap_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = SitaApi.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        SitaApi ss = new SitaApi(wsdlURL, SERVICE_NAME);
        SitaApiSoap port = ss.getSitaApiSoap();  
        
        {
        System.out.println("Invoking deleteIncident...");
        java.lang.String _deleteIncident_token = "";
        int _deleteIncident_id = 0;
        boolean _deleteIncident__return = port.deleteIncident(_deleteIncident_token, _deleteIncident_id);
        System.out.println("deleteIncident.result=" + _deleteIncident__return);


        }
        {
        System.out.println("Invoking getTeamsNearIncident...");
        java.lang.String _getTeamsNearIncident_token = "";
        double _getTeamsNearIncident_longitude = 0.0;
        double _getTeamsNearIncident_latitude = 0.0;
        int _getTeamsNearIncident_radius = 0;
        SitaApi.ArrayOfTeam _getTeamsNearIncident__return = port.getTeamsNearIncident(_getTeamsNearIncident_token, _getTeamsNearIncident_longitude, _getTeamsNearIncident_latitude, _getTeamsNearIncident_radius);
        System.out.println("getTeamsNearIncident.result=" + _getTeamsNearIncident__return);


        }
        {
        System.out.println("Invoking addTask...");
        java.lang.String _addTask_token = "";
        java.lang.String _addTask_description = "";
        boolean _addTask__return = port.addTask(_addTask_token, _addTask_description);
        System.out.println("addTask.result=" + _addTask__return);


        }
        {
        System.out.println("Invoking getTasksFromActionPlan...");
        java.lang.String _getTasksFromActionPlan_token = "";
        int _getTasksFromActionPlan_actionPlanId = 0;
        SitaApi.ArrayOfTask _getTasksFromActionPlan__return = port.getTasksFromActionPlan(_getTasksFromActionPlan_token, _getTasksFromActionPlan_actionPlanId);
        System.out.println("getTasksFromActionPlan.result=" + _getTasksFromActionPlan__return);


        }
        {
        System.out.println("Invoking addToxication...");
        java.lang.String _addToxication_token = "";
        java.lang.String _addToxication_name = "";
        java.lang.String _addToxication_description = "";
        java.lang.String _addToxication_chemicalCompound = "";
        int _addToxication_dangerLevel = 0;
        double _addToxication_volatility = 0.0;
        boolean _addToxication__return = port.addToxication(_addToxication_token, _addToxication_name, _addToxication_description, _addToxication_chemicalCompound, _addToxication_dangerLevel, _addToxication_volatility);
        System.out.println("addToxication.result=" + _addToxication__return);


        }
        {
        System.out.println("Invoking editActionPlan...");
        java.lang.String _editActionPlan_token = "";
        java.lang.String _editActionPlan_name = "";
        SitaApi.ArrayOfInt _editActionPlan_taskIds = null;
        boolean _editActionPlan__return = port.editActionPlan(_editActionPlan_token, _editActionPlan_name, _editActionPlan_taskIds);
        System.out.println("editActionPlan.result=" + _editActionPlan__return);


        }
        {
        System.out.println("Invoking getMedia...");
        java.lang.String _getMedia_token = "";
        int _getMedia_start = 0;
        int _getMedia_limit = 0;
        SitaApi.ArrayOfAnyType _getMedia__return = port.getMedia(_getMedia_token, _getMedia_start, _getMedia_limit);
        System.out.println("getMedia.result=" + _getMedia__return);


        }
        {
        System.out.println("Invoking login...");
        java.lang.String _login_username = "";
        java.lang.String _login_password = "";
        java.lang.String _login__return = port.login(_login_username, _login_password);
        System.out.println("login.result=" + _login__return);


        }
        {
        System.out.println("Invoking getMediaOfIncident...");
        java.lang.String _getMediaOfIncident_token = "";
        int _getMediaOfIncident_incident = 0;
        int _getMediaOfIncident_start = 0;
        int _getMediaOfIncident_limit = 0;
        SitaApi.ArrayOfAnyType _getMediaOfIncident__return = port.getMediaOfIncident(_getMediaOfIncident_token, _getMediaOfIncident_incident, _getMediaOfIncident_start, _getMediaOfIncident_limit);
        System.out.println("getMediaOfIncident.result=" + _getMediaOfIncident__return);


        }
        {
        System.out.println("Invoking addIncident...");
        java.lang.String _addIncident_token = "";
        int _addIncident_amountVictims = 0;
        int _addIncident_amountWounded = 0;
        double _addIncident_longitude = 0.0;
        double _addIncident_latitude = 0.0;
        int _addIncident_dangerlevel = 0;
        int _addIncident_radius = 0;
        java.lang.String _addIncident_description = "";
        boolean _addIncident__return = port.addIncident(_addIncident_token, _addIncident_amountVictims, _addIncident_amountWounded, _addIncident_longitude, _addIncident_latitude, _addIncident_dangerlevel, _addIncident_radius, _addIncident_description);
        System.out.println("addIncident.result=" + _addIncident__return);


        }
        {
        System.out.println("Invoking sendMessageWithMedia...");
        java.lang.String _sendMessageWithMedia_token = "";
        int _sendMessageWithMedia_teamId = 0;
        java.lang.String _sendMessageWithMedia_description = "";
        SitaApi.ArrayOfInt _sendMessageWithMedia_mediaIds = null;
        boolean _sendMessageWithMedia__return = port.sendMessageWithMedia(_sendMessageWithMedia_token, _sendMessageWithMedia_teamId, _sendMessageWithMedia_description, _sendMessageWithMedia_mediaIds);
        System.out.println("sendMessageWithMedia.result=" + _sendMessageWithMedia__return);


        }
        {
        System.out.println("Invoking getActionPlans...");
        java.lang.String _getActionPlans_token = "";
        SitaApi.ArrayOfActionPlan _getActionPlans__return = port.getActionPlans(_getActionPlans_token);
        System.out.println("getActionPlans.result=" + _getActionPlans__return);


        }
        {
        System.out.println("Invoking logout...");
        boolean _logout__return = port.logout();
        System.out.println("logout.result=" + _logout__return);


        }
        {
        System.out.println("Invoking getToxications...");
        java.lang.String _getToxications_token = "";
        SitaApi.ArrayOfToxication _getToxications__return = port.getToxications(_getToxications_token);
        System.out.println("getToxications.result=" + _getToxications__return);


        }
        {
        System.out.println("Invoking getTasks...");
        java.lang.String _getTasks_token = "";
        SitaApi.ArrayOfTask _getTasks__return = port.getTasks(_getTasks_token);
        System.out.println("getTasks.result=" + _getTasks__return);


        }
        {
        System.out.println("Invoking addActionPlan...");
        java.lang.String _addActionPlan_token = "";
        java.lang.String _addActionPlan_name = "";
        SitaApi.ArrayOfInt _addActionPlan_taskIds = null;
        boolean _addActionPlan__return = port.addActionPlan(_addActionPlan_token, _addActionPlan_name, _addActionPlan_taskIds);
        System.out.println("addActionPlan.result=" + _addActionPlan__return);


        }
        {
        System.out.println("Invoking sendMessage...");
        java.lang.String _sendMessage_token = "";
        int _sendMessage_teamId = 0;
        java.lang.String _sendMessage_description = "";
        boolean _sendMessage__return = port.sendMessage(_sendMessage_token, _sendMessage_teamId, _sendMessage_description);
        System.out.println("sendMessage.result=" + _sendMessage__return);


        }
        {
        System.out.println("Invoking editIncident...");
        java.lang.String _editIncident_token = "";
        int _editIncident_id = 0;
        int _editIncident_amountVictims = 0;
        int _editIncident_amountWounded = 0;
        double _editIncident_longitude = 0.0;
        double _editIncident_latitude = 0.0;
        int _editIncident_radius = 0;
        int _editIncident_dangerlevel = 0;
        java.lang.String _editIncident_description = "";
        boolean _editIncident__return = port.editIncident(_editIncident_token, _editIncident_id, _editIncident_amountVictims, _editIncident_amountWounded, _editIncident_longitude, _editIncident_latitude, _editIncident_radius, _editIncident_dangerlevel, _editIncident_description);
        System.out.println("editIncident.result=" + _editIncident__return);


        }
        {
        System.out.println("Invoking getIncidents...");
        java.lang.String _getIncidents_token = "";
        int _getIncidents_start = 0;
        int _getIncidents_limit = 0;
        SitaApi.ArrayOfIncident _getIncidents__return = port.getIncidents(_getIncidents_token, _getIncidents_start, _getIncidents_limit);
        System.out.println("getIncidents.result=" + _getIncidents__return);


        }

        System.exit(0);
    }

}
