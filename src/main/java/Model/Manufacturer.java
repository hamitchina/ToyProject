package Model;

/**
 * Created by Yelena_Khamitchina on 27.11.2016.
 */
public class Manufacturer {
    private String manufacturerName;
    private String mafacturerCountry;

    public Manufacturer (){}

    public Manufacturer(String manufacturerName, String mafacturerCountry) {
        this.manufacturerName = manufacturerName;
        this.mafacturerCountry = mafacturerCountry;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getMafacturerCountry() {
        return mafacturerCountry;
    }

    public void setMafacturerCountry(String mafacturerCountry) {
        this.mafacturerCountry = mafacturerCountry;
    }

    @Override
    public String toString() {
        return (" Manufacturer " + manufacturerName +
                ", Country of manufacturing " + mafacturerCountry + " ");


    }
}
