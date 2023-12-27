
/**
 * The FurnitureType enum class represents distinct furniture types and their corresponding recommended rooms.
 * Each enum constant defines a specific furniture type along with its recommended placement.
 * Example: Sofa -> Living Room, Table -> Dining or Living Room, Chair -> Bedroom or Office or Living Room
 */
public enum FurnitureType {
    SOFA("Living Room"),
    TABLE("Dining Room or Living Room"),
    CHAIR("Living Room, Bedroom, or Office"),
    UNKNOWN("No specific recommendation");

    private final String recommendedRoom;

    FurnitureType(String recommendedRoom) {
        this.recommendedRoom = recommendedRoom;
    }
    
    /**
     * Retrieves the recommended room for the specific furniture type.
     *
     * @return the recommended room for the furniture type
     */
    public String getRecommendedRoom() {
        return recommendedRoom;
    }
}
