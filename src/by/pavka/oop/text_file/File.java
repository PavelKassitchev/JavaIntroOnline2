package by.pavka.oop.text_file;

public abstract class  File<T> {

    private T content;
    private Directory host;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Directory getHost() {
        return host;
    }

    public void setHost(Directory host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "File " + name;
    }

    public void delete() {
        if(host != null) {
            host.removeFile(this);
            host = null;
        }
        content = null;
    }

    public abstract void printContent();
    public abstract <T> void addContent(T addition);
}
