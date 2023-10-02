
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static boolean barcoAEsquerda = false;
    public static void main(String[] args) {
        inicializaPessoa();
        int escolha = 0;
        do {
            System.out.print("""
                    --- Bem vindo ao minigame Travessia do Rio ---
                        
                        [1] Jogar
                        [2] Sair
                        
                    >\t""");
            escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> {
                    jogo();
                }
                case 2 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
            }
        }while (true);
    }

    private static void jogo(){
        int escolha = 0;
        do {
            verificaDerrota();
            System.out.print("""
                    --- Bem vindo ao minigame Travessia do Rio ---
                        
                        [1] Colocar uma pessoa na jangada
                        [2] Remover uma pessoa da jangada
                        [3] Mover Jangada
                        [4] Sair
                        
                    >\t""");
            escolha = sc.nextInt();
            switch (escolha){
                case 1-> {
                    try {
                        if(Pessoa.barco.size()<2) {
                            Pessoa.listaPessoa(barcoAEsquerda);
                            System.out.print("Escolha uma delas: ");
                            int escolhaPessoa = sc.nextInt();
                            if (escolhaPessoa >= 0 && escolhaPessoa < Pessoa.ladoParaTravessia.size() || escolhaPessoa < Pessoa.ladoPosTravessia.size()) {
                                if (Pessoa.ladoParaTravessia.contains(Pessoa.ladoParaTravessia.get(escolhaPessoa))) {
                                    Pessoa.barco.add(Pessoa.ladoParaTravessia.get(escolhaPessoa));
                                    Pessoa.ladoParaTravessia.remove(Pessoa.ladoParaTravessia.get(escolhaPessoa));
                                } else if (Pessoa.ladoPosTravessia.contains(Pessoa.ladoPosTravessia.get(escolhaPessoa))) {
                                    Pessoa.barco.add(Pessoa.ladoPosTravessia.get(escolhaPessoa));
                                    Pessoa.ladoPosTravessia.remove(Pessoa.ladoPosTravessia.get(escolhaPessoa));
                                } else {
                                    throw new IndiceEscolhidoInvalido();
                                }
                            }
                        }
                        else {
                            throw new BarcoCheioException();
                        }

                    }catch (IndiceEscolhidoInvalido | BarcoCheioException e){
                        System.err.println(e.getMessage());
                    }
                }
                case 2->{
                    try {
                        if (Pessoa.barco.size() == 0) {
                            throw new SemCondutorException();
                        } else {
                            System.out.println("Quem deseja remover da jangada: ");
                            Pessoa.listaJangada();
                            System.out.println("Sua escolha: ");
                            int escolhaPessoa = sc.nextInt();
                            if (Pessoa.barco.size()>escolhaPessoa && Pessoa.barco.contains(Pessoa.barco.get(escolhaPessoa))) {
                                if (barcoAEsquerda) {
                                    Pessoa.ladoPosTravessia.add(Pessoa.barco.get(escolhaPessoa));
                                } else {
                                    Pessoa.ladoParaTravessia.add(Pessoa.barco.get(escolhaPessoa));
                                }
                                Pessoa.barco.remove(Pessoa.barco.get(escolhaPessoa));
                            } else {
                                throw new IndiceEscolhidoInvalido();
                            }
                        }
                    }catch (IndiceEscolhidoInvalido | SemCondutorException e){
                        System.err.println(e.getMessage());
                    }
                }
                case 3-> {
                    try {
                        if (Pessoa.barco.size() >= 1) {
                            barcoAEsquerda = !barcoAEsquerda;
                        }else {
                            throw new SemCondutorException();
                        }
                    } catch (SemCondutorException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 4 -> {
                    return;
                }
            }
        }while (true);
    }

    private static void verificaDerrota() {
        int contMissionario = 0;
        int contCanibal = 0;

        if(barcoAEsquerda){
            for (Pessoa pessoa:Pessoa.ladoParaTravessia) {
                if(pessoa instanceof Canibal){
                    contCanibal++;
                }else if(pessoa instanceof Missionario){
                    contMissionario++;
                }
            }
        }else {
            for (Pessoa pessoa:Pessoa.ladoPosTravessia) {
                if(pessoa instanceof Canibal){
                    contCanibal++;
                }else if(pessoa instanceof Missionario){
                    contMissionario++;
                }
            }
        }
        try {
            if(contCanibal>contMissionario && contMissionario!=0){
                throw new PerdeuPlayboyException();
            }
            if(Pessoa.ladoPosTravessia.size()>=6){
                System.out.println("""
                        !!!!!!!!!!!!!!!!!!!!!!!!!!
                        !!!!!!!! PARABÉNS !!!!!!!!
                        !!!!!! VOCE VENCEU !!!!!!!
                        !!!!!!!!!!!!!!!!!!!!!!!!!!
                """);
            }
        }catch (PerdeuPlayboyException e){
            System.err.println(e.getMessage()+contCanibal);
            System.exit(0);
        }
    }

    private static void inicializaPessoa() {
        Pessoa missionario = new Missionario();
        Pessoa missionario2 = new Missionario();
        Pessoa missionario3 = new Missionario();
        Pessoa canibal = new Canibal();
        Pessoa canibal2 = new Canibal();
        Pessoa canibal3 = new Canibal();
    }

    private static void levarPessoa(Pessoa pessoa) {

    }
}
