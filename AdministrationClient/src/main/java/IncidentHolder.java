import SitaApi.Incident;

/**
 * Created by frank on 30/03/2016.
 */
class IncidentHolder {
    private static IncidentHolder singleTon = new IncidentHolder();
    private static Incident incident;
    public IncidentHolder() {
        incident = null;
    }

    /**
     * Get the current active incident
     * @return the current incident
     */
    public static Incident getIncident() {
        return incident;
    }

    /**
     * Set the current active incident
     * @param incident The incident
     */
    public static void setIncident(Incident incident) {
        incident = incident;
    }

    /**
     * Clear the current incident
     */
    public static void clearIncident() {
        incident = null;
    }
}
