
public class NodeSong {
  

    /**
     * @return the nombreCancion
     */
    public String getNameSong() {
        return nameSong;
    }

    /**
     * @param nameSong the nombreCancion to set
     */
    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    /**
     * @return the duracionCancion
     */
    public String getDurationSong() {
        return durationSong;
    }

    /**
     * @param durationSong the duracionCancion to set
     */
    public void setDurationSong(String durationSong) {
        this.durationSong = durationSong;
    }

    /**
     * @return the nombreArtista
     */
    public String getArtistName() {
        return nameArtist;
    }

    /**
     * @param nameArtist the nombreArtista to set
     */
    public void setArtistName(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    /**
     * @return the anterior
     */
    public NodeSong getPrevious() {
        return previous;
    }

    /**
     * @param previous the anterior to set
     */
    public void setPrevious(NodeSong previous) {
        this.previous = previous;
    }

    /**
     * @return the siguiente
     */
    public NodeSong getNext() {
        return next;
    }

    /**
     * @param next the siguiente to set
     */
    public void setNext(NodeSong next) {
        this.next = next;
    }
    private String nameSong;
    private String durationSong;
    private String nameArtist;
    private NodeSong previous;
    private NodeSong next;
}

 
