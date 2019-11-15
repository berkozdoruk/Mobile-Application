package ctis487.labguide7;

public class House {
    int logo;
    String name;
    String words;

    public House(int logo, String name, String words) {
        this.logo = logo;
        this.name = name;
        this.words = words;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Houses{" +
                "logo=" + logo +
                ", name=" + name +
                ", wrods=" + words +
                '}';
    }
}