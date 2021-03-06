import java.io.*;

public class Star implements Serializable {
    private String name;
    private String catalogName;
    private double declination;
    private double rectasenction;
    private double observedSize;
    private double size;
    private double distance;
    private String constellation; //todo change to Constellation class
    private String hemiSphere;
    private double temerature;
    private double mass;
    //------------------------------------------------------

    //Getery i setery
    public String getName() { return this.name;}
    public String getCatalogName() { return this.catalogName;}
    public void setCatalogName(String catalogName){ this.catalogName = catalogName;}
    public double getDeclination() { return this.declination;}
    public double getRectasenction() { return this.rectasenction;}
    public double getObservedSize() { return this.observedSize;}
    public double getSize() { return this.size;}
    public double getDistance() { return this.distance;}
    public String getConstellation() { return this.constellation;}
    public String getHemiSphere() { return this.hemiSphere;}
    public double getTemperture() { return this.temerature;}
    public double getMass() { return this.mass;}
    //------------------------------------------------------

    //Konstruktor domyślny
    public Star() {
        this.name = "randomStar";
        this.catalogName = "randomCatalogName";
        this.declination = 10;
        this.rectasenction = 10;
        this.observedSize = 4;
        this.size = 20000;
        this.constellation = "randomConstelation";
        this.hemiSphere = "south";
        this.temerature = 34211;
        this.mass = 23451;
    }


    //Konstruktor
    public Star(String name, String catalogName,  double declination, double rectasenction, double observedSize,
                double distance, String constellation, String hemiSphere, double temerature, double mass) {
        this.constellation = constellation;
        setName(name);
        this.catalogName = catalogName;
        setDeclination(declination);
        setRectasenction(rectasenction);
        setObservedSize(observedSize);
        this.distance = distance;
        this.size = this.observedSize - (5*Math.log1p(0)*this.distance*3.26d)+5;
        this.hemiSphere = hemiSphere;
        this.temerature = temerature > 2000 ? temerature : 2000;
        setMass(mass);
    }

    //Konstruktor kopiujący
    public Star(Star star){
        this.name = star.name;
        this.catalogName = star.catalogName;
        this.declination = star.declination;
        this.rectasenction = star.rectasenction;
        this.observedSize = star.observedSize;
        this.size = star.size;
        this.distance = star.distance;
        this.constellation = star.constellation;
        this.hemiSphere = star.hemiSphere;
        this.temerature = star.temerature;
        this.mass = star.mass;
    }

    //--------------------------------------
    //Metody wykorzystwane do sprawdzania warunków w konstrukotrze
    //--------------------------------------
    //sprawdzanie i ustawianie nazwy
    private void setName(String name) {
        if (ProjectMethods.Contains(name)) {
            this.name = name;
        } else {
            this.name = "AAA1234";
        }
    }

    //sprawdzanie i ustawianie deklinacji
    private void setDeclination(double declination) {
        if(this.hemiSphere == "PN"){
            if(declination>=0 && declination<=90){
                this.declination = declination;
            }
        }else if(this.hemiSphere == "PD"){
            if(declination<=0 && declination>=-90){
                this.declination = declination;
            }
        }else{
            this.declination = 0;
        }
    }

    //sprawdzanie i ustawianie rektasencji
    private void setRectasenction(double rectasenction){
        if(rectasenction>=0 && rectasenction<=24){
            this.rectasenction = rectasenction;
        }else{
            this.rectasenction = 0;
        }
    }

    // //sprawdzanie i ustawianie onserwowanej wielkości
    private void setObservedSize(double observedSize){
        if(observedSize>=-26.74d && observedSize<=15.00d){
            this.observedSize = observedSize;
        }else{
            this.observedSize = -26.74d;
        }
    }

    //sprawdzanie i ustawianie masy
    private void setMass(double mass){
        if(mass >=0.1d && mass<=50d){
            this.mass = mass;
        }else{
            this.mass = 0.1d;
        }
    }




}


