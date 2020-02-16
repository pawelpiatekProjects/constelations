import java.io.*;
import java.util.ArrayList;

public class SuperClass implements Serializable {
    public Star[] superArr;
    public ArrayList<Star> stars = new ArrayList<Star>();
    public String [] greekAlphabet = new String[]{"new",
            "\u0391", "\u0392", "\u0393", "\u0394", "\u0395", "\u0396", "\u0397", "\u0398", "\u0399", "\u039A", "\u039B",
            "\u039C", "\u039D", "\u039E", "\u039F", "\u03A0", "\u03A1", "\u03A3", "\u03A4", "\u03A5", "\u03A6", "\u03A7",
            "\u03A8", "\u03A9",
    };

    public SuperClass(){
        this.superArr = new Star[100];
    }

    //wyświetlanie wszystkich gwaizd na liście
    public void print(){
        for(int i=0;i<stars.size();i++){
            System.out.println("Nazwa: "+ this.stars.get(i).getName());
            System.out.println("Nazwa katalogowa: "+ this.stars.get(i).getCatalogName());
            System.out.println("Deklinacja: "+ this.stars.get(i).getDeclination());
            System.out.println("Raktasencja: "+ this.stars.get(i).getRectasenction());
            System.out.println("Obserwowana wielkosc: "+ this.stars.get(i).getObservedSize());
            System.out.println("Wielkosc: "+ this.stars.get(i).getSize());
            System.out.println("Odleglosc: "+ this.stars.get(i).getDistance());
            System.out.println("Konstelacja: "+ this.stars.get(i).getConstellation());
            System.out.println("Polkula: "+ this.stars.get(i).getHemiSphere());
            System.out.println("Temperatura: "+ this.stars.get(i).getTemperture());
            System.out.println("Masa: "+ this.stars.get(i).getMass());
            System.out.println("----------------------");
        }
    }


    public String toString(){
        String result= "";
        for(int i=0;i<this.superArr.length;i++){
            result = result + this.superArr[i].getName();
        }
        return result;
    }

    //Dodawanie nowej gwiazdy do listy
   public void addToList(Star temp){
        this.stars.add(temp);
   }

   //Usuwanie gwiazdy
    public void RemoveStar(String name) {
        int index = -1;
        String constelationName = "";
        int constelationcounter = 0;
        for (int i = 0; i < stars.size(); i++) {
            if (ProjectMethods.CompareTo(name, this.stars.get(i).getName())) {
                index = i;
            }
        }
        constelationName = this.stars.get(index).getConstellation();
        if (index >= 0) {
            this.stars.remove(index);
        } else {
            System.out.println("Podana gwiazda nie istnieje");
        }
        for(int i=0;i<this.stars.size();i++){
            Star tempStar = this.stars.get(i);
            if(ProjectMethods.CompareTo(this.stars.get(i).getConstellation(),constelationName)){
                tempStar.setCatalogName( this.greekAlphabet[constelationcounter+1]+constelationName);
                constelationcounter++;
                this.stars.set(i, tempStar);
            }
        }

    }

    //Wyswietlanie gwiazdy po indeksie
    public void getStar(int i) {
        System.out.println("Nazwa: " + this.stars.get(i).getName());
        System.out.println("Nazwa katalogowa: " + this.stars.get(i).getCatalogName());
        System.out.println("Deklinacja: " + this.stars.get(i).getDeclination());
        System.out.println("Rektasencja: " + this.stars.get(i).getRectasenction());
        System.out.println("Obserwowana wielkosć : " + this.stars.get(i).getObservedSize());
        System.out.println("Absolutna wielkosć : " + this.stars.get(i).getSize());
        System.out.println("Odległość : " + this.stars.get(i).getDistance());
        System.out.println("Konstelacja : " + this.stars.get(i).getConstellation());
        System.out.println("Półkula : " + this.stars.get(i).getHemiSphere());
        System.out.println("Temperatura : " + this.stars.get(i).getTemperture());
        System.out.println("Masa : " + this.stars.get(i).getMass());
    }

    //Metoda pomocnicza służąca do wyświetlania tablicy gwiazd spełniających dane kryterium
    //np. przynależność do danej konstelacji
    public void getStar(Star[] temp, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println("Nazwa: " + temp[i].getName());
            System.out.println("Nazwa katalogowa: " + this.stars.get(i).getCatalogName());
            System.out.println("Deklinacja: " + temp[i].getDeclination());
            System.out.println("Rektesencja: " + temp[i].getRectasenction());
            System.out.println("Obsrwowana wielkość: " + temp[i].getObservedSize());
            System.out.println("Absolutna wielkość: " + temp[i].getSize());
            System.out.println("Konstelacja: " + this.stars.get(i).getConstellation());
            System.out.println("Półkula: " + temp[i].getHemiSphere());
            System.out.println("Temperatura: " + temp[i].getTemperture());
            System.out.println("Masa: " + temp[i].getMass());
            System.out.println("-------------------------------------------------");
        }
    }

    //Metoda służąca do wyszukiwania gwiazd należących do tego samego gwiazdozbioru
    public void findStarsInConstelation(String constelationName) {
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            String tempConstelationName = this.stars.get(i).getConstellation();
            if (ProjectMethods.CompareTo(tempConstelationName, constelationName)) {
                temp[counter] = stars.get(i);
                System.out.print("obiekt: " + this.stars.get(i).getConstellation() + " ");
                System.out.println("atrybut metody: " + constelationName);
                counter++;
            }
        }
        this.getStar(temp, counter);
    }


    //Metoda służąca do pobierania greckiej litery dla odpowiedniej gwiazdy
    public String getGreek(String constelationName){
        String letter = this.greekAlphabet[0];
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            String tempConstelationName = this.stars.get(i).getConstellation();
            if (ProjectMethods.CompareTo(tempConstelationName, constelationName)) {
                temp[counter] = stars.get(i);
                System.out.print("obiekt: " + this.stars.get(i).getConstellation() + " ");
                System.out.println("atrybut metody: " + constelationName);
                counter++;
            }
        }
        int newNumber = counter+1;
        letter = greekAlphabet[newNumber];
        return letter;
    }

    //Metoda służąca do wyszukiwania gwiazd w podanej odległości
    public void findByDistance(double distance){
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            if (this.stars.get(i).getDistance() == distance) {
                temp[counter] = stars.get(i);
                counter++;
            }
        }
        this.getStar(temp, counter);
    }

    //Metoda służąca do wyszukiwania gwiazd o podanej temperaturze
    public void findByTemperature(double begin, double end) {
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            if (this.stars.get(i).getTemperture() >= begin && this.stars.get(i).getTemperture() <= end) {
                temp[counter] = stars.get(i);
                counter++;
            }
        }
        this.getStar(temp, counter);
    }

    //Metoda służąca do wyszukiwania gwiazd o podanym rozmiarze
    public void findBySize(double begin, double end) {
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            if (this.stars.get(i).getObservedSize() >= begin && this.stars.get(i).getObservedSize() <= end) {
                temp[counter] = stars.get(i);
                counter++;
            }
        }
        this.getStar(temp, counter);
    }

    //Metoda służąca do wyszukiwania gwiazd na podanej półkuli
    public void findByHemiSphere(String hemisphere) {
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            if (ProjectMethods.CompareTo(this.stars.get(i).getHemiSphere(), hemisphere)){
                temp[counter] = stars.get(i);
                counter++;
            }
        }
        this.getStar(temp, counter);
    }

    //Metoda służąca do wyszukiwania potencjalnych supernowych
    public void findSupernova() {
        Star[] temp = new Star[this.stars.size()];
        int counter = 0;
        for (int i = 0; i < stars.size(); i++) {
            if (this.stars.get(i).getMass() >= 1.44d) {
                temp[counter] = stars.get(i);
                counter++;
            }
        }
        this.getStar(temp, counter);
    }

    //--------------------------------------------------------------
    //Zapisywanie i odczytywanie z pliku
    //--------------------------------------------------------------


    //Zapisywanie do pliku
    public int saveArrToObject(ArrayList<Star>list, String fileName){
        int result = 0;

        ObjectOutputStream stream = null;
        try{
            stream = new ObjectOutputStream(new FileOutputStream("./"+fileName+".obj"));
            SuperClass temp = new SuperClass();
            for(int i=0;i<list.size();i++){
                temp.stars.add(list.get(i));
            }
            stream.writeObject(temp);
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
            result = -1;
        }

        return result;

    }

    //Odczyytywanie z pliku
    public int readFromObj(String fileName)
    {
        int result = 0;
        ObjectInputStream stream = null;
        try{
            stream = new ObjectInputStream(new FileInputStream("./"+fileName+".obj"));
            Object obj = null;
            while((obj = stream.readObject())!=null)
            {
                SuperClass temp = new SuperClass();
                temp = (SuperClass)obj;
                for(int i=0;i<temp.stars.size();i++)
                {
                    this.stars.add(temp.stars.get(i));

                }
            }

            stream.close();
        }catch (EOFException ex){

        } catch (Exception e){
            e.printStackTrace();
            result = -1;
        }

        return result;
    }
}
