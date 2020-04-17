package by.pavka.clazz.aggregation_composition.text;

class Word implements Textable {

    private String content;

    public Word(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    //other fields and methods
}
