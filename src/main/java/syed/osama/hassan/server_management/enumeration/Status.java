package syed.osama.hassan.server_management.enumeration;

/**
 *
 * @author Syed Osama Hassan
 */
public enum Status
{
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
}
