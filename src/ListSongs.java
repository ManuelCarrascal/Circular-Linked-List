
import javax.swing.JOptionPane;

public class ListSongs {

    NodeSong start;
    NodeSong end;

    ListSongs() {
        start = null;
        end = null;
    }

    public void InsertAtStart(String nameSong, String durationSong, String nameArtist) {
        NodeSong newNode = new NodeSong();
        newNode.setNameSong(nameSong);
        newNode.setDurationSong(durationSong);
        newNode.setArtistName(nameArtist);
        if (start == null) {
            start = newNode;
            end = start;
            newNode.setPrevious(newNode);
            newNode.setNext(newNode);
        } else {
            newNode.setNext(start);
            start.setPrevious(newNode);
            newNode.setPrevious(end);
            end.setNext(newNode);
            start = newNode;
        }
    }

    public void InsertAtEnd(String nameSong, String durationSong, String nameArtist) {
        NodeSong newNode = new NodeSong();
        newNode.setNameSong(nameSong);
        newNode.setDurationSong(durationSong);
        newNode.setArtistName(nameArtist);
        if (start == null) {
            start = newNode;
            end = start;
            newNode.setPrevious(newNode);
            newNode.setNext(newNode);
        } else {
            end.setNext(newNode);
            newNode.setPrevious(end);
            newNode.setNext(start);
            start.setPrevious(newNode);
            end = newNode;

        }
    }

    public void PrintFirstToLast() {
        NodeSong temporalNode = start;
        if (start == null) {
            JOptionPane.showMessageDialog(null, "no songs have been added to the list");
        } else {
            do {
                JOptionPane.showMessageDialog(null, "Song Details:\n " + "Name of song: "
                        + temporalNode.getNameSong() + "\nDuration: "
                        + temporalNode.getDurationSong() + "\nArtist name: " + temporalNode.getArtistName());
                temporalNode = temporalNode.getNext();
            } while (temporalNode != start);
        }
    }

    public void PrintLastToFirst() {
        NodeSong temporalNode = end;
        if (start == null) {
            JOptionPane.showMessageDialog(null, "no songs have been added to the list");
        } else {
            do {
                JOptionPane.showMessageDialog(null, "Song Details:\n " + "Name of song: "
                        + temporalNode.getNameSong() + "\nDuration: "
                        + temporalNode.getDurationSong() + "\nArtist name: " + temporalNode.getArtistName());
                temporalNode = temporalNode.getPrevious();
            } while (temporalNode != end);
        }
    }

    public boolean DeleteSong(String search) {
        boolean found = false;
        if (start == null) {
            JOptionPane.showMessageDialog(null, "no songs have been added to the list");
        } else {
            NodeSong InitialNode = start;
            NodeSong EndNode = end;

            do {
                if (InitialNode.getNameSong().equalsIgnoreCase(search)) {
                    JOptionPane.showMessageDialog(null, "the song " + InitialNode.getNameSong() + " has been successfully removed from the list");
                    if (InitialNode == start && InitialNode == end) {
                        start = null;
                        end = null;
                    } else if (InitialNode == start) {
                        start = start.getNext();
                        end.setNext(start);
                        start.setPrevious(end);

                    } else if (InitialNode == end) {
                        end = end.getPrevious();
                        end.setNext(start);
                        start.setPrevious(end);
                    } else {
                        EndNode.setNext(InitialNode.getNext());
                        EndNode = InitialNode.getNext();
                        InitialNode = InitialNode.getPrevious();
                        EndNode.setPrevious(InitialNode);
                    }

                    found = true;
                }
                EndNode = InitialNode;
                InitialNode = InitialNode.getNext();
            } while (InitialNode != start && found == false);
            if (!found) {
                JOptionPane.showMessageDialog(null, "this song has not been entered");
            }
        }
        return found;
    }

    public void SearchSong(String search) {
        NodeSong temporalNode = start;
        boolean flag = false;
        if (start == null) {
            JOptionPane.showMessageDialog(null, "Song not found");
        } else {
            do {
                if (temporalNode.getNameSong().equals(search)) {
                    JOptionPane.showMessageDialog(null, "Song Details\n"
                            + "Name of song: " + temporalNode.getNameSong() + "\nDuration: "
                            + temporalNode.getDurationSong() + "\nArtist name: " + temporalNode.getArtistName());
                    flag = true;
                } else {
                    temporalNode = temporalNode.getNext();
                }
            } while (temporalNode != start && flag == false);
            if (!flag) {
                JOptionPane.showMessageDialog(null, "This song does not exist");
            }
        }
    }

    public void ModifySong(String nameSong, String durationSong, String nameArtist,String search) {
        NodeSong temporalNode = start;
        boolean flag = false;
        if (start == null) {
            JOptionPane.showMessageDialog(null, "Song not found");
        } else {
            do {
                if (temporalNode.getNameSong().equals(search)) {
                 temporalNode.setNameSong(nameSong);
                 temporalNode.setDurationSong(durationSong);
                 temporalNode.setArtistName(nameArtist);
                    flag = true;
                } else {
                    temporalNode = temporalNode.getNext();
                }
            } while (temporalNode != start && flag == false);
            if (!flag) {
                JOptionPane.showMessageDialog(null, "This song does not exist");
            }
        }
    }
}
