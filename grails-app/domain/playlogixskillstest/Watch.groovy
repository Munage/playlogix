package playlogixskillstest

class Watch {

    String brand
    String model
    Double price
    int warranty

    static constraints = {
        brand nullable: false, blank: false
        model nullable: false, blank: false
        price nullable: false, min: 0 as Double
        warranty min: 0
    }
}
