public class Person {

    private String name;
    private boolean isNice;

    public Person(String name, boolean isNice) {
        this.name = name;
        this.isNice = isNice;
    }

    public boolean getIsNice() {
        return isNice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + isNice;
    }
}
