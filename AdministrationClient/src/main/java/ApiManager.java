import SitaApi.SitaApi;
import SitaApi.SitaApiSoap;

import javax.xml.namespace.QName;
import java.net.URL;

/**
 * Created by Rick on 13-4-2016.
 */
public class ApiManager {
    private static final QName SITA_SERVICE_NAME = new QName("http://cims.nl/", "SitaApi");

    public ApiManager() {
        URL sitaWsdlURL = SitaApi.WSDL_LOCATION;
        SitaApi sitaapisocket = new SitaApi(sitaWsdlURL, SITA_SERVICE_NAME);
        sitaPort = sitaapisocket.getSitaApiSoap12();
    }

    private String sitaToken = null;
    private SitaApiSoap sitaPort;

    public boolean loginSita(String username, String password){
        return false;
    }

    public boolean logoutSita(){
        return false;
    }

    public String getSitaToken(){
        return sitaToken;
    }

    public SitaApiSoap getSitaPort(){
        return sitaPort;
    }
}
