package CartaMayor;
// Asignamos el tipo de Palo a numeros
// 4 es Oro
// 3 es Copas
// 2 es Espadas
// 1 Bastos

public class ModelCard {
    private Cartas carta1;
    private Cartas carta2;
    private String palo1, palo2;
    private int estado;
    private String[] estadoToString;
    private int[] user,ia;


    public ModelCard(){
        user = new int[2];
        ia = new int[2];
        carta1 = new Cartas();
        carta2 = new Cartas();
        estadoToString = new String[2];
        palo1 = new String();
        palo2 = new String();
    }

    public void calcularTiro(){
        user[0]=carta1.getNumeroCarta();
        user[1]=carta1.getPaloCarta();
        ia[0]=carta2.getNumeroCarta();
        ia[1]=carta2.getPaloCarta();
    }



    public void determinarJuego(){
        if (user[0] > ia[0]){
            estado = 1;

        }
        if (user[0] < ia[0]){
            estado = 2;
        }
        else{
            determinarPalo();
            if (user[0]==ia[0] && user[1]>ia[1]){
                estado = 3;
            }
            if (user[0]==ia[0] && user[1]<ia[1]){
                estado = 4;
            }

        }


    }


    public void determinarPalo(){
        if(user[1]==1){
            palo1= "Bastos";
        }
        if (user[1]==2){
            palo1= "Espadas";
        }
        if (user[1]==3){
            palo1= "Copas";
        }
        if (user[1]==4){
            palo1= "Oros";
        }
        if(ia[1]==1){
            palo2= "Bastos";
        }
        if (ia[1]==2){
            palo2= "Espadas";
        }
        if (ia[1]==3){
            palo2= "Copas";
        }
        if (ia[1]==4){
            palo2= "Oros";
        }
    }


    public String[] getEstadoToString(){
        switch(estado) {
            case 1:
                estadoToString[0] = "Tu carta es =" + user[0]
                +"\nCarta de la maquina es =" + ia[0];
                estadoToString[1] = "¡Sacaste la carta mayor, has ganado!";
                break;
            case 2:
                estadoToString[0] = "Tu carta es =" + user[0]
                +"\nCarta de la maquina es =" + ia[0];
                estadoToString[1] = "¡Sacaste la carta menor, has perdido!";
                break;
            case 3:
                estadoToString[0] = "Tu carta es =" + user[0]
                        +"\nCarta de la maquina es =" + ia[0];
                estadoToString[1] = "Empataste el valor!, el juego se definirá por Palos"
                        +"\n Tu Palo: "+palo1+ " Palo de la maquina: "+ palo2
                +"\nGanaste";
                break;
            case 4:
                estadoToString[0] = "Tu carta es =" + user[0]
                        +"\nCarta de la maquina es =" + ia[0];
                estadoToString[1] = "Empataste el valor!, el juego se definirá por Palos"
                        +"\n Tu Palo: "+palo1+ " Palo de la maquina: "+ palo2
                        +"\nPerdiste";
                break;

    }
    return estadoToString;

    }
}