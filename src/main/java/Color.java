enum Color {        //неявно - public static
    COLOR4_0("4+0"),
    COLOR4_4("4+4"),
    COLOR1_0("1+0"),
    COLOR1_1("1+1"),
    COLOR4_1("4+1");

    private String color;

    //конструктор
    Color(String color) {
        this.color = color;
    }
    //геттер
    String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
}