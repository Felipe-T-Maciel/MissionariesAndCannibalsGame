import java.util.ArrayList;

abstract class Pessoa {

    public Pessoa() {
        ladoParaTravessia.add(this);
    }

    static ArrayList<Pessoa> ladoPosTravessia = new ArrayList<>(11);
    static ArrayList<Pessoa> ladoParaTravessia = new ArrayList<>(11);
    static ArrayList<Pessoa> barco = new ArrayList<>(2);

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
