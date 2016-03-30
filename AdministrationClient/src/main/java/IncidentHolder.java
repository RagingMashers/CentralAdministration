/**
 * Created by frank on 30/03/2016.
 */
public class IncidentHolder {
    private static IncidentHolder singleTon = new IncidentHolder();
    private static String incident;
    public IncidentHolder() {
        incident = "";
    }

    /**
     * Get the current active incident
     * @return the current incident
     */
    public static String getIncident() {
        return incident;
    }

    /**
     * Set the current active incident
     * @param name the name of the incident
     */
    public static void setIncident(String name) {
        incident = name;
    }

    /**
     * Clear the current incident
     */
    public static void clearIncident() {
        incident = "";
    }
}
