enum Color {        //неявно - public static
    COLOR4_0("4+0") { public double apply(double x, double y) { return x + y; } },
    COLOR4_4("4+4") {},
    COLOR1_0("1+0") {},
    COLOR1_1("1+1") {},
    COLOR4_1("4+1") {};

    private final String color;

    //конструктор
    Color(String color) { this.color = color; }

    //геттер
    public String getColor(){ return color; }

    @Override
    public String toString() { return color; }
}