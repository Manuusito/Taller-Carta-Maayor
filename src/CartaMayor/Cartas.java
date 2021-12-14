package CartaMayor;

import java.util.Random;

public class Cartas {
    private int numeroCarta;

    public int getNumeroCarta(){
        Random aleatorio = new Random();
        numeroCarta = aleatorio.nextInt(12)+1;
        while (numeroCarta == 8 || numeroCarta == 9){
            numeroCarta = aleatorio.nextInt(12)+1;
        }
        return numeroCarta;

    }

    private int paloCarta;

    public int getPaloCarta(){
      Random aleatorio = new Random();
      paloCarta = aleatorio.nextInt(4)+1;
      return paloCarta;
    }

    //public int getNumeroCarta() {
    //    List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 11, 12);
    //    Random rand = new Random();
    //    return givenList.get(rand.nextInt(givenList.size()));
    //}

  // public int getPaloCarta() {
  //      String palos[] = {"Oros", "Copas", "Espadas", "Bastos"};
    //    Random Palo = new Random();
      //  return Palo.nextInt(4);
    //}

}
