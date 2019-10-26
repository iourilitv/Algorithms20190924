package additional.dynamic_programming;

class Thing {
    private String name;//название вещи
    private Integer weight;//вес вещи
    private Integer cost;//стоимость вещи

    Thing(String name, Integer weight, Integer cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    Integer getWeight() {
        return weight;
    }

    Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + "={weight=" + weight +
                ", cost=" + cost +
                "}";
    }
}
