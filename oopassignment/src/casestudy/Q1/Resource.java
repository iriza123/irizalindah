package casestudy.Q1;

public class Resource {
    private String resourceId;
    private String resourceName;
    private int quantity;
    private String resourceType;

    // Constructor
    public Resource() {

    }

    // Getters and Setters
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    // Display Resource Details
    public void displayResourceDetails() {
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Resource Name: " + resourceName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Resource Type: " + resourceType);
    }
}