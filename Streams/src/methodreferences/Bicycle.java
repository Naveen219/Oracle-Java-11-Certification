package methodreferences;

public class Bicycle {
    private String brand;
    private Integer frameSize;

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }

    public Bicycle(String brand, Integer frameSize) {
        this.brand = brand;
        this.frameSize = frameSize;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(Integer frameSize) {
        this.frameSize = frameSize;
    }


    @Override
    public String toString() {
        return "Bicycle{" +
                "brand='" + brand + '\'' +
                ", frameSize=" + frameSize +
                '}';
    }
}