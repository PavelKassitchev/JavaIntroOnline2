package by.pavka.clazz.aggregation_composition.text;

class Sentence implements Textable {

    private String content;

    public Sentence(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
    //other fields and methods
}
