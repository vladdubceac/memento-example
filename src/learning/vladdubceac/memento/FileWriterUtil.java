package learning.vladdubceac.memento;

public class FileWriterUtil {
    // Originator class
    private String filename;
    private StringBuilder content;
    private Memento me;

    public FileWriterUtil(String filename) {
        this.filename = filename;
        content = new StringBuilder();
    }

    public void write(String str){
        content.append(str);
    }

    @Override
    public String toString() {
        return content.toString();
    }

    // creates the memento
    public Memento save(){
        return new Memento(this.filename, this.content);
    }

    // restore into its earlier state
    public void undoToLastSave(Object obj){
        Memento memento = (Memento)obj;
        this.filename = memento.filename;
        this.content = memento.content;
    }

    private class Memento{
        private String filename;
        private StringBuilder content;

        public Memento(String filename, StringBuilder content) {
            this.filename = filename;
            // deep copy, so that Memento and FileWriterUtil
            // content variables don't refer to same object
            this.content = content;
        }
    }
}
