import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
    // Variable quee representa el indice 
    private int index;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
        index = 1;
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * Método que nos da el índice de la canción
     */
    public int getIndex(){
        return index;
    }
    
    /**
     * Método que nos muestra por pantalla el nombre de todos los archivos MP3 
     */
    public void listAllFiles(){
        int indice;
        indice = 1;
        for (String file : files){
            System.out.println(indice + ". " + file);
            indice = indice + 1;
        }
    }
    
    /**
     * Método que nos permite hacer una búsqueda de ciertos archivos
     */
    public void listMatching(String searchString)
    {
        boolean resultado;
        resultado = false;
        
        for (String filename : files) {
            if (filename.contains(searchString)){
                System.out.println(filename);
                resultado = true;
            }
        }
        
        if (!resultado){
            System.out.println("No hay coincidencias en la búsqueda.");
        }
    }
    
    /**
     * Reproduce una muestra de la canción
     */
    public void playSamplesArtist(String artist){
        for (String filename : files) {
            if (filename.contains(artist)){
                player.playSample(filename);
            }
        }
    }
    
    /**
     * Método que nos devuelve el índice del primer archivo que encuentre la cadena de búsqueda
     */
    public int findFirst(String busqueda){
        boolean found = false;
        while (!found && index < files.size()){
            for (String filename : files){
                if (busqueda.equals(filename)){
                    return index;
                }
                else {
                    return -1;
                }
            }
        }
        return index;
    }
}
