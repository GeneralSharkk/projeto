package Reader;


import Info.Table;
import Votes.CountyVote;
import Votes.DistrictVote;
import Votes.ParishVote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class que lê os ficheiros .csv.
 *
 * @author henri
 */
public class Reader {
    
    private String tables;
    private String districtVotes;
    private String countiesVotes;
    private String parishesVotes;

    /**
     * Constroí um leitor de fiheiros csv.
     * Vai inicar todas as Strings com o path dos ficheiros no progama.
     */
    public Reader(){
        this.tables = "src/Reader/Mesas.csv";
        this.districtVotes = "src/Reader/VotosAssembleia.csv";
        this.countiesVotes = "src/Reader/VotosCamara.csv";
        this.parishesVotes = "src/Reader/VotosFreguesias.csv";
    }

    /**
     * Método que vai ler o ficheiro das mesas (Mesas.csv).
     * 
     * @return arrayList com todas as meses
     */
    public ArrayList<Table> readTables(){
        ArrayList<Table> all = new ArrayList<>();
        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(this.tables));
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");

                String stringId = values[0];
                String stringCouncilId = values[1];
                String council = values[2]; 
                String stringTableNumber = values[3];
                String stringNumberOfVoters= values[4];

                Table temp = new Table();

                int id = Integer.parseInt(stringId);
                temp.setId(id);

                int councilId = Integer.parseInt(stringCouncilId);
                temp.setCouncilId(councilId);

                temp.setCouncil(council);

                int tableNumber = Integer.parseInt(stringTableNumber);
                temp.setTableNumber(tableNumber);

                int numberOfVoters = Integer.parseInt(stringNumberOfVoters);
                temp.setNumberOfVoters(numberOfVoters);

                all.add(temp);
            }
            reader.close();
            
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * Método que vai ler o ficheiro dos votos da assemblia (VotosAssembleia.csv).
     * 
     * @return arrayList com totos os votos da assemblia
     */
    public ArrayList<DistrictVote> readDistrictVotes(){
        ArrayList<DistrictVote> all = new ArrayList<>();
        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(this.districtVotes));
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");

                String stringTableId = values[0];
                String council = values[1];
                String politicalParty = values[2]; 
                String stringNumberOfVotes = values[3];

                DistrictVote temp = new DistrictVote();

                int tableId = Integer.parseInt(stringTableId);
                temp.setTableId(tableId);

                temp.setCouncil(council);

                temp.setPoliticalParty(politicalParty);

                int numberOfVotes = Integer.parseInt(stringNumberOfVotes);
                temp.setNumberOfVotes(numberOfVotes);

                all.add(temp);
            }
            reader.close();
            
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * Método que vai ler o ficheiro dos votos da camera (VotosCamara.csv).
     * 
     * @return arrayList com totos os votos da camera
     */
    public ArrayList<CountyVote> readCountiesVotes(){
        ArrayList<CountyVote> all = new ArrayList<>();
        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(this.countiesVotes));
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");

                String stringTableId = values[0];
                String council = values[1];
                String politicalParty = values[2]; 
                String stringNumberOfVotes = values[3];

                CountyVote temp = new CountyVote();

                int tableId = Integer.parseInt(stringTableId);
                temp.setTableId(tableId);

                temp.setCouncil(council);

                temp.setPoliticalParty(politicalParty);

                int numberOfVotes = Integer.parseInt(stringNumberOfVotes);
                temp.setNumberOfVotes(numberOfVotes);

                all.add(temp);
            }
            reader.close();
            
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * Método que vai ler o ficheiro dos votos das freguesias (VotosFreguesias.csv).
     * 
     * @return arrayList com totos os votos da freguesias
     */
    public ArrayList<ParishVote> readParishesVotes(){
        ArrayList<ParishVote> all = new ArrayList<>();
        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(this.parishesVotes));
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");

                String stringTableId = values[0];
                String council = values[1];
                String politicalParty = values[2]; 
                String stringNumberOfVotes = values[3];

                ParishVote temp = new ParishVote();

                int tableId = Integer.parseInt(stringTableId);
                temp.setTableId(tableId);

                temp.setCouncil(council);

                temp.setPoliticalParty(politicalParty);

                int numberOfVotes = Integer.parseInt(stringNumberOfVotes);
                temp.setNumberOfVotes(numberOfVotes);

                all.add(temp);
            }
            reader.close();
            
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return all;
    }
}
