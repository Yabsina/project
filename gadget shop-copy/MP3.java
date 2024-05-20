// MP3 class
public class MP3 extends Gadget {
    // Additional attribute
    private int availableMemory;

    // Constructor
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    // Accessor method for availableMemory
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Method to download music
    public void downloadMusic(int downloadSize) {
        if (downloadSize <= availableMemory) {
            availableMemory -= downloadSize;
            System.out.println("Music downloaded successfully.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    // Method to delete music
    public void deleteMusic(int deleteSize) {
        availableMemory += deleteSize;
        System.out.println("Music deleted successfully.");
    }

    // Override display method to include availableMemory
    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}
