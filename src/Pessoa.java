import java.util.ArrayList;

abstract class Pessoa {

    public Pessoa() {
        ladoParaTravessia.add(this);
    }

    static ArrayList<Pessoa> ladoPosTravessia = new ArrayList<>(11);
    static ArrayList<Pessoa> ladoParaTravessia = new ArrayList<>(11);
    static ArrayList<Pessoa> barco = new ArrayList<>(2);

    public static void Mapa() {
        System.out.println("|==========================|");
        System.out.println(
                "|"+verificaPosicao(ladoPosTravessia.get(0))+"´"
                +verificaPosicao(ladoPosTravessia.get(1))+"´"
                +verificaPosicao(ladoPosTravessia.get(2))+
                "´| ~  ~   ~   |´"
                +verificaPosicao(ladoParaTravessia.get(0))+"´"
                +verificaPosicao(ladoParaTravessia.get(1))+"´"
                +verificaPosicao(ladoParaTravessia.get(2))+"|"
                +
                "\n|"+verificaPosicao(ladoPosTravessia.get(3))+"´"
                +verificaPosicao(ladoPosTravessia.get(4))+"´"
                +verificaPosicao(ladoPosTravessia.get(5))+
                "´|     ~   ~  |´"
                +verificaPosicao(ladoParaTravessia.get(3))+"´"
                +verificaPosicao(ladoParaTravessia.get(4))+"´"
                +verificaPosicao(ladoParaTravessia.get(5))+"|"
                +
                "\n|"+verificaPosicao(ladoPosTravessia.get(6))+"´"
                +verificaPosicao(ladoPosTravessia.get(7))+"´"
                +verificaPosicao(ladoPosTravessia.get(8))+
                "´|  ~  ~ {"+verificaPosicao(barco.get(0))+verificaPosicao(barco.get(1))+"] |´"
                +verificaPosicao(ladoParaTravessia.get(6))+"´"
                +verificaPosicao(ladoParaTravessia.get(7))+"´"
                +verificaPosicao(ladoParaTravessia.get(8))+"|"
                +
                "\n|"+verificaPosicao(ladoPosTravessia.get(9))+"´"
                +verificaPosicao(ladoPosTravessia.get(10))+"´"
                +verificaPosicao(ladoPosTravessia.get(11))+
                "´| ~   ~    ~ |´"
                +verificaPosicao(ladoParaTravessia.get(9))+"´"
                +verificaPosicao(ladoParaTravessia.get(10))+"´"
                +verificaPosicao(ladoParaTravessia.get(11))+"|");
        System.out.println("|==========================|");
    }

    public static String verificaPosicao(Pessoa pessoa){
        if(pessoa==null){
            return ",";
        }else {
            return pessoa.getIcon();
        }
    }

    public static void inicializaArray(){
        for (int i = 0; i < 12; i++) {
            ladoParaTravessia.add(null);
            ladoPosTravessia.add(null);
            if(i<2){
                barco.add(null);
            }
        }
    }

    public static void listaPessoa(boolean barco) {
        if(!barco){
            for (Pessoa pessoa:
                 ladoParaTravessia) {
                if(pessoa!=null){
                    System.out.println("["+ladoParaTravessia.indexOf(pessoa)+"] "+pessoa.getIcon());
                }
            }
        }else {
            for (Pessoa pessoa:
                    ladoPosTravessia) {
                if(pessoa!=null) {
                    System.out.println("[" + ladoPosTravessia.indexOf(pessoa) + "] " + pessoa.getIcon());
                }
            }
        }
    }

    public static void listaJangada() {
            for (Pessoa pessoa:
                    barco) {
                if(pessoa!=null){
                    System.out.println("["+barco.indexOf(pessoa)+"] "+pessoa.getIcon());
                }
            }
    }


    abstract String getIcon();
}
