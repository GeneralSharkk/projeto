package POOProjeto;

import java.util.Scanner;
import Info.Candidate;
import Info.Candidates;
import Info.County;
import Info.Tables;
import Reader.Reader;
import Votes.CountyElection;
import Votes.DistrictElection;
import Votes.ParishElection;

/**
 * Class que representa um Menu.
 * 
 * @author henri
 */
public class Menu {

    private final Scanner reader;
    private AutharcicElection autharcicElection;
    private EuropeanElection europeanElection;
    private PresidentialElection presidentialElection;
    private LegislativeElection legislativeElection;
    private Reader readerFile;
    private Tables tables;

    /**
     * Constroí um Menu.
     */
    public Menu(){
        reader = new Scanner(System.in);
        readerFile = new Reader();
        tables = new Tables();
        tables.setTables(readerFile.readTables());
    }
    
    /**
     * Menu principal.
     */
    public void mainMenu(){

        boolean stop = false;
        do{
            System.out.println("\n\tProcesso Eleitoral");
            System.out.println("1. Presidenciais");
            System.out.println("2. Legislativas");
            System.out.println("3. Europeias");
            System.out.println("4. Autárquicas");
            System.out.println("0. Sair");
            System.out.print("opcao: ");
            
            int option = reader.nextInt();

            switch(option){
                case 1:
                    presidentialMenu();
                    break;
                case 2:
                    legislativeMenu();
                    break;
                case 3:
                    europeanMenu();
                    break;
                case 4:
                    autharcicMenu();
                    break;
                case 0:
                    stop = true;
                    reader.close();
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(!stop);
    }

    /**
     * Menu das autarquicas.
     */
    private void autharcicMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tAutárquicas");
            System.out.println("1. Criar eleição");
            System.out.println("2. Acabar eleição");
            System.out.println("3. Carregar meses");
            System.out.println("4. Carregar votos");
            System.out.println("5. Número de votos por mesa");
            System.out.println("6. Assembleia Municipal");
            System.out.println("7. Câmara Municipal");
            System.out.println("8. Assembleia de Freguesias");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");

            int option = reader.nextInt();

            switch(option){
                case 1:
                    if(autharcicElection == null){
                        System.out.println("\nQual o concelho da eleição?");
                        System.out.print("concelho: ");

                        String countyString = reader.next();
                        County county = new County(countyString);
                        
                        autharcicElection = new AutharcicElection(county);
                        break;
                    }
                    System.out.println("Já está a decorrer uma eleição.");
                    break;
                case 2:
                    if(autharcicElection != null){
                        autharcicElection = null;
                        System.out.println("Eleiçao terminada.");
                        break;
                    }
                    System.out.println("Não está a decorrer nunhuma eleição.");
                    break;
                case 3:
                    if(autharcicElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\nCarregado com sucesso");
                    autharcicElection.LoadTables(tables);
                    break;
                case 4:
                    if(autharcicElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\nCarregado com sucesso");
                    CountyElection c = new CountyElection();
                    c.setVotes(readerFile.readCountiesVotes());

                    DistrictElection d = new DistrictElection();
                    d.setVotes(readerFile.readDistrictVotes());
                    
                    ParishElection p = new ParishElection();
                    p.setVotes(readerFile.readParishesVotes());

                    autharcicElection.LoadVotes(c, d, p);
                    break;
                case 5:
                    System.out.println("\n" + autharcicElection.numberOfCandidatesPerTable());
                    break;
                case 6:
                    if(autharcicElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    districtElectionMenu();
                    break;
                case 7:
                    if(autharcicElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    countyElectionMenu();
                    break;
                case 8:
                    if(autharcicElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    parishElectionMenu(); 
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(!stop);
    }

    /**
     * Menu dos distritos.
     */
    private void districtElectionMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tAssembleia Municipal");
            System.out.println("1. Calcular Mandatos");
            System.out.println("2. Calcular Votos e Percetangens");
            System.out.println("3. Calcular Taxa de absenção");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");

            int option = reader.nextInt();

            switch(option){
                case 1:
                    System.out.println("\n---------------------------------------------");
                    System.out.println(autharcicElection.calculateMandates(1));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 2:
                    System.out.println("\n---------------------------------------------");
                    System.out.println(autharcicElection.numberOfVotesAndPercentage(1));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + autharcicElection.calculateAbstentionRate(1));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(!stop);
    }

    /**
     * Menu dos concelhos.
     */
    private void countyElectionMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tCâmara Municipal");
            System.out.println("1. Calcular Mandatos");
            System.out.println("2. Calcular Votos e Percetangens");
            System.out.println("3. Calcular Taxa de absenção");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");

            int option = reader.nextInt();

            switch(option){
                case 1:
                    System.out.println("\n---------------------------------------------");
                    System.out.println(autharcicElection.calculateMandates(2));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 2:
                    System.out.println("\n---------------------------------------------");
                    System.out.println(autharcicElection.numberOfVotesAndPercentage(2));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + autharcicElection.calculateAbstentionRate(2));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(!stop);
    }

    /**
     * Menu das freguesias.
     */
    private void parishElectionMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tAssembleia de Freguesias");
            System.out.println("1. Calcular Mandatos");
            System.out.println("2. Calcular Votos e Percetangens");
            System.out.println("3. Calcular Taxa de absenção");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");

            int option = reader.nextInt();

            switch(option){
                case 1:
                    System.out.println("\n---------------------------------------------");
                    System.out.println(autharcicElection.calculateMandates(3));
                    break;
                case 2:
                    System.out.println("\n---------------------------------------------");
                    System.out.println(autharcicElection.numberOfVotesAndPercentage(3));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + autharcicElection.calculateAbstentionRate(3));
                    System.out.println("---------------------------------------------\n");
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(!stop);
    }

    /**
     * Menu das europeias.
     */
    private void europeanMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tEuropeias");
            System.out.println("1. Criar eleição");
            System.out.println("2. Acabar eleição");
            System.out.println("3. Calcular Mandatos");
            System.out.println("4. Calcular Votos e Percetangens");
            System.out.println("5. Calcular Taxa de absenção");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");

            int option = reader.nextInt();

            switch(option){
                case 1:
                    if(europeanElection == null){
                        System.out.print("\nQuantos partidos vão participar? -> ");
                        int option2 = reader.nextInt();

                        int mandates = 0;
                        String[] politicalParty = new String[option2];
                        int[] votes = new int[option2];

                        for(int i = 0; i < option2; i++){
                            int temp = i + 1;
                            System.out.print("\nNome do partido nº" + temp + ": ");
                            String name = reader.next() + reader.nextLine();
                            politicalParty[i] = name;

                        }

                        for(int i = 0; i < option2; i++){
                            System.out.print("\nNúmero de votos do partido " + politicalParty[i] + ": ");
                            int numberVotes = reader.nextInt();
                            votes[i] = numberVotes;
                        }
                        
                        System.out.print("\nNúmero de Mandatos: ");
                        mandates = reader.nextInt();

                        europeanElection = new EuropeanElection(politicalParty, votes, mandates);
                        break;
                    }
                    System.out.println("Já está a decorrer uma eleição.");
                    break;
                case 2:
                    if(europeanElection != null){
                        europeanElection = null;
                        System.out.println("Eleiçao terminada.");
                        break;
                    }
                    System.out.println("Não está a decorrer nunhuma eleição.");
                    break;
                case 3:
                    if(europeanElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + europeanElection.calculateMandates());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 4:
                    if(europeanElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + europeanElection.numberOfVotesAndPercentage());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 5:
                    if(europeanElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + europeanElection.calculateAbstentionRate());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }

        }while(!stop);
    }

    /**
     * Menu das legislativas.
     */
    private void legislativeMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tLegislativas");
            System.out.println("1. Criar eleição");
            System.out.println("2. Acabar eleição");
            System.out.println("3. Calcular Mandatos");
            System.out.println("4. Calcular Votos e Percetangens");
            System.out.println("5. Calcular Taxa de absenção");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");

            int option = reader.nextInt();

            switch(option){
                case 1:
                    if(legislativeElection == null){
                        System.out.print("\nQuantos partidos vão participar? -> ");
                        int option2 = reader.nextInt();

                        int mandates = 0;
                        String[] politicalParty = new String[option2];
                        int[] votes = new int[option2];

                        for(int i = 0; i < option2; i++){
                            int temp = i + 1;
                            System.out.print("\nNome do partido nº" + temp + ": ");
                            String name = reader.next() + reader.nextLine();
                            politicalParty[i] = name;

                        }

                        for(int i = 0; i < option2; i++){
                            System.out.print("\nNúmero de votos do partido " + politicalParty[i] + ": ");
                            int numberVotes = reader.nextInt();
                            votes[i] = numberVotes;
                        }
                        
                        System.out.print("\nNúmero de Mandatos: ");
                        mandates = reader.nextInt();

                        legislativeElection = new LegislativeElection(politicalParty, votes, mandates);
                        break;
                    }
                    System.out.println("Já está a decorrer uma eleição.");
                    break;
                case 2:
                    if(legislativeElection != null){
                        legislativeElection = null;
                        System.out.println("Eleiçao terminada.");
                        break;
                    }
                    System.out.println("Não está a decorrer nunhuma eleição.");
                    break;
                case 3:
                    if(legislativeElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + legislativeElection.calculateMandates());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 4:
                    if(legislativeElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + legislativeElection.numberOfVotesAndPercentage());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 5:
                    if(legislativeElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + legislativeElection.calculateAbstentionRate());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }

        }while(!stop);
    }

    /**
     * Menu das presidenciais.
     */
    private void presidentialMenu(){
        boolean stop = false;
        do{
            System.out.println("\n\tPresidenciais");
            System.out.println("1. Criar eleição");
            System.out.println("2. Acabar eleição");
            System.out.println("3. Declarar Vencedor");
            System.out.println("4. Calcular Votos e Percetangens");
            System.out.println("5. Calcular Taxa de absenção");
            System.out.println("0. Voltar");
            System.out.print("opcao: ");


            int option = reader.nextInt();

            switch(option){
                case 1:
                    if(presidentialElection == null){
                        System.out.print("\nQuantos candidatos vão participar? -> ");

                        int option2 = 0;

                        try {
                            int test = reader.nextInt();
                            option2 = test;
                        }catch (Exception e){
                            System.out.println("Opção inválida.\n");
                        }

                        Candidates candidates = new Candidates();
                        System.out.println("");

                        for(int i = 0; i < option2; i++){
                            int temp = i + 1;
                            System.out.print("Nome do candidato nº" + temp + ": ");
                            String name = reader.next() + reader.nextLine();
                            System.out.print("Data de nascimento do candidato nº" + temp + "(YYYY-MM-dd): ");
                            String dateOfBirth = reader.next() + reader.nextLine();
                            System.out.print("Votos do candidato nº" + temp + ": ");
                            int votes = reader.nextInt();
                            Candidate candidate = new Candidate(name, dateOfBirth, votes);
                            if(candidate.getAge() < 35){
                                System.out.println("Candidato não tem idade suficiente, tente outra vez.");
                                i--;
                            }else{
                                candidates.addCandidate(candidate);
                            }
                            System.out.println("---------------------------------------------");
                        }

                        presidentialElection = new PresidentialElection(candidates);
                        break;
                    }
                    System.out.println("Já está a decorrer uma eleição.");
                    break;
                case 2:
                    if(presidentialElection != null){
                        presidentialElection = null;
                        System.out.println("Eleiçao terminada.");
                        break;
                    }
                    System.out.println("Não está a decorrer nunhuma eleição.");
                    break;
                case 3:
                    if(presidentialElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + presidentialElection.declareWinner());
                    System.out.println("\n---------------------------------------------\n");
                    break;
                case 4:
                    if(presidentialElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + presidentialElection.numberOfVotesAndPercentage());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 5:
                    if(presidentialElection == null){
                        System.out.println("Não está a decorrer nunhuma eleição.");
                        break;
                    }
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n" + presidentialElection.calculateAbstentionRate());
                    System.out.println("---------------------------------------------\n");
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while(!stop);
    }
}
