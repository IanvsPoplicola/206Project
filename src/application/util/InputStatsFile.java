package application.util;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * this class should read all the txt files in the SavedGamesStats folder
 */
public class InputStatsFile {
    private String savedGamesDir = System.getProperty("user.dir")+"/SavedGamesStats/";
    private ArrayList<SaveGame> listOfSavedGames = new ArrayList<>();                   //this stores all the files as SaveGame object
    private Gson gson = new Gson();

    private ObservableList<SaveGameObservable> observableArrayList = FXCollections.observableArrayList();//stores all the observable lists of saveGame


    /**
     *this method will go into the SavedGamesStats folder and get all the files
     * it will then try and store them in the
     */
    public void getFiles(){
        File folder = new File(savedGamesDir);//get the SavedGamesStats folder as a File
        File[] listOfFiles = folder.listFiles();//get all the files inside that folder, and stores it in an array of File type

        //need to sort the File[] array


        for (int i = 0; i < listOfFiles.length; i++) {
            String jsonString="";
            //System.out.println("File " + listOfFiles[i].getName());//display the file name:debugging purposes

            try {
                File tempFile = listOfFiles[i];
                BufferedReader buff = new BufferedReader(new FileReader(tempFile));
                jsonString = buff.readLine();
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            //System.out.println(jsonString);
            SaveGame getTheGameStats = gson.fromJson(jsonString, SaveGame.class);
            listOfSavedGames.add(getTheGameStats);
        }

    }

    /**
     * this getter method returns the arraylist of all the stats of saved games
     * the object in the array list is the SaveGame object.
     * please refer to SaveGame object for getters.
     *
     * will return NULL if there were NO filesS in the SavedGamesStats folder !!!!
     * @return
     */
    public ArrayList<SaveGame> getAllSavedGames(){
        return listOfSavedGames;
    }

    /**
     * should return the ObservableList<SaveGame> of the ArrayList<SaveGame>
     * @return
     */
    public ObservableList<SaveGameObservable> getObservableList(String selectedLevel){

        //loop through the ArrayList of SaveGame

        for (int i = 0 ; i < listOfSavedGames.size() ; i++){
            //convert the SaveGame object to a SaveGameObservable object
            SaveGameObservable temp = new SaveGameObservable(listOfSavedGames.get(i));

            //check if the passed in selectedLevel.equals("custom")

            if (!selectedLevel.equals("custom")) {
                //if it's not custom
                if (temp.getTheLevel().equals(selectedLevel)) {//if the SaveGame is what the user selected to show on the stats
                    observableArrayList.add(temp);//add the SaveGameObservable object to the observableArrayList
                }
            }else{
                if (temp.getTheOperation().equals("custom")){//can also use selectedLevel, but we know that it has to be custom
                    observableArrayList.add(temp);
                }
            }
        }

        return observableArrayList;
    }


    //-----------------------------------------------------------



}
